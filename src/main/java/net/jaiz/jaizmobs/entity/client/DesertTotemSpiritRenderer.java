package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.TotemSpiritEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class DesertTotemSpiritRenderer extends MobEntityRenderer<TotemSpiritEntity, TotemSpirit<TotemSpiritEntity>> {
    private static final Identifier TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/desert_totem_spirit.png");

    public DesertTotemSpiritRenderer(EntityRendererFactory.Context context) {
        super(context, new TotemSpirit<>(context.getPart(ModModelLayers.DESERT_TOTEM_SPIRIT)), 0.5f);
    }

    @Override
    public Identifier getTexture(TotemSpiritEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(TotemSpiritEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
