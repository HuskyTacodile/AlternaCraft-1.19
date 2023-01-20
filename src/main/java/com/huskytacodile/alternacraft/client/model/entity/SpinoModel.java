package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.SpinoRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.semiaquatic.SpinoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SpinoModel extends AnimatedGeoModel<SpinoEntity> {
    @Override
    public ResourceLocation getAnimationFileLocation(SpinoEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/spiny.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(SpinoEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/spino_gen2.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(SpinoEntity entity)    {
        return SpinoRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
