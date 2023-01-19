package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.CarnoRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.large.CarnoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CarnoModel extends GeoModel<CarnoEntity> {
    @Override
    public ResourceLocation getAnimationResource(CarnoEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/carno.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(CarnoEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/carno.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CarnoEntity entity)    {
        return CarnoRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
