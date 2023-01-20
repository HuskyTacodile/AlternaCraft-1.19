package com.huskytacodile.alternacraft.data;

import com.huskytacodile.alternacraft.block.ModBlocks;
import com.huskytacodile.alternacraft.item.ModItems;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot {
    @Override
    protected void addTables() {

        this.add(ModBlocks.TITANIUM_ORE.get(), (block) -> createOreDrop(ModBlocks.TITANIUM_ORE.get(), ModItems.TITANIUM_INGOT.get()));
        this.add(ModBlocks.PAINITE_ORE.get(), (block) -> createOreDrop(ModBlocks.PAINITE_ORE.get(), ModItems.PAINITE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}