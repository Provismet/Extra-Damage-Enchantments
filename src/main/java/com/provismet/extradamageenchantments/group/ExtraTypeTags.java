package com.provismet.extradamageenchantments.group;

import com.provismet.extradamageenchantments.ExtraDEMain;

import net.minecraft.entity.EntityType;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

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
        return TagKey.of(Registry.ENTITY_TYPE_KEY, ExtraDEMain.identifier(path));
    }
}
