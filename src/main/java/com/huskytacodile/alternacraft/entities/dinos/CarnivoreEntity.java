package com.huskytacodile.alternacraft.entities.dinos;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;

import java.util.function.Predicate;

public abstract class CarnivoreEntity extends AlternaDinoEntity {

    public CarnivoreEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }
    protected static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(CarnivoreEntity.class, EntityDataSerializers.BOOLEAN);
    protected Predicate<LivingEntity> getPreySelection(Entity entity) {
        return (e) -> e.getType() != entity.getType() && (e.getType() == EntityType.SHEEP || e.getType() == EntityType.RABBIT
                || e.getType() == EntityType.COW || e.getType() == EntityType.CHICKEN || e.getType() == EntityType.PIG || e.getType() == EntityType.HORSE
                || e.getType() == EntityType.GOAT);
    }

    @SuppressWarnings("deprecation")
	public boolean isFood(ItemStack stack) {
        Item item = stack.getItem();
        return item.isEdible() && item.getFoodProperties().isMeat();
    }
    public void setAttacking(boolean attack) {
        this.entityData.set(ATTACKING, attack);
    }
    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
    }

    private <E extends GeoAnimatable> PlayState attackPredicate(AnimationState<E> event) {
        if(isAttacking()) {
            event.getController().setAnimation(RawAnimation.begin().thenLoop("animation." + this.getAnimationName() + ".attack"));

            return PlayState.CONTINUE;
        }

        return PlayState.STOP;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        super.registerControllers(data);
        data.add(new AnimationController
                (this, "attackController", 0, this::attackPredicate));
    }

}
