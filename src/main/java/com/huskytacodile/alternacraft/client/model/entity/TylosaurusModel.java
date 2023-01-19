package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.TylosaurusRenderer;
import com.huskytacodile.alternacraft.entities.TylosaurusEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TylosaurusModel extends GeoModel<TylosaurusEntity> {
    @Override
    public ResourceLocation getAnimationResource(TylosaurusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/tylosaurus.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(TylosaurusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/tylosaurus.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TylosaurusEntity entity)    {
        return TylosaurusRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
