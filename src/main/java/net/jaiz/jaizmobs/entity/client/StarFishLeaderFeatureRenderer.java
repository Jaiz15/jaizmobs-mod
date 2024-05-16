package net.jaiz.jaizmobs.entity.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.StarFishLeaderEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;

@Environment(value = EnvType.CLIENT)
public class StarFishLeaderFeatureRenderer<T extends StarFishLeaderEntity>
        extends EyesFeatureRenderer<T, StarFishLeader<T>> {
    private static final RenderLayer SKIN = RenderLayer.getEyes(new Identifier(JaizMobs.MOD_ID, "textures/entity/star_fish_leader_glow.png"));

    public StarFishLeaderFeatureRenderer(FeatureRendererContext<T, StarFishLeader<T>> featureRendererContext) {
        super(featureRendererContext);
    }



    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}

