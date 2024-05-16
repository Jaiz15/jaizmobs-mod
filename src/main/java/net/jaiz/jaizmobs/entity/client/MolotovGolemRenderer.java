package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.MolotovGolemEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class MolotovGolemRenderer extends MobEntityRenderer<MolotovGolemEntity, MolotovGolem<MolotovGolemEntity>> {
    private static final Identifier TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/molotov_golem.png");

    public MolotovGolemRenderer(EntityRendererFactory.Context context) {
        super(context, new MolotovGolem<>(context.getPart(ModModelLayers.MOLOTOV_GOLEM)), 0.5f);
        this.addFeature(new MolotovGolemFeatureRenderer<>(this));
    }

    @Override
    public Identifier getTexture(MolotovGolemEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(MolotovGolemEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
