package me.mcblueparrot.client.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import me.mcblueparrot.client.mod.impl.HitregOptimizerMod;
import net.minecraft.client.multiplayer.PlayerControllerMP;

@Mixin(PlayerControllerMP.class)
public class MixinPlayerControllerMP {

	@Inject(method = "getBlockReachDistance()F", at = @At("RETURN"), cancellable = true)
	public void modifyReachDistance(CallbackInfoReturnable<Float> cir) {
		if(HitregOptimizerMod.enabled && HitregOptimizerMod.instance != null) {
			cir.setReturnValue(HitregOptimizerMod.instance.reachDistance);
		}
	}

}

