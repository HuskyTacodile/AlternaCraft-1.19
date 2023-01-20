package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.DryptoRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.medium.DryptoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DryptoModel extends AnimatedGeoModel<DryptoEntity> {
    @Override
    public ResourceLocation getAnimationFileLocation(DryptoEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/drypto.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(DryptoEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/drypto.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(DryptoEntity entity)    {
        return DryptoRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
