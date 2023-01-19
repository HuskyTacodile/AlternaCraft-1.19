package com.huskytacodile.alternacraft.item.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import org.apache.logging.log4j.LogManager;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class CryoPodItem extends Item {
    public CryoPodItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResult interactLivingEntity(@NotNull ItemStack pStack, @NotNull Player pPlayer, @NotNull LivingEntity pInteractionTarget, @NotNull InteractionHand pUsedHand) {
        if (pPlayer.getLevel().isClientSide()){
            return InteractionResult.PASS;
        }
        if (pStack.getTag() != null && pStack.getTag().contains("entity")){
            Optional<Entity> entityOptional = EntityType.create(pStack.getTag().getCompound("entity"), pPlayer.getLevel());
            if (entityOptional.isEmpty()) {
                LogManager.getLogger().error("Couldn't spawn entity for unknown reasons. Contact the mod creator if this issue persists with other entities.");
                pPlayer.sendSystemMessage(Component.literal("Couldn't spawn entity for unknown reasons."));
                return InteractionResult.FAIL;
            } else {
                Entity ent = entityOptional.get();
                ent.setPos(pInteractionTarget.position());
                pPlayer.getLevel().addFreshEntity(ent);
                pStack.getOrCreateTag().remove("entity");
                pPlayer.setItemInHand(pUsedHand, pStack);
                return InteractionResult.SUCCESS;
            }
        }
        CompoundTag entity = new CompoundTag();
        if (!pInteractionTarget.save(entity)){
            LogManager.getLogger().error("Couldn't save entity for unknown reasons. Contact the mod creator if this issue persists with other entities.");
            pPlayer.sendSystemMessage(Component.literal("Couldn't store entity for unknown reasons."));
            return InteractionResult.FAIL;
        }
        pStack.getOrCreateTag().put("entity", entity);
        pInteractionTarget.remove(Entity.RemovalReason.DISCARDED);
        pPlayer.setItemInHand(pUsedHand, pStack);
        pPlayer.setItemInHand(pUsedHand, pStack);
        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        var pPlayer = pContext.getPlayer();
        var pStack = pContext.getItemInHand();
        if (pPlayer == null || pPlayer.getLevel().isClientSide()){
            return InteractionResult.PASS;
        }
        if (pStack.getTag() != null && pStack.getTag().contains("entity")){
            Optional<Entity> entityOptional = EntityType.create(pStack.getTag().getCompound("entity"), pContext.getLevel());
            if (entityOptional.isEmpty()) {
                LogManager.getLogger().error("Couldn't spawn entity for unknown reasons. Contact the mod creator if this issue persists with other entities.");
                pPlayer.sendSystemMessage(Component.literal("Couldn't spawn entity for unknown reasons."));
                return InteractionResult.FAIL;
            } else {
                Entity ent = entityOptional.get();
                ent.setPos(pContext.getClickLocation());
                pContext.getLevel().addFreshEntity(ent);
                pStack.getOrCreateTag().remove("entity");
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }
}
