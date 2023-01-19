package com.huskytacodile.alternacraft.client.render.entity;

import com.google.common.collect.Maps;
import com.huskytacodile.alternacraft.client.model.entity.AtrociraptorModel;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.medium.raptor.AtrociraptorEntity;
import com.huskytacodile.alternacraft.entities.variant.QuadrupleVariant;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Map;

public class AtrociraptorRenderer extends GeoEntityRenderer<AtrociraptorEntity>
{
    public AtrociraptorRenderer(EntityRendererProvider.Context entityRendererProvider) {
        super(entityRendererProvider, new AtrociraptorModel());
        this.shadowRadius = 1.1F;
    }
    public static final Map<QuadrupleVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(QuadrupleVariant.class), (p_114874_) -> {
                p_114874_.put(QuadrupleVariant.MALE, new ResourceLocation("alternacraft:textures/entity/atroci_red.png"));
                p_114874_.put(QuadrupleVariant.FEMALE, new ResourceLocation("alternacraft:textures/entity/atroci_ghost.png"));
                p_114874_.put(QuadrupleVariant.MALE2, new ResourceLocation("alternacraft:textures/entity/atroci_tiger.png"));
                p_114874_.put(QuadrupleVariant.FEMALE2, new ResourceLocation("alternacraft:textures/entity/atroci_panthera.png"));
            });
    @Override
    public ResourceLocation getTextureLocation(AtrociraptorEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }
    @Override
    public RenderType getRenderType(AtrociraptorEntity animatable, ResourceLocation texture, @org.jetbrains.annotations.Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }

    @Override
    protected float getDeathMaxRotation(AtrociraptorEntity entityLivingBaseIn){
        return 0.0F;
    }
}
