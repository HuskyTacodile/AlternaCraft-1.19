package com.huskytacodile.alternacraft.entities.dinos;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public abstract class MediumCarnivoreEntity extends CarnivoreEntity {
    public MediumCarnivoreEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }
}
