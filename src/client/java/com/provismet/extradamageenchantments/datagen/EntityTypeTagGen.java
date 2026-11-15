package com.provismet.extradamageenchantments.datagen;

import com.provismet.extradamageenchantments.utility.tags.EDEEntityTypeTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityTypeIds;

import java.util.concurrent.CompletableFuture;

public class EntityTypeTagGen extends FabricTagsProvider.EntityTypeTagsProvider {
    public EntityTypeTagGen (FabricPackOutput output, CompletableFuture<Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags (Provider arg) {
        this.builder(EDEEntityTypeTags.ARCANE)
            .add(EntityTypeIds.ALLAY)
            .add(EntityTypeIds.BLAZE)
            .add(EntityTypeIds.BREEZE)
            .add(EntityTypeIds.COPPER_GOLEM)
            .add(EntityTypeIds.IRON_GOLEM)
            .add(EntityTypeIds.MAGMA_CUBE)
            .add(EntityTypeIds.SLIME)
            .add(EntityTypeIds.SNOW_GOLEM)
            .add(EntityTypeIds.VEX);
        
        this.builder(EDEEntityTypeTags.BEASTLY)
            .add(EntityTypeIds.BAT)
            .add(EntityTypeIds.CAMEL)
            .add(EntityTypeIds.CAT)
            .add(EntityTypeIds.CHICKEN)
            .add(EntityTypeIds.COW)
            .add(EntityTypeIds.DONKEY)
            .add(EntityTypeIds.FOX)
            .add(EntityTypeIds.GHAST)
            .add(EntityTypeIds.GOAT)
            .add(EntityTypeIds.HOGLIN)
            .add(EntityTypeIds.HORSE)
            .add(EntityTypeIds.LLAMA)
            .add(EntityTypeIds.MULE)
            .add(EntityTypeIds.OCELOT)
            .add(EntityTypeIds.PANDA)
            .add(EntityTypeIds.PARROT)
            .add(EntityTypeIds.PIG)
            .add(EntityTypeIds.POLAR_BEAR)
            .add(EntityTypeIds.RABBIT)
            .add(EntityTypeIds.RAVAGER)
            .add(EntityTypeIds.SHEEP)
            .add(EntityTypeIds.SNIFFER)
            .add(EntityTypeIds.STRIDER)
            .add(EntityTypeIds.TRADER_LLAMA)
            .add(EntityTypeIds.WOLF)
            .add(EntityTypeIds.ARMADILLO);

        this.builder(EDEEntityTypeTags.FUNGIFLORAL)
            .add(EntityTypeIds.CREEPER)
            .add(EntityTypeIds.MOOSHROOM)
            .add(EntityTypeIds.WARDEN);

        this.builder(EDEEntityTypeTags.HUMANOID)
            .add(EntityTypeIds.PIGLIN)
            .add(EntityTypeIds.PIGLIN_BRUTE)
            .add(EntityTypeIds.PLAYER)
            .add(EntityTypeIds.VILLAGER)
            .add(EntityTypeIds.WANDERING_TRADER)
            .add(EntityTypeIds.WITCH);

        this.builder(EDEEntityTypeTags.OUTERWORLDLY)
            .add(EntityTypeIds.ENDERMAN)
            .add(EntityTypeIds.ENDER_DRAGON)
            .add(EntityTypeIds.SHULKER);

        this.builder(EDEEntityTypeTags.SENSITIVE_TO_UNRAVEL)
            .addOptionalTag(EDEEntityTypeTags.ARCANE);

        this.builder(EDEEntityTypeTags.SENSITIVE_TO_BUTCHER)
            .addOptionalTag(EDEEntityTypeTags.BEASTLY);

        this.builder(EDEEntityTypeTags.SENSITIVE_TO_HERBICIDE)
            .addOptionalTag(EDEEntityTypeTags.FUNGIFLORAL);

        this.builder(EDEEntityTypeTags.SENSITIVE_TO_REBEL)
            .addOptionalTag(EDEEntityTypeTags.HUMANOID)
            .addOptionalTag(EntityTypeTags.ILLAGER);

        this.builder(EDEEntityTypeTags.SENSITIVE_TO_VOIDRENDER)
            .addOptionalTag(EDEEntityTypeTags.OUTERWORLDLY);
    }
    
}
