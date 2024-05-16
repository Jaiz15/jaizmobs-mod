package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.GeyserBerryEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class GeyserBerryRenderer extends MobEntityRenderer<GeyserBerryEntity, GeyserBerry<GeyserBerryEntity>> {
    private static final Identifier TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/geyser_berry.png");

    public GeyserBerryRenderer(EntityRendererFactory.Context context) {
        super(context, new GeyserBerry<>(context.getPart(ModModelLayers.GEYSER_BERRY)), 0.3f);
    }

    @Override
    public Identifier getTexture(GeyserBerryEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(GeyserBerryEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
