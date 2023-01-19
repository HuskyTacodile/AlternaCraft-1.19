package com.huskytacodile.alternacraft.client.render.entity;

import com.google.common.collect.Maps;
import com.huskytacodile.alternacraft.client.model.entity.BaryonyxModel;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.semiaquatic.BaryonyxEntity;
import com.huskytacodile.alternacraft.entities.variant.TripleVariant;
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

public class BaryonyxRenderer extends GeoEntityRenderer<BaryonyxEntity>
{
    public BaryonyxRenderer(EntityRendererProvider.Context entityRendererProvider) {
        super(entityRendererProvider, new BaryonyxModel());
        this.shadowRadius = 2.2F;
    }
    public static final Map<TripleVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(TripleVariant.class), (p_114874_) -> {
                p_114874_.put(TripleVariant.MALE, new ResourceLocation("alternacraft:textures/entity/baryonyx_chaos.png"));
                p_114874_.put(TripleVariant.FEMALE, new ResourceLocation("alternacraft:textures/entity/bary_grim.png"));
                p_114874_.put(TripleVariant.FEMALE2, new ResourceLocation("alternacraft:textures/entity/bary_fk.png"));
            });
    @Override
    public ResourceLocation getTextureLocation(BaryonyxEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public RenderType getRenderType(BaryonyxEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }

    @Override
    protected float getDeathMaxRotation(BaryonyxEntity entityLivingBaseIn){
        return 0.0F;
    }
}
