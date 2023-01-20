package com.huskytacodile.alternacraft.client.render.entity;

import com.google.common.collect.Maps;
import com.huskytacodile.alternacraft.client.model.entity.JPSpinoModel;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.semiaquatic.JPSpinoEntity;

import com.huskytacodile.alternacraft.entities.variant.TripleVariant;
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

public class JPSpinoRenderer extends GeoEntityRenderer<JPSpinoEntity>
{
    public JPSpinoRenderer(EntityRendererProvider.Context entityRendererProvider) {
        super(entityRendererProvider, new JPSpinoModel());
        this.shadowRadius = 4.0F;
    }
    public static final Map<TripleVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(TripleVariant.class), (p_114874_) -> {
                p_114874_.put(TripleVariant.MALE, new ResourceLocation("alternacraft:textures/entity/jpspino_male.png"));
                p_114874_.put(TripleVariant.FEMALE, new ResourceLocation("alternacraft:textures/entity/jpspino_female.png"));
                p_114874_.put(TripleVariant.FEMALE2, new ResourceLocation("alternacraft:textures/entity/jpspino_male1.png"));
            });
    @Override
    public ResourceLocation getTextureLocation(JPSpinoEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public RenderType getRenderType(JPSpinoEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource multiBufferSource, VertexConsumer vertexConsumer, int packedLightIn,
                                    ResourceLocation textureLocation)
    {
        if(animatable.isBaby()) {
            stack.scale(0.4F, 0.4F, 0.4F);
        } else {
            stack.scale(0.8F, 0.8F, 0.8F);
        }
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }
    @Override
    protected float getDeathMaxRotation(JPSpinoEntity entityLivingBaseIn){
        return 0.0F;
    }
}
