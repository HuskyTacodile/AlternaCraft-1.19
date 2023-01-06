package com.huskytacodile.alternacraft.entities.dinos;

import com.huskytacodile.alternacraft.entities.Sleeping;
import com.huskytacodile.alternacraft.entities.variant.IVariant;
import com.huskytacodile.alternacraft.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import org.apache.logging.log4j.LogManager;
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

import java.util.EnumMap;
import java.util.Map;

public abstract class AlternaDinoEntity extends TamableAnimal implements PlayerRideableJumping, GeoAnimatable, Sleeping {
    public enum DinoLevelCategory{
        HEALTH(Attributes.MAX_HEALTH, .054f),
        ATTACK(Attributes.ATTACK_DAMAGE, .017f),
        SPEED(Attributes.MOVEMENT_SPEED, .025f);

        public final Attribute attribute;
        public final float multiplier;
        DinoLevelCategory(Attribute attribute, float multiplier){
            this.attribute = attribute;
            this.multiplier = multiplier;
        }
    }
	private static final EntityDataAccessor<Boolean> ASLEEP = SynchedEntityData.defineId(AlternaDinoEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> NATURAL_SITTING = SynchedEntityData.defineId(AlternaDinoEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(AlternaDinoEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> SITTING = SynchedEntityData.defineId(AlternaDinoEntity.class, EntityDataSerializers.BOOLEAN);

    final AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    public AlternaDinoEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor world, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType mobSpawnType, @Nullable SpawnGroupData groupData, @Nullable CompoundTag tag) {
        return super.finalizeSpawn(world, difficulty, mobSpawnType, groupData, tag);
    }

    protected Item getTamingItem() {
        return ModItems.TOTEM_OF_HUGO.get();
    }

    public abstract AttributeSupplier attributeSupplier();

    public void aiStep() {
        super.aiStep();
        if (this.level.isClientSide()){
            return;
        }
        if (this.isAsleep() || this.isNaturallySitting()) {
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0D);
        } else {
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(getAttributeLeveledAttribute(DinoLevelCategory.SPEED));
        }
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(getAttributeLeveledAttribute(DinoLevelCategory.HEALTH));
        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(getAttributeLeveledAttribute(DinoLevelCategory.ATTACK));
        this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(getAttributeLeveledAttribute(DinoLevelCategory.SPEED));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
        this.entityData.define(SITTING, false);
        this.entityData.define(ASLEEP, false);
        this.entityData.define(NATURAL_SITTING, false);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", this.getTypeVariant());
        tag.putBoolean("IsAsleep", this.isAsleep());
        tag.putBoolean("NaturallySitting", this.isNaturallySitting());
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
        this.entityData.set(ASLEEP, tag.getBoolean("IsAsleep"));
        this.entityData.set(NATURAL_SITTING, tag.getBoolean("NaturallySitting"));
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

    @SuppressWarnings("deprecation")
	@Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();

        if (this.level.isClientSide) {
            boolean flag = this.isOwnedBy(player) || this.isTame()
                    || item == getTamingItem() && !this.isTame();
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            if (this.isTame()) {
                if(player.isCrouching() && hand == InteractionHand.MAIN_HAND) {
                    setSitting(!isSitting());
                }

                if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                    if (!player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }
                    this.heal((float)item.getFoodProperties().getNutrition());
                    return InteractionResult.SUCCESS;
                }

                player.startRiding(this);

            } else if (item == Items.NETHERITE_SWORD && !this.isOnFire()) {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }

                if (this.random.nextInt(3) == 0 && !ForgeEventFactory.onAnimalTame(this, player)) {
                    this.tame(player);
                    this.navigation.stop();
                    this.setTarget(null);
                    this.setOrderedToSit(true);
                    this.level.broadcastEntityEvent(this, (byte)7);
                } else {
                    this.level.broadcastEntityEvent(this, (byte)6);
                }
                return InteractionResult.SUCCESS;
            }
            return super.mobInteract(player, hand);
        }
    }

    @Override
    public void onPlayerJump(int pJumpPower){
        net.minecraftforge.common.ForgeHooks.onLivingJump(this);
        this.addDeltaMovement(new Vec3(0, 0.5 + pJumpPower / 300f, 0));
    }

    @Override
    public boolean canJump(@NotNull Player pPlayer){
        return this.isOnGround() && this.getOwner() != null  && canBeControlledByRider();
    }

    @Override
    public void handleStartJump(int pJumpPower){}
    @Override
    public void handleStopJump() {}


    public @NotNull Vec3 getDismountLocationForPassenger(@NotNull LivingEntity p_230268_1_) {
        Direction direction = this.getMotionDirection();
        if (direction.getAxis() != Direction.Axis.Y) {
            int[][] aint = DismountHelper.offsetsForDirection(direction);
            BlockPos blockpos = this.blockPosition();
            BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();

            for (Pose pose : p_230268_1_.getDismountPoses()) {
                AABB axisalignedbb = p_230268_1_.getLocalBoundsForPose(pose);

                for (int[] aint1 : aint) {
                    blockpos$mutable.set(blockpos.getX() + aint1[0], blockpos.getY(), blockpos.getZ() + aint1[1]);
                    double d0 = this.level.getBlockFloorHeight(blockpos$mutable);
                    if (DismountHelper.isBlockFloorValid(d0)) {
                        Vec3 vec3 = Vec3.upFromBottomCenterOf(blockpos$mutable, d0);
                        if (DismountHelper.canDismountTo(this.level, p_230268_1_, axisalignedbb.move(vec3))) {
                            p_230268_1_.setPose(pose);
                            return vec3;
                        }
                    }
                }
            }

        }
        return super.getDismountLocationForPassenger(p_230268_1_);
    }

    public void travel(@NotNull Vec3 pTravelVector) {
        if (this.isAlive()) {
            if (this.isVehicle() && canBeControlledByRider()) {
                LivingEntity livingentity = (LivingEntity)this.getControllingPassenger();
                this.setYRot(livingentity.getYRot());
                this.yRotO = this.getYRot();
                this.setXRot(livingentity.getXRot() * 0.5F);
                this.setRot(this.getYRot(), this.getXRot());
                this.yBodyRot = this.getYRot();
                this.yHeadRot = this.yBodyRot;
                float f = livingentity.xxa * 0.5F;
                float f1 = livingentity.zza;
                if (f1 <= 0.0F) {
                    f1 *= 0.25F;
                }

                if (this.isControlledByLocalInstance()) {
                    this.setSpeed((float)this.getAttributeValue(Attributes.MOVEMENT_SPEED));
                    super.travel(new Vec3(f, pTravelVector.y, f1));
                }

                this.calculateEntityAnimation(this, false);
                this.tryCheckInsideBlocks();
            } else {
                super.travel(pTravelVector);
            }
        }
    }

    protected SoundEvent getSwimSound() {
        return SoundEvents.FISH_SWIM;
    }

    public Entity getControllingPassenger() {
        return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
    }

    public boolean canBeControlledByRider() {
        Entity entity = this.getControllingPassenger();
        if (!(entity instanceof Player)) {
            return false;
        } else {
            Player playerentity = (Player)entity;
            return playerentity.getMainHandItem().getItem() == Items.NETHERITE_SWORD || playerentity.getOffhandItem().getItem() == Items.NETHERITE_SWORD;
        }
    }

    public void setSitting(boolean sitting) {
        this.entityData.set(SITTING, sitting);
        this.setOrderedToSit(sitting);
    }

    public boolean isSitting() {
        return this.entityData.get(SITTING);
    }

    protected void setVariant(IVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }
    
    public boolean isAsleep() {
    	return this.entityData.get(ASLEEP);
    }
    
    public void setAsleep(boolean isAsleep) {
    	this.entityData.set(ASLEEP, isAsleep);
    }
    
    public boolean isNaturallySitting() {
    	return this.entityData.get(NATURAL_SITTING);
    }
    
    public void setNaturallySitting(boolean isSitting) {
    	this.entityData.set(NATURAL_SITTING, isSitting);
    }

    public IVariant getVariant() {
        return null;
    }

    protected int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }


    public abstract String getAnimationName();




    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    public boolean doHurtTarget(@NotNull Entity entity) {
        boolean flag = super.doHurtTarget(entity);
        if (flag) {
            this.doEnchantDamageEffects(this, entity);
        }

        return flag;
    }

    public boolean canBeLeashed(Player player){
        return false;
    }

    @Override
    public double getTick(Object object) {
        return this.tickCount;
    }

    @Override
    public double getPassengersRidingOffset() {
        return 3d;
    }

    @Override
    public float getStepHeight() {
        return 1f;
    }

    @Override
    protected int calculateFallDamage(float pFallDistance, float pDamageMultiplier) {
        return fallDistance > 4 ? super.calculateFallDamage(pFallDistance, pDamageMultiplier) : 0;
    }

    public double getAttributeLeveledAttribute(DinoLevelCategory category){
        return attributeSupplier().getValue(category.attribute);
    }
}
