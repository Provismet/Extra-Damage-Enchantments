package com.provismet.extradamageenchants.enchantment;

import com.provismet.extradamageenchants.ExtraDEMain;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.registry.Registry;

public class ExtraEnchants {
    public static final Enchantment REBEL = Registry.register(Registry.ENCHANTMENT, ExtraDEMain.identifier("rebel"), new ExtraDamageEnchantment(Enchantment.Rarity.UNCOMMON, 0, EquipmentSlot.MAINHAND));
    public static final Enchantment VOIDRENDER = Registry.register(Registry.ENCHANTMENT, ExtraDEMain.identifier("voidrender"), new ExtraDamageEnchantment(Enchantment.Rarity.UNCOMMON, 1, EquipmentSlot.MAINHAND));
    public static final Enchantment UNRAVEL = Registry.register(Registry.ENCHANTMENT, ExtraDEMain.identifier("unravel"), new ExtraDamageEnchantment(Enchantment.Rarity.UNCOMMON, 2, EquipmentSlot.MAINHAND));
    public static final Enchantment HERBICIDE = Registry.register(Registry.ENCHANTMENT, ExtraDEMain.identifier("herbicide"), new ExtraDamageEnchantment(Enchantment.Rarity.UNCOMMON, 3, EquipmentSlot.MAINHAND));
    public static final Enchantment BUTCHER = Registry.register(Registry.ENCHANTMENT, ExtraDEMain.identifier("butcher"), new ExtraDamageEnchantment(Enchantment.Rarity.UNCOMMON, 4, EquipmentSlot.MAINHAND));
}
