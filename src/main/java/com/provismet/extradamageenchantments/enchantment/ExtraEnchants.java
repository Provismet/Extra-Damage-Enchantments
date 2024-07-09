package com.provismet.extradamageenchantments.enchantment;

import com.provismet.CombatPlusCore.registries.CPCEnchantmentComponentTypes;
import com.provismet.CombatPlusCore.utility.tag.CPCItemTags;
import com.provismet.extradamageenchantments.ExtraDEMain;

import com.provismet.extradamageenchantments.group.ExtraTypeTags;
import com.provismet.lilylib.container.EnchantmentContainer;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.enchantment.effect.entity.ApplyMobEffectEnchantmentEffect;
import net.minecraft.enchantment.effect.value.AddEnchantmentEffect;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.TagKey;

public class ExtraEnchants {
    public static final EnchantmentContainer REBEL = new EnchantmentContainer(
        ExtraDEMain.identifier("rebel"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup) -> createBasicBuilder(itemLookup, enchantmentLookup, ExtraTypeTags.SENSITIVE_TO_REBEL)
    );
    public static final EnchantmentContainer VOIDRENDER = new EnchantmentContainer(
        ExtraDEMain.identifier("voidrender"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup) -> createBasicBuilder(itemLookup, enchantmentLookup, ExtraTypeTags.SENSITIVE_TO_VOIDRENDER)
            .addEffect(
                EnchantmentEffectComponentTypes.POST_ATTACK,
                EnchantmentEffectTarget.ATTACKER,
                EnchantmentEffectTarget.VICTIM,
                new ApplyMobEffectEnchantmentEffect(
                    RegistryEntryList.of(StatusEffects.GLOWING),
                    EnchantmentLevelBasedValue.linear(1),
                    EnchantmentLevelBasedValue.linear(1, 0.5f),
                    EnchantmentLevelBasedValue.constant(0),
                    EnchantmentLevelBasedValue.constant(0)
                ),
                EntityPropertiesLootCondition.builder(
                    LootContext.EntityTarget.THIS,
                    EntityPredicate.Builder.create().type(ExtraTypeTags.SENSITIVE_TO_VOIDRENDER)
                )
            )
    );
    public static final EnchantmentContainer UNRAVEL = new EnchantmentContainer(
        ExtraDEMain.identifier("unravel"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup) -> createBasicBuilder(itemLookup, enchantmentLookup, ExtraTypeTags.SENSITIVE_TO_UNRAVEL)
            .addEffect(
                EnchantmentEffectComponentTypes.POST_ATTACK,
                EnchantmentEffectTarget.ATTACKER,
                EnchantmentEffectTarget.VICTIM,
                new ApplyMobEffectEnchantmentEffect(
                    RegistryEntryList.of(StatusEffects.GLOWING),
                    EnchantmentLevelBasedValue.linear(1),
                    EnchantmentLevelBasedValue.linear(1, 0.5f),
                    EnchantmentLevelBasedValue.constant(0),
                    EnchantmentLevelBasedValue.constant(0)
                ),
                EntityPropertiesLootCondition.builder(
                    LootContext.EntityTarget.THIS,
                    EntityPredicate.Builder.create().type(ExtraTypeTags.SENSITIVE_TO_UNRAVEL)
                )
            )
    );
    public static final EnchantmentContainer HERBICIDE = new EnchantmentContainer(
        ExtraDEMain.identifier("herbicide"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup) -> createBasicBuilder(itemLookup, enchantmentLookup, ExtraTypeTags.SENSITIVE_TO_HERBICIDE)
    );
    public static final EnchantmentContainer BUTCHER = new EnchantmentContainer(
        ExtraDEMain.identifier("butcher"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup) -> createBasicBuilder(itemLookup, enchantmentLookup, ExtraTypeTags.SENSITIVE_TO_BUTCHER)
            .addEffect(
                EnchantmentEffectComponentTypes.POST_ATTACK,
                EnchantmentEffectTarget.ATTACKER,
                EnchantmentEffectTarget.VICTIM,
                new ApplyMobEffectEnchantmentEffect(
                    RegistryEntryList.of(StatusEffects.SLOWNESS),
                    EnchantmentLevelBasedValue.linear(1.5f),
                    EnchantmentLevelBasedValue.linear(1.5f, 0.5f),
                    EnchantmentLevelBasedValue.constant(2),
                    EnchantmentLevelBasedValue.constant(2)
                ),
                EntityPropertiesLootCondition.builder(
                    LootContext.EntityTarget.THIS,
                    EntityPredicate.Builder.create().type(ExtraTypeTags.SENSITIVE_TO_BUTCHER)
                )
            )
    );

    private static RegistryKey<Enchantment> of (String name) {
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, ExtraDEMain.identifier(name));
    }

    public static void bootstrap (Registerable<Enchantment> registerable) {
        register(registerable, REBEL);
        register(registerable, VOIDRENDER);
        register(registerable, UNRAVEL);
        register(registerable, HERBICIDE);
        register(registerable, BUTCHER);
    }

    private static void register (Registerable<Enchantment> registerable, EnchantmentContainer container) {
        registerable.register(container.getKey(), container.getBuilder(registerable).build(container.getKey().getValue()));
    }

    private static Enchantment.Builder createBasicBuilder (RegistryEntryLookup<Item> itemLookup, RegistryEntryLookup<Enchantment> enchantmentLookup, TagKey<EntityType<?>> tag) {
        return Enchantment.builder(
            Enchantment.definition(
                itemLookup.getOrThrow(CPCItemTags.DAMAGE_ENCHANTABLE),
                itemLookup.getOrThrow(CPCItemTags.DAMAGE_PRIMARY_ENCHANTABLE),
                5,
                5,
                Enchantment.leveledCost(5, 8),
                Enchantment.leveledCost(25, 8),
                2,
                AttributeModifierSlot.MAINHAND
            )
        ).exclusiveSet(
            enchantmentLookup.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET)
        ).addEffect(
            CPCEnchantmentComponentTypes.GAMERULE_DAMAGE,
            new AddEnchantmentEffect(EnchantmentLevelBasedValue.linear(2.5f)),
            EntityPropertiesLootCondition.builder(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(tag)
            )
        );
    }
}
