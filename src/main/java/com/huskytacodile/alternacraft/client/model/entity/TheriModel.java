package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.TheriRenderer;
import com.huskytacodile.alternacraft.entities.dinos.herbivore.large.agitated.TheriEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TheriModel extends AnimatedGeoModel<TheriEntity> {
    @Override
    public ResourceLocation getAnimationFileLocation(TheriEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/theri.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(TheriEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/theri.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(TheriEntity entity)    {
        return TheriRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
