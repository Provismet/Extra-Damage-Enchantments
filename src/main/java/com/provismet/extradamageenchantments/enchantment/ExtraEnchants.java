package com.provismet.extradamageenchantments.enchantment;

import com.provismet.extradamageenchantments.ExtraDEMain;

import com.provismet.extradamageenchantments.group.ExtraTypeTags;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.Optional;

public class ExtraEnchants {
    public static final Enchantment REBEL = new ExtraDamageEnchantment(Optional.of(ExtraTypeTags.SENSITIVE_TO_REBEL));
    public static final Enchantment VOIDRENDER = new ExtraDamageEnchantment(Optional.of(ExtraTypeTags.SENSITIVE_TO_VOIDRENDER), StatusEffects.GLOWING, 0, 60);
    public static final Enchantment UNRAVEL = new ExtraDamageEnchantment(Optional.of(ExtraTypeTags.SENSITIVE_TO_UNRAVEL), StatusEffects.GLOWING, 0, 60);
    public static final Enchantment HERBICIDE = new ExtraDamageEnchantment(Optional.of(ExtraTypeTags.SENSITIVE_TO_HERBICIDE));
    public static final Enchantment BUTCHER = new ExtraDamageEnchantment(Optional.of(ExtraTypeTags.SENSITIVE_TO_BUTCHER), StatusEffects.SLOWNESS, 2, 20);

    public static void register () {
        Registry.register(Registries.ENCHANTMENT, ExtraDEMain.identifier("rebel"), REBEL);
        Registry.register(Registries.ENCHANTMENT, ExtraDEMain.identifier("voidrender"), VOIDRENDER);
        Registry.register(Registries.ENCHANTMENT, ExtraDEMain.identifier("unravel"), UNRAVEL);
        Registry.register(Registries.ENCHANTMENT, ExtraDEMain.identifier("herbicide"), HERBICIDE);
        Registry.register(Registries.ENCHANTMENT, ExtraDEMain.identifier("butcher"), BUTCHER);
    }
}
