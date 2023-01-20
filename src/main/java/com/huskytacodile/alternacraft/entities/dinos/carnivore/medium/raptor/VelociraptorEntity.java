package com.huskytacodile.alternacraft.entities.dinos.carnivore.medium.raptor;

import com.huskytacodile.alternacraft.entities.attackgoal.RaptorMeleeAttackGoal;
import com.huskytacodile.alternacraft.entities.variant.DuodecupleVariant;
import com.huskytacodile.alternacraft.entities.variant.IVariant;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.huskytacodile.alternacraft.entities.ai.CathemeralSleepGoal;
import com.huskytacodile.alternacraft.entities.ai.DinoSittingGoal;
import com.huskytacodile.alternacraft.entities.ai.SleepingRandomLookAroundGoal;
import com.huskytacodile.alternacraft.entities.dinos.RaptorEntity;
import com.huskytacodile.alternacraft.util.ModSoundEvents;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NonTameRandomTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class VelociraptorEntity extends RaptorEntity {
    public VelociraptorEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
        this.setTame(false);
    }
    @Override
    public AttributeSupplier attributeSupplier() {
        return VelociraptorEntity.attributes().build();
    }
    public static AttributeSupplier.Builder attributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 46.00D)
                .add(Attributes.MOVEMENT_SPEED, 0.4D)
                .add(Attributes.FOLLOW_RANGE, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 6.0D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(1, new RaptorMeleeAttackGoal(this, 1.2, false));
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(4, new SleepingRandomLookAroundGoal<>(this));
        this.goalSelector.addGoal(4, new CathemeralSleepGoal<>(this));
        this.goalSelector.addGoal(4, new DinoSittingGoal(this));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, Ingredient.of(Items.NETHERITE_SWORD), false));
        this.goalSelector.addGoal(3, new RandomSwimmingGoal(this,0,1));
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.targetSelector.addGoal(5, new NonTameRandomTargetGoal<>(this, Animal.class, false,
                getPreySelection(this)));
    }
    


    @Override
    public SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor p_146746_, @NotNull DifficultyInstance p_146747_, @NotNull MobSpawnType p_146748_, @Nullable SpawnGroupData p_146749_, @Nullable CompoundTag p_146750_) {
        DuodecupleVariant variant = Util.getRandom(DuodecupleVariant.values(), this.random);
        setVariant(variant);
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }

    public IVariant getVariant() {
        return DuodecupleVariant.byId(this.getTypeVariant() & 255);
    }


    @Override
    protected SoundEvent getAmbientSound()
    {
        return this.isAsleep() ? ModSoundEvents.RAPTOR_SNORE.get() : ModSoundEvents.RAPTOR_IDLE.get();
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return ModSoundEvents.RAPTOR_DEATH.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return ModSoundEvents.RAPTOR_HURT.get();
    }

    @Override
    public String getAnimationName() {
        return "raptor";
    }

    @Nullable
    @Override
        public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
            return null;
    }
}