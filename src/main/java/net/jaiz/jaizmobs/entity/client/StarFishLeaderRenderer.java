package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.CultivatorEntity;
import net.jaiz.jaizmobs.entity.custom.StarFishLeaderEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

public class StarFishLeaderRenderer extends MobEntityRenderer<StarFishLeaderEntity, StarFishLeader<StarFishLeaderEntity>> {
    private static final Identifier TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/star_fish_leader.png");
    private static final Identifier ATLAS_TEXTURE = new Identifier(JaizMobs.MOD_ID, "textures/entity/star_fish_leader_atlas.png");

    public StarFishLeaderRenderer(EntityRendererFactory.Context context) {
        super(context, new StarFishLeader<>(context.getPart(ModModelLayers.STARFISHLEADER)), 0.1f);
        this.addFeature(new StarFishLeaderFeatureRenderer<>(this));
    }

    @Override
    public Identifier getTexture(StarFishLeaderEntity entity) {
        String string = Formatting.strip(entity.getName().getString());
        if ("Atlas".equals(string)) {
            return ATLAS_TEXTURE;
        }
        return TEXTURE;
    }
    @Override
    public void render(StarFishLeaderEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
