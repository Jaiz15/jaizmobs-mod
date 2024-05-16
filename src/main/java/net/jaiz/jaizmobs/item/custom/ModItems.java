package net.jaiz.jaizmobs.item.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.ModEntities;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(JaizMobs.MOD_ID, name), item);
    }

    // Food

    public static final Item STAR_FISH = registerItem("star_fish", new Item(new FabricItemSettings().food(ModFoodComponents.STAR_FISH)));
    public static final Item STRIDER_HAM = registerItem("strider_ham", new Item(new FabricItemSettings().food(ModFoodComponents.STRIDER_HAM).fireproof()));
    public static final Item COOKED_STAR_FISH = registerItem("cooked_star_fish", new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_STAR_FISH)));
    public static final Item HELIUM_MEMBRANE = registerItem("helium_membrane", new Item(new FabricItemSettings().food(ModFoodComponents.HELIUM_MEMBRANE)));
    public static final Item HUNTER_EEL = registerItem("hunter_eel", new Item(new FabricItemSettings().food(ModFoodComponents.HUNTER_EEL)));
    public static final Item COOKED_HUNTER_EEL = registerItem("cooked_hunter_eel", new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_HUNTER_EEL)));
    public static final Item EEL_ON_A_STICK = registerItem("eel_on_a_stick", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item STARFISH_ON_A_STICK = registerItem("starfish_on_a_stick", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item GEYSER_BERRY = registerItem("geyser_berry", new Item(new FabricItemSettings().food(ModFoodComponents.GEYSER_BERRY)));
    public static final Item COOKED_WARPED_FUNGUS = registerItem("cooked_warped_fungus", new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_WARPED_FUNGUS)));
    public static final Item COOKED_CRIMSON_FUNGUS = registerItem("cooked_crimson_fungus", new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_CRIMSON_FUNGUS)));
    private static void addItemsToFoodGroup(FabricItemGroupEntries entries) {
        entries.add(COOKED_STAR_FISH);
        entries.add(STAR_FISH);
        entries.add(HELIUM_MEMBRANE);
        entries.add(HUNTER_EEL);
        entries.add(COOKED_HUNTER_EEL);
        entries.add(GEYSER_BERRY);
        entries.add(COOKED_WARPED_FUNGUS);
        entries.add(COOKED_CRIMSON_FUNGUS);
        entries.add(STRIDER_HAM);
    }

    // Ingredients

    public static final Item VOID_HUSK = registerItem("void_husk", new Item(new FabricItemSettings()));
    public static final Item TATTERED_WING = registerItem("tattered_wing", new Item(new FabricItemSettings()));
    public static final Item KLEPHTOPOD_SCUTE = registerItem("klephtopod_scute", new Item(new FabricItemSettings()));
    public static final Item DRIPSTONE_SHARD = registerItem("dripstone_shard", new Item(new FabricItemSettings()));
    public static final Item CRACKED_CALCITE_TOTEM = registerItem("cracked_calcite_totem", new Item(new FabricItemSettings().maxCount(16)));
    public static final Item SULFURIC_REMNANT = registerItem("sulfuric_remnant", new Item(new FabricItemSettings()));
    public static final Item HARDENED_BONE_FRAGMENT = registerItem("hardened_bone_fragment", new Item(new FabricItemSettings()));
    public static final Item BASALT_MANDIBLE = registerItem("basalt_mandible", new Item(new FabricItemSettings().fireproof()));
    private static void addItemsToIngredientsGroup(FabricItemGroupEntries entries)
    {
        entries.add(VOID_HUSK);
        entries.add(TATTERED_WING);
        entries.add(KLEPHTOPOD_SCUTE);
        entries.add(DRIPSTONE_SHARD);
        entries.add(BASALT_MANDIBLE);
        entries.add(SULFURIC_REMNANT);
        entries.add(HARDENED_BONE_FRAGMENT);
        entries.add(CRACKED_CALCITE_TOTEM);
    }

    // Armour Items

    public static final Item VOID_SCALE_MAIL_HELMET = registerItem("void_scale_mail_helmet",
            new ModArmourItem(ModArmourMaterials.VOID_SCALE_MAIL, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item VOID_SCALE_MAIL_CHESTPLATE = registerItem("void_scale_mail_chestplate",
            new ModArmourItem(ModArmourMaterials.VOID_SCALE_MAIL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item VOID_SCALE_MAIL_LEGGINGS = registerItem("void_scale_mail_leggings",
            new ModArmourItem(ModArmourMaterials.VOID_SCALE_MAIL, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item VOID_SCALE_MAIL_BOOTS = registerItem("void_scale_mail_boots",
            new ModArmourItem(ModArmourMaterials.VOID_SCALE_MAIL, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item KLEPHTOPOD_SHELL = registerItem("klephtopod_shell",
            new ModArmourItem(ModArmourMaterials.KLEPHTOPOD_SHELL, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item KLEPHTOPOD_CHESTPLATE = registerItem("klephtopod_chestplate",
            new ModArmourItem(ModArmourMaterials.KLEPHTOPOD_SHELL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item HARDENED_SKULL = registerItem("hardened_skull",
            new ModArmourItem(ModArmourMaterials.HARDENED_BONE, ArmorItem.Type.HELMET, new FabricItemSettings()));

    private static void addItemsToCombatGroup(FabricItemGroupEntries entries) {
        entries.add(DRIPSTONE_SHANK);
        entries.add(MANDIBLE_BLADE);
        entries.add(GLOW_TOOL);
        entries.add(EEL_ON_A_STICK);
        entries.add(STARFISH_ON_A_STICK);
        entries.add(CALCITE_TOTEM);
        entries.add(KLEPHTOPOD_SHELL);
        entries.add(KLEPHTOPOD_CHESTPLATE);
        entries.add(HARDENED_SKULL);
        entries.add(VOID_SCALE_MAIL_HELMET);
        entries.add(VOID_SCALE_MAIL_CHESTPLATE);
        entries.add(VOID_SCALE_MAIL_LEGGINGS);
        entries.add(VOID_SCALE_MAIL_BOOTS);


    }

    // Tools + Weapons

    public static final Item DRIPSTONE_SHANK = registerItem("dripstone_shank", new SwordItem(ModToolMaterial.DRIPSTONE, 13, -3.2f, new FabricItemSettings()));
    public static final Item MANDIBLE_BLADE = registerItem("mandible_blade", new SwordItem(ModToolMaterial.STRIDER, 2, -2.5f, new FabricItemSettings().fireproof()));
    public static final Item GLOW_TOOL = registerItem("glow_tool", new GlowTool(new FabricItemSettings()));



    // Spawn Eggs

    public static final Item TOTEM_SPIRIT_SPAWN_EGG = registerItem("totem_spirit_spawn_egg", new SpawnEggItem(ModEntities.TOTEM_SPIRIT, 0xD36D58, 0x905043, new FabricItemSettings()));
    public static final Item DESERT_TOTEM_SPIRIT_SPAWN_EGG = registerItem("desert_totem_spirit_spawn_egg", new SpawnEggItem(ModEntities.DESERT_TOTEM_SPIRIT, 0xFBE7BD, 0xB59A61, new FabricItemSettings()));
    public static final Item JUNGLE_TOTEM_SPIRIT_SPAWN_EGG = registerItem("jungle_totem_spirit_spawn_egg", new SpawnEggItem(ModEntities.JUNGLE_TOTEM_SPIRIT, 0x6E6A67, 0x465D3B, new FabricItemSettings()));
    public static final Item SPORETRAP_SPAWN_EGG = registerItem("sporetrap_spawn_egg", new SpawnEggItem(ModEntities.SPORETRAP, 0x55801C, 0xF1AF19, new FabricItemSettings()));
    public static final Item VOIDBULL_SPAWN_EGG = registerItem("voidbull_spawn_egg", new SpawnEggItem(ModEntities.VOIDBULL, 0xD5CFB3, 0x53375A, new FabricItemSettings()));
    public static final Item STARFISH_SPAWN_EGG = registerItem("starfish_spawn_egg", new SpawnEggItem(ModEntities.STARFISH, 0x523A4D, 0xE142A5, new FabricItemSettings()));
    public static final Item STARFISHLEADER_SPAWN_EGG = registerItem("starfishleader_spawn_egg", new SpawnEggItem(ModEntities.STARFISHLEADER, 0x523A4D, 0xFF98FD, new FabricItemSettings()));
    public static final Item PINE_GIANT_SPAWN_EGG = registerItem("pine_giant_spawn_egg", new SpawnEggItem(ModEntities.PINE_GIANT, 0x594F3E, 0x4E763F, new FabricItemSettings()));
    public static final Item DRIPLET_SPAWN_EGG = registerItem("driplet_spawn_egg", new SpawnEggItem(ModEntities.DRIPLET, 0xCDA977, 0xBF9178, new FabricItemSettings()));
    public static final Item STALAGTITAN_SPAWN_EGG = registerItem("stalagtitan_spawn_egg", new SpawnEggItem(ModEntities.STALAGTITAN, 0xCDA977, 0x946247, new FabricItemSettings()));
    public static final Item SNAIL_SPAWN_EGG = registerItem("snail_spawn_egg", new SpawnEggItem(ModEntities.SNAIL, 0x4F3420, 0xEAE4B0, new FabricItemSettings()));
    public static final Item CALCITE_GOLEM_SPAWN_EGG = registerItem("calcite_golem_spawn_egg", new SpawnEggItem(ModEntities.CALCITE_GOLEM, 0xEEEDE5, 0xAAAAAA, new FabricItemSettings()));
    public static final Item CALCITE_TOTEM = registerItem("calcite_totem", new SpawnEggItem(ModEntities.CALCITE_GOLEM, 0xEEEDE5, 0xAAAAAA, new FabricItemSettings().maxCount(16)));
    public static final Item CULTIVATOR_SPAWN_EGG = registerItem("cultivator_spawn_egg", new SpawnEggItem(ModEntities.CULTIVATOR, 0x8A7D6B, 0xF3D9B6, new FabricItemSettings()));
    public static final Item KLEPHTOPOD_SPAWN_EGG = registerItem("klephtopod_spawn_egg", new SpawnEggItem(ModEntities.KLEPHTOPOD, 0x44465D, 0xAD755C, new FabricItemSettings()));
    public static final Item FROSTED_TOTEM_SPIRIT_SPAWN_EGG = registerItem("frosted_totem_spirit_spawn_egg", new SpawnEggItem(ModEntities.FROSTED_TOTEM_SPIRIT, 0xE3F5F5, 0x95BFC9, new FabricItemSettings()));
    public static final Item HUNTER_EEL_SPAWN_EGG = registerItem("hunter_eel_spawn_egg", new SpawnEggItem(ModEntities.HUNTER_EEL, 0xA2766C, 0xF0CCA8, new FabricItemSettings()));
    public static final Item AEROBLOB_SPAWN_EGG = registerItem("aeroblob_spawn_egg", new SpawnEggItem(ModEntities.AEROBLOB, 0xD296D0, 0xE142B1, new FabricItemSettings()));
    public static final Item ENDERWING_SPAWN_EGG = registerItem("enderwing_spawn_egg", new SpawnEggItem(ModEntities.ENDERWING, 0x3F1944, 0xD6B8B1, new FabricItemSettings()));
    public static final Item MOLOTOV_GOLEM_SPAWN_EGG = registerItem("molotov_golem_spawn_egg", new SpawnEggItem(ModEntities.MOLOTOV_GOLEM, 0x27282A, 0xEA703F, new FabricItemSettings()));
    public static final Item GEYSER_BERRY_SPAWN_EGG = registerItem("geyser_berry_spawn_egg", new SpawnEggItem(ModEntities.GEYSER_BERRY, 0x13C1A6, 0xF3A85D, new FabricItemSettings()));
    public static final Item CRIMSON_TRUFFLER_SPAWN_EGG = registerItem("crimson_truffler_spawn_egg", new SpawnEggItem(ModEntities.CRIMSON_TRUFFLER, 0x95122A, 0xFF7400, new FabricItemSettings()));
    public static final Item WARPED_TRUFFLER_SPAWN_EGG = registerItem("warped_truffler_spawn_egg", new SpawnEggItem(ModEntities.WARPED_TRUFFLER, 0x2CC79D, 0xFF7400, new FabricItemSettings()));
    public static final Item EMBERBEETLE_SPAWN_EGG = registerItem("emberbeetle_spawn_egg", new SpawnEggItem(ModEntities.EMBERBEETLE, 0x280610, 0xF9AE42, new FabricItemSettings()));
    public static final Item SOULWADER_SPAWN_EGG = registerItem("soulwader_spawn_egg", new SpawnEggItem(ModEntities.SOULWADER, 0x211D1A, 0x7AF0D9, new FabricItemSettings()));
    public static final Item STRIDER_HUNTER_SPAWN_EGG = registerItem("strider_hunter_spawn_egg", new SpawnEggItem(ModEntities.STRIDER_HUNTER, 0xAD3C2D, 0x170806, new FabricItemSettings()));



    private static void addItemsToEggItemGroup(FabricItemGroupEntries entries) {
        entries.add(TOTEM_SPIRIT_SPAWN_EGG);
        entries.add(JUNGLE_TOTEM_SPIRIT_SPAWN_EGG);
        entries.add(DESERT_TOTEM_SPIRIT_SPAWN_EGG);
        entries.add(FROSTED_TOTEM_SPIRIT_SPAWN_EGG);
        entries.add(SPORETRAP_SPAWN_EGG);
        entries.add(PINE_GIANT_SPAWN_EGG);
        entries.add(DRIPLET_SPAWN_EGG);
        entries.add(STALAGTITAN_SPAWN_EGG);
        entries.add(CALCITE_GOLEM_SPAWN_EGG);
        entries.add(CULTIVATOR_SPAWN_EGG);
        entries.add(KLEPHTOPOD_SPAWN_EGG);
        entries.add(HUNTER_EEL_SPAWN_EGG);
        entries.add(SNAIL_SPAWN_EGG);
        entries.add(MOLOTOV_GOLEM_SPAWN_EGG);
        entries.add(GEYSER_BERRY_SPAWN_EGG);
        entries.add(CRIMSON_TRUFFLER_SPAWN_EGG);
        entries.add(WARPED_TRUFFLER_SPAWN_EGG);
        entries.add(EMBERBEETLE_SPAWN_EGG);
        entries.add(SOULWADER_SPAWN_EGG);
        entries.add(STRIDER_HUNTER_SPAWN_EGG);
        entries.add(VOIDBULL_SPAWN_EGG);
        entries.add(AEROBLOB_SPAWN_EGG);
        entries.add(ENDERWING_SPAWN_EGG);
        entries.add(STARFISH_SPAWN_EGG);
        entries.add(STARFISHLEADER_SPAWN_EGG);

    }
    // Item group registries

    public static void registerModItems() {
        JaizMobs.LOGGER.info("Registering Mod Items for " + JaizMobs.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(ModItems::addItemsToEggItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatGroup);

    }
}
