package com.provismet.extradamageenchants.enchantment;

import com.provismet.extradamageenchants.ExtraDEMain;
import com.provismet.extradamageenchants.group.ExtraGroup;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.registry.Registry;

public class ExtraEnchants {
    public static final Enchantment REBEL = new ExtraDamageEnchantment(Enchantment.Rarity.UNCOMMON, ExtraGroup.HUMANOID, EquipmentSlot.MAINHAND);
    public static final Enchantment VOIDRENDER = new ExtraDamageEnchantment(Enchantment.Rarity.UNCOMMON, ExtraGroup.OUTERWORDLY, EquipmentSlot.MAINHAND);
    public static final Enchantment UNRAVEL = new ExtraDamageEnchantment(Enchantment.Rarity.UNCOMMON, ExtraGroup.ARCANE, EquipmentSlot.MAINHAND);
    public static final Enchantment HERBICIDE = new ExtraDamageEnchantment(Enchantment.Rarity.UNCOMMON, ExtraGroup.FUNGIFLORAL, EquipmentSlot.MAINHAND);
    public static final Enchantment BUTCHER = new ExtraDamageEnchantment(Enchantment.Rarity.UNCOMMON, ExtraGroup.BEASTLY, EquipmentSlot.MAINHAND);

    public static void register () {
        Registry.register(Registry.ENCHANTMENT, ExtraDEMain.identifier("rebel"), REBEL);
        Registry.register(Registry.ENCHANTMENT, ExtraDEMain.identifier("voidrender"), VOIDRENDER);
        Registry.register(Registry.ENCHANTMENT, ExtraDEMain.identifier("unravel"), UNRAVEL);
        Registry.register(Registry.ENCHANTMENT, ExtraDEMain.identifier("herbicide"), HERBICIDE);
        Registry.register(Registry.ENCHANTMENT, ExtraDEMain.identifier("butcher"), BUTCHER);
    }
}
