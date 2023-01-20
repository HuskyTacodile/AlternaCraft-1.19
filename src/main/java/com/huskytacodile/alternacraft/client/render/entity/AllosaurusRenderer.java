package com.huskytacodile.alternacraft.client.render.entity;

import com.google.common.collect.Maps;
import com.huskytacodile.alternacraft.client.model.entity.AllosaurusModel;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.large.AllosaurusEntity;
import com.huskytacodile.alternacraft.entities.variant.RarityVariant;
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

public class AllosaurusRenderer extends GeoEntityRenderer<AllosaurusEntity>
{
    public AllosaurusRenderer(EntityRendererProvider.Context entityRendererProvider) {
        super(entityRendererProvider, new AllosaurusModel());
        this.shadowRadius = 3.85F;
    }
    public static final Map<RarityVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(RarityVariant.class), (p_114874_) -> {
                p_114874_.put(RarityVariant.MALE, new ResourceLocation("alternacraft:textures/entity/allosaurus_fallen_kingdom.png"));
                p_114874_.put(RarityVariant.FEMALE, new ResourceLocation("alternacraft:textures/entity/allosaurus_dominion.png"));
                p_114874_.put(RarityVariant.MALE2, new ResourceLocation("alternacraft:textures/entity/allosaurus_fallen_kingdom.png"));
                p_114874_.put(RarityVariant.FEMALE2, new ResourceLocation("alternacraft:textures/entity/allosaurus_dominion.png"));
                p_114874_.put(RarityVariant.MALE3, new ResourceLocation("alternacraft:textures/entity/allosaurus_fallen_kingdom.png"));
                p_114874_.put(RarityVariant.FEMALE3, new ResourceLocation("alternacraft:textures/entity/allosaurus_dominion.png"));
                p_114874_.put(RarityVariant.MALE4, new ResourceLocation("alternacraft:textures/entity/allosaurus_fallen_kingdom.png"));
                p_114874_.put(RarityVariant.FEMALE4, new ResourceLocation("alternacraft:textures/entity/allosaurus_dominion.png"));
                p_114874_.put(RarityVariant.MALE5, new ResourceLocation("alternacraft:textures/entity/allosaurus_fallen_kingdom.png"));
                p_114874_.put(RarityVariant.FEMALE5, new ResourceLocation("alternacraft:textures/entity/allosaurus_dominion.png"));
                p_114874_.put(RarityVariant.MALE6, new ResourceLocation("alternacraft:textures/entity/allosaurus_fallen_kingdom.png"));
                p_114874_.put(RarityVariant.FEMALE6, new ResourceLocation("alternacraft:textures/entity/allosaurus_dominion.png"));
                p_114874_.put(RarityVariant.AETHER, new ResourceLocation("alternacraft:textures/entity/allosaurus_aether.png"));
            });
    @Override
    public ResourceLocation getTextureLocation(AllosaurusEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }
    @Override
    public RenderType getRenderType(AllosaurusEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource multiBufferSource, VertexConsumer vertexConsumer, int packedLightIn,
                                    ResourceLocation textureLocation)
    {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }
    @Override
    protected float getDeathMaxRotation(AllosaurusEntity entityLivingBaseIn){
        return 0.0F;
    }
}
