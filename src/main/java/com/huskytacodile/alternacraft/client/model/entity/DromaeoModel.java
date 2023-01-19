package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.DromaeoRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.medium.raptor.DromaeoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DromaeoModel extends GeoModel<DromaeoEntity> {
    @Override
    public ResourceLocation getAnimationResource(DromaeoEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/dromaeo.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(DromaeoEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/dromaeo.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DromaeoEntity entity)    {
        return DromaeoRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
