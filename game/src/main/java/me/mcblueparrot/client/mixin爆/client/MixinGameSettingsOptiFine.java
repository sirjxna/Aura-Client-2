package me.mcblueparrot.client.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.settings.GameSettings;
import net.minecraft.src.Config;
import net.optifine.Lang;

@Mixin(GameSettings.class)
public class MixinGameSettingsOptiFine {

	@Inject(method = "<init>(Lnet/minecraft/client/Minecraft;Ljava/io/File;)V", at = @At("TAIL"))
	public void initOptiFine(GameSettings settings, net.minecraft.client.Minecraft mc, java.io.File file, CallbackInfo ci) {
		// Initialize OptiFine Config when GameSettings is created
		Config.initGameSettings((GameSettings)(Object)this);
	}

}

