package com.provismet.extradamageenchantments.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.provismet.extradamageenchantments.group.ExtraGroup;
import com.provismet.extradamageenchantments.group.ExtraTypeTags;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
	public LivingEntityMixin (EntityType<?> type, World world) {
		super(type, world);
	}

	@Inject(at=@At("TAIL"), method="getGroup", cancellable=true)
	public void getGroup (CallbackInfoReturnable<EntityGroup> cir) {
		EntityType<?> type = ((LivingEntity)(Object)this).getType();

		if (type.isIn(ExtraTypeTags.OUTERWORLDLY)) cir.setReturnValue(ExtraGroup.OUTERWORDLY);
		else if (type.isIn(ExtraTypeTags.ARCANE)) cir.setReturnValue(ExtraGroup.ARCANE);
		else if (type.isIn(ExtraTypeTags.FUNGIFLORAL)) cir.setReturnValue(ExtraGroup.FUNGIFLORAL);
		else if (type.isIn(ExtraTypeTags.BEASTLY)) cir.setReturnValue(ExtraGroup.BEASTLY);
		else if (type.isIn(ExtraTypeTags.UNDEAD)) cir.setReturnValue(EntityGroup.UNDEAD);
		else if (type.isIn(ExtraTypeTags.ARTHROPOD)) cir.setReturnValue(EntityGroup.ARTHROPOD);
		else if (type.isIn(ExtraTypeTags.ILLAGER)) cir.setReturnValue(EntityGroup.ILLAGER);
		else if (type.isIn(ExtraTypeTags.AQUATIC)) cir.setReturnValue(EntityGroup.AQUATIC);
		else if (type.isIn(ExtraTypeTags.HUMANOID)) cir.setReturnValue(ExtraGroup.HUMANOID);
	}
}
