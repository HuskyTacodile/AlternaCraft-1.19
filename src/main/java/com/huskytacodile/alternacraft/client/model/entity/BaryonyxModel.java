package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.BaryonyxRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.semiaquatic.BaryonyxEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BaryonyxModel extends GeoModel<BaryonyxEntity> {
    @Override
    public ResourceLocation getAnimationResource(BaryonyxEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/baryonyx.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(BaryonyxEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/baryonyx.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BaryonyxEntity entity)    {
        return BaryonyxRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
