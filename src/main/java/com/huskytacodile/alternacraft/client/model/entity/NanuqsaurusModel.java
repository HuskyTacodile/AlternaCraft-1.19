package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.NanuqsaurusRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.large.NanuqsaurusEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class NanuqsaurusModel extends AnimatedGeoModel<NanuqsaurusEntity> {
    @Override
    public ResourceLocation getAnimationFileLocation(NanuqsaurusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/nanuqsaurus.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(NanuqsaurusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/nanuqsaurus.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(NanuqsaurusEntity entity)    {
        return NanuqsaurusRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
