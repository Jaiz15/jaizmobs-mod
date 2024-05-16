package net.jaiz.jaizmobs.entity.custom;

import net.jaiz.jaizmobs.entity.ai.KlephtopodAttackGoal;
import net.jaiz.jaizmobs.item.custom.ModItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.AquaticMoveControl;
import net.minecraft.entity.ai.control.YawAdjustingLookControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.SwimNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.DrownedEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.*;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;


public class KlephtopodEntity extends WaterCreatureEntity implements ItemSteerable{

    private static final Ingredient ATTRACTING_INGREDIENT = Ingredient.ofItems(ModItems.HUNTER_EEL, ModItems.COOKED_HUNTER_EEL, ModItems.EEL_ON_A_STICK);
    @Nullable
    private TemptGoal temptGoal;

    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(KlephtopodEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;


    public KlephtopodEntity(EntityType<? extends WaterCreatureEntity > entityType, World world) {

        super(entityType, world);
        this.moveControl = new AquaticMoveControl(this, 85, 10, 0.022f, 0.1f, true);
        this.lookControl = new YawAdjustingLookControl(this, 10);
        this.experiencePoints = 20;
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
        super.tick();
        if(this.getWorld().isClient()) {
            setupAnimationStates();
        }
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
        this.goalSelector.add(0, new MoveIntoWaterGoal(this));
        this.goalSelector.add(4, new SwimAroundGoal(this, 1.0, 10));
        this.goalSelector.add(8, new WanderAroundGoal(this, 1.0, 10));
        this.goalSelector.add(1, new KlephtopodAttackGoal(this, 1d, false));
        this.targetSelector.add(4, new RevengeGoal(this));
        this.temptGoal = new TemptGoal(this, 1.4, ATTRACTING_INGREDIENT, false);
        this.goalSelector.add(3, this.temptGoal);
        this.goalSelector.add(6, new ChaseBoatGoal(this));
        this.targetSelector.add(5, new RevengeGoal(this));
        this.targetSelector.add(8, new ActiveTargetGoal (this, HunterEelEntity.class, true));
        this.targetSelector.add(8, new ActiveTargetGoal (this, DrownedEntity.class, true));

    }

    public static DefaultAttributeContainer.Builder createKlephtopodAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 40)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.2f)
                .add(EntityAttributes.GENERIC_ARMOR, 2.6f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 40);

    }

    @Override
    protected EntityNavigation createNavigation(World world) {
        return new SwimNavigation(this, world);
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
    public boolean canHaveStatusEffect(StatusEffectInstance effect) {
        if (effect.getEffectType() == StatusEffects.POISON) {
            return effect.getEffectType() == StatusEffects.REGENERATION;
        }
        return super.canHaveStatusEffect(effect);
    }

    public void setAttacking(boolean attacking) {
        this.dataTracker.set(ATTACKING, attacking);
    }

    @Override
    public boolean isAttacking() {
        return this.dataTracker.get(ATTACKING);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING, false);
    }

    @Override
    public EntityGroup getGroup() {
        return EntityGroup.AQUATIC;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_STRIDER_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_TURTLE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_TURTLE_DEATH;
    }

    @Override
    protected SoundEvent getSplashSound() {
        return SoundEvents.ENTITY_DOLPHIN_SPLASH;
    }

    @Override
    protected SoundEvent getSwimSound() {
        return SoundEvents.ENTITY_DOLPHIN_SWIM;
    }

    public static boolean canSpawn(EntityType<? extends WaterCreatureEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return KlephtopodEntity.canMobSpawn(type, world, spawnReason, pos, random);
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
        if ((entity = this.getFirstPassenger()) instanceof PlayerEntity && (playerEntity = (PlayerEntity)entity).isHolding(ModItems.EEL_ON_A_STICK)) {
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
        return new Vec3d(0.0, controllingPlayer.getPitch() * -10, 10.0);
    }

    @Override
    protected float getSaddledSpeed(PlayerEntity controllingPlayer) {
        if(isTouchingWater()) {
            return (float) (this.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED) / 5);
        } else {
            return (float) (this.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED) / 32);
        }
    }


    @Override
    public boolean consumeOnAStickItem() {
        return false;
    }
}
