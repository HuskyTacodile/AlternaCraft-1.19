package com.huskytacodile.alternacraft.client.render.entity;


import com.google.common.collect.Maps;
import com.huskytacodile.alternacraft.client.model.entity.OxalaiaModel;

import com.huskytacodile.alternacraft.entities.dinos.carnivore.semiaquatic.SuchomimusEntity;
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

public class OxalaiaRenderer extends GeoEntityRenderer<SuchomimusEntity>
{
    public OxalaiaRenderer(EntityRendererProvider.Context entityRendererProvider) {
        super(entityRendererProvider, new OxalaiaModel());
        this.shadowRadius = 4.0F;
    }
    public static final Map<GenderVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(GenderVariant.class), (p_114874_) -> {
                p_114874_.put(GenderVariant.MALE, new ResourceLocation("alternacraft:textures/entity/oxalaia_male.png"));
                p_114874_.put(GenderVariant.FEMALE, new ResourceLocation("alternacraft:textures/entity/oxalaia_female.png"));
            });
    @Override
    public ResourceLocation getTextureLocation(SuchomimusEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }
    @Override
    public RenderType getRenderType(SuchomimusEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource multiBufferSource, VertexConsumer vertexConsumer, int packedLightIn,
                                    ResourceLocation textureLocation)
    {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }
    @Override
    protected float getDeathMaxRotation(SuchomimusEntity entityLivingBaseIn){
        return 0.0F;
    }
}
