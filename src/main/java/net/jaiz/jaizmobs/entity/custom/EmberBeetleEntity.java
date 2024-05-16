package net.jaiz.jaizmobs.entity.custom;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.EnumSet;

public class EmberBeetleEntity extends FlyingEntity {

    public EmberBeetleEntity(EntityType<? extends EmberBeetleEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 1;
        this.setPathfindingPenalty(PathNodeType.LAVA, 0.0f);
        this.moveControl = new EmberBeetleEntity.EmberBeetleMoveControl(this);
    }

    public AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;


    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40);
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()) {
            setupAnimationStates();
        }
    }

    @Override
    public boolean isPushedByFluids() {
        return false;
    }

    @Override
    public boolean isFireImmune() {
        return true;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new FlyRandomlyGoal(this));
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
    }

    public static DefaultAttributeContainer.Builder createEmberBeetleAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 4)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20)
                .add(EntityAttributes.GENERIC_ARMOR, 2.0f);

    }
    static class FlyRandomlyGoal
            extends Goal {
        private final EmberBeetleEntity emberBeetle;

        public FlyRandomlyGoal(EmberBeetleEntity emberbeetle) {
            this.emberBeetle = emberbeetle;
            this.setControls(EnumSet.of(Control.MOVE));
        }

        @Override
        public boolean canStart() {
            double f;
            double e;
            MoveControl moveControl = this.emberBeetle.getMoveControl();
            if (!moveControl.isMoving()) {
                return true;
            }
            double d = moveControl.getTargetX() - this.emberBeetle.getX();
            double g = d * d + (e = moveControl.getTargetY() - this.emberBeetle.getY()) * e + (f = moveControl.getTargetZ() - this.emberBeetle.getZ()) * f;
            return g < 1.0 || g > 3600.0;
        }

        @Override
        public boolean shouldContinue() {
            return false;
        }

        @Override
        public void start() {
            Random random = this.emberBeetle.getRandom();
            double d = this.emberBeetle.getX() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            double e = this.emberBeetle.getY() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            double f = this.emberBeetle.getZ() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            this.emberBeetle.getMoveControl().moveTo(d, e, f, 0.035);
        }
    }


    static class EmberBeetleMoveControl
            extends MoveControl {
        private final EmberBeetleEntity emberBeetle;
        private int collisionCheckCooldown;

        public EmberBeetleMoveControl(EmberBeetleEntity emberbeetle) {
            super(emberbeetle);
            this.emberBeetle = emberbeetle;
        }

        @Override
        public void tick() {
            if (this.state != State.MOVE_TO) {
                return;
            }
            if (this.collisionCheckCooldown-- <= 0) {
                this.collisionCheckCooldown += this.emberBeetle.getRandom().nextInt(5) + 2;
                Vec3d vec3d = new Vec3d(this.targetX - this.emberBeetle.getX(), this.targetY - this.emberBeetle.getY(), this.targetZ - this.emberBeetle.getZ());
                double d = vec3d.length();
                if (this.willCollide(vec3d = vec3d.normalize(), MathHelper.ceil(d))) {
                    this.emberBeetle.setVelocity(this.emberBeetle.getVelocity().add(vec3d.multiply(0.1)));
                } else {
                    this.state = State.WAIT;
                }
            }
            if (this.emberBeetle.getTarget() == null) {
                Vec3d vec3d = this.emberBeetle.getVelocity();
                this.emberBeetle.setYaw(-((float)MathHelper.atan2(vec3d.x, vec3d.z)) * 57.295776f);
                this.emberBeetle.bodyYaw = this.emberBeetle.getYaw();
            } else {
                LivingEntity livingEntity = this.emberBeetle.getTarget();
                double d = 64.0;
                if (livingEntity.squaredDistanceTo(this.emberBeetle) < 4096.0) {
                    double e = livingEntity.getX() - this.emberBeetle.getX();
                    double f = livingEntity.getZ() - this.emberBeetle.getZ();
                    this.emberBeetle.setYaw(-((float)MathHelper.atan2(e, f)) * 57.295776f);
                    this.emberBeetle.bodyYaw = this.emberBeetle.getYaw();
                }
            }
        }

        private boolean willCollide(Vec3d direction, int steps) {
            Box box = this.emberBeetle.getBoundingBox();
            for (int i = 1; i < steps; ++i) {
                box = box.offset(direction);
                if (this.emberBeetle.getWorld().isSpaceEmpty(this.emberBeetle, box)) continue;
                return false;
            }
            return true;
        }

    }

    public static boolean canSpawn(EntityType<EmberBeetleEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return EmberBeetleEntity.canMobSpawn(type, world, spawnReason, pos, random);
    }


    @Override
    protected SoundEvent getAmbientSound() {

        return SoundEvents.ENTITY_BEE_LOOP;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_BEE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_BEE_DEATH;
    }

    @Override
    public EntityGroup getGroup() {
        return EntityGroup.ARTHROPOD;
    }


}
