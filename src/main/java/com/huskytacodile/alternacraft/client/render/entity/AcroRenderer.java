package com.huskytacodile.alternacraft.client.render.entity;

import com.google.common.collect.Maps;
import com.huskytacodile.alternacraft.client.model.entity.AcroModel;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.large.AcroEntity;
import com.huskytacodile.alternacraft.entities.variant.TripleVariant;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Map;

public class AcroRenderer extends GeoEntityRenderer<AcroEntity>
{
    public AcroRenderer(EntityRendererProvider.Context entityRendererProvider) {
        super(entityRendererProvider, new AcroModel());
        this.shadowRadius = 4.0F;
    }
    public static final Map<TripleVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(TripleVariant.class), (p_114874_) -> {
                p_114874_.put(TripleVariant.MALE, new ResourceLocation("alternacraft:textures/entity/acro_male.png"));
                p_114874_.put(TripleVariant.FEMALE, new ResourceLocation("alternacraft:textures/entity/acro_female.png"));
                p_114874_.put(TripleVariant.FEMALE2, new ResourceLocation("alternacraft:textures/entity/acro_male1.png"));
            });
    @Override
    public ResourceLocation getTextureLocation(AcroEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public RenderType getRenderType(AcroEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }

    @Override
    protected float getDeathMaxRotation(AcroEntity entityLivingBaseIn){
        return 0.0F;
    }
}
