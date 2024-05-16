package net.jaiz.jaizmobs.entity.custom;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.Goal;
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

public class StarFishLeaderEntity extends FlyingEntity {


    public StarFishLeaderEntity(EntityType<? extends StarFishLeaderEntity> entityType, World world) {
        super((EntityType<? extends FlyingEntity>)entityType, world);
        this.experiencePoints = 1;
        this.moveControl = new StarFishLeaderEntity.StarFishLeaderMoveControl(this);
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
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 6)
                .add(EntityAttributes.GENERIC_ARMOR, 0.5f);

    }
    static class FlyRandomlyGoal
            extends Goal {
        private final StarFishLeaderEntity starfishleader;

        public FlyRandomlyGoal(StarFishLeaderEntity starfishleader) {
            this.starfishleader = starfishleader;
            this.setControls(EnumSet.of(Control.MOVE));
        }

        @Override
        public boolean canStart() {
            double f;
            double e;
            MoveControl moveControl = this.starfishleader.getMoveControl();
            if (!moveControl.isMoving()) {
                return true;
            }
            double d = moveControl.getTargetX() - this.starfishleader.getX();
            double g = d * d + (e = moveControl.getTargetY() - this.starfishleader.getY()) * e + (f = moveControl.getTargetZ() - this.starfishleader.getZ()) * f;
            return g < 1.0 || g > 3600.0;
        }

        @Override
        public boolean shouldContinue() {
            return false;
        }

        @Override
        public void start() {
            Random random = this.starfishleader.getRandom();
            double d = this.starfishleader.getX() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            double e = this.starfishleader.getY() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            double f = this.starfishleader.getZ() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            this.starfishleader.getMoveControl().moveTo(d, e, f, 0.025);
        }
    }



    static class StarFishLeaderMoveControl
            extends MoveControl {
        private final StarFishLeaderEntity starfishleader;
        private int collisionCheckCooldown;

        public StarFishLeaderMoveControl(StarFishLeaderEntity starfishleader) {
            super(starfishleader);
            this.starfishleader = starfishleader;
        }

        @Override
        public void tick() {
            if (this.starfishleader.getY() >= 150) {
                this.starfishleader.discard();
                return;
            }
            if (this.state != State.MOVE_TO) {
                return;
            }
            if (this.collisionCheckCooldown-- <= 0) {
                this.collisionCheckCooldown += this.starfishleader.getRandom().nextInt(5) + 2;
                Vec3d vec3d = new Vec3d(this.targetX - this.starfishleader.getX(), this.targetY - this.starfishleader.getY(), this.targetZ - this.starfishleader.getZ());
                double d = vec3d.length();
                if (this.willCollide(vec3d = vec3d.normalize(), MathHelper.ceil(d))) {
                    this.starfishleader.setVelocity(this.starfishleader.getVelocity().add(vec3d.multiply(0.1)));
                } else {
                    this.state = State.WAIT;
                }
            }
            if (this.starfishleader.getTarget() == null) {
                Vec3d vec3d = this.starfishleader.getVelocity();
                this.starfishleader.setYaw(-((float)MathHelper.atan2(vec3d.x, vec3d.z)) * 57.295776f);
                this.starfishleader.bodyYaw = this.starfishleader.getYaw();
            } else {
                LivingEntity livingEntity = this.starfishleader.getTarget();
                double d = 64.0;
                if (livingEntity.squaredDistanceTo(this.starfishleader) < 4096.0) {
                    double e = livingEntity.getX() - this.starfishleader.getX();
                    double f = livingEntity.getZ() - this.starfishleader.getZ();
                    this.starfishleader.setYaw(-((float)MathHelper.atan2(e, f)) * 57.295776f);
                    this.starfishleader.bodyYaw = this.starfishleader.getYaw();
                }
            }
        }

        private boolean willCollide(Vec3d direction, int steps) {
            Box box = this.starfishleader.getBoundingBox();
            for (int i = 1; i < steps; ++i) {
                box = box.offset(direction);
                if (this.starfishleader.getWorld().isSpaceEmpty(this.starfishleader, box)) continue;
                return false;
            }
            return true;
        }

    }

    public static boolean canSpawn(EntityType<StarFishLeaderEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return StarFishLeaderEntity.canMobSpawn(type, world, spawnReason, pos, random);
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
