package com.mcmoddev.orespawn;

import com.google.common.base.Function;
import com.mcmoddev.lib.init.Materials;

import mmd.orespawn.api.OreSpawnAPI;
import mmd.orespawn.api.SpawnLogic;
import net.minecraftforge.fml.common.Loader;

public class NetherMetalsOreSpawn implements Function<OreSpawnAPI, SpawnLogic> {

	@Override
	public SpawnLogic apply(OreSpawnAPI api) {

		SpawnLogic logic = api.createSpawnLogic();

		// Vanilla		
		logic.getDimension(-1)
				.addOre(Materials.getMaterialByName("coal").oreNether.getDefaultState(), 8, 8,  12, 0,  96)
				.addOre(Materials.getMaterialByName("diamond").oreNether.getDefaultState(), 8, 8,  12, 0,  96)
				.addOre(Materials.getMaterialByName("emerald").oreNether.getDefaultState(), 8, 8,  12, 0,  96)
				.addOre(Materials.getMaterialByName("gold").oreNether.getDefaultState(), 8, 8,  12, 0,  96)
				.addOre(Materials.getMaterialByName("iron").oreNether.getDefaultState(), 8, 8,  12, 0,  96);
				/*
				.addOre(ModBlocks.lapisOre.getDefaultState(), 8, 8,  12, 0,  96)
				.addOre(ModBlocks.redstoneOre.getDefaultState(), 8, 8,  12, 0,  96);
		 		*/

		//Base Metals
		if (Loader.isModLoaded("basemetals")) {
			logic.getDimension(-1)
					.addOre(Materials.getMaterialByName("antimony").oreNether.getDefaultState(), 8, 4, 10, 0,  32)
					.addOre(Materials.getMaterialByName("antimony").oreNether.getDefaultState(), 8, 4,  10, 0,  32)
					.addOre(Materials.getMaterialByName("antimony").oreNether.getDefaultState(), 8, 12,  20, 0,  96)
					.addOre(Materials.getMaterialByName("antimony").oreNether.getDefaultState(), 8, 12,  20, 0,  96)
					.addOre(Materials.getMaterialByName("antimony").oreNether.getDefaultState(), 8, 4,  10, 0,  32)
					.addOre(Materials.getMaterialByName("antimony").oreNether.getDefaultState(), 8, 4,  10, 0,  96)
					.addOre(Materials.getMaterialByName("antimony").oreNether.getDefaultState(), 8, 4,  10, 0,  32)
					.addOre(Materials.getMaterialByName("antimony").oreNether.getDefaultState(), 8, 8,  10, 0,  32)
					.addOre(Materials.getMaterialByName("antimony").oreNether.getDefaultState(), 8, 12,  20, 0,  96)
					.addOre(Materials.getMaterialByName("antimony").oreNether.getDefaultState(), 8, 8,  12, 0,  96);
		}

		//Modern Metals
		if (Loader.isModLoaded("modernmetals")) {
			logic.getDimension(-1)
					.addOre(Materials.getMaterialByName("aluminum").oreNether.getDefaultState(), 8, 8,  10, 0,  96)
					.addOre(Materials.getMaterialByName("cadmium").oreNether.getDefaultState(), 8, 8,  10, 0,  96)
					.addOre(Materials.getMaterialByName("chromium").oreNether.getDefaultState(), 8, 8,  10, 0,  96)
					.addOre(Materials.getMaterialByName("iridium").oreNether.getDefaultState(), 8, 8,  10, 0,  96)
					.addOre(Materials.getMaterialByName("magnesium").oreNether.getDefaultState(), 8, 8,  10, 0,  96)
					.addOre(Materials.getMaterialByName("manganese").oreNether.getDefaultState(), 8, 8,  10, 0,  96)
					.addOre(Materials.getMaterialByName("osmium").oreNether.getDefaultState(), 8, 8,  10, 0,  96)
					.addOre(Materials.getMaterialByName("plutonium").oreNether.getDefaultState(), 8, 4,  10, 0,  96)
					.addOre(Materials.getMaterialByName("rutile").oreNether.getDefaultState(), 8, 8,  10, 0,  96)
					.addOre(Materials.getMaterialByName("tantalum").oreNether.getDefaultState(), 8, 8,  10, 0,  96)
					.addOre(Materials.getMaterialByName("titanium").oreNether.getDefaultState(), 8, 4,  10, 0,  96)
					.addOre(Materials.getMaterialByName("tungsten").oreNether.getDefaultState(), 8, 8,  10, 0,  96)
					.addOre(Materials.getMaterialByName("uranium").oreNether.getDefaultState(), 8, 4,  10, 0,  96)
					.addOre(Materials.getMaterialByName("zirconium").oreNether.getDefaultState(), 8, 8,  10, 0,  96);
		}

		return logic;
	}
}
