package com.provismet.extradamageenchantments.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.registry.tag.TagKey;
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
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

import java.util.Optional;

@Mixin(value = DamageEnchantment.class, priority = 990)
public abstract class DamageEnchantmentMixin extends Enchantment implements CPCEnchantment {
    @Final
    @Shadow
    private Optional<TagKey<EntityType<?>>> applicableEntities;

    protected DamageEnchantmentMixin (Properties properties) {
        super(properties);
    }

    @Inject(method="getAttackDamage", at=@At("HEAD"), cancellable=true)
    private void preventAttackDamage (int level, EntityType<?> type, CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue(0f);
    }

    @Override
    public float getAttackDamage (int level, EquipmentSlot slot, LivingEntity user, LivingEntity target) {
        if (slot != EquipmentSlot.MAINHAND) return 0f;

        if (this.applicableEntities.isEmpty()) {
            return 1.0F + (float)Math.max(0, level - 1) * 0.5F;
        }
        else {
            float damage = target.getType() != null && target.getType().isIn(this.applicableEntities.get()) ? (float)level * 2.5f : 0.0f;
            damage *= (float)user.getWorld().getGameRules().get(ExtraGameRules.PLAYER_ENCHANTMENT_DAMAGE_MOD).get();
            return damage;
        }
    }
}
