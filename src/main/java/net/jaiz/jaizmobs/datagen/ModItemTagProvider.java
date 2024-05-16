package net.jaiz.jaizmobs.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.jaiz.jaizmobs.item.custom.ModItems;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.VOID_SCALE_MAIL_HELMET, ModItems.VOID_SCALE_MAIL_CHESTPLATE, ModItems.VOID_SCALE_MAIL_LEGGINGS, ModItems.VOID_SCALE_MAIL_BOOTS,
                        ModItems.KLEPHTOPOD_SHELL, ModItems.KLEPHTOPOD_CHESTPLATE, ModItems.HARDENED_SKULL);

    }
}
