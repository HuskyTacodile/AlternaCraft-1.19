package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.IndoraptorGen2Renderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.large.hybrid.IndoraptorGen2Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class IndoraptorGen2Model extends GeoModel<IndoraptorGen2Entity> {
    @Override
    public ResourceLocation getAnimationResource(IndoraptorGen2Entity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/indoraptor.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(IndoraptorGen2Entity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/indoraptor.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(IndoraptorGen2Entity entity)    {
        return IndoraptorGen2Renderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
