package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.CarchaRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.large.CarchaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CarchaModel extends GeoModel<CarchaEntity> {
    @Override
    public ResourceLocation getAnimationResource(CarchaEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/carcha.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(CarchaEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/carcha.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CarchaEntity entity)    {
        return CarchaRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
