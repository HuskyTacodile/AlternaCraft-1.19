package com.huskytacodile.alternacraft.world.features;

import com.huskytacodile.alternacraft.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_FOSSILE_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.FOSSIL_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> FOSSILE_ORE = FeatureUtils.register("fossil_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_FOSSILE_ORES, 9));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_PAINITE_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.PAINITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_PAINITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(ModBlocks.MUDSTONE.get()), ModBlocks.MUDSTONE_PAINITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(ModBlocks.SHALE.get()), ModBlocks.SHALE_PAINITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(ModBlocks.SLITSTONE.get()), ModBlocks.SLITSTONE_PAINITE_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> PAINITE_ORE = FeatureUtils.register("painite_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_PAINITE_ORES, 9));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_TITANIUM_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.TITANIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_TITANIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(ModBlocks.MUDSTONE.get()), ModBlocks.MUDSTONE_TITANIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(ModBlocks.SHALE.get()), ModBlocks.SHALE_TITANIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(ModBlocks.SLITSTONE.get()), ModBlocks.SLITSTONE_TITANIUM_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> TITANIUM_ORE = FeatureUtils.register("titanium_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_TITANIUM_ORES, 9));
}
