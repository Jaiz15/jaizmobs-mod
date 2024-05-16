package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.SporeTrapEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SporeTrapRenderer extends MobEntityRenderer<SporeTrapEntity, SporeTrap<SporeTrapEntity>> {
    private static final Identifier TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/sporetrap.png");

    public SporeTrapRenderer(EntityRendererFactory.Context context) {
        super(context, new SporeTrap<>(context.getPart(ModModelLayers.SPORETRAP)), 0.25f);
    }

    @Override
    public void render(SporeTrapEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(SporeTrapEntity entity) {
        return TEXTURE;
    }

}
