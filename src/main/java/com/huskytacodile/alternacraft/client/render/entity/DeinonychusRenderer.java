package com.huskytacodile.alternacraft.client.render.entity;

import com.google.common.collect.Maps;
import com.huskytacodile.alternacraft.client.model.entity.DeinonychusModel;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.medium.raptor.DeinonychusEntity;
import com.huskytacodile.alternacraft.entities.variant.GenderVariant;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Map;

public class DeinonychusRenderer extends GeoEntityRenderer<DeinonychusEntity>
{
    public DeinonychusRenderer(EntityRendererProvider.Context entityRendererProvider) {
        super(entityRendererProvider, new DeinonychusModel());
        this.shadowRadius = 1.2F;
    }
    public static final Map<GenderVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(GenderVariant.class), (p_114874_) -> {
                p_114874_.put(GenderVariant.MALE, new ResourceLocation("alternacraft:textures/entity/deinonychus.png"));
                p_114874_.put(GenderVariant.FEMALE, new ResourceLocation("alternacraft:textures/entity/deinonychus.png"));
            });

    @Override
    public ResourceLocation getTextureLocation(DeinonychusEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public RenderType getRenderType(DeinonychusEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));

    }

    @Override
    protected float getDeathMaxRotation(DeinonychusEntity entityLivingBaseIn){
        return 0.0F;
    }
}
