package com.huskytacodile.alternacraft.world.feature;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModConfiguredFeature {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Alternacraft.MOD_ID);


    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_TITANIUM_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.TITANIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_TITANIUM_ORE.get().defaultBlockState()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> TITANIUM_ORE = CONFIGURED_FEATURES.register("titanium_ore",
            () -> new ConfiguredFeature<>((OreFeature) Feature.ORE, new OreConfiguration(OVERWORLD_TITANIUM_ORES, 9)));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_PAINITE_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.PAINITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_PAINITE_ORE.get().defaultBlockState()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> PAINITE_ORE = CONFIGURED_FEATURES.register("painite_ore",
            () -> new ConfiguredFeature<>((OreFeature) Feature.ORE, new OreConfiguration(OVERWORLD_PAINITE_ORES, 4)));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_FOSSIL_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.FOSSIL_ORE.get().defaultBlockState()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> FOSSIL_ORE = CONFIGURED_FEATURES.register("fossil_ore",
            () -> new ConfiguredFeature<>((OreFeature) Feature.ORE, new OreConfiguration(OVERWORLD_FOSSIL_ORES, 4)));
}
