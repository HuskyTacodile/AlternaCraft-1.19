
package com.huskytacodile.alternacraft.client.render.entity;

import com.google.common.collect.Maps;
import com.huskytacodile.alternacraft.client.model.entity.ScorpiusModel;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.large.hybrid.ScorpiusEntity;
import com.huskytacodile.alternacraft.entities.variant.QuadrupleVariant;
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

public class ScorpiusRenderer extends GeoEntityRenderer<ScorpiusEntity>
{
    public ScorpiusRenderer(EntityRendererProvider.Context entityRendererProvider) {
        super(entityRendererProvider, new ScorpiusModel());
        this.shadowRadius = 4.0F;
    }
    public static final Map<QuadrupleVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(QuadrupleVariant.class), (p_114874_) -> {
                p_114874_.put(QuadrupleVariant.MALE, new ResourceLocation("alternacraft:textures/entity/scorpius_male.png"));
                p_114874_.put(QuadrupleVariant.FEMALE, new ResourceLocation("alternacraft:textures/entity/scorpius_female.png"));
                p_114874_.put(QuadrupleVariant.FEMALE2, new ResourceLocation("alternacraft:textures/entity/alpha_scorpius.png"));
                p_114874_.put(QuadrupleVariant.MALE2, new ResourceLocation("alternacraft:textures/entity/scorpius_gen_3.png"));
            });
    @Override
    public ResourceLocation getTextureLocation(ScorpiusEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }
    @Override
    public RenderType getRenderType(ScorpiusEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource multiBufferSource, VertexConsumer vertexConsumer, int packedLightIn,
                                    ResourceLocation textureLocation)
    {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }
    @Override
    protected float getDeathMaxRotation(ScorpiusEntity entityLivingBaseIn){
        return 0.0F;
    }
}
