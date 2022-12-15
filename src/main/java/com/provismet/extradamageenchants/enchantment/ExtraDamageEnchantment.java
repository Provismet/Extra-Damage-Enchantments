package com.provismet.extradamageenchants.enchantment;

import com.provismet.extradamageenchants.group.ExtraGroup;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ExtraDamageEnchantment extends DamageEnchantment {
    private static final int BASE_POWER = 5;
    private static final int POWER_PER_LEVEL = 8;
    private static final int MIN_MAX_POWER_DIFFERENCE = 20;
    private final EntityGroup preferredGroup;

    public ExtraDamageEnchantment (Enchantment.Rarity weight, EntityGroup preferredGroup, EquipmentSlot ... slots) {
        super(weight, -1, slots);
        this.preferredGroup = preferredGroup;
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
        if (entityGroup == this.preferredGroup || (this.preferredGroup == ExtraGroup.HUMANOID && entityGroup == EntityGroup.ILLAGER)) {
            return (float)level * 2.5f;
        }
        return 0.0f;
    }

    @Override
    public void onTargetDamaged (LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)target;
            if (livingEntity.getGroup() == this.preferredGroup) {
                if (this.preferredGroup == ExtraGroup.OUTERWORDLY || this.preferredGroup == ExtraGroup.ARCANE) {
                    livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 60, 1));
                }
                else if (this.preferredGroup == ExtraGroup.BEASTLY) {
                    int i = 20 + user.getRandom().nextInt(10 * level);
                    livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, i, 2));
                }
            }
        }
    }
}
