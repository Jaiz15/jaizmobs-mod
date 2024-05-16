package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.StarFishEntity;
import net.jaiz.jaizmobs.entity.custom.StarFishLeaderEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

public class StarFishRenderer extends MobEntityRenderer<StarFishEntity, StarFish<StarFishEntity>> {
    private static final Identifier TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/star_fish.png");
    private static final Identifier ATLAS_TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/star_fish_atlas.png");

    public StarFishRenderer(EntityRendererFactory.Context context) {
        super(context, new StarFish<>(context.getPart(ModModelLayers.STARFISH)), 0.1f);
        this.addFeature(new StarFishFeatureRenderer(this));
    }

    @Override
    public Identifier getTexture(StarFishEntity entity) {
        String string = Formatting.strip(entity.getName().getString());
        if ("Atlas".equals(string)) {
            return ATLAS_TEXTURE;
        }
        return TEXTURE;
    }
    @Override
    public void render(StarFishEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
