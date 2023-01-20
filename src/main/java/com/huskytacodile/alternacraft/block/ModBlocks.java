package com.huskytacodile.alternacraft.block;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.block.custom.AlternaPortalBlock;
import com.huskytacodile.alternacraft.block.custom.AlternaRadiatorBlock;
import com.huskytacodile.alternacraft.item.ModCreativeModeTab;
import com.huskytacodile.alternacraft.item.ModItems;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, Alternacraft.MOD_ID);

    public static final RegistryObject<Block> CLADOPHLEBIS = registerBlock("cladophlebis",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 1,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION)));

    public static final RegistryObject<Block> JW_BANNER = registerBlock("jw_banner",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_BANNER)));

    public static final RegistryObject<Block> ALTERNA_RADIATOR = registerBlock("alterna_radiator",
            () -> new AlternaRadiatorBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CONCRETE_STONE = registerBlock("concrete_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CONCRETE_PILLAR = registerBlock("concrete_pillar",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> METEORITE = registerBlock("meteorite",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CONCRETE_BRICKS = registerBlock("concrete_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ELEMENTAL_STONE = registerBlock("elemental_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> TITANIUM_BRICKS = registerBlock("titanium_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ALUMINUM_BLOCK = registerBlock("aluminum_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ALUMINUM_BRICKS = registerBlock("aluminum_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> AMBER_ORE = registerBlock("amber_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> FOSSIL_ORE = registerBlock("fossil_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> PAINITE_ORE = registerBlock("painite_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(7f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> TITANIUM_ORE = registerBlock("titanium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MUDSTONE = registerBlock("mudstone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MUDSTONE_TITANIUM_ORE = registerBlock("mudstone_titanium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MUDSTONE_COAL_ORE = registerBlock("mudstone_coal_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MUDSTONE_GOLD_ORE = registerBlock("mudstone_gold_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MUDSTONE_REDSTONE_ORE = registerBlock("mudstone_redstone_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MUDSTONE_COPPER_ORE = registerBlock("mudstone_copper_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MUDSTONE_DIAMOND_ORE = registerBlock("mudstone_diamond_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MUDSTONE_PAINITE_ORE = registerBlock("mudstone_painite_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(7f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MUDSTONE_EMERALD_ORE = registerBlock("mudstone_emerald_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SLITSTONE = registerBlock("slitstone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SHALE = registerBlock("shale",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SHALE_COPPER_ORE = registerBlock("shale_copper_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SHALE_DIAMOND_ORE = registerBlock("shale_diamond_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SHALE_PAINITE_ORE = registerBlock("shale_painite_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(7f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SHALE_GOLD_ORE = registerBlock("shale_gold_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SHALE_COAL_ORE = registerBlock("shale_coal_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SHALE_IRON_ORE = registerBlock("shale_iron_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SHALE_REDSTONE_ORE = registerBlock("shale_redstone_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SHALE_LAPIS_ORE = registerBlock("shale_lapis_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SHALE_EMERALD_ORE = registerBlock("shale_emerald_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SHALE_TITANIUM_ORE = registerBlock("shale_titanium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DEEPSLATE_TITANIUM_ORE = registerBlock("deepslate_titanium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DEEPSLATE_PAINITE_ORE = registerBlock("deepslate_painite_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(7f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SLITSTONE_TITANIUM_ORE = registerBlock("slitstone_titanium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SLITSTONE_COPPER_ORE = registerBlock("slitstone_copper_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SLITSTONE_DIAMOND_ORE = registerBlock("slitstone_diamond_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SLITSTONE_EMERALD_ORE = registerBlock("slitstone_emerald_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SLITSTONE_IRON_ORE = registerBlock("slitstone_iron_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SLITSTONE_GOLD_ORE = registerBlock("slitstone_gold_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SLITSTONE_REDSTONE_ORE = registerBlock("slitstone_redstone_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SLITSTONE_COAL_ORE = registerBlock("slitstone_coal_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SLITSTONE_LAPIS_ORE = registerBlock("slitstone_lapis_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SLITSTONE_PAINITE_ORE = registerBlock("slitstone_painite_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(7f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DNA_SEQUENCER = registerBlock("dna_sequencer",
            () -> new LanternBlock(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DNA_EXTRACTOR = registerBlock("dna_extractor",
            () -> new LanternBlock(BlockBehaviour.Properties.of(Material.METAL).noOcclusion()));

    public static final RegistryObject<Block> DNA_COMBINATOR = registerBlock("dna_combinator",
            () -> new LanternBlock(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SECURITY_FENCE = registerBlock("security_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(6f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ALTERNA_PORTAL = registerBlockWithoutBlockItem("alterna_portal",
            AlternaPortalBlock::new);

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(),
                new Item.Properties().tab(ModCreativeModeTab.BLOCKS_TAB)));
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
