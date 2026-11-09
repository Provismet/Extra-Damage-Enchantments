package com.provismet.datagen.extradamageenchantments;

import com.provismet.extradamageenchantments.registries.EDEEnchantments;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class ExtraDEDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator (FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(EnchantmentGenerator::new);
        pack.addProvider(EntityTypeTagGen::new);
        pack.addProvider(EnchantmentTagGen::new);
        pack.addProvider(LanguageGen::new);
    }

    @Override
    public void buildRegistry (RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.ENCHANTMENT, EDEEnchantments::bootstrap);
    }
}
