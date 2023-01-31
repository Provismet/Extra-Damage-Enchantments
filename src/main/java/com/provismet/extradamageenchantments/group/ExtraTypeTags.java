package com.provismet.extradamageenchantments.group;

import com.provismet.extradamageenchantments.ExtraDEMain;

import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ExtraTypeTags {
    public static final TagKey<EntityType<?>> HUMANOID = ExtraTypeTags.of("humanoid");
    public static final TagKey<EntityType<?>> OUTERWORLDLY = ExtraTypeTags.of("outerworldly");
    public static final TagKey<EntityType<?>> ARCANE = ExtraTypeTags.of("arcane");
    public static final TagKey<EntityType<?>> FUNGIFLORAL = ExtraTypeTags.of("fungifloral");
    public static final TagKey<EntityType<?>> BEASTLY = ExtraTypeTags.of("beastly");

    public static final TagKey<EntityType<?>> UNDEAD = ExtraTypeTags.of("undead");
    public static final TagKey<EntityType<?>> ARTHROPOD = ExtraTypeTags.of("arthropod");
    public static final TagKey<EntityType<?>> ILLAGER = ExtraTypeTags.of("illager");
    public static final TagKey<EntityType<?>> AQUATIC = ExtraTypeTags.of("aquatic");

    private static TagKey<EntityType<?>> of (String path) {
        return TagKey.of(RegistryKeys.ENTITY_TYPE, ExtraDEMain.identifier(path));
    }
}
