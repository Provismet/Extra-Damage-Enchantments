package com.provismet.generated.extradamageenchantments;

import com.provismet.extradamageenchantments.ExtraGameRules;
import com.provismet.extradamageenchantments.enchantment.ExtraEnchants;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.enchantment.Enchantment;

public class LanguageGen extends FabricLanguageProvider {
    protected LanguageGen (FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations (TranslationBuilder translationBuilder) {
        LanguageGen.addEnchantment(translationBuilder, ExtraEnchants.BUTCHER, "Butcher", "Increase damage and inflicts slowness against animals and monsters such as Hoglins and Striders.");
        LanguageGen.addEnchantment(translationBuilder, ExtraEnchants.HERBICIDE, "Herbicide", "Increases damage against floral and fungal mobs such as creepers.");
        LanguageGen.addEnchantment(translationBuilder, ExtraEnchants.REBEL, "Rebel", "Increases damage against humanoid mobs such as Piglins and Villagers.");
        LanguageGen.addEnchantment(translationBuilder, ExtraEnchants.UNRAVEL, "Unravel", "Increases damage and inflicts glow against magic-based mobs such as Blazes and Vexes.");
        LanguageGen.addEnchantment(translationBuilder, ExtraEnchants.VOIDRENDER, "Voidrender", "Increases damage and inflicts glow against void-related mobs such as Endermen and Shulkers.");

        translationBuilder.add(ExtraGameRules.PLAYER_ENCHANTMENT_DAMAGE_MOD.getTranslationKey(), "PvP effectiveness of extra damage enchantments");
        translationBuilder.add(ExtraGameRules.PLAYER_ENCHANTMENT_DAMAGE_MOD.getTranslationKey() + ".description", "Bonus damage from extra damage enchantments (such as Rebel) will be multiplied by this value if the target is a player.");

        translationBuilder.add("wiki.extra_de.link", "Wiki");
    }
    
    private static void addEnchantment (TranslationBuilder translationBuilder, Enchantment enchantment, String name, String description) {
        translationBuilder.add(enchantment, name);
        translationBuilder.add(enchantment.getTranslationKey() + ".desc", description);
    }
}
