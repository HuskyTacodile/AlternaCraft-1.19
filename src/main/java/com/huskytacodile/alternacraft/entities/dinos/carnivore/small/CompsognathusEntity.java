package com.huskytacodile.alternacraft.entities.dinos.carnivore.small;

import com.huskytacodile.alternacraft.entities.attackgoal.CompyMeleeAttackGoal;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.large.AllosaurusEntity;
import com.huskytacodile.alternacraft.entities.smalldinoai.SmallDinoNocturnalSleepGoal;
import com.huskytacodile.alternacraft.entities.smalldinoai.SmallDinoSittingGoal;
import com.huskytacodile.alternacraft.entities.smalldinoai.SmallDinoSleepingRandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.huskytacodile.alternacraft.entities.dinos.SmallCarnivoreEntity;
import com.huskytacodile.alternacraft.entities.variant.IVariant;
import com.huskytacodile.alternacraft.entities.variant.TripleVariant;
import com.huskytacodile.alternacraft.util.ModSoundEvents;

import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NonTameRandomTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

public class CompsognathusEntity extends SmallCarnivoreEntity {
	public CompsognathusEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
		super(entityType, level);
		this.setTame(false);
	}
	@Override
	public AttributeSupplier attributeSupplier() {
		return CompsognathusEntity.attributes().build();
	}
	public static AttributeSupplier.Builder attributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 12.00D)
				.add(Attributes.MOVEMENT_SPEED, 0.15D)
				.add(Attributes.FOLLOW_RANGE, 16.0D)
				.add(Attributes.ATTACK_DAMAGE, 3.0D);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
		this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
		this.goalSelector.addGoal(1, new CompyMeleeAttackGoal(this, 1.2, false));
		this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(4, new SmallDinoSleepingRandomLookAroundGoal(this));
		this.goalSelector.addGoal(4, new SmallDinoSittingGoal(this));
		this.goalSelector.addGoal(4, new SmallDinoNocturnalSleepGoal(this));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, Ingredient.of(Items.NETHERITE_SWORD), false));
		this.goalSelector.addGoal(0,new RandomSwimmingGoal(this,0,1));
		this.goalSelector.addGoal(2, new FloatGoal(this));
		this.targetSelector.addGoal(5, new NonTameRandomTargetGoal<>(this, Animal.class, false,
				getPreySelection(this)));
	}



	@Override
	public SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor p_146746_, @NotNull DifficultyInstance p_146747_, @NotNull MobSpawnType p_146748_, @Nullable SpawnGroupData p_146749_, @Nullable CompoundTag p_146750_) {
		TripleVariant variant = Util.getRandom(TripleVariant.values(), this.random);
		setVariant(variant);
		return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
	}

	public IVariant getVariant() {
		return TripleVariant.byId(this.getTypeVariant() & 255);
	}

	@Override
	protected SoundEvent getAmbientSound()
	{
		return this.isAsleep() ? null : ModSoundEvents.COMPY_AMBIENT.get();
	}

	@Override
	protected SoundEvent getDeathSound()
	{
		return ModSoundEvents.COMPY_DEATH.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn)
	{
		return ModSoundEvents.COMPY_HURT.get();
	}

	@Override
	public String getAnimationName() {
		return "compsognathus";
	}


	@Nullable
	@Override
	public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
		return null;
	}

	@Override
	public double getTick(Object object) {
		return 0;
	}
}