package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.OxalaiaRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.semiaquatic.SuchomimusEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OxalaiaModel extends GeoModel<SuchomimusEntity> {
    @Override
    public ResourceLocation getAnimationResource(SuchomimusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/oxalaia.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(SuchomimusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/oxalaia.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SuchomimusEntity entity)    {
        return OxalaiaRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
