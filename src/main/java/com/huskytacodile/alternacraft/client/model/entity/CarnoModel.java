package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.CarnoRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.large.CarnoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CarnoModel extends AnimatedGeoModel<CarnoEntity> {
    @Override
    public ResourceLocation getAnimationFileLocation(CarnoEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/carno.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(CarnoEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/carno.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(CarnoEntity entity)    {
        return CarnoRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
