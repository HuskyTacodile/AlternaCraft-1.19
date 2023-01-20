package com.huskytacodile.alternacraft.client.render.entity;

import com.google.common.collect.Maps;
import com.huskytacodile.alternacraft.client.model.entity.IndoraptorGen2Model;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.large.hybrid.IndoraptorGen2Entity;
import com.huskytacodile.alternacraft.entities.variant.GenderVariant;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;
import java.util.Map;

public class IndoraptorGen2Renderer extends GeoEntityRenderer<IndoraptorGen2Entity>
{
    public IndoraptorGen2Renderer(EntityRendererProvider.Context entityRendererProvider) {
        super(entityRendererProvider, new IndoraptorGen2Model());
        this.shadowRadius = 4.0F;
    }
    public static final Map<GenderVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(GenderVariant.class), (p_114874_) -> {
                p_114874_.put(GenderVariant.MALE, new ResourceLocation("alternacraft:textures/entity/indoraptor_male.png"));
                p_114874_.put(GenderVariant.FEMALE, new ResourceLocation("alternacraft:textures/entity/indoraptor_female.png"));
            });
    @Override
    public ResourceLocation getTextureLocation(IndoraptorGen2Entity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public RenderType getRenderType(IndoraptorGen2Entity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource multiBufferSource, VertexConsumer vertexConsumer, int packedLightIn,
                                    ResourceLocation textureLocation)
    {
        if(animatable.isBaby()) {
            stack.scale(0.2F, 0.2F, 0.2F);
            this.shadowRadius = 1.0F;
        } else {
            stack.scale(1.0F, 1.0F, 1.0F);
            this.shadowRadius = 4.0F;
        }
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }
    @Override
    protected float getDeathMaxRotation(IndoraptorGen2Entity entityLivingBaseIn){
        return 0.0F;
    }
}
