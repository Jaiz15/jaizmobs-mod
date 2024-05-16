package net.jaiz.jaizmobs.entity.custom;

import net.jaiz.jaizmobs.entity.ai.GeyserBerryAttackGoal;
import net.jaiz.jaizmobs.item.custom.ModItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;


public class GeyserBerryEntity extends HostileEntity {

    private static final TrackedData<Boolean> ATTACKING = DataTracker.registerData(MolotovGolemEntity.class, TrackedDataHandlerRegistry.BOOLEAN);



    public AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;


    public GeyserBerryEntity(EntityType<? extends HostileEntity> entityType, World world) {

        super(entityType, world);
        this.disableExperienceDropping();
    }

    @Override
    public void tick() {
        super.tick();
    }

    public static boolean canSpawn(EntityType<GeyserBerryEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return world.getBlockState(pos.down()).isIn(BlockTags.NYLIUM);
    }

    @Override
    protected void initGoals() {
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));
        this.goalSelector.add(1, new GeyserBerryAttackGoal(this, 1, false));
        this.targetSelector.add(1, new ActiveTargetGoal(this, PlayerEntity.class, true));
        this.targetSelector.add(4, new ActiveTargetGoal(this, PathAwareEntity.class, true));
    }

    @Override
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        this.dropItem(ModItems.GEYSER_BERRY_SPAWN_EGG);
        this.discard();
        return ActionResult.PASS;
    }


    @Override
    public boolean isFireImmune() {
        return true;
    }

    public static DefaultAttributeContainer.Builder createGeyserBerryAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 1)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.0f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20);

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
}
