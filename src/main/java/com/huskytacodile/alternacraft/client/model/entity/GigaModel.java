package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.GigaRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.large.GigaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GigaModel extends AnimatedGeoModel<GigaEntity> {
    @Override
    public ResourceLocation getAnimationFileLocation(GigaEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/giganotosaurus.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(GigaEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/giganotosaurus.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(GigaEntity entity)    {
        return GigaRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
