package com.provismet.datagen.extradamageenchantments;

import com.provismet.extradamageenchantments.registries.EDEEnchantments;
import com.provismet.lilylib.datagen.tag.LilyTagProviders;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalEnchantmentTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.tags.EnchantmentTags;

import java.util.concurrent.CompletableFuture;

public class EnchantmentTagGen extends LilyTagProviders.LilyEnchantmentTagProvider {
    public EnchantmentTagGen (FabricPackOutput output, CompletableFuture<Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags (HolderLookup.Provider wrapperLookup) {
        this.builder(ConventionalEnchantmentTags.WEAPON_DAMAGE_ENHANCEMENTS)
            .add(EDEEnchantments.BUTCHER.getKey())
            .add(EDEEnchantments.HERBICIDE.getKey())
            .add(EDEEnchantments.REBEL.getKey())
            .add(EDEEnchantments.UNRAVEL.getKey())
            .add(EDEEnchantments.VOIDRENDER.getKey());

        this.builder(EnchantmentTags.DAMAGE_EXCLUSIVE)
            .add(EDEEnchantments.BUTCHER.getKey())
            .add(EDEEnchantments.HERBICIDE.getKey())
            .add(EDEEnchantments.REBEL.getKey())
            .add(EDEEnchantments.UNRAVEL.getKey())
            .add(EDEEnchantments.VOIDRENDER.getKey());

        this.builder(EnchantmentTags.NON_TREASURE)
            .add(EDEEnchantments.BUTCHER.getKey())
            .add(EDEEnchantments.HERBICIDE.getKey())
            .add(EDEEnchantments.REBEL.getKey())
            .add(EDEEnchantments.UNRAVEL.getKey())
            .add(EDEEnchantments.VOIDRENDER.getKey());

        this.builder(EnchantmentTags.IN_ENCHANTING_TABLE)
            .add(EDEEnchantments.BUTCHER.getKey())
            .add(EDEEnchantments.HERBICIDE.getKey())
            .add(EDEEnchantments.REBEL.getKey())
            .add(EDEEnchantments.UNRAVEL.getKey())
            .add(EDEEnchantments.VOIDRENDER.getKey());

        this.builder(EnchantmentTags.TRADEABLE)
            .add(EDEEnchantments.BUTCHER.getKey())
            .add(EDEEnchantments.HERBICIDE.getKey())
            .add(EDEEnchantments.REBEL.getKey())
            .add(EDEEnchantments.UNRAVEL.getKey())
            .add(EDEEnchantments.VOIDRENDER.getKey());

        this.builder(EnchantmentTags.ON_RANDOM_LOOT)
            .add(EDEEnchantments.BUTCHER.getKey())
            .add(EDEEnchantments.HERBICIDE.getKey())
            .add(EDEEnchantments.REBEL.getKey())
            .add(EDEEnchantments.UNRAVEL.getKey())
            .add(EDEEnchantments.VOIDRENDER.getKey());

        this.builder(EnchantmentTags.ON_TRADED_EQUIPMENT)
            .add(EDEEnchantments.BUTCHER.getKey())
            .add(EDEEnchantments.HERBICIDE.getKey())
            .add(EDEEnchantments.REBEL.getKey())
            .add(EDEEnchantments.UNRAVEL.getKey())
            .add(EDEEnchantments.VOIDRENDER.getKey());
    }
}
