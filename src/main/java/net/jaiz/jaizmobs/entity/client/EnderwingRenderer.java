package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.EnderwingEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class EnderwingRenderer extends MobEntityRenderer<EnderwingEntity, Enderwing<EnderwingEntity>> {
    private static final Identifier TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/enderwing.png");

    public EnderwingRenderer(EntityRendererFactory.Context context) {
        super(context, new Enderwing<>(context.getPart(ModModelLayers.ENDERWING)), 0.7f);
        this.addFeature(new EnderwingFeatureRenderer<>(this));
    }

    @Override
    public Identifier getTexture(EnderwingEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(EnderwingEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
