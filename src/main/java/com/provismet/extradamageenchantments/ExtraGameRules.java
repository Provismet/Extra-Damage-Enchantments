package com.provismet.extradamageenchantments;

import com.provismet.CombatPlusCore.utility.CombatGameRules;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.gamerule.v1.rule.DoubleRule;
import net.minecraft.world.GameRules;

public class ExtraGameRules {
    public static final GameRules.Key<DoubleRule> PLAYER_ENCHANTMENT_DAMAGE_MOD = GameRuleRegistry.register("damageEnchantAgainstPlayerEffectiveness", CombatGameRules.CATEGORY, GameRuleFactory.createDoubleRule(0.5, 0.0));

    public static void register () {
        // This does nothing, but I am calling it just to guarantee that this class has been loaded.
    }
}
