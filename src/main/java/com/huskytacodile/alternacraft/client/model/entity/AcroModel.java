package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.AcroRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.large.AcroEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AcroModel extends AnimatedGeoModel<AcroEntity> {
    @Override
    public ResourceLocation getModelLocation(AcroEntity object) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/acrocanthosaurus.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(AcroEntity entity) {
        return AcroRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public ResourceLocation getAnimationFileLocation(AcroEntity animatable) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/acrocanthosaurus.animation.json");
    }
}
