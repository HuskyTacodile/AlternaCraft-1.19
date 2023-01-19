package com.huskytacodile.alternacraft.entities.dinos;

import com.huskytacodile.alternacraft.entities.variant.GenderVariant;
import com.huskytacodile.alternacraft.entities.variant.IVariant;
import com.huskytacodile.alternacraft.item.ModItems;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.ForgeEventFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public abstract class AlternaNonRideableDinoEntity extends AlternaDinoEntity implements GeoAnimatable {
    public AlternaNonRideableDinoEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor world, @NotNull DifficultyInstance difficulty,
                                        @NotNull MobSpawnType mobSpawnType, @Nullable SpawnGroupData groupData,
                                        @Nullable CompoundTag tag) {
        IVariant variant = Util.getRandom(GenderVariant.values(), this.random);
        setVariant(variant);

        return super.finalizeSpawn(world, difficulty, mobSpawnType, groupData, tag);
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull InteractionResult mobInteract(@NotNull Player player, @NotNull InteractionHand hand) {
        super.mobInteract(player, hand);
        if (this.getOwner() != null) {
            var itemStack = player.getItemInHand(hand);
            if (this.isFood(itemStack) && this.getHealth() < this.getMaxHealth()) {
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
                this.heal((float) itemStack.getItem().getFoodProperties().getNutrition());
                return InteractionResult.SUCCESS;
            } else {
                this.navigation.stop();
                this.setTarget(null);
                this.setOrderedToSit(true);
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public IVariant getVariant() {
        return GenderVariant.byId(this.getTypeVariant() & 255);
    }

    protected  <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (!(animationSpeed > -0.10F && animationSpeed < 0.05F)) {
            event.getController().setAnimation(RawAnimation.begin().thenLoop("animation." + getAnimationName() + ".walk"));
            return PlayState.CONTINUE;
        }
        if (this.isAggressive() && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.getController().setAnimation(RawAnimation.begin().thenLoop("animation." + getAnimationName() + ".attack"));
            return PlayState.CONTINUE;
        }
        if (this.isSitting() || this.getHealth() < 0.01 || this.isDeadOrDying() || this.isNaturallySitting()) {
            event.getController().setAnimation(RawAnimation.begin().thenLoop("animation." + getAnimationName() + ".sit"));
            return PlayState.CONTINUE;
        }
        if (this.isSwimming() && !(animationSpeed > -0.10F && animationSpeed < 0.05F) && !this.isAggressive()) {
            event.getController().setAnimation(RawAnimation.begin().thenLoop("animation." + getAnimationName() + ".walk"));
            return PlayState.CONTINUE;
        }
        if (this.isAsleep() || this.getHealth() < 0.01 || this.isDeadOrDying()) {
            event.getController().setAnimation(RawAnimation.begin().thenLoop("animation." + getAnimationName() + ".sleep"));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(RawAnimation.begin().thenLoop("animation." + getAnimationName() + ".idle"));

        return PlayState.CONTINUE;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController(this, "controller", 0, this::predicate));
    }
}
