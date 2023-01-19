package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.VelociraptorRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.medium.raptor.VelociraptorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class VelociraptorModel extends GeoModel<VelociraptorEntity> {
    @Override
    public ResourceLocation getAnimationResource(VelociraptorEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/raptor.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(VelociraptorEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/raptor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(VelociraptorEntity entity)    {
        return VelociraptorRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
