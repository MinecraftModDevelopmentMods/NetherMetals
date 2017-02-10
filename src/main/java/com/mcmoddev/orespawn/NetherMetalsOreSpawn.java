package com.mcmoddev.orespawn;

import com.google.common.base.Function;

import com.mcmoddev.nethermetals.blocks.ModBlocks;
import mmd.orespawn.api.OreSpawnAPI;
import mmd.orespawn.api.SpawnLogic;
import net.minecraftforge.fml.common.Loader;

public class NetherMetalsOreSpawn implements Function<OreSpawnAPI, SpawnLogic> {

	@Override
	public SpawnLogic apply(OreSpawnAPI api) {

		SpawnLogic logic = api.createSpawnLogic();

		// Vanilla
		logic.getDimension(-1)
				.addOre(ModBlocks.coalOre.getDefaultState(), 8, 8,  12, 0,  96)
				.addOre(ModBlocks.diamondOre.getDefaultState(), 8, 8,  12, 0,  96)
				.addOre(ModBlocks.emeraldOre.getDefaultState(), 8, 8,  12, 0,  96)
				.addOre(ModBlocks.goldOre.getDefaultState(), 8, 8,  12, 0,  96)
				.addOre(ModBlocks.ironOre.getDefaultState(), 8, 8,  12, 0,  96)
				.addOre(ModBlocks.lapisOre.getDefaultState(), 8, 8,  12, 0,  96)
				.addOre(ModBlocks.redstoneOre.getDefaultState(), 8, 8,  12, 0,  96);

		//Base Metals
		if (Loader.isModLoaded("basemetals")) {
			logic.getDimension(-1)
					.addOre(ModBlocks.antimonyOre.getDefaultState(), 8, 4, 10, 0,  32)
					.addOre(ModBlocks.bismuthOre.getDefaultState(), 8, 4,  10, 0,  32)
					.addOre(ModBlocks.copperOre.getDefaultState(), 8, 12,  20, 0,  96)
					.addOre(ModBlocks.leadOre.getDefaultState(), 8, 12,  20, 0,  96)
					.addOre(ModBlocks.mercuryOre.getDefaultState(), 8, 4,  10, 0,  32)
					.addOre(ModBlocks.nickelOre.getDefaultState(), 8, 4,  10, 0,  96)
					.addOre(ModBlocks.platinumOre.getDefaultState(), 8, 4,  10, 0,  32)
					.addOre(ModBlocks.silverOre.getDefaultState(), 8, 8,  10, 0,  32)
					.addOre(ModBlocks.tinOre.getDefaultState(), 8, 12,  20, 0,  96)
					.addOre(ModBlocks.zincOre.getDefaultState(), 8, 8,  12, 0,  96);
		}

		//Modern Metals
		if (Loader.isModLoaded("modernmetals")) {
			logic.getDimension(-1)
					.addOre(ModBlocks.aluminumOre.getDefaultState(), 8, 8,  10, 0,  96)
					.addOre(ModBlocks.cadmiumOre.getDefaultState(), 8, 8,  10, 0,  96)
					.addOre(ModBlocks.chromiumOre.getDefaultState(), 8, 8,  10, 0,  96)
					.addOre(ModBlocks.iridiumOre.getDefaultState(), 8, 8,  10, 0,  96)
					.addOre(ModBlocks.magnesiumOre.getDefaultState(), 8, 8,  10, 0,  96)
					.addOre(ModBlocks.manganeseOre.getDefaultState(), 8, 8,  10, 0,  96)
					.addOre(ModBlocks.osmiumOre.getDefaultState(), 8, 8,  10, 0,  96)
					.addOre(ModBlocks.plutoniumOre.getDefaultState(), 8, 4,  10, 0,  96)
					.addOre(ModBlocks.rutileOre.getDefaultState(), 8, 8,  10, 0,  96)
					.addOre(ModBlocks.tantalumOre.getDefaultState(), 8, 8,  10, 0,  96)
					.addOre(ModBlocks.titaniumOre.getDefaultState(), 8, 4,  10, 0,  96)
					.addOre(ModBlocks.tungstenOre.getDefaultState(), 8, 8,  10, 0,  96)
					.addOre(ModBlocks.uraniumOre.getDefaultState(), 8, 4,  10, 0,  96)
					.addOre(ModBlocks.zirconiumOre.getDefaultState(), 8, 8,  10, 0,  96);
		}
		return logic;
	}
}
