package net.jaiz.jaizmobs.entity.custom;


import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;


public class CultivatorEntity extends AnimalEntity {

    public AnimationState idleAnimationState = new AnimationState();
    public int seedDropTime = this.random.nextInt(6000) + 1200;
    public int beetSeedDropTime = this.random.nextInt(6000) + 1200;
    public int melonSeedDropTime = this.random.nextInt(12000) + 1200;
    public int pumpkinSeedDropTime = this.random.nextInt(12000) + 1200;

    private int idleAnimationTimeout = 0;

    public CultivatorEntity(EntityType<? extends AnimalEntity> entityType, World world) {

        super(entityType, world);
        this.experiencePoints = 20;
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
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
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0));

    }

    public static DefaultAttributeContainer.Builder createCultivatorAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30)
                .add(EntityAttributes.GENERIC_ARMOR, 0.4f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 60)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.16)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.1f);

    }

    public static boolean canSpawn(EntityType<CultivatorEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return CultivatorEntity.canMobSpawn(type, world, spawnReason, pos, random);
    }

    @Override
    public void tickMovement() {
        super.tickMovement();

        if (!this.getWorld().isClient && this.isAlive() && !this.isBaby() && --this.seedDropTime <= 0) {
            this.playSound(SoundEvents.BLOCK_LAVA_POP, 0.7f, (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 1.0f);
            this.dropItem(Items.WHEAT_SEEDS);
            this.emitGameEvent(GameEvent.ENTITY_PLACE);
            this.seedDropTime = this.random.nextInt(6000) + 1200;

        }
        if (!this.getWorld().isClient && this.isAlive() && !this.isBaby() && --this.beetSeedDropTime <= 0) {
            this.playSound(SoundEvents.BLOCK_LAVA_POP, 0.7f, (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 1.0f);
            this.dropItem(Items.BEETROOT_SEEDS);
            this.emitGameEvent(GameEvent.ENTITY_PLACE);
            this.beetSeedDropTime = this.random.nextInt(6000) + 1200;

        }
        if (!this.getWorld().isClient && this.isAlive() && !this.isBaby() && --this.melonSeedDropTime <= 0) {
            this.playSound(SoundEvents.BLOCK_LAVA_POP, 0.7f, (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 1.0f);
            this.dropItem(Items.MELON_SEEDS);
            this.emitGameEvent(GameEvent.ENTITY_PLACE);
            this.melonSeedDropTime = this.random.nextInt(12000) + 1200;

        }
        if (!this.getWorld().isClient && this.isAlive() && !this.isBaby() && --this.pumpkinSeedDropTime <= 0) {
            this.playSound(SoundEvents.BLOCK_LAVA_POP, 0.7f, (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 1.0f);
            this.dropItem(Items.PUMPKIN_SEEDS);
            this.emitGameEvent(GameEvent.ENTITY_PLACE);
            this.pumpkinSeedDropTime = this.random.nextInt(12000) + 1200;

        }
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_STRIDER_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SNIFFER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SNIFFER_DEATH;
    }

}
