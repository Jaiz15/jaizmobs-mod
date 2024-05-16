package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.CultivatorEntity;
import net.jaiz.jaizmobs.entity.custom.StriderHunterEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

public class CultivatorRenderer extends MobEntityRenderer<CultivatorEntity, Cultivator<CultivatorEntity>> {
    private static final Identifier TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/cultivator.png");
    private static final Identifier EPIC_TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/cultivator_epic.png");

    public CultivatorRenderer(EntityRendererFactory.Context context) {
        super(context, new Cultivator<>(context.getPart(ModModelLayers.CULTIVATOR)), 1f);
    }

    @Override
    public Identifier getTexture(CultivatorEntity entity) {
        String string = Formatting.strip(entity.getName().getString());
        if ("Epiccool".equals(string)) {
            return EPIC_TEXTURE;
        }
        return TEXTURE;
    }

    @Override
    public void render(CultivatorEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
