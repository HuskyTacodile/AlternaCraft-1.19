package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.CeratosuchopsRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.semiaquatic.CeratosuchopsEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CeratosuchopsModel extends GeoModel<CeratosuchopsEntity> {
    @Override
    public ResourceLocation getAnimationResource(CeratosuchopsEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/ceratosuchops.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(CeratosuchopsEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/ceratosuchops.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CeratosuchopsEntity entity)    {
        return CeratosuchopsRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
