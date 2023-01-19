package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.PyroraptorRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.medium.raptor.PyroraptorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PyroraptorModel extends GeoModel<PyroraptorEntity> {
    @Override
    public ResourceLocation getAnimationResource(PyroraptorEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/pyro.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(PyroraptorEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/pyro.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PyroraptorEntity entity)    {
        return PyroraptorRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
