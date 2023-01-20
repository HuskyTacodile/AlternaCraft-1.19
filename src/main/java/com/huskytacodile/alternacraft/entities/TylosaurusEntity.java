package com.huskytacodile.alternacraft.entities;

import com.huskytacodile.alternacraft.config.AlternacraftConfig;
import com.huskytacodile.alternacraft.entities.variant.GenderVariant;
import com.huskytacodile.alternacraft.util.ModSoundEvents;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.function.Predicate;



public class TylosaurusEntity extends WaterAnimal implements IAnimatable {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT =
            SynchedEntityData.defineId(TylosaurusEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> ASLEEP = SynchedEntityData.defineId(TylosaurusEntity.class, EntityDataSerializers.BOOLEAN);
    private AnimationFactory factory = GeckoLibUtil.createFactory(this);
    public static final Predicate<LivingEntity> PREY_SELECTOR = (p_30437_) -> {
        EntityType<?> entitytype = p_30437_.getType();
        return entitytype == EntityType.SHEEP || entitytype == EntityType.RABBIT
                || entitytype == EntityType.COW || entitytype == EntityType.CHICKEN ||
                entitytype == EntityType.PIG ||
                entitytype == EntityType.SALMON ||
                entitytype == EntityType.TROPICAL_FISH ||
                entitytype == EntityType.TURTLE ||
                entitytype == EntityType.DROWNED ||
                entitytype == EntityType.DOLPHIN ||
                entitytype == ModEntityTypes.JPSPINO.get()||
                entitytype == ModEntityTypes.OXALAIA.get()||
                entitytype == ModEntityTypes.TYRANNOSAURUS.get()||
                entitytype == ModEntityTypes.YUTYRANNUS.get()||
                entitytype == ModEntityTypes.CARCHA.get()||
                entitytype == ModEntityTypes.GIGA.get()||
                entitytype == ModEntityTypes.BARYONYX.get()||
                entitytype == ModEntityTypes.BARYONYX_GEN2.get()||
                entitytype == ModEntityTypes.CERATOSUCHOPS.get()||
                entitytype == ModEntityTypes.INDOMINUS.get()||
                entitytype == ModEntityTypes.INDORAPTOR_GEN2.get()||
                entitytype == ModEntityTypes.ALLOSAURUS.get()||
                entitytype == ModEntityTypes.SCORPIUS.get();
    };
    protected TylosaurusEntity(EntityType<? extends WaterAnimal> p_i48575_1_, Level p_i48575_2_) {
        super(p_i48575_1_, p_i48575_2_);
        this.moveControl = new TylosaurusEntity.FishMoveControl(this);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
    }
    @SuppressWarnings("deprecation")
	public boolean isFood(ItemStack p_70877_1_) {
        Item item = p_70877_1_.getItem();
        return item.isEdible() && item.getFoodProperties().isMeat();
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
    }
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_146746_, DifficultyInstance p_146747_, MobSpawnType p_146748_, @Nullable SpawnGroupData p_146749_, @Nullable CompoundTag p_146750_) {
        GenderVariant variant = Util.getRandom(GenderVariant.values(), this.random);
        setVariant(variant);
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }
    private void setVariant(GenderVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
        this.entityData.set(ASLEEP, false);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", this.getTypeVariant());
        tag.putBoolean("IsAsleep", this.isAsleep());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag p_21815_) {
        super.readAdditionalSaveData(p_21815_);
        this.entityData.set(DATA_ID_TYPE_VARIANT, p_21815_.getInt("Variant"));
        this.entityData.set(ASLEEP, p_21815_.getBoolean("IsAsleep"));
    }
    public GenderVariant getVariant() {
        return GenderVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }
    
    public boolean isAsleep() {
    	return this.entityData.get(ASLEEP);
    }
    
    private void setAsleep(boolean isAsleep) {
    	this.entityData.set(ASLEEP, isAsleep);
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return this.isAsleep() ? null : ModSoundEvents.TYLO_AMBIENT.get();
    }


