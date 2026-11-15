package com.provismet.extradamageenchantments.registries;

import com.provismet.combatplus.api.tag.CombatPlusItemTags;
import com.provismet.combatplus.registries.CombatPlusEnchantmentComponentTypes;
import com.provismet.extradamageenchantments.ExtraDamageEnchantmentsMain;
import com.provismet.extradamageenchantments.utility.tags.EDEEntityTypeTags;
import com.provismet.lilylib.container.EnchantmentContainer;
import net.minecraft.advancements.predicates.entity.EntityPredicate;
import net.minecraft.advancements.predicates.entity.EntityTypePredicate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentTarget;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.AddValue;
import net.minecraft.world.item.enchantment.effects.ApplyMobEffect;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;

public class EDEEnchantments {
    public static final EnchantmentContainer REBEL = new EnchantmentContainer(
        ExtraDamageEnchantmentsMain.identifier("rebel"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup, entityLookup) -> createBasicBuilder(itemLookup, enchantmentLookup, entityLookup, EDEEntityTypeTags.SENSITIVE_TO_REBEL)
    );
    public static final EnchantmentContainer VOIDRENDER = new EnchantmentContainer(
        ExtraDamageEnchantmentsMain.identifier("voidrender"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup, entityLookup) -> createBasicBuilder(itemLookup, enchantmentLookup, entityLookup, EDEEntityTypeTags.SENSITIVE_TO_VOIDRENDER)
            .withEffect(
                EnchantmentEffectComponents.POST_ATTACK,
                EnchantmentTarget.ATTACKER,
                EnchantmentTarget.VICTIM,
                new ApplyMobEffect(
                    HolderSet.direct(MobEffects.GLOWING),
                    LevelBasedValue.perLevel(1),
                    LevelBasedValue.perLevel(1, 0.5f),
                    LevelBasedValue.constant(0),
                    LevelBasedValue.constant(0)
                ),
                LootItemEntityPropertyCondition.hasProperties(
                    LootContext.EntityTarget.THIS,
                    EntityPredicate.Builder.entity().entityType(EntityTypePredicate.of(entityLookup, EDEEntityTypeTags.SENSITIVE_TO_VOIDRENDER))
                )
            )
    );
    public static final EnchantmentContainer UNRAVEL = new EnchantmentContainer(
        ExtraDamageEnchantmentsMain.identifier("unravel"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup, entityLookup) -> createBasicBuilder(itemLookup, enchantmentLookup, entityLookup, EDEEntityTypeTags.SENSITIVE_TO_UNRAVEL)
            .withEffect(
                EnchantmentEffectComponents.POST_ATTACK,
                EnchantmentTarget.ATTACKER,
                EnchantmentTarget.VICTIM,
                new ApplyMobEffect(
                    HolderSet.direct(MobEffects.GLOWING),
                    LevelBasedValue.perLevel(1),
                    LevelBasedValue.perLevel(1, 0.5f),
                    LevelBasedValue.constant(0),
                    LevelBasedValue.constant(0)
                ),
                LootItemEntityPropertyCondition.hasProperties(
                    LootContext.EntityTarget.THIS,
                    EntityPredicate.Builder.entity().entityType(EntityTypePredicate.of(entityLookup, EDEEntityTypeTags.SENSITIVE_TO_UNRAVEL))
                )
            )
    );
    public static final EnchantmentContainer HERBICIDE = new EnchantmentContainer(
        ExtraDamageEnchantmentsMain.identifier("herbicide"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup, entityLookup) -> createBasicBuilder(itemLookup, enchantmentLookup, entityLookup, EDEEntityTypeTags.SENSITIVE_TO_HERBICIDE)
    );
    public static final EnchantmentContainer BUTCHER = new EnchantmentContainer(
        ExtraDamageEnchantmentsMain.identifier("butcher"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup, entityLookup) -> createBasicBuilder(itemLookup, enchantmentLookup, entityLookup, EDEEntityTypeTags.SENSITIVE_TO_BUTCHER)
            .withEffect(
                EnchantmentEffectComponents.POST_ATTACK,
                EnchantmentTarget.ATTACKER,
                EnchantmentTarget.VICTIM,
                new ApplyMobEffect(
                    HolderSet.direct(MobEffects.SLOWNESS),
                    LevelBasedValue.perLevel(1.5f),
                    LevelBasedValue.perLevel(1.5f, 0.5f),
                    LevelBasedValue.constant(2),
                    LevelBasedValue.constant(2)
                ),
                LootItemEntityPropertyCondition.hasProperties(
                    LootContext.EntityTarget.THIS,
                    EntityPredicate.Builder.entity().entityType(EntityTypePredicate.of(entityLookup, EDEEntityTypeTags.SENSITIVE_TO_BUTCHER))
                )
            )
    );

    public static void bootstrap (BootstrapContext<Enchantment> registerable) {
        register(registerable, REBEL);
        register(registerable, VOIDRENDER);
        register(registerable, UNRAVEL);
        register(registerable, HERBICIDE);
        register(registerable, BUTCHER);
    }

    private static void register (BootstrapContext<Enchantment> registerable, EnchantmentContainer container) {
        registerable.register(container.getKey(), container.getBuilder(registerable).build(container.getKey().identifier()));
    }

    private static Enchantment.Builder createBasicBuilder (HolderGetter<Item> itemLookup, HolderGetter<Enchantment> enchantmentLookup, HolderGetter<EntityType<?>> entityLookup, TagKey<EntityType<?>> tag) {
        return Enchantment.enchantment(
            Enchantment.definition(
                itemLookup.getOrThrow(CombatPlusItemTags.DAMAGE_ENCHANTABLE),
                itemLookup.getOrThrow(CombatPlusItemTags.DAMAGE_PRIMARY_ENCHANTABLE),
                5,
                5,
                Enchantment.dynamicCost(5, 8),
                Enchantment.dynamicCost(25, 8),
                2,
                EquipmentSlotGroup.MAINHAND
            )
        ).exclusiveWith(
            enchantmentLookup.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE)
        ).withEffect(
            CombatPlusEnchantmentComponentTypes.GAMERULE_DAMAGE,
            new AddValue(LevelBasedValue.perLevel(2.5f)),
            LootItemEntityPropertyCondition.hasProperties(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.entity().entityType(EntityTypePredicate.of(entityLookup, tag))
            )
        );
    }
}
