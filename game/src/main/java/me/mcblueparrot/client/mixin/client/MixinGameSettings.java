package me.mcblueparrot.client.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.settings.GameSettings;
import net.minecraft.src.Config;

@Mixin(GameSettings.class)
public class MixinGameSettings {

	private static boolean firstLoad = true;

	@Inject(method = "<init>(Lnet/minecraft/client/Minecraft;Ljava/io/File;)V", at = @At("RETURN"))
	public void initOptiFine(GameSettings settings, net.minecraft.client.Minecraft mc, java.io.File file, CallbackInfo ci) {
		// Initialize OptiFine Config when GameSettings is created
		Config.initGameSettings((GameSettings)(Object)this);
	}

	@Inject(method = "loadOptions", at = @At("HEAD"))
	public void setDefaults(CallbackInfo callback) {
		useVbo = true; // Use VBOs by default.
	}

	@Inject(method = "loadOptions", at = @At("TAIL"), cancellable = true)
	public void postLoadOptions(CallbackInfo callback) {
		if(firstLoad) {
			callback.cancel();
			firstLoad = false;
		}
	}

	@Shadow
	public boolean useVbo;

}
