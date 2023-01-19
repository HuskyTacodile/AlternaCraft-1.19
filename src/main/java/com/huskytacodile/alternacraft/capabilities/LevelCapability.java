package com.huskytacodile.alternacraft.capabilities;

import net.minecraft.nbt.CompoundTag;

public class LevelCapability implements ILevelCapability{
    private int level;

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int setLevel(int level) {
        return this.level = level;
    }

    @Override
    public int addLevels(int levels) {
        return this.level += level;
    }

    @Override
    public CompoundTag serializeNBT() {
        final CompoundTag tag = new CompoundTag();
        tag.putInt("level", this.level);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        this.level = nbt.getInt("level");
    }
}
