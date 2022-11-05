package com.huskytacodile.alternacraft.entities.dinos;

import java.util.function.Predicate;

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
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;

import static com.huskytacodile.alternacraft.entities.dinos.SmallCarnivoreEntity.ATTACKING;

public abstract class CarnivoreEntity extends AlternaDinoEntity {

    public CarnivoreEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }
    protected static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(CarnivoreEntity.class, EntityDataSerializers.BOOLEAN);

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

    private <E extends IAnimatable> PlayState attackPredicate(AnimationEvent<E> event) {
        if(isAttacking()) {
            event.getController().setAnimation(new AnimationBuilder()
                    .addAnimation("animation." + this.getAnimationName() + ".attack", false));

            return PlayState.CONTINUE;
        }

        return PlayState.STOP;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public void registerControllers(AnimationData data) {
        super.registerControllers(data);
        data.addAnimationController(new AnimationController
                (this, "attackController", 0, this::attackPredicate));
    }

}
