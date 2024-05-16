package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.KlephtopodEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class KlephtopodRenderer extends MobEntityRenderer<KlephtopodEntity, Klephtopod<KlephtopodEntity>> {
    private static final Identifier TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/klephtopod.png");

    public KlephtopodRenderer(EntityRendererFactory.Context context) {
        super(context, new Klephtopod<>(context.getPart(ModModelLayers.KLEPHTOPOD)), 0.8f);
    }

    @Override
    public Identifier getTexture(KlephtopodEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(KlephtopodEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
