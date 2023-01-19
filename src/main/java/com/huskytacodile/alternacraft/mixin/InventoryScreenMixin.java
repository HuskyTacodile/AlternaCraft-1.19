package com.huskytacodile.alternacraft.mixin;

import com.huskytacodile.alternacraft.client.screen.PlayerInventoryScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Minecraft.class)
public abstract class InventoryScreenMixin {

    @Redirect(method = "Lnet/minecraft/client/Minecraft;handleKeybinds()V", at = @At(value = "INVOKE",
    target = "Lnet/minecraft/client/Minecraft;setScreen(Lnet/minecraft/client/gui/screens/Screen;)V", ordinal = 1))
    private void setScreen(Minecraft instance, Screen screen){
        instance.setScreen(new PlayerInventoryScreen(instance.player));
    }
}
