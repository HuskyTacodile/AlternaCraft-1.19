package com.huskytacodile.alternacraft;

import com.huskytacodile.alternacraft.block.ModBlocks;
import com.huskytacodile.alternacraft.block.entity.ModBlockEntities;
import com.huskytacodile.alternacraft.config.AlternacraftConfig;
import com.huskytacodile.alternacraft.config.AlternacraftConfigHolder;
import com.huskytacodile.alternacraft.enchantment.ModEnchantments;
import com.huskytacodile.alternacraft.entities.ModEntityTypes;
import com.huskytacodile.alternacraft.item.ModItems;
import com.huskytacodile.alternacraft.misc.ModPOIs;
import com.huskytacodile.alternacraft.util.ModSoundEvents;
import com.huskytacodile.alternacraft.world.dimension.ModDimensions;
import com.huskytacodile.alternacraft.world.structure.ModStructures;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Alternacraft.MOD_ID)
@Mod.EventBusSubscriber(modid = Alternacraft.MOD_ID)
public class Alternacraft {
    public static final String MOD_ID = "alternacraft";
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public Alternacraft() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        final ModLoadingContext modLoadingContext = ModLoadingContext.get();

        eventBus.addListener(this::onModConfigEvent);

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        ModEntityTypes.register(eventBus);
        ModStructures.register(eventBus);

        ModSoundEvents.register(eventBus);
        ModEnchantments.register(eventBus);

        ModBlockEntities.register(eventBus);
        ModDimensions.register();

        ModPOIs.register(eventBus);

        eventBus.addListener(this::setup);

        modLoadingContext.registerConfig(ModConfig.Type.COMMON, AlternacraftConfigHolder.COMMON_SPEC, "alteracraft.toml");
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        GeckoLib.initialize();
    }
    
    @SubscribeEvent
    public void onModConfigEvent(final ModConfigEvent event) {
    	final ModConfig config = event.getConfig();
    	if (config.getSpec() == AlternacraftConfigHolder.COMMON_SPEC) {
    		AlternacraftConfig.bake(config);
    	}
    }

    private void setup(final FMLCommonSetupEvent event) {

    }
}
