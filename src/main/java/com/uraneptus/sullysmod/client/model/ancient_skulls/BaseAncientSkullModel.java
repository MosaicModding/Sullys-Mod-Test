package com.uraneptus.sullysmod.client.model.ancient_skulls;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.model.geom.ModelPart;

public abstract class BaseAncientSkullModel extends SkullModelBase {
    private final ModelPart head;
    private final float scale;

    public BaseAncientSkullModel(ModelPart root, float scale) {
        this.head = root.getChild("head");
        this.scale = scale;
    }

    @Override
    public void setupAnim(float pMouthAnimation, float pYRot, float pXRot) {
        this.head.yRot = pYRot * ((float)Math.PI / 180F);
        this.head.xRot = pXRot * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        poseStack.pushPose();
        //poseStack.scale(this.scale, this.scale, this.scale);
        this.head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();
    }

    public abstract float headRenderScale();
    public abstract float headRenderHeight();
}
