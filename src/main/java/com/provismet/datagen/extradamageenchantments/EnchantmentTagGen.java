package com.provismet.datagen.extradamageenchantments;

import java.util.concurrent.CompletableFuture;

import com.provismet.extradamageenchantments.registries.EDEEnchantments;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.EnchantmentTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalEnchantmentTags;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.EnchantmentTags;

public class EnchantmentTagGen extends EnchantmentTagProvider {

    public EnchantmentTagGen (FabricDataOutput output, CompletableFuture<WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure (WrapperLookup arg) {
        getOrCreateTagBuilder(ConventionalEnchantmentTags.WEAPON_DAMAGE_ENHANCEMENTS)
            .add(EDEEnchantments.BUTCHER.getKey())
            .add(EDEEnchantments.HERBICIDE.getKey())
            .add(EDEEnchantments.REBEL.getKey())
            .add(EDEEnchantments.UNRAVEL.getKey())
            .add(EDEEnchantments.VOIDRENDER.getKey());

        getOrCreateTagBuilder(EnchantmentTags.DAMAGE_EXCLUSIVE_SET)
            .add(EDEEnchantments.BUTCHER.getKey())
            .add(EDEEnchantments.HERBICIDE.getKey())
            .add(EDEEnchantments.REBEL.getKey())
            .add(EDEEnchantments.UNRAVEL.getKey())
            .add(EDEEnchantments.VOIDRENDER.getKey());
    }
}
