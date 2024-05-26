package com.provismet.extradamageenchantments.enchantment;

import com.provismet.CombatPlusCore.interfaces.CPCEnchantment;
import com.provismet.CombatPlusCore.utility.CPCItemTags;
import com.provismet.extradamageenchantments.ExtraGameRules;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

import java.util.Optional;

public class ExtraDamageEnchantment extends DamageEnchantment implements CPCEnchantment {
    private final RegistryEntry<StatusEffect> status;
    private final int effectDuration;
    private final int effectAmplifier;

    protected final TagKey<EntityType<?>> targetTag;

    public ExtraDamageEnchantment (Properties properties, Optional<TagKey<EntityType<?>>> applicableEntities, RegistryEntry<StatusEffect> effect, int effectAmplifier, int effectDuration) {
        super(properties, applicableEntities);
        this.targetTag = applicableEntities.orElse(null);
        this.status = effect;
        this.effectAmplifier = effectAmplifier;
        this.effectDuration = effectDuration;
    }

    public ExtraDamageEnchantment (Properties properties, Optional<TagKey<EntityType<?>>> applicableEntities) {
        this(properties, applicableEntities, null, 0, 0);
    }

    public ExtraDamageEnchantment (Optional<TagKey<EntityType<?>>> applicableEntities, RegistryEntry<StatusEffect> effect, int effectAmplifier, int effectDuration) {
        this(Enchantment.properties(CPCItemTags.DAMAGE_ENCHANTABLE, CPCItemTags.DAMAGE_PRIMARY_ENCHANTABLE, 5, 5, Enchantment.leveledCost(5, 8), Enchantment.leveledCost(25, 8), 2, new EquipmentSlot[]{EquipmentSlot.MAINHAND}), applicableEntities, effect, effectAmplifier, effectDuration);
    }

    public ExtraDamageEnchantment (Optional<TagKey<EntityType<?>>> applicableEntities) {
        this(applicableEntities, null, 0, 0);
    }

    @Override
    public final float getAttackDamage (int level, EntityType<?> entityType) {
        return 0f;
    }

    @Override
    public float getAttackDamage (int level, EquipmentSlot slot, LivingEntity user, LivingEntity target) {
        if (slot == EquipmentSlot.MAINHAND && this.isPreferred(target)) {
            float damage = (float)level * 2.5f;
            if (target instanceof PlayerEntity) damage *= (float)user.getWorld().getGameRules().get(ExtraGameRules.PLAYER_ENCHANTMENT_DAMAGE_MOD).get();
            return damage;
        }
        return 0f;
    }

    @Override
    public void onTargetDamaged (LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity livingEntity) {
            if (this.isPreferred(livingEntity) && this.status != null) {
                int randomModifier = user.getRandom().nextInt(10 * level);
                livingEntity.addStatusEffect(new StatusEffectInstance(this.status, this.effectDuration + randomModifier, this.effectAmplifier), user);
            }
        }
    }

    // This is a separate function because it provides an easy mixin injection point for other mods.
    protected boolean isPreferred (LivingEntity target) {
        return this.targetTag != null && target.getType().isIn(this.targetTag);
    }
}
