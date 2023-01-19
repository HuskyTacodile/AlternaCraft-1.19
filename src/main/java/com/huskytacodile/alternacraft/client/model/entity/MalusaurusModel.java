package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.MalusaurusRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.large.MalusaurusEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MalusaurusModel extends GeoModel<MalusaurusEntity> {
    @Override
    public ResourceLocation getAnimationResource(MalusaurusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/malusaurus.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(MalusaurusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/malusaurus.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MalusaurusEntity entity)    {
        return MalusaurusRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
