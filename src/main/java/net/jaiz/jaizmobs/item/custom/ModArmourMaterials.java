package net.jaiz.jaizmobs.item.custom;

import net.jaiz.jaizmobs.JaizMobs;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;

public enum ModArmourMaterials implements ArmorMaterial {
    VOID_SCALE_MAIL("void_scale_mail", 40, new int[] {5, 8, 7, 6}, 10,
            SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 3f, 0.3f, () -> Ingredient.ofItems(ModItems.VOID_HUSK)),

    KLEPHTOPOD_SHELL("klephtopod_shell", 18, new int[] {2, 4, 4, 2}, 12,
            SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 1f, 0.0f, () -> Ingredient.ofItems(ModItems.KLEPHTOPOD_SCUTE)),

    HARDENED_BONE("hardened_bone", 12, new int[] {7, 1, 1, 1}, 17,
            SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 1f, 0.0f, () -> Ingredient.ofItems(ModItems.HARDENED_BONE_FRAGMENT))

    ;




    private final String name;
    private final int durabilityMultiplyer;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResisitance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = {11, 16, 15, 13};

    ModArmourMaterials(String name, int durabilityMultiplyer, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResisitance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplyer = durabilityMultiplyer;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResisitance = knockbackResisitance;
        this.repairIngredient = repairIngredient;
    }


    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplyer;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return JaizMobs.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResisitance;
    }
}
