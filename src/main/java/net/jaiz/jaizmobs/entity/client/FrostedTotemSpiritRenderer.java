package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.FrostedTotemSpiritEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class FrostedTotemSpiritRenderer extends MobEntityRenderer<FrostedTotemSpiritEntity, FrostedTotemSpirit<FrostedTotemSpiritEntity>> {
    private static final Identifier TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/frosted_totem_spirit.png");

    public FrostedTotemSpiritRenderer(EntityRendererFactory.Context context) {
        super(context, new FrostedTotemSpirit<>(context.getPart(ModModelLayers.FROSTED_TOTEM_SPIRIT)), 0.5f);
    }

    @Override
    public Identifier getTexture(FrostedTotemSpiritEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(FrostedTotemSpiritEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
