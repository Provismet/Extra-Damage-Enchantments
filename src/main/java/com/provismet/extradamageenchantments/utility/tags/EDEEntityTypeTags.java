package com.provismet.extradamageenchantments.utility.tags;

import com.provismet.extradamageenchantments.ExtraDEMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class EDEEntityTypeTags {
    public static final TagKey<EntityType<?>> HUMANOID = EDEEntityTypeTags.of("humanoid");
    public static final TagKey<EntityType<?>> OUTERWORLDLY = EDEEntityTypeTags.of("outerworldly");
    public static final TagKey<EntityType<?>> ARCANE = EDEEntityTypeTags.of("arcane");
    public static final TagKey<EntityType<?>> FUNGIFLORAL = EDEEntityTypeTags.of("fungifloral");
    public static final TagKey<EntityType<?>> BEASTLY = EDEEntityTypeTags.of("beastly");

    public static final TagKey<EntityType<?>> SENSITIVE_TO_REBEL = EDEEntityTypeTags.of("sensitive_to_rebel");
    public static final TagKey<EntityType<?>> SENSITIVE_TO_VOIDRENDER = EDEEntityTypeTags.of("sensitive_to_voidrender");
    public static final TagKey<EntityType<?>> SENSITIVE_TO_UNRAVEL = EDEEntityTypeTags.of("sensitive_to_unravel");
    public static final TagKey<EntityType<?>> SENSITIVE_TO_HERBICIDE = EDEEntityTypeTags.of("sensitive_to_herbicide");
    public static final TagKey<EntityType<?>> SENSITIVE_TO_BUTCHER = EDEEntityTypeTags.of("sensitive_to_butcher");

    private static TagKey<EntityType<?>> of (String path) {
        return TagKey.create(Registries.ENTITY_TYPE, ExtraDEMain.identifier(path));
    }
}
