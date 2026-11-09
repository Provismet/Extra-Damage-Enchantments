package com.provismet.extradamageenchantments.datagen;

import com.provismet.extradamageenchantments.registries.EDEEnchantments;
import com.provismet.lilylib.datagen.provider.LilyLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class LanguageGen extends LilyLanguageProvider {
    protected LanguageGen(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations (HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        addEnchantment(translationBuilder, EDEEnchantments.BUTCHER, "Butcher", "Increase damage and inflicts slowness against animals and monsters such as Hoglins and Striders.");
        addEnchantment(translationBuilder, EDEEnchantments.HERBICIDE, "Herbicide", "Increases damage against floral and fungal mobs such as creepers.");
        addEnchantment(translationBuilder, EDEEnchantments.REBEL, "Rebel", "Increases damage against humanoid mobs such as Piglins and Villagers.");
        addEnchantment(translationBuilder, EDEEnchantments.UNRAVEL, "Unravel", "Increases damage and inflicts glow against magic-based mobs such as Blazes and Vexes.");
        addEnchantment(translationBuilder, EDEEnchantments.VOIDRENDER, "Voidrender", "Increases damage and inflicts glow against void-related mobs such as Endermen and Shulkers.");
    }
}
