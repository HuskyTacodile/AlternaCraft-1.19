package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.MorosRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.small.MorosEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MorosModel extends AnimatedGeoModel<MorosEntity> {
    @Override
    public ResourceLocation getAnimationFileLocation(MorosEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/moros.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(MorosEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/moros.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(MorosEntity entity)    {
        return MorosRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
