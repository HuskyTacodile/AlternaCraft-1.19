package com.huskytacodile.alternacraft.item;


import com.huskytacodile.alternacraft.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab ALTERNACRAFT_GROUP = new CreativeModeTab("alternacraft_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.FOSSIL.get());
        }
    };
    public static final CreativeModeTab BLOCKS_TAB = new CreativeModeTab("blocks_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.CONCRETE_BRICKS.get());
        }
    };
    public static final CreativeModeTab DNA_SYRINGES = new CreativeModeTab("dna_syringes") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.EMPTY_SYRINGE.get());
        }
    };
}
