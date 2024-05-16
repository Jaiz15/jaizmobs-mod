package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.StriderHunterEntity;
import net.jaiz.jaizmobs.entity.custom.TotemSpiritEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

public class StriderHunterRenderer extends MobEntityRenderer<StriderHunterEntity, StriderHunter<StriderHunterEntity>> {
    private static final Identifier TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/strider_hunter.png");
    private static final Identifier PINK_TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/strider_hunter_pink.png");
    private static final Identifier HAHA_TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/strider_hunter_comedian.png");

    public StriderHunterRenderer(EntityRendererFactory.Context context) {
        super(context, new StriderHunter<>(context.getPart(ModModelLayers.STRIDERHUNTER)), 1.2f);
    }

    @Override
    public Identifier getTexture(StriderHunterEntity entity) {
        String string = Formatting.strip(entity.getName().getString());
        if ("Zuper".equals(string)) {
            return PINK_TEXTURE;
        }
        if ("DeadComedy".equals(string)) {
            return HAHA_TEXTURE;
        }
        return TEXTURE;
    }


    @Override
    public void render(StriderHunterEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
