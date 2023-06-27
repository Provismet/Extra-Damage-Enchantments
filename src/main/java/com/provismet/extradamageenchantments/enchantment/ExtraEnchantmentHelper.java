package com.provismet.extradamageenchantments.enchantment;

import java.util.Map;

import org.apache.commons.lang3.mutable.MutableFloat;

import com.provismet.extradamageenchantments.ExtraGameRules;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class ExtraEnchantmentHelper {
    public static float getAttackDamage (ItemStack stack, LivingEntity entity) {
        MutableFloat mutableFloat = new MutableFloat();
        Map<Enchantment,Integer> enchantments = EnchantmentHelper.get(stack);
        enchantments.forEach((Enchantment enchantment, Integer level) -> mutableFloat.add(getAttackDamage(enchantment, level, entity)));

        return mutableFloat.floatValue();
    }

    // Gets the attack damage from an enchantment to a single entity.
    public static float getAttackDamage (Enchantment enchantment, int level, LivingEntity entity) {
        float damageBoost = enchantment.getAttackDamage(level, entity.getGroup());

        if (entity instanceof PlayerEntity && enchantment != Enchantments.SHARPNESS && enchantment instanceof DamageEnchantment) {
            damageBoost *= entity.getWorld().getGameRules().get(ExtraGameRules.PLAYER_ENCHANTMENT_DAMAGE_MOD).get();
        }
        return damageBoost;
    }
}
