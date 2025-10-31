package me.mcblueparrot.client.mod.impl;

import com.google.gson.annotations.Expose;

import me.mcblueparrot.client.mod.Mod;
import me.mcblueparrot.client.mod.ModCategory;
import me.mcblueparrot.client.mod.annotation.ConfigOption;
import me.mcblueparrot.client.mod.annotation.Slider;

public class HitregOptimizerMod extends Mod {

	public static boolean enabled;
	public static HitregOptimizerMod instance;

	// This is stored as a percentage (10-100) but represents reach distance (3.05-3.15)
	@Expose
	@ConfigOption("NoHitDelay chance")
	@Slider(min = 10F, max = 100F, step = 1F, suffix = "%")
	public float noHitDelayChance = 10F; // Default 10% = 3.05 reach

	public HitregOptimizerMod() {
		super("Hitreg Optimizer", "hitreg_optimizer", "improves for better hit registration.", ModCategory.UTILITY);
		instance = this;
	}

	/**
	 * Converts the displayed percentage (10-100%) to actual reach distance (3.05-3.15)
	 */
	public float getReachDistance() {
		// Map 10-100 to 3.05-3.15
		// 10% = 3.05, 100% = 3.15
		float normalized = (noHitDelayChance - 10F) / 90F; // 0.0 to 1.0
		return 3.05F + (normalized * 0.10F); // 3.05 + (0 to 0.10)
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

