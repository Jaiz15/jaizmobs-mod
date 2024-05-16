package net.jaiz.jaizmobs.entity.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.MolotovGolemEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;

@Environment(value = EnvType.CLIENT)
public class MolotovGolemFeatureRenderer<T extends MolotovGolemEntity>
        extends EyesFeatureRenderer<T, MolotovGolem<T>> {
    private static final RenderLayer SKIN = RenderLayer.getEyes(new Identifier(JaizMobs.MOD_ID, "textures/entity/molotov_golem_glow.png"));

    public MolotovGolemFeatureRenderer(FeatureRendererContext<T, MolotovGolem<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}

