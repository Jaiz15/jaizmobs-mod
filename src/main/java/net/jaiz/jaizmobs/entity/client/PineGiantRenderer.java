package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.PineGiantEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class PineGiantRenderer extends MobEntityRenderer<PineGiantEntity, PineGiant<PineGiantEntity>> {
    private static final Identifier TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/pine_giant.png");

    public PineGiantRenderer(EntityRendererFactory.Context context) {
        super(context, new PineGiant<>(context.getPart(ModModelLayers.PINE_GIANT)), 0.5f);
    }

    @Override
    public Identifier getTexture(PineGiantEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(PineGiantEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
