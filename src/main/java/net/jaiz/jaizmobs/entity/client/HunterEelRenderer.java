package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.HunterEelEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class HunterEelRenderer extends MobEntityRenderer<HunterEelEntity, HunterEel<HunterEelEntity>> {
    private static final Identifier TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/hunter_eel.png");

    public HunterEelRenderer(EntityRendererFactory.Context context) {
        super(context, new HunterEel<>(context.getPart(ModModelLayers.HUNTER_EEL)), 0.0f);
    }

    @Override
    public Identifier getTexture(HunterEelEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(HunterEelEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
