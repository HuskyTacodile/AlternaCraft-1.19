package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.OxalaiaRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.semiaquatic.SuchomimusEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class OxalaiaModel extends AnimatedGeoModel<SuchomimusEntity> {
    @Override
    public ResourceLocation getAnimationFileLocation(SuchomimusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/oxalaia.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(SuchomimusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/oxalaia.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(SuchomimusEntity entity)    {
        return OxalaiaRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
