package com.huskytacodile.alternacraft.util;

import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Rarity;

public enum EggTier {
    COMMON,
    UNCOMMON,
    RARE,
    VERY_RARE,
    EPIC,
    MYTHICALLY_RARE;

    public Rarity getRarity() {
        return switch (this) {
            case UNCOMMON -> Rarity.UNCOMMON;
            case RARE -> Rarity.RARE;
            case VERY_RARE -> Rarity.create("very_rare", ChatFormatting.GREEN);
            case EPIC -> Rarity.EPIC;
            case MYTHICALLY_RARE -> Rarity.create("mythically_rare", ChatFormatting.GOLD);
            default -> Rarity.COMMON;
        };
    }
}
