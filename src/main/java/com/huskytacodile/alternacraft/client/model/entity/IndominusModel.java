package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.IndominusRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.large.hybrid.IndominusEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class IndominusModel extends AnimatedGeoModel<IndominusEntity> {
    @Override
    public ResourceLocation getAnimationFileLocation(IndominusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/indominus.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(IndominusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/indominus.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(IndominusEntity entity)    {
        return IndominusRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
