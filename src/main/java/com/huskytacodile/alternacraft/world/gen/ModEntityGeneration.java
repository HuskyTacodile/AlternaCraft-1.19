package com.huskytacodile.alternacraft.world.gen;

import com.huskytacodile.alternacraft.entities.ModEntityTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Arrays;
import java.util.List;

public class ModEntityGeneration {
    public static void onEntitySpawn(final BiomeLoadingEvent event) {
        addEntityToSpecificBiomes(event, ModEntityTypes.COMPY.get(),
                7, 2, 5, Biomes.TAIGA, Biomes.BIRCH_FOREST);
        addEntityToSpecificBiomes(event, ModEntityTypes.MOROS.get(),
                3, 2, 4, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA);
        addEntityToSpecificBiomes(event, ModEntityTypes.OXALAIA.get(),
                1, 1, 1, Biomes.BAMBOO_JUNGLE, Biomes.JUNGLE, Biomes.LUSH_CAVES);
        addEntityToSpecificBiomes(event, ModEntityTypes.PYRO.get(),
                2, 1, 3, Biomes.FROZEN_OCEAN, Biomes.ICE_SPIKES);
        addEntityToSpecificBiomes(event, ModEntityTypes.TYRANNOSAURUS.get(),
                1, 1, 2, Biomes.PLAINS, Biomes.DESERT);
        addEntityToSpecificBiomes(event, ModEntityTypes.SPINO.get(),
                2, 1, 2, Biomes.SWAMP);
        addEntityToSpecificBiomes(event, ModEntityTypes.JPSPINO.get(),
                1, 1, 2, Biomes.SWAMP);
        addEntityToSpecificBiomes(event, ModEntityTypes.THERI.get(),
                2, 1, 2, Biomes.TAIGA, Biomes.SNOWY_TAIGA);
        addEntityToSpecificBiomes(event, ModEntityTypes.VELOCIRAPTOR.get(),
                2, 1, 3, Biomes.PLAINS);
        addEntityToSpecificBiomes(event, ModEntityTypes.CARNO.get(),
                2, 2, 3, Biomes.JUNGLE, Biomes.SPARSE_JUNGLE, Biomes.SAVANNA);
        addEntityToSpecificBiomes(event, ModEntityTypes.CERATOSUCHOPS.get(),
                2, 2, 4, Biomes.SWAMP);
        addEntityToSpecificBiomes(event, ModEntityTypes.DEINONYCHUS.get(),
                2, 1, 3, Biomes.PLAINS, Biomes.DESERT);
        addEntityToSpecificBiomes(event, ModEntityTypes.DROMAEO.get(),
                2, 1, 4, Biomes.SNOWY_TAIGA, Biomes.SNOWY_BEACH);
        addEntityToSpecificBiomes(event, ModEntityTypes.DRYPTO.get(),
                2, 1, 3, Biomes.PLAINS, Biomes.WINDSWEPT_HILLS, Biomes.MEADOW);
        addEntityToSpecificBiomes(event, ModEntityTypes.GIGA.get(),
                1, 1, 2, Biomes.DESERT, Biomes.OLD_GROWTH_SPRUCE_TAIGA);
        addEntityToSpecificBiomes(event, ModEntityTypes.INDOMINUS.get(),
                1, 1, 1, Biomes.FOREST);
        addEntityToSpecificBiomes(event, ModEntityTypes.INDORAPTOR.get(),
                1, 1, 1, Biomes.PLAINS, Biomes.SAVANNA);
        addEntityToSpecificBiomes(event, ModEntityTypes.INDORAPTOR_GEN2.get(),
                1, 1, 1, Biomes.PLAINS, Biomes.SAVANNA);
        addEntityToSpecificBiomes(event, ModEntityTypes.SCORPIUS.get(),
                1, 1, 1, Biomes.DESERT, Biomes.BADLANDS);
        addEntityToSpecificBiomes(event, ModEntityTypes.ACRO.get(),
                1, 1, 3, Biomes.JUNGLE, Biomes.SAVANNA);
        addEntityToSpecificBiomes(event, ModEntityTypes.ALLOSAURUS.get(),
                2, 2, 4, Biomes.BIRCH_FOREST, Biomes.FOREST, Biomes.SAVANNA);
        addEntityToSpecificBiomes(event, ModEntityTypes.BARYONYX.get(),
                2, 2, 3, Biomes.SWAMP);
        addEntityToSpecificBiomes(event, ModEntityTypes.ATROCI.get(),
                2, 1, 3, Biomes.JUNGLE, Biomes.SPARSE_JUNGLE, Biomes.SAVANNA);
        addEntityToSpecificBiomes(event, ModEntityTypes.CARCHA.get(),
                1, 2, 2, Biomes.DESERT, Biomes.BADLANDS);
        addEntityToSpecificBiomes(event, ModEntityTypes.BARYONYX_GEN2.get(),
                2, 2, 3, Biomes.SWAMP);
    }

    private static void addEntityToAllBiomesExceptThese(BiomeLoadingEvent event, EntityType<?> type,
                                                        int weight, int minCount, int maxCount, ResourceKey<Biome>... biomes) {
        // Goes through each entry in the biomes and sees if it matches the current biome we are loading
        boolean isBiomeSelected = Arrays.stream(biomes).map(ResourceKey::location)
                .map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()));

        if(!isBiomeSelected) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }

    @SafeVarargs
    private static void addEntityToSpecificBiomes(BiomeLoadingEvent event, EntityType<?> type,
                                                  int weight, int minCount, int maxCount, ResourceKey<Biome>... biomes) {
        // Goes through each entry in the biomes and sees if it matches the current biome we are loading
        boolean isBiomeSelected = Arrays.stream(biomes).map(ResourceKey::location)
                .map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()));

        if(isBiomeSelected) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }

    private static void addEntityToAllOverworldBiomes(BiomeLoadingEvent event, EntityType<?> type,
                                                      int weight, int minCount, int maxCount) {
        if(!event.getCategory().equals(Biome.BiomeCategory.THEEND) && !event.getCategory().equals(Biome.BiomeCategory.NETHER)) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }

    private static void addEntityToAllBiomesNoNether(BiomeLoadingEvent event, EntityType<?> type,
                                                     int weight, int minCount, int maxCount) {
        if(!event.getCategory().equals(Biome.BiomeCategory.NETHER)) {
            List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
            base.add(new MobSpawnSettings.SpawnerData(type,weight, minCount, maxCount));
        }
    }

    private static void addEntityToAllBiomesNoEnd(BiomeLoadingEvent event, EntityType<?> type,
                                                  int weight, int minCount, int maxCount) {
        if(!event.getCategory().equals(Biome.BiomeCategory.THEEND)) {
            List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
            base.add(new MobSpawnSettings.SpawnerData(type,weight, minCount, maxCount));
        }
    }

    private static void addEntityToAllBiomes(BiomeLoadingEvent event, EntityType<?> type,
                                             int weight, int minCount, int maxCount) {
        List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
        base.add(new MobSpawnSettings.SpawnerData(type,weight, minCount, maxCount));
    }
}
