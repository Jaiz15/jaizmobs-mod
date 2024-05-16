package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.EmberBeetleEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class EmberBeetleRenderer extends MobEntityRenderer<EmberBeetleEntity, EmberBeetle<EmberBeetleEntity>> {
    private static final Identifier TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/emberbeetle.png");

    public EmberBeetleRenderer(EntityRendererFactory.Context context) {
        super(context, new EmberBeetle<>(context.getPart(ModModelLayers.EMBERBEETLE)), 0.1f);
        this.addFeature(new EmberBeetleFeatureRenderer<>(this));
    }

    @Override
    public Identifier getTexture(EmberBeetleEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(EmberBeetleEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
