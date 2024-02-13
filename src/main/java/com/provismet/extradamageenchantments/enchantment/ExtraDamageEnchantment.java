package com.provismet.extradamageenchantments.enchantment;

import com.provismet.CombatPlusCore.interfaces.CPCEnchantment;
import com.provismet.extradamageenchantments.ExtraGameRules;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;

public class ExtraDamageEnchantment extends DamageEnchantment implements CPCEnchantment {
    private static final int BASE_POWER = 5;
    private static final int POWER_PER_LEVEL = 8;
    private static final int MIN_MAX_POWER_DIFFERENCE = 20;
    
    private final EntityGroup[] preferredGroups;
    private final StatusEffect status;
    private final int effectDuration;
    private final int effectAmplifier;

    public ExtraDamageEnchantment (Enchantment.Rarity weight, EntityGroup[] preferredGroups, StatusEffect effect, int effectAmplifier, int effectDuration, EquipmentSlot ... slots) {
        super(weight, -1, slots);
        this.preferredGroups = preferredGroups;
        this.status = effect;
        this.effectAmplifier = effectAmplifier;
        this.effectDuration = effectDuration;
    }

    public ExtraDamageEnchantment (Enchantment.Rarity weight, EntityGroup[] preferredGroups, EquipmentSlot ... slots) {
        this(weight, preferredGroups, null, 0, 0, slots);
    }

    public ExtraDamageEnchantment (Enchantment.Rarity weight, EntityGroup preferredGroup, EquipmentSlot ... slots) {
        this(weight, new EntityGroup[] {preferredGroup}, slots);
    }

    public ExtraDamageEnchantment (Enchantment.Rarity weight, EntityGroup preferredGroup, StatusEffect effect, int effectAmplifier, int effectDuration, EquipmentSlot ... slots) {
        this(weight, new EntityGroup[] {preferredGroup}, effect, effectAmplifier, effectDuration, slots);
    }

    @Override
    public int getMinPower (int level) {
        return BASE_POWER + (level - 1) * POWER_PER_LEVEL;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + MIN_MAX_POWER_DIFFERENCE;
    }

    @Override
    public float getAttackDamage (int level, EntityGroup entityGroup) {
        return 0f;
    }

    @Override
    public float getAttackDamage (int level, EquipmentSlot slot, LivingEntity user, LivingEntity target) {
        if (slot == EquipmentSlot.MAINHAND && this.isPreferred(target.getGroup())) {
            float damage = (float)level * 2.5f;
            if (target instanceof PlayerEntity) damage *= (float)user.getWorld().getGameRules().get(ExtraGameRules.PLAYER_ENCHANTMENT_DAMAGE_MOD).get();
            return damage;
        }
        return 0f;
    }

    @Override
    public void onTargetDamaged (LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity livingEntity) {
            if (this.isPreferred(livingEntity.getGroup()) && this.status != null) {
                int randomModifier = user.getRandom().nextInt(10 * level);
                livingEntity.addStatusEffect(new StatusEffectInstance(this.status, this.effectDuration + randomModifier, this.effectAmplifier), user);
            }
        }
    }

    protected boolean isPreferred (EntityGroup group) {
        for (EntityGroup preferred : this.preferredGroups) {
            if (preferred == group) return true;
        }
        return false;
    }
}
