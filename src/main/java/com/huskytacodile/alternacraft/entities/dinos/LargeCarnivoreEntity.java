package com.huskytacodile.alternacraft.entities.dinos;

import com.huskytacodile.alternacraft.entities.ModEntityTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.function.Predicate;

public abstract class LargeCarnivoreEntity extends CarnivoreEntity {
    public LargeCarnivoreEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected Predicate<LivingEntity> getPreySelection(Entity entity) {
        return (e) -> e.getType() != entity.getType() && (e.getType() == EntityType.SHEEP || e.getType() == EntityType.RABBIT ||
                e.getType() == EntityType.COW || e.getType() == EntityType.CHICKEN || e.getType() == EntityType.PIG ||
                e.getType() == ModEntityTypes.JPSPINO.get() || e.getType() == ModEntityTypes.OXALAIA.get() ||
                e.getType() == ModEntityTypes.TYRANNOSAURUS.get() || e.getType() == ModEntityTypes.YUTYRANNUS.get() ||
                e.getType() == ModEntityTypes.CARCHA.get() || e.getType() == ModEntityTypes.BARYONYX.get() || e.getType() == ModEntityTypes.BARYONYX_GEN2.get() ||
                e.getType() == ModEntityTypes.TYLOSAURUS.get() || e.getType() == ModEntityTypes.MOSASAURUS.get() ||
                e.getType() == ModEntityTypes.CERATOSUCHOPS.get() || e.getType() == ModEntityTypes.INDOMINUS.get() ||
                e.getType() == ModEntityTypes.INDORAPTOR_GEN2.get() || e.getType() == ModEntityTypes.SCORPIUS.get());
    }
}
