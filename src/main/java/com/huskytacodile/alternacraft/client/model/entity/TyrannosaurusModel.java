package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.TyrannosaurusRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.large.TyrannosaurusEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TyrannosaurusModel extends AnimatedGeoModel<TyrannosaurusEntity> {
    @Override
    public ResourceLocation getAnimationFileLocation(TyrannosaurusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/trex.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(TyrannosaurusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/trex.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(TyrannosaurusEntity entity)    {
        return TyrannosaurusRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
