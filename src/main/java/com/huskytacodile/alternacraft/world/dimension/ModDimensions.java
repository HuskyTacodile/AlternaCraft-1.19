package com.huskytacodile.alternacraft.world.dimension;

import com.huskytacodile.alternacraft.Alternacraft;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensions {

    public static final ResourceKey<Level> ALTERNADIM_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(Alternacraft.MOD_ID, "alternadim"));
    public static final ResourceKey<DimensionType> ALTERNADIM_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY,
                    new ResourceLocation(Alternacraft.MOD_ID, "alternadim"));

    public static void register() {
        System.out.println("Registering ModDimensions for " + Alternacraft.MOD_ID);
    }

}
