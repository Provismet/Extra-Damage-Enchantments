package com.provismet.extradamageenchantments.enchantment;

import com.provismet.extradamageenchantments.ExtraDEMain;
import com.provismet.extradamageenchantments.group.ExtraGroup;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ExtraEnchants {
    public static final Enchantment REBEL = new ExtraDamageEnchantment(Enchantment.Rarity.UNCOMMON, new EntityGroup[] {ExtraGroup.HUMANOID, EntityGroup.ILLAGER}, EquipmentSlot.MAINHAND);
    public static final Enchantment VOIDRENDER = new ExtraDamageEnchantment(Enchantment.Rarity.UNCOMMON, ExtraGroup.OUTERWORDLY, StatusEffects.GLOWING, 0, 60, EquipmentSlot.MAINHAND);
    public static final Enchantment UNRAVEL = new ExtraDamageEnchantment(Enchantment.Rarity.UNCOMMON, ExtraGroup.ARCANE, StatusEffects.GLOWING, 0, 60, EquipmentSlot.MAINHAND);
    public static final Enchantment HERBICIDE = new ExtraDamageEnchantment(Enchantment.Rarity.UNCOMMON, ExtraGroup.FUNGIFLORAL, EquipmentSlot.MAINHAND);
    public static final Enchantment BUTCHER = new ExtraDamageEnchantment(Enchantment.Rarity.UNCOMMON, ExtraGroup.BEASTLY, StatusEffects.SLOWNESS, 2, 20, EquipmentSlot.MAINHAND);

    public static void register () {
        Registry.register(Registries.ENCHANTMENT, ExtraDEMain.identifier("rebel"), REBEL);
        Registry.register(Registries.ENCHANTMENT, ExtraDEMain.identifier("voidrender"), VOIDRENDER);
        Registry.register(Registries.ENCHANTMENT, ExtraDEMain.identifier("unravel"), UNRAVEL);
        Registry.register(Registries.ENCHANTMENT, ExtraDEMain.identifier("herbicide"), HERBICIDE);
        Registry.register(Registries.ENCHANTMENT, ExtraDEMain.identifier("butcher"), BUTCHER);
    }
}
