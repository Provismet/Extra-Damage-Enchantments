package com.provismet.extradamageenchantments.compat;

import com.provismet.extradamageenchantments.ExtraDamageEnchantmentsMain;
import com.provismet.extradamageenchantments.utility.tags.EDEEntityTypeTags;
import com.provismet.provihealth.api.ProviHealthApi;
import net.minecraft.world.item.Items;

public class HealthEntrypoint implements ProviHealthApi {
    private static final int DEFAULT_PRIORITY = -990;

    @Override
    public void onInitialize () {
        this.registerIcon(EDEEntityTypeTags.ARCANE, Items.LAPIS_LAZULI, DEFAULT_PRIORITY);
        this.registerIcon(EDEEntityTypeTags.BEASTLY, Items.BEEF, DEFAULT_PRIORITY + 1);
        this.registerIcon(EDEEntityTypeTags.FUNGIFLORAL, Items.KELP, DEFAULT_PRIORITY + 2);
        this.registerIcon(EDEEntityTypeTags.HUMANOID, Items.BOOK, DEFAULT_PRIORITY + 3);
        this.registerIcon(EDEEntityTypeTags.OUTERWORLDLY, Items.ENDER_PEARL, DEFAULT_PRIORITY + 4);

        this.registerPortrait(EDEEntityTypeTags.ARCANE, ExtraDamageEnchantmentsMain.identifier("textures/gui/health_bar/arcane.png"), DEFAULT_PRIORITY);
        this.registerPortrait(EDEEntityTypeTags.BEASTLY, ExtraDamageEnchantmentsMain.identifier("textures/gui/health_bar/beastly.png"), DEFAULT_PRIORITY + 1);
        this.registerPortrait(EDEEntityTypeTags.FUNGIFLORAL, ExtraDamageEnchantmentsMain.identifier("textures/gui/health_bar/fungifloral.png"), DEFAULT_PRIORITY + 2);
        this.registerPortrait(EDEEntityTypeTags.HUMANOID, ExtraDamageEnchantmentsMain.identifier("textures/gui/health_bar/humanoid.png"), DEFAULT_PRIORITY + 3);
        this.registerPortrait(EDEEntityTypeTags.OUTERWORLDLY, ExtraDamageEnchantmentsMain.identifier("textures/gui/health_bar/outerworldly.png"), DEFAULT_PRIORITY + 4);
    }
}
