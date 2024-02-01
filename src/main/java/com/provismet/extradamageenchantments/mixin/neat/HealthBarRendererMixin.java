package com.provismet.extradamageenchantments.mixin.neat;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.provismet.extradamageenchantments.group.ExtraGroup;

import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import vazkii.neat.HealthBarRenderer;

@Pseudo
@Mixin(HealthBarRenderer.class)
public abstract class HealthBarRendererMixin {
    @Inject(method="getIcon", at=@At("TAIL"), cancellable=true)
	private static void addMoreIcons (LivingEntity livingEntity, boolean isBoss, CallbackInfoReturnable<ItemStack> cir) {
		EntityGroup grouping = livingEntity.getGroup();
		if (grouping == ExtraGroup.ARCANE) cir.setReturnValue(new ItemStack(Items.LAPIS_LAZULI));
		else if (grouping == ExtraGroup.BEASTLY) cir.setReturnValue(new ItemStack(Items.BEEF));
		else if (grouping == ExtraGroup.FUNGIFLORAL) cir.setReturnValue(new ItemStack(Items.KELP));
		else if (grouping == ExtraGroup.HUMANOID) cir.setReturnValue(new ItemStack(Items.BOOK));
		else if (grouping == ExtraGroup.OUTERWORDLY) cir.setReturnValue(new ItemStack(Items.ENDER_PEARL));
		else if (grouping == EntityGroup.AQUATIC) cir.setReturnValue(new ItemStack(Items.COD));
		else if (grouping == EntityGroup.ILLAGER) cir.setReturnValue(new ItemStack(Items.IRON_AXE));
	}
}
