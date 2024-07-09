package com.provismet.datagen.extradamageenchantments;

import com.provismet.extradamageenchantments.registries.EDEEnchantments;

import com.provismet.lilylib.container.EnchantmentContainer;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class LanguageGen extends FabricLanguageProvider {
    protected LanguageGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations (RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        LanguageGen.addEnchantment(translationBuilder, EDEEnchantments.BUTCHER, "Butcher", "Increase damage and inflicts slowness against animals and monsters such as Hoglins and Striders.");
        LanguageGen.addEnchantment(translationBuilder, EDEEnchantments.HERBICIDE, "Herbicide", "Increases damage against floral and fungal mobs such as creepers.");
        LanguageGen.addEnchantment(translationBuilder, EDEEnchantments.REBEL, "Rebel", "Increases damage against humanoid mobs such as Piglins and Villagers.");
        LanguageGen.addEnchantment(translationBuilder, EDEEnchantments.UNRAVEL, "Unravel", "Increases damage and inflicts glow against magic-based mobs such as Blazes and Vexes.");
        LanguageGen.addEnchantment(translationBuilder, EDEEnchantments.VOIDRENDER, "Voidrender", "Increases damage and inflicts glow against void-related mobs such as Endermen and Shulkers.");
    }
    
    private static void addEnchantment (TranslationBuilder translationBuilder, EnchantmentContainer enchantment, String name, String description) {
        translationBuilder.add(enchantment.getTranslationKey(), name);
        translationBuilder.add(enchantment.getTranslationKey("desc"), description);
    }
}
