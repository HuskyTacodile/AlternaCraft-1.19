package com.huskytacodile.alternacraft.misc;

import com.google.common.collect.ImmutableSet;
import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.block.ModBlocks;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPOIs {
    public static final DeferredRegister<PoiType> POI
            = DeferredRegister.create(ForgeRegistries.POI_TYPES, Alternacraft.MOD_ID);

    public static final RegistryObject<PoiType> ALTERNA_PORTAL =
            POI.register("alterna_portal", () -> new PoiType("alterna_portal",
                    ImmutableSet.copyOf(ModBlocks.ALTERNA_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));


    public static void register(IEventBus eventBus) {
        POI.register(eventBus);
    }
}