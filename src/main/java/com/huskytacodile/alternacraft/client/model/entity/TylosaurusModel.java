package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.TylosaurusRenderer;
import com.huskytacodile.alternacraft.entities.TylosaurusEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TylosaurusModel extends AnimatedGeoModel<TylosaurusEntity> {
    @Override
    public ResourceLocation getAnimationFileLocation(TylosaurusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/tylosaurus.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(TylosaurusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/tylosaurus.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(TylosaurusEntity entity)    {
        return TylosaurusRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
