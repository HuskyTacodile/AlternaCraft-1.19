package com.huskytacodile.alternacraft.world.structure;

import com.huskytacodile.alternacraft.Alternacraft;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModStructures {

    /**
     * We are using the Deferred Registry system to register our structure as this is the preferred way on Forge.
     * This will handle registering the base structure for us at the correct time so we don't have to handle it ourselves.
     */
    public static final DeferredRegister<StructureFeature<?>> DEFERRED_REGISTER
            = DeferredRegister.create(Registry.STRUCTURE_FEATURE_REGISTRY, Alternacraft.MOD_ID);

    /**
     * Registers the base structure itself and sets what its path is. In this case,
     * this base structure will have the resourcelocation of structure_tutorial:sky_structures.
     */

    public static final RegistryObject<StructureFeature<?>> RAPTOR_DEN = DEFERRED_REGISTER.register("raptor_den", RaptorDen::new);

    public static final RegistryObject<StructureFeature<?>> CARCHAR_CAGE = DEFERRED_REGISTER.register("carchar_cage", CarcharCage::new);

    public static final RegistryObject<StructureFeature<?>> RUNDOWN_INDORAPTOR_ARENA = DEFERRED_REGISTER.register("rundown_indoraptor_arena", RundownIndoraptorArena::new);

    public static final RegistryObject<StructureFeature<?>> RAPTOR_ARENA = DEFERRED_REGISTER.register("raptor_arena", RaptorArena::new);

    public static final RegistryObject<StructureFeature<?>> CARNOTAURUS_PADDOCK = DEFERRED_REGISTER.register("carnotaurus_paddock", CarnotaurusPaddock::new);

    public static void register(IEventBus eventBus) {
        DEFERRED_REGISTER.register(eventBus);
    }
}
