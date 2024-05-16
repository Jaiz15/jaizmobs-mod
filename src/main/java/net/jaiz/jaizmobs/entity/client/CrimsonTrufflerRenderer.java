package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.CrimsonTrufflerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CrimsonTrufflerRenderer extends MobEntityRenderer<CrimsonTrufflerEntity, Crimson_Truffler<CrimsonTrufflerEntity>> {
    private static final Identifier TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/crimson_truffler.png");

    public CrimsonTrufflerRenderer(EntityRendererFactory.Context context) {
        super(context, new Crimson_Truffler<>(context.getPart(ModModelLayers.CRIMSON_TRUFFLER)), 0.25f);
    }

    @Override
    public void render(CrimsonTrufflerEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(CrimsonTrufflerEntity entity) {
        return TEXTURE;
    }

}
