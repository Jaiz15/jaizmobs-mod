package net.jaiz.jaizmobs;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.jaiz.jaizmobs.block.ModBlocks;
import net.jaiz.jaizmobs.entity.ModEntities;
import net.jaiz.jaizmobs.entity.custom.*;
import net.jaiz.jaizmobs.item.custom.ModItems;
import net.jaiz.jaizmobs.world.gen.ModWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JaizMobs implements ModInitializer {
	public static final String MOD_ID = "jaizmobs";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {


		// Mod Blocks

		ModBlocks.registerModBlocks();

		// Items
		ModItems.registerModItems();

		// Fuel Items
		FuelRegistry.INSTANCE.add(ModItems.SULFURIC_REMNANT, 3200);

		// Mob Registries
		FabricDefaultAttributeRegistry.register(ModEntities.TOTEM_SPIRIT, TotemSpiritEntity.createTotemSpiritAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.DESERT_TOTEM_SPIRIT, TotemSpiritEntity.createTotemSpiritAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.JUNGLE_TOTEM_SPIRIT, TotemSpiritEntity.createTotemSpiritAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SPORETRAP, SporeTrapEntity.createSporeTrapAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.VOIDBULL, VoidBullEntity.createVoidBullAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.STARFISH, StarFishEntity.createStarFishAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.STARFISHLEADER, StarFishEntity.createStarFishAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.PINE_GIANT, PineGiantEntity.createPineGiantAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.DRIPLET, DripletEntity.createDripletAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.STALAGTITAN, StalagtitanEntity.createStalagtitanAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SNAIL, SnailEntity.createSnailAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.CALCITE_GOLEM, CalciteGolemEntity.createCalciteGolemAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.CULTIVATOR, CultivatorEntity.createCultivatorAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.KLEPHTOPOD, KlephtopodEntity.createKlephtopodAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.FROSTED_TOTEM_SPIRIT, FrostedTotemSpiritEntity.createFrostedTotemSpiritAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.HUNTER_EEL, HunterEelEntity.createHunterEelAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.AEROBLOB, AeroblobEntity.createAeroblobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.ENDERWING, EnderwingEntity.createEnderwingAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.MOLOTOV_GOLEM, MolotovGolemEntity.createMoltovGolemAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.GEYSER_BERRY, GeyserBerryEntity.createGeyserBerryAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.WARPED_TRUFFLER, WarpedTrufflerEntity.createWarpedTrufflerAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.CRIMSON_TRUFFLER, CrimsonTrufflerEntity.createCrimsonTrufflerAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.EMBERBEETLE, EmberBeetleEntity.createEmberBeetleAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SOULWADER, SoulWaderEntity.createSoulWaderAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.STRIDER_HUNTER, StriderHunterEntity.createStriderHunterAttributes());

		// World Gen
		ModWorldGen.generateWorldGen();
	}
}