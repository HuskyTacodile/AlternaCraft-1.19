package com.huskytacodile.alternacraft.entities.dinos;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.function.Predicate;

public abstract class SemiAquaticEntity extends CarnivoreEntity {
    public SemiAquaticEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }
    @Override
    protected Predicate<LivingEntity> getPreySelection(Entity entity) {
        return (e) -> e.getType() != entity.getType() && (e.getType() == EntityType.TROPICAL_FISH || e.getType() == EntityType.SALMON
        || e.getType() == EntityType.COD || e.getType() == EntityType.PUFFERFISH || e.getType() == EntityType.FROG || e.getType() == EntityType.DROWNED);
    }
}
