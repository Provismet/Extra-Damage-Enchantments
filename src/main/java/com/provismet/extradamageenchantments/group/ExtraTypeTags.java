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

    public static final TagKey<EntityType<?>> SENSITIVE_TO_REBEL = ExtraTypeTags.of("sensitive_to_rebel");
    public static final TagKey<EntityType<?>> SENSITIVE_TO_VOIDRENDER = ExtraTypeTags.of("sensitive_to_voidrender");
    public static final TagKey<EntityType<?>> SENSITIVE_TO_UNRAVEL = ExtraTypeTags.of("sensitive_to_unravel");
    public static final TagKey<EntityType<?>> SENSITIVE_TO_HERBICIDE = ExtraTypeTags.of("sensitive_to_herbicide");
    public static final TagKey<EntityType<?>> SENSITIVE_TO_BUTCHER = ExtraTypeTags.of("sensitive_to_butcher");

    private static TagKey<EntityType<?>> of (String path) {
        return TagKey.of(RegistryKeys.ENTITY_TYPE, ExtraDEMain.identifier(path));
    }
}
