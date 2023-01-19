package com.huskytacodile.alternacraft.capabilities;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.AutoRegisterCapability;
import net.minecraftforge.common.util.INBTSerializable;

@AutoRegisterCapability
public interface ILevelCapability extends INBTSerializable<CompoundTag> {
    int getLevel();
    int setLevel(int level);
    int addLevels(int levels);
}
