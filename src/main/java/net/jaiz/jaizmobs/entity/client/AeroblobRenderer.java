package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.AeroblobEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class AeroblobRenderer extends MobEntityRenderer<AeroblobEntity, Aeroblob<AeroblobEntity>> {
    private static final Identifier TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/aeroblob.png");

    public AeroblobRenderer(EntityRendererFactory.Context context) {
        super(context, new Aeroblob<>(context.getPart(ModModelLayers.AEROBLOB)), 0.8f);
        this.addFeature(new AeroblobFeatureRenderer<>(this));
    }

    @Override
    public Identifier getTexture(AeroblobEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(AeroblobEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
