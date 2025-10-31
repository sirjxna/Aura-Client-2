package me.mcblueparrot.client.mod.impl;

import com.google.gson.annotations.Expose;

import me.mcblueparrot.client.mod.Mod;
import me.mcblueparrot.client.mod.ModCategory;
import me.mcblueparrot.client.mod.annotation.ConfigOption;
import me.mcblueparrot.client.mod.annotation.Slider;

public class HitregOptimizerMod extends Mod {

	public static boolean enabled;
	public static HitregOptimizerMod instance;

	@Expose
	@ConfigOption("Reach Distance")
	@Slider(min = 3.05F, max = 3.15F, step = 0.1F, suffix = " ")
	public float reachDistance = 3.10F;

	public HitregOptimizerMod() {
		super("Hitreg Optimizer", "hitreg_optimizer", "Increases your reach/attack range for better hit registration.", ModCategory.COMBAT);
		instance = this;
	}

	@Override
	protected void onEnable() {
		super.onEnable();
		enabled = true;
	}

	@Override
	protected void onDisable() {
		super.onDisable();
		enabled = false;
	}

	@Override
	public boolean isEnabledByDefault() {
		return false;
	}

}

