package com.huskytacodile.alternacraft.entities.dinos;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;

import java.util.function.Predicate;

public abstract class SemiAquaticEntity extends CarnivoreEntity {
    public SemiAquaticEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }
    @Override
    protected Predicate<LivingEntity> getPreySelection(Entity entity) {
        return (e) -> e.getType() != entity.getType() && (e.getType() == EntityType.TROPICAL_FISH || e.getType() == EntityType.SALMON
        || e.getType() == EntityType.COD || e.getType() == EntityType.PUFFERFISH || e.getType() == EntityType.DROWNED);
    }
}
