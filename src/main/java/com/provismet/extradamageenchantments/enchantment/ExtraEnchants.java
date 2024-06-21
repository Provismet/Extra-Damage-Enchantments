package com.provismet.extradamageenchantments.enchantment;

import com.provismet.extradamageenchantments.ExtraDEMain;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class ExtraEnchants {
    public static final RegistryKey<Enchantment> REBEL = ExtraEnchants.of("rebel");
    public static final RegistryKey<Enchantment> VOIDRENDER = ExtraEnchants.of("voidrender");
    public static final RegistryKey<Enchantment> UNRAVEL = ExtraEnchants.of("unravel");
    public static final RegistryKey<Enchantment> HERBICIDE = ExtraEnchants.of("herbicide");
    public static final RegistryKey<Enchantment> BUTCHER = ExtraEnchants.of("butcher");

    private static RegistryKey<Enchantment> of (String name) {
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, ExtraDEMain.identifier(name));
    }

    public static void register () {}
}
