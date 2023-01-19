package com.huskytacodile.alternacraft.world.dimension;

import com.huskytacodile.alternacraft.Alternacraft;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensions {

    public static final ResourceKey<Level> ALTERNADIM_KEY = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(Alternacraft.MOD_ID, "alternadim"));
    public static final ResourceKey<DimensionType> ALTERNADIM_TYPE =
            ResourceKey.create(Registries.DIMENSION_TYPE,
                    new ResourceLocation(Alternacraft.MOD_ID, "alternadim"));

    public static void register() {
        System.out.println("Registering ModDimensions for " + Alternacraft.MOD_ID);
    }

}
