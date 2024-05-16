package net.jaiz.jaizmobs.entity.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.AeroblobEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;

@Environment(value = EnvType.CLIENT)
public class AeroblobFeatureRenderer<T extends AeroblobEntity>
        extends EyesFeatureRenderer<T, Aeroblob<T>> {
    private static final RenderLayer SKIN = RenderLayer.getEyes(new Identifier(JaizMobs.MOD_ID, "textures/entity/aeroblob_glow.png"));

    public AeroblobFeatureRenderer(FeatureRendererContext<T, Aeroblob<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}

