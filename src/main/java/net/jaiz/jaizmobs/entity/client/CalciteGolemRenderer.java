package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.CalciteGolemEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CalciteGolemRenderer extends MobEntityRenderer<CalciteGolemEntity, Calcite_Golem<CalciteGolemEntity>> {
    private static final Identifier TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/calcite_golem.png");

    public CalciteGolemRenderer(EntityRendererFactory.Context context) {
        super(context, new Calcite_Golem<>(context.getPart(ModModelLayers.CALCITE_GOLEM)), 0.3f);
    }

    @Override
    public Identifier getTexture(CalciteGolemEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(CalciteGolemEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
