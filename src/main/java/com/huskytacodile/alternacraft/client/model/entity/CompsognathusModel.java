package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.CompsognathusRenderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.small.CompsognathusEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CompsognathusModel extends GeoModel<CompsognathusEntity> {
    @Override
    public ResourceLocation getAnimationResource(CompsognathusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/compsognathus.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(CompsognathusEntity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/compsognathus.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CompsognathusEntity entity)    {
        return CompsognathusRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
