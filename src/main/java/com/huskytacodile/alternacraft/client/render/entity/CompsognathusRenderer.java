package com.huskytacodile.alternacraft.client.render.entity;

import com.google.common.collect.Maps;
import com.huskytacodile.alternacraft.client.model.entity.CompsognathusModel;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.small.CompsognathusEntity;
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

public class CompsognathusRenderer extends GeoEntityRenderer<CompsognathusEntity>
{
    public CompsognathusRenderer(EntityRendererProvider.Context entityRendererProvider) {
        super(entityRendererProvider, new CompsognathusModel());
        this.shadowRadius = .7F;
    }
    public static final Map<TripleVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(TripleVariant.class), (p_114874_) -> {
                p_114874_.put(TripleVariant.MALE, new ResourceLocation("alternacraft:textures/entity/compsognathus_male.png"));
                p_114874_.put(TripleVariant.FEMALE, new ResourceLocation("alternacraft:textures/entity/compsognathus_female.png"));
                p_114874_.put(TripleVariant.FEMALE2, new ResourceLocation("alternacraft:textures/entity/compsognathus_female2.png"));
            });
    @Override
    public ResourceLocation getTextureLocation(CompsognathusEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public RenderType getRenderType(CompsognathusEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource multiBufferSource, VertexConsumer vertexConsumer, int packedLightIn,
                                    ResourceLocation textureLocation)
    {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }
    @Override
    protected float getDeathMaxRotation(CompsognathusEntity entityLivingBaseIn){
        return 0.0F;
    }
}
