package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.WarpedTrufflerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class WarpedTrufflerRenderer extends MobEntityRenderer<WarpedTrufflerEntity, Warped_Truffler<WarpedTrufflerEntity>> {
    private static final Identifier TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/warped_truffler.png");

    public WarpedTrufflerRenderer(EntityRendererFactory.Context context) {
        super(context, new Warped_Truffler<>(context.getPart(ModModelLayers.WARPED_TRUFFLER)), 0.25f);
    }

    @Override
    public void render(WarpedTrufflerEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(WarpedTrufflerEntity entity) {
        return TEXTURE;
    }

}
