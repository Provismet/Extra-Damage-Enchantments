package com.provismet.datagen.extradamageenchantments;

import java.util.concurrent.CompletableFuture;

import com.provismet.extradamageenchantments.enchantment.ExtraEnchants;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.EnchantmentTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalEnchantmentTags;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;

public class EnchantmentTagGen extends EnchantmentTagProvider {

    public EnchantmentTagGen (FabricDataOutput output, CompletableFuture<WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure (WrapperLookup arg) {
        getOrCreateTagBuilder(ConventionalEnchantmentTags.WEAPON_DAMAGE_ENHANCEMENT)
            .add(ExtraEnchants.BUTCHER)
            .add(ExtraEnchants.HERBICIDE)
            .add(ExtraEnchants.REBEL)
            .add(ExtraEnchants.UNRAVEL)
            .add(ExtraEnchants.VOIDRENDER);
    }
}
