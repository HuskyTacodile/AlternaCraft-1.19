package com.huskytacodile.alternacraft.world;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.world.gen.ModEntityGeneration;
import com.huskytacodile.alternacraft.world.gen.ModOreGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Alternacraft.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModOreGeneration.generateOres(event);

        ModEntityGeneration.onEntitySpawn(event);
    }
}
