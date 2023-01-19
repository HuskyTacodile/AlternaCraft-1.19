package com.huskytacodile.alternacraft.client.render.entity;

import com.google.common.collect.Maps;
import com.huskytacodile.alternacraft.client.model.entity.TyrannosaurusModel;
import com.huskytacodile.alternacraft.entities.dinos.carnivore.large.TyrannosaurusEntity;
import com.huskytacodile.alternacraft.entities.variant.SextupleVariant;
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

public class TyrannosaurusRenderer extends GeoEntityRenderer<TyrannosaurusEntity>
{
    public TyrannosaurusRenderer(EntityRendererProvider.Context entityRendererProvider) {
        super(entityRendererProvider, new TyrannosaurusModel());
        this.shadowRadius = 4.0F;
    }
    public static final Map<SextupleVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(SextupleVariant.class), (p_114874_) -> {
                p_114874_.put(SextupleVariant.MALE, new ResourceLocation("alternacraft:textures/entity/t_rex_buck.png"));
                p_114874_.put(SextupleVariant.FEMALE, new ResourceLocation("alternacraft:textures/entity/t_rex_doe.png"));
                p_114874_.put(SextupleVariant.MALE2, new ResourceLocation("alternacraft:textures/entity/t_rex_alpha.png"));
                p_114874_.put(SextupleVariant.FEMALE2, new ResourceLocation("alternacraft:textures/entity/t_rex_little_eatie.png"));
                p_114874_.put(SextupleVariant.MALE3, new ResourceLocation("alternacraft:textures/entity/t_rex_big_eatie.png"));
                p_114874_.put(SextupleVariant.FEMALE3, new ResourceLocation("alternacraft:textures/entity/t_rex_rexy.png"));
            });
    @Override
    public ResourceLocation getTextureLocation(TyrannosaurusEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public RenderType getRenderType(TyrannosaurusEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));

    }

    @Override
    protected float getDeathMaxRotation(TyrannosaurusEntity entityLivingBaseIn){
        return 0.0F;
    }
}
