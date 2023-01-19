package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.AtrociraptorRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.medium.raptor.AtrociraptorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AtrociraptorModel extends GeoModel<AtrociraptorEntity> {
    @Override
    public ResourceLocation getAnimationResource(AtrociraptorEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/atroci.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(AtrociraptorEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/atroci.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AtrociraptorEntity entity)    {
        return AtrociraptorRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
