package com.provismet.datagen.extradamageenchantments;

import com.provismet.CombatPlusCore.utility.tag.CPCItemTags;
import com.provismet.datagen.CombatPlusCore.provider.CPCEnchantmentProvider;
import com.provismet.extradamageenchantments.enchantment.ExtraEnchants;
import com.provismet.extradamageenchantments.group.ExtraTypeTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.enchantment.effect.entity.ApplyMobEffectEnchantmentEffect;
import net.minecraft.enchantment.effect.value.AddEnchantmentEffect;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

public class EnchantmentGenerator extends CPCEnchantmentProvider {
    public EnchantmentGenerator (FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup, Entries entries, EnchantmentBuilder builder) {
        builder.add(
            ExtraEnchants.REBEL.getValue(),
            createInitialBuilder(builder, ExtraTypeTags.SENSITIVE_TO_REBEL)
        );

        builder.add(
            ExtraEnchants.BUTCHER.getValue(),
            createInitialBuilder(
                builder,
                ExtraTypeTags.SENSITIVE_TO_BUTCHER
            ).addEffect(
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

        builder.add(
            ExtraEnchants.HERBICIDE.getValue(),
            createInitialBuilder(builder, ExtraTypeTags.SENSITIVE_TO_HERBICIDE)
        );

        builder.add(
            ExtraEnchants.UNRAVEL.getValue(),
            createInitialBuilder(
                builder,
                ExtraTypeTags.SENSITIVE_TO_UNRAVEL
            ).addEffect(
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

        builder.add(
            ExtraEnchants.VOIDRENDER.getValue(),
            createInitialBuilder(
                builder,
                ExtraTypeTags.SENSITIVE_TO_VOIDRENDER
            ).addEffect(
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
    }

    private static Enchantment.Builder createInitialBuilder (EnchantmentBuilder builder, TagKey<EntityType<?>> tag) {
        return Enchantment.builder(
            Enchantment.definition(
                builder.getItemEntryList(CPCItemTags.DAMAGE_ENCHANTABLE),
                builder.getItemEntryList(CPCItemTags.DAMAGE_PRIMARY_ENCHANTABLE),
                5,
                5,
                Enchantment.leveledCost(5, 8),
                Enchantment.leveledCost(25, 8),
                2,
                AttributeModifierSlot.MAINHAND
            )
        ).exclusiveSet(
            builder.getEnchantmentEntryList(EnchantmentTags.DAMAGE_EXCLUSIVE_SET)
        ).addEffect(
            EnchantmentEffectComponentTypes.DAMAGE,
            new AddEnchantmentEffect(EnchantmentLevelBasedValue.linear(2.5f)),
            EntityPropertiesLootCondition.builder(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(tag)
            )
        );
    }
}
