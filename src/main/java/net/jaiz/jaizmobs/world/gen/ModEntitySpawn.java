package net.jaiz.jaizmobs.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.jaiz.jaizmobs.entity.ModEntities;
import net.jaiz.jaizmobs.entity.custom.*;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntitySpawn {
    public static void addEntitySpawn() {

        // Totem Spirit Spawn
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.BADLANDS), SpawnGroup.MONSTER,
                ModEntities.TOTEM_SPIRIT, 40, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SAVANNA), SpawnGroup.MONSTER,
                ModEntities.TOTEM_SPIRIT, 40, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SAVANNA_PLATEAU), SpawnGroup.MONSTER,
                ModEntities.TOTEM_SPIRIT, 40, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.WOODED_BADLANDS), SpawnGroup.MONSTER,
                ModEntities.TOTEM_SPIRIT, 40, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.ERODED_BADLANDS), SpawnGroup.MONSTER,
                ModEntities.TOTEM_SPIRIT, 40, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.WINDSWEPT_SAVANNA), SpawnGroup.MONSTER,
                ModEntities.TOTEM_SPIRIT, 40, 1, 2);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SNOWY_PLAINS), SpawnGroup.MONSTER,
                ModEntities.FROSTED_TOTEM_SPIRIT, 15, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SNOWY_SLOPES), SpawnGroup.MONSTER,
                ModEntities.FROSTED_TOTEM_SPIRIT, 15, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SNOWY_TAIGA), SpawnGroup.MONSTER,
                ModEntities.FROSTED_TOTEM_SPIRIT, 15, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_PEAKS), SpawnGroup.MONSTER,
                ModEntities.FROSTED_TOTEM_SPIRIT, 15, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.JAGGED_PEAKS), SpawnGroup.MONSTER,
                ModEntities.FROSTED_TOTEM_SPIRIT, 15, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.ICE_SPIKES), SpawnGroup.MONSTER,
                ModEntities.FROSTED_TOTEM_SPIRIT, 15, 1, 2);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.JUNGLE), SpawnGroup.MONSTER,
                ModEntities.JUNGLE_TOTEM_SPIRIT, 60, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.BAMBOO_JUNGLE), SpawnGroup.MONSTER,
                ModEntities.JUNGLE_TOTEM_SPIRIT, 60, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SPARSE_JUNGLE), SpawnGroup.MONSTER,
                ModEntities.JUNGLE_TOTEM_SPIRIT, 30, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.TAIGA), SpawnGroup.MONSTER,
                ModEntities.JUNGLE_TOTEM_SPIRIT, 15, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA), SpawnGroup.MONSTER,
                ModEntities.JUNGLE_TOTEM_SPIRIT, 15, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_PINE_TAIGA), SpawnGroup.MONSTER,
                ModEntities.JUNGLE_TOTEM_SPIRIT, 15, 1, 2);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DESERT), SpawnGroup.MONSTER,
                ModEntities.DESERT_TOTEM_SPIRIT, 40, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.BEACH), SpawnGroup.MONSTER,
                ModEntities.DESERT_TOTEM_SPIRIT, 40, 1, 2);


        // Pine Giant Spawn
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_PINE_TAIGA), SpawnGroup.MONSTER,
                ModEntities.PINE_GIANT, 15, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA), SpawnGroup.MONSTER,
                ModEntities.PINE_GIANT, 15, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST), SpawnGroup.MONSTER,
                ModEntities.PINE_GIANT, 15, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.TAIGA), SpawnGroup.MONSTER,
                ModEntities.PINE_GIANT, 15, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.LUSH_CAVES), SpawnGroup.MONSTER,
                ModEntities.PINE_GIANT, 10, 1, 1);


        // Spore Trap Spawn
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.BAMBOO_JUNGLE), SpawnGroup.MONSTER,
                ModEntities.SPORETRAP, 70, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.LUSH_CAVES), SpawnGroup.MONSTER,
                ModEntities.SPORETRAP, 200, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.JUNGLE), SpawnGroup.MONSTER,
                ModEntities.SPORETRAP, 40, 1, 2);

        // Void Bull Spawn

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS), SpawnGroup.MONSTER,
                ModEntities.VOIDBULL, 1, 0, 1);


        // Aeroblob
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.END_BARRENS), SpawnGroup.MONSTER,
                ModEntities.AEROBLOB, 1, 0, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SMALL_END_ISLANDS), SpawnGroup.MONSTER,
                ModEntities.AEROBLOB, 2, 0, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS), SpawnGroup.MONSTER,
                ModEntities.AEROBLOB, 1, 0, 1);

        // StarFishes Spawn

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS), SpawnGroup.MONSTER,
                ModEntities.STARFISH, 5, 2, 8);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS), SpawnGroup.MONSTER,
                ModEntities.STARFISHLEADER, 5, 1, 3);

        // Enderwing / Arch Phantom

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS), SpawnGroup.MONSTER,
                ModEntities.ENDERWING, 1, 0, 1);


        // Dripstone Creatures

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DRIPSTONE_CAVES), SpawnGroup.MONSTER,
                ModEntities.DRIPLET, 220, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DRIPSTONE_CAVES), SpawnGroup.MONSTER,
                ModEntities.STALAGTITAN, 100, 1, 1);

        // Snail

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SWAMP), SpawnGroup.CREATURE,
                ModEntities.SNAIL, 3, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.MANGROVE_SWAMP), SpawnGroup.CREATURE,
                ModEntities.SNAIL, 3, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.LUSH_CAVES), SpawnGroup.CREATURE,
                ModEntities.SNAIL, 3, 1, 2);

        // Calcite Golem

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.STONY_PEAKS), SpawnGroup.CREATURE,
                ModEntities.CALCITE_GOLEM, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.STONY_SHORE), SpawnGroup.CREATURE,
                ModEntities.CALCITE_GOLEM, 1, 1, 1);

        // Cultivator

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.CHERRY_GROVE), SpawnGroup.CREATURE,
                ModEntities.CULTIVATOR, 1, 0, 1);

        // Klephtopod

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_LUKEWARM_OCEAN), SpawnGroup.CREATURE,
                ModEntities.KLEPHTOPOD, 1, 0, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.WARM_OCEAN), SpawnGroup.CREATURE,
                ModEntities.KLEPHTOPOD, 1, 0, 1);

        // Hunter Eel

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_LUKEWARM_OCEAN), SpawnGroup.CREATURE,
                ModEntities.HUNTER_EEL, 2, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.WARM_OCEAN), SpawnGroup.CREATURE,
                ModEntities.HUNTER_EEL, 2, 1, 2);

        // MolotovGolem

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.BASALT_DELTAS), SpawnGroup.MONSTER,
                ModEntities.MOLOTOV_GOLEM, 30, 1, 2);

        // Geyser Berry

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.WARPED_FOREST), SpawnGroup.MONSTER,
                ModEntities.GEYSER_BERRY, 10, 2, 5);

        // Trufflers

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.CRIMSON_FOREST), SpawnGroup.MONSTER,
                ModEntities.CRIMSON_TRUFFLER, 15, 1, 3);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.WARPED_FOREST), SpawnGroup.MONSTER,
                ModEntities.WARPED_TRUFFLER, 15, 1, 3);

        // Ember Beetle

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.WARPED_FOREST), SpawnGroup.MONSTER,
                ModEntities.EMBERBEETLE, 5, 1, 7);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.CRIMSON_FOREST), SpawnGroup.MONSTER,
                ModEntities.EMBERBEETLE, 5, 1, 7);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.NETHER_WASTES), SpawnGroup.MONSTER,
                ModEntities.EMBERBEETLE, 5, 1, 7);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.BASALT_DELTAS), SpawnGroup.MONSTER,
                ModEntities.EMBERBEETLE, 5, 1, 7);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SOUL_SAND_VALLEY), SpawnGroup.MONSTER,
                ModEntities.EMBERBEETLE, 4, 1, 7);

        // Soul Wader

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SOUL_SAND_VALLEY), SpawnGroup.MONSTER,
                ModEntities.SOULWADER, 1, 1, 3);

        // Strider hunter

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.NETHER_WASTES), SpawnGroup.MONSTER,
                ModEntities.STRIDER_HUNTER, 10, 1, 2);

        // Spawn Restrictors

        SpawnRestriction.register(ModEntities.TOTEM_SPIRIT, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(ModEntities.JUNGLE_TOTEM_SPIRIT, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(ModEntities.DESERT_TOTEM_SPIRIT, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(ModEntities.FROSTED_TOTEM_SPIRIT, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(ModEntities.PINE_GIANT, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(ModEntities.SPORETRAP, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SporeTrapEntity::canSpawn);
        SpawnRestriction.register(ModEntities.VOIDBULL, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(ModEntities.AEROBLOB, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AeroblobEntity::canSpawn);
        SpawnRestriction.register(ModEntities.DRIPLET, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(ModEntities.STALAGTITAN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(ModEntities.STARFISH, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, StarFishEntity::canSpawn);
        SpawnRestriction.register(ModEntities.STARFISHLEADER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, StarFishLeaderEntity::canSpawn);
        SpawnRestriction.register(ModEntities.SNAIL, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SnailEntity::canSpawn);
        SpawnRestriction.register(ModEntities.CULTIVATOR, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, CultivatorEntity::canSpawn);
        SpawnRestriction.register(ModEntities.CALCITE_GOLEM, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, CalciteGolemEntity::canSpawn);
        SpawnRestriction.register(ModEntities.KLEPHTOPOD, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, KlephtopodEntity::canSpawn);
        SpawnRestriction.register(ModEntities.HUNTER_EEL, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HunterEelEntity::canSpawn);
        SpawnRestriction.register(ModEntities.ENDERWING, SpawnRestriction.Location.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EnderwingEntity::canSpawn);
        SpawnRestriction.register(ModEntities.MOLOTOV_GOLEM, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MolotovGolemEntity::canSpawn);
        SpawnRestriction.register(ModEntities.GEYSER_BERRY, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, GeyserBerryEntity::canSpawn);
        SpawnRestriction.register(ModEntities.CRIMSON_TRUFFLER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, CrimsonTrufflerEntity::canSpawn);
        SpawnRestriction.register(ModEntities.WARPED_TRUFFLER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WarpedTrufflerEntity::canSpawn);
        SpawnRestriction.register(ModEntities.EMBERBEETLE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EmberBeetleEntity::canSpawn);
        SpawnRestriction.register(ModEntities.SOULWADER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(ModEntities.STRIDER_HUNTER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnIgnoreLightLevel);
    }
}
