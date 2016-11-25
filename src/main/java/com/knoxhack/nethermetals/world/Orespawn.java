package com.knoxhack.nethermetals.world;

import com.google.common.base.Function;

import com.knoxhack.nethermetals.blocks.ModBlocks;
import mmd.orespawn.api.OreSpawnAPI;
import mmd.orespawn.api.SpawnLogic;

public class Orespawn implements Function<OreSpawnAPI, SpawnLogic> {
	@Override
	public SpawnLogic apply(OreSpawnAPI api) {
		SpawnLogic logic = api.createSpawnLogic();

		// Vanilla
		logic.getDimension(-1)
				.addOre(ModBlocks.coal_ore.getDefaultState(),     15,  4,  7, 0, 128)
				.addOre(ModBlocks.diamond_ore.getDefaultState(),  15,  4,  7, 0, 128)
				.addOre(ModBlocks.emerald_ore.getDefaultState(),  15,  4,  7, 0, 128)
				.addOre(ModBlocks.gold_ore.getDefaultState(),     15,  4,  7, 0, 128)
				.addOre(ModBlocks.iron_ore.getDefaultState(),     15,  4,  7, 0, 128)
				.addOre(ModBlocks.lapis_ore.getDefaultState(),    15,  4,  7, 0, 128)
				.addOre(ModBlocks.redstone_ore.getDefaultState(), 15,  4,  7, 0, 128);

		// Base Metals
		logic.getDimension(-1)
				.addOre(ModBlocks.antimony_ore.getDefaultState(),  8,  4, 10, 0, 128)
				.addOre(ModBlocks.bismuth_ore.getDefaultState(),   8,  4, 10, 0, 128)
				.addOre(ModBlocks.copper_ore.getDefaultState(),    8, 12, 20, 0, 128)
				.addOre(ModBlocks.lead_ore.getDefaultState(),      8, 12, 20, 0, 128)
				.addOre(ModBlocks.mercury_ore.getDefaultState(),   8,  4, 10, 0, 128)
				.addOre(ModBlocks.nickel_ore.getDefaultState(),    8,  4, 10, 0, 128)
				.addOre(ModBlocks.platinum_ore.getDefaultState(),  8,  4, 10, 0, 128)
				.addOre(ModBlocks.silver_ore.getDefaultState(),    8,  8, 10, 0, 128)
				.addOre(ModBlocks.tin_ore.getDefaultState(),       8, 12, 20, 0, 128)
				.addOre(ModBlocks.zinc_ore.getDefaultState(),      8,  8, 12, 0, 128);

		// Modern Metals
		logic.getDimension(-1)
				.addOre(ModBlocks.aluminum_ore.getDefaultState(),  8,  8, 10, 0, 128)
				.addOre(ModBlocks.cadmium_ore.getDefaultState(),   8,  8, 10, 0, 128)
				.addOre(ModBlocks.chromium_ore.getDefaultState(),  8,  8, 10, 0, 128)
				.addOre(ModBlocks.iridium_ore.getDefaultState(),   8,  8, 10, 0, 128)
				.addOre(ModBlocks.magnesium_ore.getDefaultState(), 8,  8, 10, 0, 128)
				.addOre(ModBlocks.manganese_ore.getDefaultState(), 8,  8, 10, 0, 128)
				.addOre(ModBlocks.osmium_ore.getDefaultState(),    8,  8, 10, 0, 128)
				.addOre(ModBlocks.plutonium_ore.getDefaultState(), 8,  4, 10, 0, 128)
				.addOre(ModBlocks.rutile_ore.getDefaultState(),    8,  8, 10, 0, 128)
				.addOre(ModBlocks.tantalum_ore.getDefaultState(),  8,  8, 10, 0, 128)
				.addOre(ModBlocks.titanium_ore.getDefaultState(),  8,  4, 10, 0, 128)
				.addOre(ModBlocks.tungsten_ore.getDefaultState(),  8,  8, 10, 0, 128)
				.addOre(ModBlocks.uranium_ore.getDefaultState(),   8,  4, 10, 0, 128)
				.addOre(ModBlocks.zirconium_ore.getDefaultState(), 8,  8, 10, 0, 128);

		return logic;
	}
}
