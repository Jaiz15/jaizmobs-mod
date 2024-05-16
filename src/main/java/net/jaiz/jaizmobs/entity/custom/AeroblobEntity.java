package net.jaiz.jaizmobs.entity.custom;

import net.jaiz.jaizmobs.item.custom.ModItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class AeroblobEntity extends FlyingEntity implements ItemSteerable{

    public AeroblobEntity(EntityType<? extends AeroblobEntity> entityType, World world) {
        super((EntityType<? extends FlyingEntity>)entityType, world);
        this.experiencePoints = 1;
        this.moveControl = new AeroblobEntity.StarFishMoveControl(this);
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

    public static DefaultAttributeContainer.Builder createAeroblobAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 6)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.1f)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.1f);

    }

    @Override
    public boolean consumeOnAStickItem() {
        return false;
    }

    static class FlyRandomlyGoal
            extends Goal {
        private final AeroblobEntity aeroblob;

        public FlyRandomlyGoal(AeroblobEntity aeroblob) {
            this.aeroblob = aeroblob;
            this.setControls(EnumSet.of(Control.MOVE));
        }

        @Override
        public boolean canStart() {
            double f;
            double e;
            MoveControl moveControl = this.aeroblob.getMoveControl();
            if (!moveControl.isMoving()) {
                return true;
            }
            double d = moveControl.getTargetX() - this.aeroblob.getX();
            double g = d * d + (e = moveControl.getTargetY() - this.aeroblob.getY()) * e + (f = moveControl.getTargetZ() - this.aeroblob.getZ()) * f;
            return g < 1.0 || g > 3600.0;
        }

        @Override
        public boolean shouldContinue() {
            return false;
        }

        @Override
        public void start() {
            Random random = this.aeroblob.getRandom();
            double d = this.aeroblob.getX() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            double e = this.aeroblob.getY() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            double f = this.aeroblob.getZ() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            this.aeroblob.getMoveControl().moveTo(d, e, f, 0.035);
        }
    }


    static class StarFishMoveControl
            extends MoveControl {
        private final AeroblobEntity starfish;
        private int collisionCheckCooldown;

        public StarFishMoveControl(AeroblobEntity starfish) {
            super(starfish);
            this.starfish = starfish;
        }

        @Override
        public void tick() {
            if (this.state != State.MOVE_TO) {
                return;
            }
            if (this.collisionCheckCooldown-- <= 0) {
                this.collisionCheckCooldown += this.starfish.getRandom().nextInt(5) + 2;
                Vec3d vec3d = new Vec3d(this.targetX - this.starfish.getX(), this.targetY - this.starfish.getY(), this.targetZ - this.starfish.getZ());
                double d = vec3d.length();
                if (this.willCollide(vec3d = vec3d.normalize(), MathHelper.ceil(d))) {
                    this.starfish.setVelocity(this.starfish.getVelocity().add(vec3d.multiply(0.1)));
                } else {
                    this.state = State.WAIT;
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

    public static boolean canSpawn(EntityType<AeroblobEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return AeroblobEntity.canMobSpawn(type, world, spawnReason, pos, random);
    }


    @Override
    protected SoundEvent getAmbientSound() {

        return SoundEvents.ENTITY_BREEZE_IDLE_AIR;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_PUFFER_FISH_BLOW_OUT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PUFFER_FISH_BLOW_UP;
    }


    @Override
    public void tickMovement() {
        if (!this.isTouchingWater() && this.isOnGround() && this.verticalCollision) {
            this.setVelocity(this.getVelocity().add((this.random.nextFloat() * 2.0f - 0.5f) * 0.05f, 0.4f, (this.random.nextFloat() * 2.0f - 0.5f) * 0.05f));
            this.setOnGround(false);
            this.velocityDirty = true;
            this.playSound(SoundEvents.ENTITY_GENERIC_SMALL_FALL, 0.5f, 1);
        }
        super.tickMovement();
    }

    @Override
    public void travel(Vec3d movementInput) {
        if (this.canMoveVoluntarily() && this.isTouchingWater()) {
            this.updateVelocity(this.getMovementSpeed(), movementInput);
            this.move(MovementType.SELF, this.getVelocity());
            this.setVelocity(this.getVelocity().multiply(0.9));
            if (this.getTarget() == null) {
                this.setVelocity(this.getVelocity().add(0.0, -0.005, 0.0));
            }
        } else {
            super.travel(movementInput);
        }
    }

    @Override
    @Nullable
    public LivingEntity getControllingPassenger() {
        PlayerEntity playerEntity;
        Entity entity;
        if ((entity = this.getFirstPassenger()) instanceof PlayerEntity && (playerEntity = (PlayerEntity)entity).isHolding(ModItems.STARFISH_ON_A_STICK)) {
            return playerEntity;

        }
        return super.getControllingPassenger();
    }


    @Override
    protected void tickControlled(PlayerEntity controllingPlayer, Vec3d movementInput) {
        this.setRotation(controllingPlayer.getYaw(), controllingPlayer.getPitch() * 0.5f);
        this.bodyYaw = this.headYaw = this.getYaw();
        this.prevYaw = this.headYaw;
        super.tickControlled(controllingPlayer, movementInput);
    }

    @Override
    protected Vec3d getControlledMovementInput(PlayerEntity controllingPlayer, Vec3d movementInput) {
        if (this.isTouchingWater()) {
            this.updateVelocity(this.getMovementSpeed(), movementInput);
            this.move(MovementType.SELF, this.getVelocity());
            this.setVelocity(this.getVelocity().multiply(0.9));
            if (this.getTarget() == null) {
                this.setVelocity(this.getVelocity().add(0.0, -0.005, 0.0));
            }
        } else {
            super.travel(movementInput);
        }
        return new Vec3d(0.0, -0.175, 1.0);
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (!player.shouldCancelInteraction()) {
            if (!this.getWorld().isClient) {
                player.startRiding(this);
            }
            return ActionResult.success(this.getWorld().isClient);
        }
        ActionResult actionResult = super.interactMob(player, hand);
        return actionResult;
    }

    @Override
    protected float getSaddledSpeed(PlayerEntity controllingPlayer) {
        return (float) (this.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED) * 2);
    }



}
