package net.jaiz.jaizmobs.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.*;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<TotemSpiritEntity> TOTEM_SPIRIT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JaizMobs.MOD_ID, "totem_spirit"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, TotemSpiritEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.0f)).build());

    public static final EntityType<TotemSpiritEntity> DESERT_TOTEM_SPIRIT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JaizMobs.MOD_ID, "desert_totem_spirit"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, TotemSpiritEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.0f)).build());

    public static final EntityType<TotemSpiritEntity> JUNGLE_TOTEM_SPIRIT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JaizMobs.MOD_ID, "jungle_totem_spirit"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, TotemSpiritEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.0f)).build());

    public static final EntityType<FrostedTotemSpiritEntity> FROSTED_TOTEM_SPIRIT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JaizMobs.MOD_ID, "frosted_totem_spirit"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FrostedTotemSpiritEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.0f)).build());

    public static final EntityType<SporeTrapEntity> SPORETRAP = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JaizMobs.MOD_ID, "sporetrap"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SporeTrapEntity::new).dimensions(EntityDimensions.fixed(0.4f, 0.8f)).build());

    public static final EntityType<VoidBullEntity> VOIDBULL = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JaizMobs.MOD_ID, "voidbull"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, VoidBullEntity::new).dimensions(EntityDimensions.fixed(1.5f, 1.6f)).build());

    public static final EntityType<StarFishEntity> STARFISH = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JaizMobs.MOD_ID, "starfish"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, StarFishEntity::new).dimensions(EntityDimensions.fixed(.6f, .6f)).build());

    public static final EntityType<StarFishLeaderEntity> STARFISHLEADER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JaizMobs.MOD_ID, "starfishleader"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, StarFishLeaderEntity::new).dimensions(EntityDimensions.fixed(.7f, .7f)).build());

    public static final EntityType<PineGiantEntity> PINE_GIANT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JaizMobs.MOD_ID, "pine_giant"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, PineGiantEntity::new).dimensions(EntityDimensions.fixed(.9f, 4.0f)).build());

    public static final EntityType<DripletEntity> DRIPLET = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JaizMobs.MOD_ID, "driplet"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, DripletEntity::new).dimensions(EntityDimensions.fixed(.5f, 0.8f)).build());

    public static final EntityType<StalagtitanEntity> STALAGTITAN = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JaizMobs.MOD_ID, "stalagtitan"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, StalagtitanEntity::new).dimensions(EntityDimensions.fixed(.8f, 3.3f)).build());

    public static final EntityType<SnailEntity> SNAIL = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JaizMobs.MOD_ID, "snail"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SnailEntity::new).dimensions(EntityDimensions.fixed(.4f, .4f)).build());

    public static final EntityType<CalciteGolemEntity> CALCITE_GOLEM = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JaizMobs.MOD_ID, "calcite_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CalciteGolemEntity::new).dimensions(EntityDimensions.fixed(.6f, 1f)).build());

    public static final EntityType<CultivatorEntity> CULTIVATOR = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JaizMobs.MOD_ID, "cultivator"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CultivatorEntity::new).dimensions(EntityDimensions.fixed(1.6f, 1.5f)).build());

    public static final EntityType<KlephtopodEntity> KLEPHTOPOD = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JaizMobs.MOD_ID, "klephtopod"),
            FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, KlephtopodEntity::new).dimensions(EntityDimensions.fixed(1f, .7f)).build());

    public static final EntityType<HunterEelEntity> HUNTER_EEL = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JaizMobs.MOD_ID, "hunter_eel"),
            FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, HunterEelEntity::new).dimensions(EntityDimensions.fixed(.8f, .5f)).build());

    public static final EntityType<AeroblobEntity> AEROBLOB = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JaizMobs.MOD_ID, "aeroblob"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, AeroblobEntity::new).dimensions(EntityDimensions.fixed(1.7f, 1.8f)).build());

    public static final EntityType<EnderwingEntity> ENDERWING = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JaizMobs.MOD_ID, "enderwing"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, EnderwingEntity::new).dimensions(EntityDimensions.fixed(1.5f, 0.6f)).build());

    public static final EntityType<MolotovGolemEntity> MOLOTOV_GOLEM = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JaizMobs.MOD_ID, "molotov_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MolotovGolemEntity::new).dimensions(EntityDimensions.fixed(.9f, 1.7f)).build());

    public static final EntityType<GeyserBerryEntity> GEYSER_BERRY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JaizMobs.MOD_ID, "geyser_berry"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, GeyserBerryEntity::new).dimensions(EntityDimensions.fixed(.5f, .5f)).build());

    public static final EntityType<WarpedTrufflerEntity> WARPED_TRUFFLER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JaizMobs.MOD_ID, "warped_truffler"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, WarpedTrufflerEntity::new).dimensions(EntityDimensions.fixed(.6f, .9f)).build());

    public static final EntityType<CrimsonTrufflerEntity> CRIMSON_TRUFFLER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JaizMobs.MOD_ID, "crimson_truffler"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CrimsonTrufflerEntity::new).dimensions(EntityDimensions.fixed(.6f, .7f)).build());

    public static final EntityType<EmberBeetleEntity> EMBERBEETLE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JaizMobs.MOD_ID, "ember_beetle"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, EmberBeetleEntity::new).dimensions(EntityDimensions.fixed(.6f, .6f)).build());

    public static final EntityType<SoulWaderEntity> SOULWADER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JaizMobs.MOD_ID, "soulwader"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SoulWaderEntity::new).dimensions(EntityDimensions.fixed(1.5f, 7.0f)).build());

    public static final EntityType<StriderHunterEntity> STRIDER_HUNTER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JaizMobs.MOD_ID, "strider_hunter"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, StriderHunterEntity::new).dimensions(EntityDimensions.fixed(1.8f, 1.6f)).build());

}
