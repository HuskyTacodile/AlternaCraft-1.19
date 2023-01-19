package com.huskytacodile.alternacraft.mixin;

import com.huskytacodile.alternacraft.misc.MixinDebugHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.inventory.Slot;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Debug(export = true)
@Mixin(InventoryMenu.class)
public abstract class InventoryMenuSlotMixin{
    @Shadow
    @Final
    CraftingContainer craftSlots;
    @Shadow
    @Final
    ResultContainer resultSlots;
    @Shadow
    @Final
    static EquipmentSlot[] SLOT_IDS;
    @Shadow
    @Final
    static ResourceLocation[] TEXTURE_EMPTY_SLOTS;

    @Redirect(method = "Lnet/minecraft/world/inventory/InventoryMenu;<init>(Lnet/minecraft/world/entity/player/Inventory;ZLnet/minecraft/world/entity/player/Player;)V", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/world/inventory/InventoryMenu;addSlot(Lnet/minecraft/world/inventory/Slot;)Lnet/minecraft/world/inventory/Slot;", ordinal = 4))
    private Slot moveHotbar(InventoryMenu instance, Slot pSlot, Inventory pPlayerInventory, boolean pActive, Player pOwner) {
        return MixinDebugHelper.InventoryMenuSlotMixinHotbar(instance, pSlot, pPlayerInventory, pActive, pOwner);
    }

    @Redirect(method = "Lnet/minecraft/world/inventory/InventoryMenu;<init>(Lnet/minecraft/world/entity/player/Inventory;ZLnet/minecraft/world/entity/player/Player;)V", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/world/inventory/InventoryMenu;addSlot(Lnet/minecraft/world/inventory/Slot;)Lnet/minecraft/world/inventory/Slot;", ordinal = 3))
    private Slot moveInventory(InventoryMenu instance, Slot pSlot, Inventory pPlayerInventory, boolean pActive, Player pOwner) {
        return MixinDebugHelper.InventoryMenuSlotMixinInventory(instance, pSlot, pPlayerInventory, pActive, pOwner);
    }

    @Redirect(method = "Lnet/minecraft/world/inventory/InventoryMenu;<init>(Lnet/minecraft/world/entity/player/Inventory;ZLnet/minecraft/world/entity/player/Player;)V", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/world/inventory/InventoryMenu;addSlot(Lnet/minecraft/world/inventory/Slot;)Lnet/minecraft/world/inventory/Slot;", ordinal = 0))
    private Slot moveResult(InventoryMenu instance, Slot pSlot, Inventory pPlayerInventory, boolean pActive, Player pOwner) {
        return MixinDebugHelper.InventoryMenuSlotMixinResult(instance, pSlot, pPlayerInventory, pActive, pOwner, craftSlots, resultSlots);
    }

    @Redirect(method = "Lnet/minecraft/world/inventory/InventoryMenu;<init>(Lnet/minecraft/world/entity/player/Inventory;ZLnet/minecraft/world/entity/player/Player;)V", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/world/inventory/InventoryMenu;addSlot(Lnet/minecraft/world/inventory/Slot;)Lnet/minecraft/world/inventory/Slot;", ordinal = 1))
    private Slot moveCraftSlots(InventoryMenu instance, Slot pSlot, Inventory pPlayerInventory, boolean pActive, Player pOwner) {
        return MixinDebugHelper.InventoryMenuSlotMixinCraftSlot(instance, pSlot, pPlayerInventory, pActive, pOwner, craftSlots);
    }

    @Redirect(method = "Lnet/minecraft/world/inventory/InventoryMenu;<init>(Lnet/minecraft/world/entity/player/Inventory;ZLnet/minecraft/world/entity/player/Player;)V", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/world/inventory/InventoryMenu;addSlot(Lnet/minecraft/world/inventory/Slot;)Lnet/minecraft/world/inventory/Slot;", ordinal = 2))
    private Slot moveCraftArmor(InventoryMenu instance, Slot pSlot, Inventory pPlayerInventory, boolean pActive, Player pOwner) {
        return MixinDebugHelper.InventoryMenuSlotMixinArmor(instance, pSlot, pPlayerInventory, pActive, pOwner, SLOT_IDS, TEXTURE_EMPTY_SLOTS);
    }

    @Redirect(method = "Lnet/minecraft/world/inventory/InventoryMenu;<init>(Lnet/minecraft/world/entity/player/Inventory;ZLnet/minecraft/world/entity/player/Player;)V", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/world/inventory/InventoryMenu;addSlot(Lnet/minecraft/world/inventory/Slot;)Lnet/minecraft/world/inventory/Slot;", ordinal = 5))
    private Slot moveCraftShield(InventoryMenu instance, Slot pSlot, Inventory pPlayerInventory, boolean pActive, Player pOwner) {
        return MixinDebugHelper.InventoryMenuSlotMixinShield(instance, pSlot, pPlayerInventory, pActive, pOwner);
    }
}