package com.provismet.extradamageenchantments;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.gamerule.v1.rule.DoubleRule;
import net.minecraft.world.GameRules;
import net.minecraft.world.GameRules.Category;

public class ExtraGameRules {
    public static final GameRules.Key<DoubleRule> PLAYER_ENCHANTMENT_DAMAGE_MOD = GameRuleRegistry.register("specialEnchantAgainstPlayersPercentEffectiveness", Category.PLAYER, GameRuleFactory.createDoubleRule(0.4, 0.0));

    public static void register () {
        // This does nothing, but I am calling it just to guarantee that this class has been loaded.
    }
}
