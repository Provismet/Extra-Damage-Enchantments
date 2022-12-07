package com.provismet.extradamageenchants.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.provismet.extradamageenchants.ExtraDEMain;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
	public LivingEntityMixin (EntityType<?> type, World world) {
		super(type, world);
	}

	@Inject(at=@At("TAIL"), method="getGroup")
	public void getGroup (CallbackInfoReturnable<EntityGroup> cir) {
		
	}
}
