package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.IndoraptorRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.large.hybrid.IndoraptorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class IndoraptorModel extends GeoModel<IndoraptorEntity> {
    @Override
    public ResourceLocation getAnimationResource(IndoraptorEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/indoraptor_alterna.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(IndoraptorEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/indoraptor_alterna.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(IndoraptorEntity entity)    {
        return IndoraptorRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
