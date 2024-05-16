package net.jaiz.jaizmobs;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.jaiz.jaizmobs.entity.ModEntities;
import net.jaiz.jaizmobs.entity.client.*;
import net.minecraft.client.render.entity.StriderEntityRenderer;

public class JaizMobsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.TOTEM_SPIRIT, TotemSpiritRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.TOTEM_SPIRIT, TotemSpirit::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.DESERT_TOTEM_SPIRIT, DesertTotemSpiritRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.DESERT_TOTEM_SPIRIT, TotemSpirit::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.JUNGLE_TOTEM_SPIRIT, JungleTotemSpiritRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.JUNGLE_TOTEM_SPIRIT, TotemSpirit::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.SPORETRAP, SporeTrapRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SPORETRAP, SporeTrap::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.VOIDBULL, VoidBullRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.VOIDBULL, VoidBull::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.STARFISH, StarFishRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.STARFISH, StarFish::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.STARFISHLEADER, StarFishLeaderRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.STARFISHLEADER, StarFishLeader::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.PINE_GIANT, PineGiantRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PINE_GIANT, PineGiant::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.DRIPLET, DripletRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.DRIPLET, Driplet::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.STALAGTITAN, StalagtitanRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.STALAGTITAN, Stalagtitan::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.SNAIL, SnailRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SNAIL, Snail::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.CALCITE_GOLEM, CalciteGolemRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CALCITE_GOLEM, Calcite_Golem::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.CULTIVATOR, CultivatorRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CULTIVATOR, Cultivator::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.KLEPHTOPOD, KlephtopodRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.KLEPHTOPOD, Klephtopod::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.FROSTED_TOTEM_SPIRIT, FrostedTotemSpiritRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.FROSTED_TOTEM_SPIRIT, FrostedTotemSpirit::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.HUNTER_EEL, HunterEelRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.HUNTER_EEL, HunterEel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.AEROBLOB, AeroblobRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.AEROBLOB, Aeroblob::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.ENDERWING, EnderwingRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.ENDERWING, Enderwing::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.MOLOTOV_GOLEM, MolotovGolemRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.MOLOTOV_GOLEM, MolotovGolem::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.GEYSER_BERRY, GeyserBerryRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.GEYSER_BERRY, GeyserBerry::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.WARPED_TRUFFLER, WarpedTrufflerRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.WARPED_TRUFFLER, Warped_Truffler::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.CRIMSON_TRUFFLER, CrimsonTrufflerRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CRIMSON_TRUFFLER, Crimson_Truffler::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.EMBERBEETLE, EmberBeetleRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.EMBERBEETLE, EmberBeetle::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.SOULWADER, SoulWaderRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SOULWADER, SoulWader::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.STRIDER_HUNTER, StriderHunterRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.STRIDERHUNTER, StriderHunter::getTexturedModelData);

    }
}
