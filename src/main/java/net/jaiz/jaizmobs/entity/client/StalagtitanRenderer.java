package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.StalagtitanEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class StalagtitanRenderer extends MobEntityRenderer<StalagtitanEntity, Stalagtitan<StalagtitanEntity>> {
    private static final Identifier TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/stalagtitan.png");

    public StalagtitanRenderer(EntityRendererFactory.Context context) {
        super(context, new Stalagtitan<>(context.getPart(ModModelLayers.STALAGTITAN)), 0.4f);
    }

    @Override
    public void render(StalagtitanEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(StalagtitanEntity entity) {
        return TEXTURE;
    }

}
