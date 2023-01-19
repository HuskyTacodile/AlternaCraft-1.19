package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.MosasaurusRenderer;
import com.huskytacodile.alternacraft.entities.MosasaurusEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MosasaurusModel extends GeoModel<MosasaurusEntity> {
    @Override
    public ResourceLocation getAnimationResource(MosasaurusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/mosasaurus.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(MosasaurusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/mosasaurus.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MosasaurusEntity entity)    {
        return MosasaurusRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
