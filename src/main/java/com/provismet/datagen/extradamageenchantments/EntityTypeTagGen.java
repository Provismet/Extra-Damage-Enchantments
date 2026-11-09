package com.provismet.datagen.extradamageenchantments;

import com.provismet.extradamageenchantments.utility.tags.EDEEntityTypeTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;

import java.util.concurrent.CompletableFuture;

public class EntityTypeTagGen extends FabricTagsProvider.EntityTypeTagsProvider {
    public EntityTypeTagGen (FabricPackOutput output, CompletableFuture<Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags (Provider arg) {
        this.valueLookupBuilder(EDEEntityTypeTags.ARCANE)
            .add(EntityType.ALLAY)
            .add(EntityType.BLAZE)
            .add(EntityType.BREEZE)
            .add(EntityType.COPPER_GOLEM)
            .add(EntityType.IRON_GOLEM)
            .add(EntityType.MAGMA_CUBE)
            .add(EntityType.SLIME)
            .add(EntityType.SNOW_GOLEM)
            .add(EntityType.VEX);
        
        this.valueLookupBuilder(EDEEntityTypeTags.BEASTLY)
            .add(EntityType.BAT)
            .add(EntityType.CAMEL)
            .add(EntityType.CAT)
            .add(EntityType.CHICKEN)
            .add(EntityType.COW)
            .add(EntityType.DONKEY)
            .add(EntityType.FOX)
            .add(EntityType.GHAST)
            .add(EntityType.GOAT)
            .add(EntityType.HOGLIN)
            .add(EntityType.HORSE)
            .add(EntityType.LLAMA)
            .add(EntityType.MULE)
            .add(EntityType.OCELOT)
            .add(EntityType.PANDA)
            .add(EntityType.PARROT)
            .add(EntityType.PIG)
            .add(EntityType.POLAR_BEAR)
            .add(EntityType.RABBIT)
            .add(EntityType.RAVAGER)
            .add(EntityType.SHEEP)
            .add(EntityType.SNIFFER)
            .add(EntityType.STRIDER)
            .add(EntityType.TRADER_LLAMA)
            .add(EntityType.WOLF)
            .add(EntityType.ARMADILLO);

        this.valueLookupBuilder(EDEEntityTypeTags.FUNGIFLORAL)
            .add(EntityType.CREEPER)
            .add(EntityType.MOOSHROOM)
            .add(EntityType.WARDEN);

        this.valueLookupBuilder(EDEEntityTypeTags.HUMANOID)
            .add(EntityType.PIGLIN)
            .add(EntityType.PIGLIN_BRUTE)
            .add(EntityType.PLAYER)
            .add(EntityType.VILLAGER)
            .add(EntityType.WANDERING_TRADER)
            .add(EntityType.WITCH);

        this.valueLookupBuilder(EDEEntityTypeTags.OUTERWORLDLY)
            .add(EntityType.ENDERMAN)
            .add(EntityType.ENDER_DRAGON)
            .add(EntityType.SHULKER);

        this.valueLookupBuilder(EDEEntityTypeTags.SENSITIVE_TO_UNRAVEL)
            .addOptionalTag(EDEEntityTypeTags.ARCANE);

        this.valueLookupBuilder(EDEEntityTypeTags.SENSITIVE_TO_BUTCHER)
            .addOptionalTag(EDEEntityTypeTags.BEASTLY);

        this.valueLookupBuilder(EDEEntityTypeTags.SENSITIVE_TO_HERBICIDE)
            .addOptionalTag(EDEEntityTypeTags.FUNGIFLORAL);

        this.valueLookupBuilder(EDEEntityTypeTags.SENSITIVE_TO_REBEL)
            .addOptionalTag(EDEEntityTypeTags.HUMANOID)
            .addOptionalTag(EntityTypeTags.ILLAGER);

        this.valueLookupBuilder(EDEEntityTypeTags.SENSITIVE_TO_VOIDRENDER)
            .addOptionalTag(EDEEntityTypeTags.OUTERWORLDLY);
    }
    
}