    @Override
    protected SoundEvent getDeathSound()
    {
        return ModSoundEvents.TYLO_DEATH.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return ModSoundEvents.TYLO_HURT.get();
    }
    public boolean doHurtTarget(Entity p_70652_1_) {
        boolean flag = super.doHurtTarget(p_70652_1_);
        if (flag) {
            this.doEnchantDamageEffects(this, p_70652_1_);
        }

        return flag;
    }


    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (!(animationSpeed > -0.10F && animationSpeed < 0.05F) && !this.isAggressive()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.tylo.swim", ILoopType.EDefaultLoopTypes.LOOP));
            return PlayState.CONTINUE;
        }
        if (this.isAggressive() && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.tylo.attack", ILoopType.EDefaultLoopTypes.LOOP));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.tylo.idle", ILoopType.EDefaultLoopTypes.LOOP));

        return PlayState.CONTINUE;
    }
    public void travel(Vec3 p_27490_) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(0.01F, p_27490_);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
            if (this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(p_27490_);
        }

    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<TylosaurusEntity>
                (this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    public static AttributeSupplier.Builder attributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 180.00D)
                .add(Attributes.MOVEMENT_SPEED, 0.70D)
                .add(Attributes.FOLLOW_RANGE, 30.0D)
                .add(Attributes.ATTACK_DAMAGE, 30.0D);
    }
    public boolean canBreatheUnderwater() {
        return true;
    }
    protected SoundEvent getSwimSound() {
        return SoundEvents.FISH_SWIM;
    }

    protected void playStepSound(BlockPos p_180429_1_, BlockState p_180429_2_) {
    }
    protected boolean canRandomSwim() {
        return true;
    }

    public MobType getMobType() {
        return MobType.WATER;
    }
    static class FishSwimGoal extends RandomSwimmingGoal {
        private final TylosaurusEntity fish;

        public FishSwimGoal(TylosaurusEntity p_27505_) {
            super(p_27505_, 1.0D, 40);
            this.fish = p_27505_;
        }


        public boolean canUse() {
            return this.fish.canRandomSwim() && super.canUse();
        }
    }
    protected PathNavigation createNavigation(Level p_27480_) {
        return new WaterBoundPathNavigation(this, p_27480_);
    }

    static class FishMoveControl extends MoveControl {
        private final TylosaurusEntity fish;

        FishMoveControl(TylosaurusEntity p_27501_) {
            super(p_27501_);
            this.fish = p_27501_;
        }

        @SuppressWarnings("deprecation")
		public void tick() {
            if (this.fish.isEyeInFluid(FluidTags.WATER)) {
                this.fish.setDeltaMovement(this.fish.getDeltaMovement().add(0.0D, 0.005D, 0.0D));
            }

            if (this.operation == Operation.MOVE_TO && !this.fish.getNavigation().isDone()) {
                float f = (float)(this.speedModifier * this.fish.getAttributeValue(Attributes.MOVEMENT_SPEED));
                this.fish.setSpeed(Mth.lerp(0.125F, this.fish.getSpeed(), f));
                double d0 = this.wantedX - this.fish.getX();
                double d1 = this.wantedY - this.fish.getY();
                double d2 = this.wantedZ - this.fish.getZ();
                if (d1 != 0.0D) {
                    double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                    this.fish.setDeltaMovement(this.fish.getDeltaMovement().add(0.0D, (double)this.fish.getSpeed() * (d1 / d3) * 0.1D, 0.0D));
                }

                if (d0 != 0.0D || d2 != 0.0D) {
                    float f1 = (float)(Mth.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
                    this.fish.setYRot(this.rotlerp(this.fish.getYRot(), f1, 90.0F));
                    this.fish.yBodyRot = this.fish.getYRot();
                }

            } else {
                this.fish.setSpeed(0.0F);
            }
        }
    }
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(4, new TylosaurusEntity.SleepingRandomLookAroundGoal(this));
        this.goalSelector.addGoal(4, new TylosaurusEntity.NocturnalSleepGoal(this));
        this.goalSelector.addGoal(5,new RandomSwimmingGoal(this,0,2));
        this.goalSelector.addGoal(3,new FishSwimGoal(this));
    }
    
    public class NocturnalSleepGoal extends Goal {
    	public TylosaurusEntity entity;
    	
    	public NocturnalSleepGoal(TylosaurusEntity sleeper) {
    		super();
    		this.entity = sleeper;
    	}
    	
    	@Override
    	public boolean canUse() {
    		Level world = entity.level;
    		if (AlternacraftConfig.sleepingAi = true && world.getDayTime() >= 0 && world.getDayTime() <= 12000 && entity.getLastHurtByMob() == null && entity.getTarget() == null && !entity.isInPowderSnow && entity.isInWater()) {
    			return true;
    		} else return false;
    	}
    	
    	@Override
    	public boolean canContinueToUse() {
    		Level world = entity.level;
    		if (world.getDayTime() >= 12000 && world.getDayTime() < 24000 || entity.getLastHurtByMob() != null || entity.getTarget() != null || entity.isInPowderSnow || !entity.isInWater()) {
    			stop();
    			return false;
    		} else return true;
    	}
    	
    	@Override
    	public void start() {
    		entity.setAsleep(true);
    		entity.getNavigation().stop();
    	}
    	
    	public void tick() {
    		super.tick();
    		Level world = entity.level;
    		if (world.getDayTime() >= 12000 && world.getDayTime() < 24000 || entity.getLastHurtByMob() != null || entity.getTarget() != null || entity.isInPowderSnow || !entity.isInWater()) {
    			stop();
    		}
    	}
    	
    	@Override
    	public void stop() {
    		entity.setAsleep(false);
    	}
    }
    
    public class SleepingRandomLookAroundGoal extends RandomLookAroundGoal {
    	
    	TylosaurusEntity entity;
    	
    	public SleepingRandomLookAroundGoal(TylosaurusEntity entity) {
    		super(entity);
    		this.entity = entity;
    	}
    	
    	public boolean canUse() {
    		return super.canUse() && !entity.isAsleep();
    	}
    	
    	public boolean canContinueToUse() {
    		return super.canContinueToUse() && !entity.isAsleep();
    	}

    }
}