package com.huskytacodile.alternacraft.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DebugRunItem extends Item {
    public DebugRunItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        //run code to test here. You can change it during the game using the hotswap function.
        if (!pLevel.isClientSide()){

        }
        return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
    }
}
