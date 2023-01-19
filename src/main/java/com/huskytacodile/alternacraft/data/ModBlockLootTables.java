package com.huskytacodile.alternacraft.data;

import com.huskytacodile.alternacraft.block.ModBlocks;
import com.huskytacodile.alternacraft.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables(Set<Item> p_249153_, FeatureFlagSet p_251215_) {
        super(p_249153_, p_251215_);
    }

    @Override
    protected void generate() {

        this.add(ModBlocks.TITANIUM_ORE.get(), (block) -> {
            return createOreDrop(ModBlocks.TITANIUM_ORE.get(), ModItems.TITANIUM_INGOT.get());
        });
        this.add(ModBlocks.PAINITE_ORE.get(), (block) -> {
            return createOreDrop(ModBlocks.PAINITE_ORE.get(), ModItems.PAINITE.get());
        });
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}