package com.huskytacodile.alternacraft.world.structure;

import com.huskytacodile.alternacraft.Alternacraft;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModStructures {

    /**
     * We are using the Deferred Registry system to register our structure as this is the preferred way on Forge.
     * This will handle registering the base structure for us at the correct time so we don't have to handle it ourselves.
     */
    public static final DeferredRegister<StructureType<?>> DEFERRED_REGISTER
            = DeferredRegister.create(Registries.STRUCTURE_TYPE, Alternacraft.MOD_ID);

    /**
     * Registers the base structure itself and sets what its path is. In this case,
     * this base structure will have the resourcelocation of structure_tutorial:sky_structures.
     */

    public static final RegistryObject<StructureType> RAPTOR_DEN = DEFERRED_REGISTER.register("raptor_den", () -> () -> RaptorDen.CODEC);

    public static final RegistryObject<StructureType> CARCHAR_CAGE = DEFERRED_REGISTER.register("carchar_cage", () -> () -> CarcharCage.CODEC);

    public static final RegistryObject<StructureType> RUNDOWN_INDORAPTOR_ARENA = DEFERRED_REGISTER.register("rundown_indoraptor_arena", () -> () -> RundownIndoraptorArena.CODEC);

    public static final RegistryObject<StructureType> RAPTOR_ARENA = DEFERRED_REGISTER.register("raptor_arena", () -> () -> RaptorArena.CODEC);

    public static final RegistryObject<StructureType> CARNOTAURUS_PADDOCK = DEFERRED_REGISTER.register("carnotaurus_paddock", () -> () -> CarnotaurusPaddock.CODEC);

    // Helper method to register since compiler will complain about typing if we did () -> SkyStructures.CODEC directly.
    private static <S extends Structure> StructureType<S> typeConvert(Codec<S> codec) {
        return () -> codec;
    }

    public static void register(IEventBus eventBus) {
        DEFERRED_REGISTER.register(eventBus);
    }
}
