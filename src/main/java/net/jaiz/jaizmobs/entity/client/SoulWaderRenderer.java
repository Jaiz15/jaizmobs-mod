package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.SoulWaderEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SoulWaderRenderer extends MobEntityRenderer<SoulWaderEntity, SoulWader<SoulWaderEntity>> {
    private static final Identifier TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/soulwader.png");

    public SoulWaderRenderer(EntityRendererFactory.Context context) {
        super(context, new SoulWader<>(context.getPart(ModModelLayers.SOULWADER)), 1.2f);
        this.addFeature(new SoulWaderFeatureRenderer<>(this));
    }

    @Override
    public Identifier getTexture(SoulWaderEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(SoulWaderEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
