package com.provismet.datagen.extradamageenchantments;

import com.provismet.extradamageenchantments.enchantment.ExtraEnchants;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Util;

import java.util.concurrent.CompletableFuture;

public class LanguageGen extends FabricLanguageProvider {
    protected LanguageGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations (RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        LanguageGen.addEnchantment(translationBuilder, ExtraEnchants.BUTCHER, "Butcher", "Increase damage and inflicts slowness against animals and monsters such as Hoglins and Striders.");
        LanguageGen.addEnchantment(translationBuilder, ExtraEnchants.HERBICIDE, "Herbicide", "Increases damage against floral and fungal mobs such as creepers.");
        LanguageGen.addEnchantment(translationBuilder, ExtraEnchants.REBEL, "Rebel", "Increases damage against humanoid mobs such as Piglins and Villagers.");
        LanguageGen.addEnchantment(translationBuilder, ExtraEnchants.UNRAVEL, "Unravel", "Increases damage and inflicts glow against magic-based mobs such as Blazes and Vexes.");
        LanguageGen.addEnchantment(translationBuilder, ExtraEnchants.VOIDRENDER, "Voidrender", "Increases damage and inflicts glow against void-related mobs such as Endermen and Shulkers.");
    }
    
    private static void addEnchantment (TranslationBuilder translationBuilder, RegistryKey<Enchantment> enchantment, String name, String description) {
        translationBuilder.addEnchantment(enchantment, name);
        translationBuilder.add(Util.createTranslationKey("enchantment", enchantment.getValue()) + ".desc", description);
    }
}
