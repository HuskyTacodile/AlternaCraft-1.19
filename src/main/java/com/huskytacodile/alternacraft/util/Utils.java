package com.huskytacodile.alternacraft.util;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.joml.Matrix4f;

public class Utils {
    /**
     *
     * @param poseStack poseStack
     * @param x1 starting x on texture
     * @param x2 ending x on texture
     * @param y1 starting y on texture
     * @param y2 ending y on texture
     * @param scalar scaling modifier
     * @param xFactor part/total of the bar width
     * @param yFactor part/total of the bar height
     * @param packedLight packedLight
     * @param healthBuilder builder
     * @param textureWidth total texture width
     * @param textureHeight total texture height
     * @param direction 0 = top to bottom & left to right
     *                  1 = bottom to top & right to left
     */
    public static void draw(PoseStack poseStack, int x1, int x2, int y1, int y2, float scalar, float xFactor, float yFactor, int packedLight, VertexConsumer healthBuilder, int textureWidth, int textureHeight, int direction) {
        int width = x2 - x1;
        int height = y2 - y1;
        poseStack.translate(direction == 0 ? 0.01 * (width-(width * xFactor)) : -0.01 * (width-(width * xFactor)), direction == 0 ? 0.01 * (height-(height * yFactor)) : -0.01 * (height-(height * yFactor)), 0);
        healthBuilder.vertex(poseStack.last().pose(),  width * scalar * xFactor,  height * yFactor * scalar, 0).uv((x1 + (direction == 0 ? width-(width * xFactor) : 0)) / ((float) textureWidth), (y2 - (direction == 1 ? (height * (1 - yFactor)) : 0 ))/((float) textureHeight)).uv2(packedLight).endVertex();
        healthBuilder.vertex(poseStack.last().pose(), -width * scalar * xFactor,  height * yFactor * scalar, 0).uv((x2 - (direction == 1 ? (width * (1 -xFactor)) : 0)) /  ((float) textureWidth), (y2 - (direction == 1 ? (height * (1 - yFactor)) : 0 ))/((float) textureHeight)).uv2(packedLight).endVertex();
        healthBuilder.vertex(poseStack.last().pose(), -width * scalar * xFactor, -height * yFactor * scalar, 0).uv((x2 - (direction == 1 ? (width * (1 -xFactor)) : 0)) /  ((float) textureWidth), (y1 + (direction == 0 ? height-(height * yFactor) : 0))/((float) textureHeight)).uv2(packedLight).endVertex();
        healthBuilder.vertex(poseStack.last().pose(),  width * scalar * xFactor, -height * yFactor * scalar, 0).uv((x1 + (direction == 0 ? width-(width * xFactor) : 0)) / ((float) textureWidth), (y1 + (direction == 0 ? height-(height * yFactor) : 0))/((float) textureHeight)).uv2(packedLight).endVertex();
        poseStack.translate(-(direction == 0 ? 0.01 * (width-(width * xFactor)) : -0.01 * (width-(width * xFactor))),-(direction == 0 ? 0.01 * (height-(height * yFactor)) : -0.01 * (height-(height * yFactor))), 0);
    }
}
