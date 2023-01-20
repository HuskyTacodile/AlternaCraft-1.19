package com.huskytacodile.alternacraft.events;

import com.google.common.collect.Lists;
import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.entities.ModEntityTypes;
import com.huskytacodile.alternacraft.entities.MosasaurusEntity;
import com.huskytacodile.alternacraft.entities.TylosaurusEntity;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.large.*;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.large.hybrid.IndominusEntity;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.large.hybrid.IndoraptorGen2Entity;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.large.hybrid.ScorpiusEntity;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.medium.DryptoEntity;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.medium.raptor.*;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.semiaquatic.*;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.small.CompsognathusEntity;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.small.MorosEntity;
import com.huskytacodile.alternacraft.entities.dinos.herbivore.large.agitated.TheriEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = Alternacraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.JPSPINO.get(), JPSpinoEntity.attributes().build());
        event.put(ModEntityTypes.INDOMINUS.get(), IndominusEntity.attributes().build());
        event.put(ModEntityTypes.OXALAIA.get(), SuchomimusEntity.attributes().build());
        event.put(ModEntityTypes.INDORAPTOR.get(), IndoraptorGen2Entity.attributes().build());
        event.put(ModEntityTypes.INDORAPTOR_GEN2.get(), IndoraptorGen2Entity.attributes().build());
        event.put(ModEntityTypes.CERATOSUCHOPS.get(), CeratosuchopsEntity.attributes().build());
        event.put(ModEntityTypes.ACRO.get(), AcroEntity.attributes().build());
        event.put(ModEntityTypes.TYLOSAURUS.get(), TylosaurusEntity.attributes().build());
        event.put(ModEntityTypes.MOSASAURUS.get(), MosasaurusEntity.attributes().build());
        event.put(ModEntityTypes.TYRANNOSAURUS.get(), TyrannosaurusEntity.attributes().build());
        event.put(ModEntityTypes.SCORPIUS.get(), ScorpiusEntity.attributes().build());
        event.put(ModEntityTypes.ALLOSAURUS.get(), AllosaurusEntity.attributes().build());
        event.put(ModEntityTypes.BARYONYX.get(), BaryonyxEntity.attributes().build());
        event.put(ModEntityTypes.BARYONYX_GEN2.get(), BaryonyxGen2Entity.attributes().build());
        event.put(ModEntityTypes.CARCHA.get(), CarchaEntity.attributes().build());
        event.put(ModEntityTypes.YUTYRANNUS.get(), NanuqsaurusEntity.attributes().build());
        event.put(ModEntityTypes.SPINO.get(), SpinoEntity.attributes().build());
        event.put(ModEntityTypes.COMPY.get(), CompsognathusEntity.attributes().build());
        event.put(ModEntityTypes.GIGA.get(), GigaEntity.attributes().build());
        event.put(ModEntityTypes.VELOCIRAPTOR.get(), VelociraptorEntity.attributes().build());
        event.put(ModEntityTypes.MALUSAURUS.get(), MalusaurusEntity.attributes().build());
        event.put(ModEntityTypes.MOROS.get(), MorosEntity.attributes().build());
        event.put(ModEntityTypes.DEINONYCHUS.get(), DeinonychusEntity.attributes().build());
        event.put(ModEntityTypes.DRYPTO.get(), DryptoEntity.attributes().build());
        event.put(ModEntityTypes.ATROCI.get(), AtrociraptorEntity.attributes().build());
        event.put(ModEntityTypes.PYRO.get(), PyroraptorEntity.attributes().build());
        event.put(ModEntityTypes.CARNO.get(), CarnoEntity.attributes().build());
        event.put(ModEntityTypes.THERI.get(), TheriEntity.attributes().build());
        event.put(ModEntityTypes.DROMAEO.get(), DromaeoEntity.attributes().build());
    }
}