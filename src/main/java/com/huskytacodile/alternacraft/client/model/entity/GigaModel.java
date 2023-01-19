package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.GigaRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.large.GigaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GigaModel extends GeoModel<GigaEntity> {
    @Override
    public ResourceLocation getAnimationResource(GigaEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/giganotosaurus.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(GigaEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/giganotosaurus.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GigaEntity entity)    {
        return GigaRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
