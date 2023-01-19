package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.DryptoRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.medium.DryptoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DryptoModel extends GeoModel<DryptoEntity> {
    @Override
    public ResourceLocation getAnimationResource(DryptoEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/drypto.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(DryptoEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/drypto.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DryptoEntity entity)    {
        return DryptoRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
