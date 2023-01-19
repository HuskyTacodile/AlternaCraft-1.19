package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.JPSpinoRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.semiaquatic.JPSpinoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class JPSpinoModel extends GeoModel<JPSpinoEntity> {
    @Override
    public ResourceLocation getAnimationResource(JPSpinoEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/spinosaurus_alterna.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(JPSpinoEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/spinosaurus_alterna.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(JPSpinoEntity entity)    {
        return JPSpinoRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
