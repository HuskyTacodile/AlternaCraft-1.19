package com.huskytacodile.alternacraft.misc;

import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.jetbrains.annotations.NotNull;

public class MixinDebugHelper {
    public static Slot InventoryMenuSlotMixinHotbar(InventoryMenu instance, Slot pSlot, Inventory pPlayerInventory, boolean pActive, Player pOwner) {
        int i1 = pSlot.getSlotIndex();
        return instance.addSlot(new Slot(pPlayerInventory, i1, 78 + i1 * 20, 184));
    }

    public static Slot InventoryMenuSlotMixinInventory(InventoryMenu instance, Slot pSlot, Inventory pPlayerInventory, boolean pActive, Player pOwner) {
        int j1 = (pSlot.x - 8)/18;
        int l = (pSlot.y - 84)/18;

        int x = j1 + (l + 1) * 9;

        int outer = (x - 9) / 6;
        int inner = (x - 9) % 6;
        return instance.addSlot(new Slot(pPlayerInventory, x,  21 + inner * 19, 54 + outer * 20));
    }

    public static Slot InventoryMenuSlotMixinResult(InventoryMenu instance, Slot pSlot, Inventory pPlayerInventory, boolean pActive, Player pOwner, CraftingContainer craftSlots, ResultContainer resultSlots) {
        return instance.addSlot(new ResultSlot(pPlayerInventory.player, craftSlots, resultSlots, 0, 205, 124));
    }

    public static Slot InventoryMenuSlotMixinCraftSlot(InventoryMenu instance, Slot pSlot, Inventory pPlayerInventory, boolean pActive, Player pOwner, CraftingContainer craftSlots) {
        int i = (pSlot.y - 18) / 18;
        int j = (pSlot.x - 98) / 18;
        return instance.addSlot(new Slot(craftSlots,j + i * 2, 152 + j * 18, 114 + i * 18));
    }

    public static Slot InventoryMenuSlotMixinArmor(InventoryMenu instance, Slot pSlot, Inventory pPlayerInventory, boolean pActive, Player pOwner, EquipmentSlot[] SLOT_IDS, ResourceLocation[] TEXTURE_EMPTY_SLOTS) {
        int k = 39 - pSlot.getSlotIndex();
        final EquipmentSlot equipmentslot = SLOT_IDS[k];
        int x = k < 3 ? 152 : 205;
        return instance.addSlot(new Slot(pPlayerInventory, 39 - k, x, 54 + (k < 3 ? k : 2) * 19) {
            /**
             * Helper method to put a stack in the slot.
             */
            public void set(@NotNull ItemStack p_219985_) {
                ItemStack itemstack = this.getItem();
                super.set(p_219985_);
                pOwner.onEquipItem(equipmentslot, itemstack, p_219985_);
            }

            /**
             * Returns the maximum stack size for a given slot (usually the same as getInventoryStackLimit(), but 1 in
             * the case of armor slots)
             */
            public int getMaxStackSize() {
                return 1;
            }

            /**
             * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace fuel.
             */
            public boolean mayPlace(@NotNull ItemStack p_39746_) {
                return p_39746_.canEquip(equipmentslot, pOwner);
            }

            /**
             * Return whether this slot's stack can be taken from this slot.
             */
            public boolean mayPickup(@NotNull Player p_39744_) {
                ItemStack itemstack = this.getItem();
                return (itemstack.isEmpty() || p_39744_.isCreative() || !EnchantmentHelper.hasBindingCurse(itemstack)) && super.mayPickup(p_39744_);
            }

            public Pair<ResourceLocation, ResourceLocation> getNoItemIcon() {
                return Pair.of(InventoryMenu.BLOCK_ATLAS, TEXTURE_EMPTY_SLOTS[equipmentslot.getIndex()]);
            }
        });
    }

    public static Slot InventoryMenuSlotMixinShield(InventoryMenu instance, Slot pSlot, Inventory pPlayerInventory, boolean pActive, Player pOwner) {
        return instance.addSlot(new Slot(pPlayerInventory, 40, 205, 54 + 19) {
            public Pair<ResourceLocation, ResourceLocation> getNoItemIcon() {
                return Pair.of(InventoryMenu.BLOCK_ATLAS, InventoryMenu.EMPTY_ARMOR_SLOT_SHIELD);
            }
        });
    }
}