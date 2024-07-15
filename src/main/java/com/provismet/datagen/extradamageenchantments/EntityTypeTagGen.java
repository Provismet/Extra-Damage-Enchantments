package com.provismet.datagen.extradamageenchantments;

import java.util.concurrent.CompletableFuture;

import com.provismet.extradamageenchantments.utility.tags.EDEEntityTypeTags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.EntityTypeTagProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.EntityTypeTags;

public class EntityTypeTagGen extends EntityTypeTagProvider {
    public EntityTypeTagGen (FabricDataOutput output, CompletableFuture<WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure (WrapperLookup arg) {
        getOrCreateTagBuilder(EDEEntityTypeTags.ARCANE)
            .add(EntityType.ALLAY)
            .add(EntityType.BLAZE)
            .add(EntityType.BREEZE)
            .add(EntityType.IRON_GOLEM)
            .add(EntityType.MAGMA_CUBE)
            .add(EntityType.SLIME)
            .add(EntityType.SNOW_GOLEM)
            .add(EntityType.VEX);
        
        getOrCreateTagBuilder(EDEEntityTypeTags.BEASTLY)
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

        getOrCreateTagBuilder(EDEEntityTypeTags.FUNGIFLORAL)
            .add(EntityType.CREEPER)
            .add(EntityType.MOOSHROOM)
            .add(EntityType.WARDEN);

        getOrCreateTagBuilder(EDEEntityTypeTags.HUMANOID)
            .add(EntityType.PIGLIN)
            .add(EntityType.PIGLIN_BRUTE)
            .add(EntityType.PLAYER)
            .add(EntityType.VILLAGER)
            .add(EntityType.WANDERING_TRADER)
            .add(EntityType.WITCH);

        getOrCreateTagBuilder(EDEEntityTypeTags.OUTERWORLDLY)
            .add(EntityType.ENDERMAN)
            .add(EntityType.ENDER_DRAGON)
            .add(EntityType.SHULKER);

        getOrCreateTagBuilder(EDEEntityTypeTags.SENSITIVE_TO_UNRAVEL)
            .addOptionalTag(EDEEntityTypeTags.ARCANE);

        getOrCreateTagBuilder(EDEEntityTypeTags.SENSITIVE_TO_BUTCHER)
            .addOptionalTag(EDEEntityTypeTags.BEASTLY);

        getOrCreateTagBuilder(EDEEntityTypeTags.SENSITIVE_TO_HERBICIDE)
            .addOptionalTag(EDEEntityTypeTags.FUNGIFLORAL);

        getOrCreateTagBuilder(EDEEntityTypeTags.SENSITIVE_TO_REBEL)
            .addOptionalTag(EDEEntityTypeTags.HUMANOID)
            .addOptionalTag(EntityTypeTags.ILLAGER);

        getOrCreateTagBuilder(EDEEntityTypeTags.SENSITIVE_TO_VOIDRENDER)
            .addOptionalTag(EDEEntityTypeTags.OUTERWORLDLY);
    }
    
}
