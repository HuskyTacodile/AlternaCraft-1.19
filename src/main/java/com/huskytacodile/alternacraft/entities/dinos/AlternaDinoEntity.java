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
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import org.apache.logging.log4j.LogManager;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.Objects;

public abstract class AlternaDinoEntity extends TamableAnimal implements PlayerRideableJumping, IAnimatable, Sleeping {
	private static final EntityDataAccessor<Boolean> ASLEEP = SynchedEntityData.defineId(AlternaDinoEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> NATURAL_SITTING = SynchedEntityData.defineId(AlternaDinoEntity.class, EntityDataSerializers.BOOLEAN);

    protected AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public AlternaDinoEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    protected static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT =
            SynchedEntityData.defineId(AlternaDinoEntity.class, EntityDataSerializers.INT);
    protected static final EntityDataAccessor<Boolean> SITTING =
            SynchedEntityData.defineId(AlternaDinoEntity.class, EntityDataSerializers.BOOLEAN);

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
            Objects.requireNonNull(this.getAttribute(Attributes.MOVEMENT_SPEED)).setBaseValue(0.0D);
        } else {
            Objects.requireNonNull(this.getAttribute(Attributes.MOVEMENT_SPEED)).setBaseValue(getAttributeLeveledAttribute(Attributes.MOVEMENT_SPEED));
        }
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


    protected  <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (!(animationSpeed > -0.10F && animationSpeed < 0.05F)) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation." + getAnimationName() + ".walk", ILoopType.EDefaultLoopTypes.LOOP));
            return PlayState.CONTINUE;
        }
        if (this.isAggressive() && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation." + getAnimationName() + ".attack", ILoopType.EDefaultLoopTypes.LOOP));
            return PlayState.CONTINUE;
        }
        if (this.isSitting() || this.getHealth() < 0.01 || this.isDeadOrDying() || this.isNaturallySitting()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation." + getAnimationName() + ".sit", ILoopType.EDefaultLoopTypes.LOOP));
            return PlayState.CONTINUE;
        }
        if (this.isSwimming() && !(animationSpeed > -0.10F && animationSpeed < 0.05F) && !this.isAggressive()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation." + getAnimationName() + ".walk", ILoopType.EDefaultLoopTypes.LOOP));
            return PlayState.CONTINUE;
        }
        if (this.isAsleep() || this.getHealth() < 0.01 || this.isDeadOrDying()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation." + getAnimationName() + ".sleep", ILoopType.EDefaultLoopTypes.LOOP));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation." + getAnimationName() + ".idle", ILoopType.EDefaultLoopTypes.LOOP));

        return PlayState.CONTINUE;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController
                (this, "controller", 0, this::predicate));
    }

    @SuppressWarnings("deprecation")
	@Override
    public @NotNull InteractionResult mobInteract(Player player, @NotNull InteractionHand hand) {
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
                    if (item.getFoodProperties() == null){
                        LogManager.getLogger().error("prevented NPE in AlternaDinoEntity.java amke sure the food item has a nutrition value 0.o weirdo!");
                        return InteractionResult.FAIL;
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
        this.setDeltaMovement(new Vec3(0, 0.5 + pJumpPower / 300f, 0));
    }

    @Override
    public boolean canJump(){
        return this.isOnGround() && this.getOwner() != null  && canBeControlledByRider();
    }

    @Override
    public void handleStartJump(int pJumpPower){}
    @Override
    public void handleStopJump() {}

    public @NotNull Vec3 getDismountLocationForPassenger(@NotNull LivingEntity p_230268_1_) {
        Direction direction = this.getMotionDirection();
        if (direction.getAxis() != Direction.Axis.Y) {
            int[][] aInt = DismountHelper.offsetsForDirection(direction);
            BlockPos blockpos = this.blockPosition();
            BlockPos.MutableBlockPos blockPos$mutable = new BlockPos.MutableBlockPos();

            for (Pose pose : p_230268_1_.getDismountPoses()) {
                AABB axisAlignedBb = p_230268_1_.getLocalBoundsForPose(pose);

                for (int[] aInt1 : aInt) {
                    blockPos$mutable.set(blockpos.getX() + aInt1[0], blockpos.getY(), blockpos.getZ() + aInt1[1]);
                    double d0 = this.level.getBlockFloorHeight(blockPos$mutable);
                    if (DismountHelper.isBlockFloorValid(d0)) {
                        Vec3 vec3 = Vec3.upFromBottomCenterOf(blockPos$mutable, d0);
                        if (DismountHelper.canDismountTo(this.level, p_230268_1_, axisAlignedBb.move(vec3))) {
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
            if (this.isVehicle() && canBeControlledByRider() && this.getControllingPassenger() != null) {
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

    protected @NotNull SoundEvent getSwimSound() {
        return SoundEvents.FISH_SWIM;
    }

    public Entity getControllingPassenger() {
        return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
    }

    public boolean canBeControlledByRider() {
        Entity entity = this.getControllingPassenger();
        if (!(entity instanceof Player playerEntity)) {
            return false;
        } else {
            return playerEntity.getMainHandItem().getItem() == Items.NETHERITE_SWORD || playerEntity.getOffhandItem().getItem() == Items.NETHERITE_SWORD;
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
    public AnimationFactory getFactory() {
        return this.factory;
    }

    public boolean doHurtTarget(@NotNull Entity entity) {
        boolean flag = super.doHurtTarget(entity);
        if (flag) {
            this.doEnchantDamageEffects(this, entity);
        }

        return flag;
    }

    public boolean canBeLeashed(@NotNull Player player){
        return false;
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

    public double getAttributeLeveledAttribute(Attribute category){
        return attributeSupplier().getValue(category);
    }
}
