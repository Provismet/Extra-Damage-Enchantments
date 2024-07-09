package com.provismet.extradamageenchantments.mixin;

import com.provismet.extradamageenchantments.registries.EDEEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.registry.Registerable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Enchantments.class)
public abstract class EnchantmentsMixin {
    @Inject(method="bootstrap", at=@At("TAIL"))
    private static void bootstrapMod (Registerable<Enchantment> registerable, CallbackInfo info) {
        EDEEnchantments.bootstrap(registerable);
    }
}
