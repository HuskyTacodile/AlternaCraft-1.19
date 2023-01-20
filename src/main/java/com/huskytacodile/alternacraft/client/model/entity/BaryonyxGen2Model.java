
package com.huskytacodile.alternacraft.client.model.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.client.render.entity.BaryonyxGen2Renderer;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.semiaquatic.BaryonyxGen2Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BaryonyxGen2Model extends AnimatedGeoModel<BaryonyxGen2Entity> {
    @Override
    public ResourceLocation getAnimationFileLocation(BaryonyxGen2Entity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "animations/bary_gen2.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(BaryonyxGen2Entity entity) {
        return new ResourceLocation(Alternacraft.MOD_ID, "geo/bary_gen_2.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(BaryonyxGen2Entity entity)    {
        return BaryonyxGen2Renderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
