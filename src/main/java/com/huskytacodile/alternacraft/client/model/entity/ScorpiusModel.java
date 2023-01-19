package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.ScorpiusRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.large.hybrid.ScorpiusEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ScorpiusModel extends GeoModel<ScorpiusEntity> {
    @Override
    public ResourceLocation getAnimationResource(ScorpiusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/scorpius.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(ScorpiusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/scorpius.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ScorpiusEntity entity)    {
        return ScorpiusRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
