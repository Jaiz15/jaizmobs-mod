package net.jaiz.jaizmobs.item.custom;


import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent STAR_FISH = new FoodComponent.Builder().hunger(4).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 50), 0.1f).build();

    public static final FoodComponent COOKED_STAR_FISH = new FoodComponent.Builder().hunger(6).saturationModifier(0.3f).build();

    public static final FoodComponent HELIUM_MEMBRANE = new FoodComponent.Builder().hunger(1).saturationModifier(0.05f).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 200), 1f).build();

    public static final FoodComponent HUNTER_EEL = new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 10), 0.1f).build();

    public static final FoodComponent COOKED_HUNTER_EEL = new FoodComponent.Builder().hunger(7).saturationModifier(0.2f).build();

    public static final FoodComponent GEYSER_BERRY = new FoodComponent.Builder().hunger(8).saturationModifier(0.4f).build();

    public static final FoodComponent COOKED_WARPED_FUNGUS = new FoodComponent.Builder().hunger(5).saturationModifier(0.3f).build();

    public static final FoodComponent COOKED_CRIMSON_FUNGUS = new FoodComponent.Builder().hunger(5).saturationModifier(0.3f).build();

    public static final FoodComponent STRIDER_HAM = new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 60), 0.1f).build();
}
