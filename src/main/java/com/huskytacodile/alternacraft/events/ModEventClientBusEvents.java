package com.huskytacodile.alternacraft.events;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.*;
import com.huskytacodile.alternacraft.client.screen.PlayerInventoryScreen;
import com.huskytacodile.alternacraft.entities.ModEntityTypes;
import com.huskytacodile.alternacraft.entities.wyverns.PlayerRideableFlying;
import com.huskytacodile.alternacraft.item.ModItems;
import com.huskytacodile.alternacraft.menu.PlayerInventoryMenu;
import com.huskytacodile.alternacraft.misc.KeyBinds;
import com.huskytacodile.alternacraft.networking.ModMessages;
import com.huskytacodile.alternacraft.networking.packet.FlyPacket;
import com.huskytacodile.alternacraft.networking.packet.LowerPacket;
import com.huskytacodile.alternacraft.util.ModItemProperties;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.FurnaceScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientPlayerChangeGameTypeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.network.NetworkHooks;

public class ModEventClientBusEvents {
    @Mod.EventBusSubscriber(modid = Alternacraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class modBusEvents {

        @SubscribeEvent
        public static void clientSetup(final FMLClientSetupEvent event) {
            ModItemProperties.makeBow(ModItems.PAINITE_BOW.get());

            EntityRenderers.register(ModEntityTypes.JPSPINO.get(), JPSpinoRenderer::new);
            EntityRenderers.register(ModEntityTypes.INDOMINUS.get(), IndominusRenderer::new);
            EntityRenderers.register(ModEntityTypes.OXALAIA.get(), OxalaiaRenderer::new);
            EntityRenderers.register(ModEntityTypes.INDORAPTOR.get(), IndoraptorRenderer::new);
            EntityRenderers.register(ModEntityTypes.INDORAPTOR_GEN2.get(), IndoraptorGen2Renderer::new);
            EntityRenderers.register(ModEntityTypes.CERATOSUCHOPS.get(), CeratosuchopsRenderer::new);
            EntityRenderers.register(ModEntityTypes.ACRO.get(), AcroRenderer::new);
            EntityRenderers.register(ModEntityTypes.TYLOSAURUS.get(), TylosaurusRenderer::new);
            EntityRenderers.register(ModEntityTypes.MOSASAURUS.get(), MosasaurusRenderer::new);
            EntityRenderers.register(ModEntityTypes.TYRANNOSAURUS.get(), TyrannosaurusRenderer::new);
            EntityRenderers.register(ModEntityTypes.SCORPIUS.get(), ScorpiusRenderer::new);
            EntityRenderers.register(ModEntityTypes.ALLOSAURUS.get(), AllosaurusRenderer::new);
            EntityRenderers.register(ModEntityTypes.BARYONYX.get(), BaryonyxRenderer::new);
            EntityRenderers.register(ModEntityTypes.BARYONYX_GEN2.get(), BaryonyxGen2Renderer::new);
            EntityRenderers.register(ModEntityTypes.CARCHA.get(), CarchaRenderer::new);
            EntityRenderers.register(ModEntityTypes.YUTYRANNUS.get(), NanuqsaurusRenderer::new);
            EntityRenderers.register(ModEntityTypes.SPINO.get(), SpinoRenderer::new);
            EntityRenderers.register(ModEntityTypes.COMPY.get(), CompsognathusRenderer::new);
            EntityRenderers.register(ModEntityTypes.GIGA.get(), GigaRenderer::new);
            EntityRenderers.register(ModEntityTypes.VELOCIRAPTOR.get(), VelociraptorRenderer::new);
            EntityRenderers.register(ModEntityTypes.MALUSAURUS.get(), MalusaurusRenderer::new);
            EntityRenderers.register(ModEntityTypes.MOROS.get(), MorosRenderer::new);
            EntityRenderers.register(ModEntityTypes.DEINONYCHUS.get(), DeinonychusRenderer::new);
            EntityRenderers.register(ModEntityTypes.DRYPTO.get(), DryptoRenderer::new);
            EntityRenderers.register(ModEntityTypes.ATROCI.get(), AtrociraptorRenderer::new);
            EntityRenderers.register(ModEntityTypes.PYRO.get(), PyroraptorRenderer::new);
            EntityRenderers.register(ModEntityTypes.CARNO.get(), CarnoRenderer::new);
            EntityRenderers.register(ModEntityTypes.THERI.get(), TheriRenderer::new);
            EntityRenderers.register(ModEntityTypes.DROMAEO.get(), DromaeoRenderer::new);
            EntityRenderers.register(ModEntityTypes.FIRE_WYVERN.get(), FireWyvernRenderer::new);
            EntityRenderers.register(ModEntityTypes.TRANQUILIZER_DART.get(), TranqDartRenderer::new);
            EntityRenderers.register(ModEntityTypes.FIRE.get(), FireRenderer::new);
            EntityRenderers.register(ModEntityTypes.ICE_WYVERN.get(), IceWyvernRenderer::new);
        }

        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinds.FLY_DOWN_KEY);
        }
    }
    @Mod.EventBusSubscriber(modid = Alternacraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
    public static class forgeEventBus{

        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if (KeyBinds.FLY_DOWN_KEY.isDown()) {
                PlayerRideableFlying entity = PlayerRideableFlying.getEntity(Minecraft.getInstance().player);
                if (entity != null && entity.canLower()) {
                    ModMessages.sendToServer(new LowerPacket());
                }
            }
            if (KeyBinds.FLY_UP_KEY.isDown()){
                PlayerRideableFlying entity = PlayerRideableFlying.getEntity(Minecraft.getInstance().player);
                if (entity != null && entity.canJump(entity.getPassenger())) {
                    ModMessages.sendToServer(new FlyPacket());
                }
            }
        }

        @SubscribeEvent
        public static void joinEvent(EntityJoinLevelEvent event){
            if (event.getEntity() instanceof Player player) {
                player.inventoryMenu = new PlayerInventoryMenu(player.getInventory(), !event.getLevel().isClientSide(), player, player.inventoryMenu);
                player.containerMenu = player.inventoryMenu;
            }
        }
    }
}
