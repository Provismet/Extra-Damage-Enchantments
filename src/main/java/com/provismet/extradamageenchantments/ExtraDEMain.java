package com.provismet.extradamageenchantments;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.provismet.extradamageenchantments.enchantment.ExtraEnchants;

public class ExtraDEMain implements ModInitializer {
	public static final String modid = "extra_de";
	public static final Logger LOGGER = LoggerFactory.getLogger(modid);

	public static Identifier identifier (String path) {
		return new Identifier(modid, path);
	}

	@Override
	public void onInitialize () {
		ExtraEnchants.register();
		ExtraGameRules.register();
	}
}
