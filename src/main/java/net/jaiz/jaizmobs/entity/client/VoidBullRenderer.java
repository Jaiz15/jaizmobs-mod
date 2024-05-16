package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.VoidBullEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class  VoidBullRenderer extends MobEntityRenderer<VoidBullEntity, VoidBull<VoidBullEntity>> {
    private static final Identifier TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/voidbull.png");

    public VoidBullRenderer(EntityRendererFactory.Context context) {
        super(context, new VoidBull<>(context.getPart(ModModelLayers.VOIDBULL)), 1f);
    }

    @Override
    public Identifier getTexture(VoidBullEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(VoidBullEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
