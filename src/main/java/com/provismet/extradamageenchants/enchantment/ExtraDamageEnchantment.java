package com.provismet.extradamageenchants.enchantment;

import com.provismet.extradamageenchants.group.ExtraGroups;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class ExtraDamageEnchantment extends DamageEnchantment {
    private static final EntityGroup[] groups = new EntityGroup[]{ExtraGroups.HUMANOID, ExtraGroups.OUTERWORDLY, ExtraGroups.ARCANE, ExtraGroups.FUNGIFLORAL, ExtraGroups.BEASTLY};
    private static final int BASE_POWER = 5;
    private static final int POWER_PER_LEVEL = 8;
    private static final int MIN_MAX_POWER_DIFFERENCE = 20;
    private final EntityGroup preferredGroup;

    public ExtraDamageEnchantment (Enchantment.Rarity weight, int typeIndex, EquipmentSlot ... slots) {
        super(weight, typeIndex, slots);

        if (typeIndex < 0 || typeIndex >= ExtraDamageEnchantment.groups.length) {
            this.preferredGroup = ExtraGroups.NULL; // This group is never assigned.
        }
        else {
            this.preferredGroup = groups[typeIndex];
        }
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
        if (entityGroup == this.preferredGroup) {
            return (float)level * 2.5f;
        }
        return 0.0f;
    }

    @Override
    public void onTargetDamaged (LivingEntity user, Entity target, int level) {
        // TODO: Ideas for this? Otherwise keep empty to avoid interacting with the super version's logic.
    }
}
