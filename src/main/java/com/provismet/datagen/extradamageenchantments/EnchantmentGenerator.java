package com.provismet.datagen.extradamageenchantments;

import com.provismet.extradamageenchantments.registries.EDEEnchantments;
import com.provismet.lilylib.datagen.provider.LilyEnchantmentProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class EnchantmentGenerator extends LilyEnchantmentProvider {
    public EnchantmentGenerator (FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void generate (RegistryWrapper.WrapperLookup wrapperLookup, EnchantmentBuilder builder) {
        builder.add(EDEEnchantments.REBEL);
        builder.add(EDEEnchantments.BUTCHER);
        builder.add(EDEEnchantments.HERBICIDE);
        builder.add(EDEEnchantments.UNRAVEL);
        builder.add(EDEEnchantments.VOIDRENDER);
    }
}
