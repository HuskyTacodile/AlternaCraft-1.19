package com.huskytacodile.alternacraft.client.render.entity;

import com.huskytacodile.alternacraft.Alternacraft;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class AlternaCraftRenderTypes extends RenderStateShard {
    public static final ResourceLocation KNOCKOUT_MENU_TEXTURE = new ResourceLocation(Alternacraft.MOD_ID, "textures/gui/knockout_status.png");
    public static final RenderType KNOCKOUT_TEXTURE_TYPE = createKnockoutMenuRenderType();

    public AlternaCraftRenderTypes(String pName, Runnable pSetupState, Runnable pClearState) {
        super(pName, pSetupState, pClearState);
    }

    private static RenderType createKnockoutMenuRenderType(){
        RenderType.CompositeState renderTypeState = RenderType.CompositeState.builder()
                .setShaderState(RenderStateShard.POSITION_TEX_SHADER)
                .setTextureState(new TextureStateShard(KNOCKOUT_MENU_TEXTURE, false, false))
                .setTransparencyState(RenderStateShard.NO_TRANSPARENCY)
                .setDepthTestState(NO_DEPTH_TEST)
                .setLightmapState(LIGHTMAP)
                .setCullState(NO_CULL)
                .createCompositeState(true);
        return RenderType.create("knockout_status", DefaultVertexFormat.POSITION_TEX, VertexFormat.Mode.QUADS, 256, true, true, renderTypeState);
    }
}
