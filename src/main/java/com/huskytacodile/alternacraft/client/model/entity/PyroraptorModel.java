package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.PyroraptorRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.medium.raptor.PyroraptorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PyroraptorModel extends AnimatedGeoModel<PyroraptorEntity> {
    @Override
    public ResourceLocation getAnimationFileLocation(PyroraptorEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/pyro.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(PyroraptorEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/pyro.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(PyroraptorEntity entity)    {
        return PyroraptorRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
