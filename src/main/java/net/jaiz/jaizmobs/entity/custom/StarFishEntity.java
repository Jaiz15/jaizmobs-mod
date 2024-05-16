package net.jaiz.jaizmobs.entity.custom;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.*;
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

public class StarFishEntity extends FlyingEntity {

    public StarFishEntity(EntityType<? extends StarFishEntity> entityType, World world) {
        super((EntityType<? extends FlyingEntity>)entityType, world);
        this.experiencePoints = 1;
        this.moveControl = new StarFishEntity.StarFishMoveControl(this);
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
    protected void initGoals() {
        this.goalSelector.add(1, new FlyRandomlyGoal(this));
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
    }

    public static DefaultAttributeContainer.Builder createStarFishAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 2)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20)
                .add(EntityAttributes.GENERIC_ARMOR, 0.5f);

    }
    static class FlyRandomlyGoal
            extends Goal {
        private final StarFishEntity starfish;

        public FlyRandomlyGoal(StarFishEntity starfish) {
            this.starfish = starfish;
            this.setControls(EnumSet.of(Goal.Control.MOVE));
        }

        @Override
        public boolean canStart() {
            double f;
            double e;
            MoveControl moveControl = this.starfish.getMoveControl();
            if (!moveControl.isMoving()) {
                return true;
            }
            double d = moveControl.getTargetX() - this.starfish.getX();
            double g = d * d + (e = moveControl.getTargetY() - this.starfish.getY()) * e + (f = moveControl.getTargetZ() - this.starfish.getZ()) * f;
            return g < 1.0 || g > 3600.0;
        }

        @Override
        public boolean shouldContinue() {
            return false;
        }

        @Override
        public void start() {
            Random random = this.starfish.getRandom();
            double d = this.starfish.getX() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            double e = this.starfish.getY() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            double f = this.starfish.getZ() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            this.starfish.getMoveControl().moveTo(d, e, f, 0.035);
        }
    }

    static class StarFishMoveControl
            extends MoveControl {
        private final StarFishEntity starfish;
        private int collisionCheckCooldown;

        public StarFishMoveControl(StarFishEntity starfish) {
            super(starfish);
            this.starfish = starfish;
        }

        @Override
        public void tick() {
            if (this.starfish.getY() >= 150) {
                this.starfish.discard();
                return;
            }
            if (this.state != MoveControl.State.MOVE_TO) {
                return;
            }
            if (this.collisionCheckCooldown-- <= 0) {
                this.collisionCheckCooldown += this.starfish.getRandom().nextInt(5) + 2;
                Vec3d vec3d = new Vec3d(this.targetX - this.starfish.getX(), this.targetY - this.starfish.getY(), this.targetZ - this.starfish.getZ());
                double d = vec3d.length();
                if (this.willCollide(vec3d = vec3d.normalize(), MathHelper.ceil(d))) {
                    this.starfish.setVelocity(this.starfish.getVelocity().add(vec3d.multiply(0.1)));
                } else {
                    this.state = MoveControl.State.WAIT;
                }
            }
            if (this.starfish.getTarget() == null) {
                Vec3d vec3d = this.starfish.getVelocity();
                this.starfish.setYaw(-((float)MathHelper.atan2(vec3d.x, vec3d.z)) * 57.295776f);
                this.starfish.bodyYaw = this.starfish.getYaw();
            } else {
                LivingEntity livingEntity = this.starfish.getTarget();
                double d = 64.0;
                if (livingEntity.squaredDistanceTo(this.starfish) < 4096.0) {
                    double e = livingEntity.getX() - this.starfish.getX();
                    double f = livingEntity.getZ() - this.starfish.getZ();
                    this.starfish.setYaw(-((float)MathHelper.atan2(e, f)) * 57.295776f);
                    this.starfish.bodyYaw = this.starfish.getYaw();
                }
            }
        }

        private boolean willCollide(Vec3d direction, int steps) {
            Box box = this.starfish.getBoundingBox();
            for (int i = 1; i < steps; ++i) {
                box = box.offset(direction);
                if (this.starfish.getWorld().isSpaceEmpty(this.starfish, box)) continue;
                return false;
            }
            return true;
        }

    }

    public static boolean canSpawn(EntityType<StarFishEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return StarFishEntity.canMobSpawn(type, world, spawnReason, pos, random);
    }


    @Override
    protected SoundEvent getAmbientSound() {

        return SoundEvents.BLOCK_BUBBLE_COLUMN_BUBBLE_POP;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_COD_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_COD_FLOP;
    }

    @Override
    public EntityGroup getGroup() {
        return EntityGroup.AQUATIC;
    }


}
