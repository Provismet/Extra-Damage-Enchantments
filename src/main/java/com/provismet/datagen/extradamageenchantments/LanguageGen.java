package com.provismet.datagen.extradamageenchantments;

import com.provismet.extradamageenchantments.registries.EDEEnchantments;

import com.provismet.lilylib.datagen.provider.LilyLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class LanguageGen extends LilyLanguageProvider {
    protected LanguageGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations (RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        addEnchantment(translationBuilder, EDEEnchantments.BUTCHER, "Butcher", "Increase damage and inflicts slowness against animals and monsters such as Hoglins and Striders.");
        addEnchantment(translationBuilder, EDEEnchantments.HERBICIDE, "Herbicide", "Increases damage against floral and fungal mobs such as creepers.");
        addEnchantment(translationBuilder, EDEEnchantments.REBEL, "Rebel", "Increases damage against humanoid mobs such as Piglins and Villagers.");
        addEnchantment(translationBuilder, EDEEnchantments.UNRAVEL, "Unravel", "Increases damage and inflicts glow against magic-based mobs such as Blazes and Vexes.");
        addEnchantment(translationBuilder, EDEEnchantments.VOIDRENDER, "Voidrender", "Increases damage and inflicts glow against void-related mobs such as Endermen and Shulkers.");
    }
}
