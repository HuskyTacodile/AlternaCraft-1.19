package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.VelociraptorRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.medium.raptor.VelociraptorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class VelociraptorModel extends AnimatedGeoModel<VelociraptorEntity> {
    @Override
    public ResourceLocation getAnimationFileLocation(VelociraptorEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/raptor.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(VelociraptorEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/raptor.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(VelociraptorEntity entity)    {
        return VelociraptorRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
