package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.DromaeoRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.medium.raptor.DromaeoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DromaeoModel extends AnimatedGeoModel<DromaeoEntity> {
    @Override
    public ResourceLocation getAnimationFileLocation(DromaeoEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/dromaeo.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(DromaeoEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/dromaeo.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(DromaeoEntity entity)    {
        return DromaeoRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
