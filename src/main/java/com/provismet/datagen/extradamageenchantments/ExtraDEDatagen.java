package com.provismet.datagen.extradamageenchantments;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ExtraDEDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator (FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(EntityTypeTagGen::new);
        pack.addProvider(EnchantmentTagGen::new);
        pack.addProvider(LanguageGen::new);
    }
    
}
