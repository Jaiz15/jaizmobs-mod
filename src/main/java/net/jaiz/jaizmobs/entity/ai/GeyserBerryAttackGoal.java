package net.jaiz.jaizmobs.entity.ai;

import net.jaiz.jaizmobs.entity.custom.GeyserBerryEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class GeyserBerryAttackGoal extends MeleeAttackGoal {
    private final GeyserBerryEntity entity;

    public GeyserBerryAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = ((GeyserBerryEntity) mob);
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    protected void attack(LivingEntity pEnemy) {
        if (isEnemyWithinAttackDistance(pEnemy)) {
            performAttack(pEnemy);
        } else {
            entity.setAttacking(false);
        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy) {
        return this.entity.distanceTo(pEnemy) <= 0.6f; // TODO
    }


    protected void performAttack(LivingEntity pEnemy) {
        this.mob.getLookControl().lookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
        this.mob.getWorld().createExplosion(this.mob, this.mob.getX(), this.mob.getY(),
                this.mob.getZ(), 1.2f,
                World.ExplosionSourceType.MOB);
        this.mob.tryAttack(pEnemy);
        this.mob.kill();
        this.mob.discard();
    }

    @Override
    public void tick() {
        super.tick();
    }

}