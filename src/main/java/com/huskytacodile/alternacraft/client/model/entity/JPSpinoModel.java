package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.JPSpinoRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.semiaquatic.JPSpinoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class JPSpinoModel extends AnimatedGeoModel<JPSpinoEntity> {
    @Override
    public ResourceLocation getAnimationFileLocation(JPSpinoEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/spinosaurus_alterna.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(JPSpinoEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/spinosaurus_alterna.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(JPSpinoEntity entity)    {
        return JPSpinoRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
