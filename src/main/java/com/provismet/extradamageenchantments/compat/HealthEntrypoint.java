package com.provismet.extradamageenchantments.compat;

import com.provismet.extradamageenchantments.ExtraDEMain;
import com.provismet.extradamageenchantments.group.ExtraGroup;
import com.provismet.provihealth.api.ProviHealthApi;

import net.minecraft.item.Items;

public class HealthEntrypoint implements ProviHealthApi {
    @Override
    public void onInitialize () {
        this.registerIcon(ExtraGroup.ARCANE, Items.LAPIS_LAZULI);
        this.registerIcon(ExtraGroup.BEASTLY, Items.BEEF);
        this.registerIcon(ExtraGroup.FUNGIFLORAL, Items.KELP);
        this.registerIcon(ExtraGroup.HUMANOID, Items.BOOK);
        this.registerIcon(ExtraGroup.OUTERWORDLY, Items.ENDER_PEARL);

        this.registerPortrait(ExtraGroup.ARCANE, ExtraDEMain.identifier("textures/gui/health_bar/arcane.png"));
        this.registerPortrait(ExtraGroup.BEASTLY, ExtraDEMain.identifier("textures/gui/health_bar/beastly.png"));
        this.registerPortrait(ExtraGroup.FUNGIFLORAL, ExtraDEMain.identifier("textures/gui/health_bar/fungifloral.png"));
        this.registerPortrait(ExtraGroup.HUMANOID, ExtraDEMain.identifier("textures/gui/health_bar/humanoid.png"));
        this.registerPortrait(ExtraGroup.OUTERWORDLY, ExtraDEMain.identifier("textures/gui/health_bar/outerworldly.png"));
    }
}
