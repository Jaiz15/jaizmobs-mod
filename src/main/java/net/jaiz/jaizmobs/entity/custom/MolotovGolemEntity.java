package net.jaiz.jaizmobs.entity.custom;

import net.jaiz.jaizmobs.entity.ai.MolotovGolemAttackGoal;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.EnumSet;

public class MolotovGolemEntity extends HostileEntity {

    private static final TrackedData<Boolean> ATTACKING = DataTracker.registerData(MolotovGolemEntity.class, TrackedDataHandlerRegistry.BOOLEAN);


    public AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;


    public AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;


    public MolotovGolemEntity(EntityType<? extends HostileEntity> entityType, World world) {

        super(entityType, world);
        this.experiencePoints = 7;
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

        if(this.isAttacking()  && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 20;
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            attackAnimationState.start(this.age);
        } else {
            --this.attackAnimationTimeout;
        }

        if(!this.isAttacking()) {
            attackAnimationState.stop();
        }

    }





    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    @Override
    public void tick() {
        if(this.getWorld().isClient()) {
            setupAnimationStates();
        }
        super.tick();
    }

    public static boolean canSpawn(EntityType<MolotovGolemEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return MolotovGolemEntity.canMobSpawn(type, world, spawnReason, pos, random);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
        this.goalSelector.add(7, new MolotovGolemEntity.LookAtTargetGoal(this));
        this.goalSelector.add(1, new MolotovGolemAttackGoal(this, 1, false));
        this.targetSelector.add(3, new ActiveTargetGoal(this, PlayerEntity.class, true));
        this.targetSelector.add(4, new RevengeGoal(this));
        this.targetSelector.add(5, new ActiveTargetGoal(this, IronGolemEntity.class, true));
        this.targetSelector.add(6, new ActiveTargetGoal(this, SnowGolemEntity.class, true));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0));

    }

    @Override
    public boolean isPushedByFluids() {
        return false;
    }

    @Override
    public boolean isFireImmune() {
        return true;
    }

    public static DefaultAttributeContainer.Builder createMoltovGolemAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 26)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.16f)
                .add(EntityAttributes.GENERIC_ARMOR, 0.2f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 14)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.2f)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0.2);

    }

    public void setAttacking(boolean attacking) {
        this.dataTracker.set(ATTACKING, attacking);
    }

    @Override
    public boolean isAttacking()
    {
        return this.dataTracker.get(ATTACKING);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING, false);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.BLOCK_LAVA_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.BLOCK_BASALT_BREAK;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_IRON_GOLEM_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.BLOCK_BASALT_STEP;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(this.getStepSound(), 0.15f, 1.0f);
    }

    static class LookAtTargetGoal
            extends Goal {
        private final MolotovGolemEntity molotov_golem;

        public LookAtTargetGoal(MolotovGolemEntity molotov_golem) {
            this.molotov_golem = molotov_golem;
            this.setControls(EnumSet.of(Goal.Control.LOOK));
        }

        @Override
        public boolean canStart() {
            return true;
        }

        @Override
        public boolean shouldRunEveryTick() {
            return true;
        }

        @Override
        public void tick() {
            if (this.molotov_golem.getTarget() == null) {
                Vec3d vec3d = this.molotov_golem.getVelocity();
                this.molotov_golem.setYaw(-((float) MathHelper.atan2(vec3d.x, vec3d.z)) * 57.295776f);
                this.molotov_golem.bodyYaw = this.molotov_golem.getYaw();
            } else {
                LivingEntity livingEntity = this.molotov_golem.getTarget();
                double d = 64.0;
                if (livingEntity.squaredDistanceTo(this.molotov_golem) < 4096.0) {
                    double e = livingEntity.getX() - this.molotov_golem.getX();
                    double f = livingEntity.getZ() - this.molotov_golem.getZ();
                    this.molotov_golem.setYaw(-((float)MathHelper.atan2(e, f)) * 57.295776f);
                    this.molotov_golem.bodyYaw = this.molotov_golem.getYaw();
                }
            }
        }
    }
}
