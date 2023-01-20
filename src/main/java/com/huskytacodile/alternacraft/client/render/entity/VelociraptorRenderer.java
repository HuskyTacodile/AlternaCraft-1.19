package com.huskytacodile.alternacraft.client.render.entity;

import com.google.common.collect.Maps;
import com.huskytacodile.alternacraft.client.model.entity.VelociraptorModel;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.medium.raptor.VelociraptorEntity;
import com.huskytacodile.alternacraft.entities.variant.DuodecupleVariant;
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

public class VelociraptorRenderer extends GeoEntityRenderer<VelociraptorEntity>
{
    public VelociraptorRenderer(EntityRendererProvider.Context entityRendererProvider) {
        super(entityRendererProvider, new VelociraptorModel());
        this.shadowRadius = 1.2F;
    }
    public static final Map<DuodecupleVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(DuodecupleVariant.class), (p_114874_) -> {
                p_114874_.put(DuodecupleVariant.JP, new ResourceLocation("alternacraft:textures/entity/raptor_jp.png"));
                p_114874_.put(DuodecupleVariant.TLW, new ResourceLocation("alternacraft:textures/entity/raptor_tlw.png"));
                p_114874_.put(DuodecupleVariant.JP3MALE, new ResourceLocation("alternacraft:textures/entity/raptor_jp3_male.png"));
                p_114874_.put(DuodecupleVariant.JP3FEMALE, new ResourceLocation("alternacraft:textures/entity/raptor_jp3_female.png"));
                p_114874_.put(DuodecupleVariant.BLUE, new ResourceLocation("alternacraft:textures/entity/raptor_blue.png"));
                p_114874_.put(DuodecupleVariant.CHARLIE, new ResourceLocation("alternacraft:textures/entity/raptor_charlie.png"));
                p_114874_.put(DuodecupleVariant.DELTA, new ResourceLocation("alternacraft:textures/entity/raptor_delta.png"));
                p_114874_.put(DuodecupleVariant.ECHO, new ResourceLocation("alternacraft:textures/entity/raptor_echo.png"));
                p_114874_.put(DuodecupleVariant.RED, new ResourceLocation("alternacraft:textures/entity/raptor_red.png"));
                p_114874_.put(DuodecupleVariant.CC, new ResourceLocation("alternacraft:textures/entity/raptor_cc.png"));
                p_114874_.put(DuodecupleVariant.DINOTRACKERMALE, new ResourceLocation("alternacraft:textures/entity/raptor_v1.png"));
                p_114874_.put(DuodecupleVariant.DINOTRACKERFEMALE, new ResourceLocation("alternacraft:textures/entity/raptor_v2.png"));
            });

    @Override
    public ResourceLocation getTextureLocation(VelociraptorEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }
    @Override
    public RenderType getRenderType(VelociraptorEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource multiBufferSource, VertexConsumer vertexConsumer, int packedLightIn,
                                    ResourceLocation textureLocation)
    {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }
    @Override
    protected float getDeathMaxRotation(VelociraptorEntity entityLivingBaseIn){
        return 0.0F;
    }
}
