package com.huskytacodile.alternacraft.item.custom;

import com.huskytacodile.alternacraft.util.Dino;
import com.huskytacodile.alternacraft.util.DinoEgg;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DinoEggItem extends Item {
    public DinoEggItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return pStack.hasTag();
    }

    @Override
    @NotNull
    public Rarity getRarity(ItemStack stack) {
        return DinoEgg.getDinoByItem(stack.getItem()).getTier().getRarity();
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(new TextComponent("DNA: " + DinoEgg.getDinoByItem(this).getName()));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}

