package com.huskytacodile.alternacraft.entities.dinos.carnivore.large;

import com.huskytacodile.alternacraft.entities.ai.DinoSittingGoal;
import com.huskytacodile.alternacraft.entities.ai.DiurnalSleepGoal;
import com.huskytacodile.alternacraft.entities.ai.SleepingRandomLookAroundGoal;
import com.huskytacodile.alternacraft.entities.attackgoal.SpinosaurusMeleeAttackGoal;
import com.huskytacodile.alternacraft.entities.dinos.LargeCarnivoreEntity;
import com.huskytacodile.alternacraft.entities.variant.IVariant;
import com.huskytacodile.alternacraft.entities.variant.TripleVariant;
import com.huskytacodile.alternacraft.util.ModSoundEvents;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NonTameRandomTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AcroEntity extends LargeCarnivoreEntity {
    public AcroEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.isAsleep() ? null : ModSoundEvents.ACRO_GROWL.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSoundEvents.ACRO_ROAR2.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSoundEvents.ACRO_ROAR1.get();
    }

    @Override
    public SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor p_146746_, @NotNull DifficultyInstance p_146747_, @NotNull MobSpawnType p_146748_, @Nullable SpawnGroupData p_146749_, @Nullable CompoundTag p_146750_) {
        TripleVariant variant = Util.getRandom(TripleVariant.values(), this.random);
        setVariant(variant);
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }

    @Override
    public IVariant getVariant() {
        return TripleVariant.byId(this.getTypeVariant() & 255);
    }

    @Override
    public String getAnimationName() {
        return "acrocanthosaurus";
    }

    @Override
    public AttributeSupplier attributeSupplier() {
        return AcroEntity.attributes().build();
    }
    public static AttributeSupplier.Builder attributes() {
        return TamableAnimal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 95.00D)
                .add(Attributes.MOVEMENT_SPEED, 0.2D)
                .add(Attributes.FOLLOW_RANGE, 16.0D)
                .add(Attributes.ATTACK_DAMAGE, 10.0D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(1, new SpinosaurusMeleeAttackGoal(this, 1.2, false));
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(4, new SleepingRandomLookAroundGoal<>(this));
        this.goalSelector.addGoal(4, new DinoSittingGoal(this));
        this.goalSelector.addGoal(4, new DiurnalSleepGoal<>(this));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, Ingredient.of(Items.NETHERITE_SWORD), false));
        this.goalSelector.addGoal(0,new RandomSwimmingGoal(this,0,1));
        this.goalSelector.addGoal(2, new FloatGoal(this));
        this.targetSelector.addGoal(5, new NonTameRandomTargetGoal<>(this, Animal.class, false,
                getPreySelection(this)));
    }
    


    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return null;
    }
}