package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.AtrociraptorRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.medium.raptor.AtrociraptorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AtrociraptorModel extends AnimatedGeoModel<AtrociraptorEntity> {
    @Override
    public ResourceLocation getAnimationFileLocation(AtrociraptorEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/atroci.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(AtrociraptorEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/atroci.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(AtrociraptorEntity entity)    {
        return AtrociraptorRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
