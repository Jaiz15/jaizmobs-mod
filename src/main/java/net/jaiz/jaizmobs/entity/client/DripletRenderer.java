package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.DripletEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class DripletRenderer extends MobEntityRenderer<DripletEntity, Driplet<DripletEntity>> {
    private static final Identifier TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/driplet.png");

    public DripletRenderer(EntityRendererFactory.Context context) {
        super(context, new Driplet<>(context.getPart(ModModelLayers.DRIPLET)), 0.2f);
    }

    @Override
    public Identifier getTexture(DripletEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(DripletEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
