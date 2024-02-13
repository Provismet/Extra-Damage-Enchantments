package com.provismet.extradamageenchantments.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.provismet.CombatPlusCore.interfaces.CPCEnchantment;
import com.provismet.extradamageenchantments.ExtraGameRules;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

@Mixin(value = DamageEnchantment.class, priority = 990)
public abstract class DamageEnchantmentMixin extends Enchantment implements CPCEnchantment {
    protected DamageEnchantmentMixin(Rarity weight, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(weight, target, slotTypes);
    }

    @Shadow
    @Final
    public int typeIndex;
    
    @Inject(method="getAttackDamage", at=@At("HEAD"), cancellable=true)
    private void preventAttackDamage (int level, EntityGroup group, CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue(0f);
    }

    @Override
    public float getAttackDamage (int level, EquipmentSlot slot, LivingEntity user, LivingEntity target) {
        if (slot != EquipmentSlot.MAINHAND) return 0f;

        float damage = 0;
        
        if (this.typeIndex == 0) {
            damage = 1.0f + (float)Math.max(0, level - 1) * 0.5f;
        }
        else {
            if (this.typeIndex == 1 && target.getGroup() == EntityGroup.UNDEAD) {
                damage = (float)level * 2.5f;
            }
            else if (this.typeIndex == 2 && target.getGroup() == EntityGroup.ARTHROPOD) {
                damage = (float)level * 2.5f;
            }

            if (target instanceof PlayerEntity) damage *= (float)user.getWorld().getGameRules().get(ExtraGameRules.PLAYER_ENCHANTMENT_DAMAGE_MOD).get();
        }
        return damage;
    }
}
