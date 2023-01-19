package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.AllosaurusRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.large.AllosaurusEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AllosaurusModel extends GeoModel<AllosaurusEntity> {
    @Override
    public ResourceLocation getAnimationResource(AllosaurusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/allosaurus.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(AllosaurusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/allosaurus.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AllosaurusEntity entity)    {
        return AllosaurusRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
