package com.provismet.extradamageenchantments.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.provismet.extradamageenchantments.enchantment.ExtraEnchantmentHelper;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin extends LivingEntity {
    protected MobEntityMixin (EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }
    
    @Redirect(method="tryAttack", at=@At(value="INVOKE", target="Lnet/minecraft/enchantment/EnchantmentHelper;getAttackDamage(Lnet/minecraft/item/ItemStack;Lnet/minecraft/entity/EntityGroup;)F"))
    private float modifyEnchantmentDamage (ItemStack itemStack, EntityGroup entityGroup, Entity target) {
        if (target instanceof LivingEntity living) {
            return ExtraEnchantmentHelper.getAttackDamage(itemStack, living);
        }
        return EnchantmentHelper.getAttackDamage(itemStack, entityGroup);
    }
}
