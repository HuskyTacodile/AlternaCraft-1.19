package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.MosasaurusRenderer;
import com.huskytacodile.alternacraft.entities.MosasaurusEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MosasaurusModel extends AnimatedGeoModel<MosasaurusEntity> {
    @Override
    public ResourceLocation getAnimationFileLocation(MosasaurusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/mosasaurus.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(MosasaurusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/mosasaurus.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(MosasaurusEntity entity)    {
        return MosasaurusRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
