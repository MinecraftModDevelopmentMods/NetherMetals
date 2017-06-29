package com.mcmoddev.orespawn;

import com.google.common.base.Function;
import com.mcmoddev.basemetals.data.MaterialNames;
import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.nethermetals.NetherMetals;
import com.mcmoddev.orespawn.api.OreSpawnAPI;
import com.mcmoddev.orespawn.api.SpawnLogic;
import net.minecraftforge.fml.common.Loader;

public class NetherMetalsOreSpawn implements Function<OreSpawnAPI, SpawnLogic> {

	@Override
	public SpawnLogic apply(OreSpawnAPI api) {

		SpawnLogic logic = api.createSpawnLogic();

		// Vanilla
		logic.getDimension(-1)
		.addOre(Materials.getMaterialByName("coal").getBlock(Names.NETHERORE).getDefaultState(), 10, 8,  12, 0,  200)
		.addOre(Materials.getMaterialByName("diamond").getBlock(Names.NETHERORE).getDefaultState(), 2, 8,  12, 0,  200)
		.addOre(Materials.getMaterialByName("emerald").getBlock(Names.NETHERORE).getDefaultState(), 4, 8,  12, 0,  200)
		.addOre(Materials.getMaterialByName("gold").getBlock(Names.NETHERORE).getDefaultState(), 5, 8,  12, 0,  200)
		.addOre(Materials.getMaterialByName("iron").getBlock(Names.NETHERORE).getDefaultState(), 10, 8,  12, 0,  200)
		.addOre(Materials.getMaterialByName("lapis").getBlock(Names.NETHERORE).getDefaultState(), 8, 8,  12, 0,  96)
		.addOre(Materials.getMaterialByName("redstone").getBlock(Names.NETHERORE).getDefaultState(), 8, 8,  12, 0,  96);

		//Base Metals
		if (Loader.isModLoaded("basemetals")) {
			if (com.mcmoddev.basemetals.util.Config.Options.materialEnabled(MaterialNames.ANTIMONY)) {
				logic.getDimension(-1).addOre(Materials.getMaterialByName("antimony").getBlock(Names.NETHERORE).getDefaultState(), 8, 4, 10, 0,  200);
			}

			if (com.mcmoddev.basemetals.util.Config.Options.materialEnabled(MaterialNames.BISMUTH)) {
				logic.getDimension(-1).addOre(Materials.getMaterialByName("bismuth").getBlock(Names.NETHERORE).getDefaultState(), 8, 4,  10, 0,  200);
			}

			if (com.mcmoddev.basemetals.util.Config.Options.materialEnabled(MaterialNames.COPPER)) {
				logic.getDimension(-1).addOre(Materials.getMaterialByName("copper").getBlock(Names.NETHERORE).getDefaultState(), 10, 12,  20, 0,  200);
			}

			if (com.mcmoddev.basemetals.util.Config.Options.materialEnabled(MaterialNames.LEAD)) {
				logic.getDimension(-1).addOre(Materials.getMaterialByName("lead").getBlock(Names.NETHERORE).getDefaultState(), 8, 12,  20, 0,  200);
			}

			if (com.mcmoddev.basemetals.util.Config.Options.materialEnabled(MaterialNames.MERCURY)) {
				logic.getDimension(-1).addOre(Materials.getMaterialByName("mercury").getBlock(Names.NETHERORE).getDefaultState(), 4, 4,  10, 0,  200);
			}

			if (com.mcmoddev.basemetals.util.Config.Options.materialEnabled(MaterialNames.NICKEL)) {
				logic.getDimension(-1).addOre(Materials.getMaterialByName("nickel").getBlock(Names.NETHERORE).getDefaultState(), 6, 4,  10, 0,  200);
			}

			if (com.mcmoddev.basemetals.util.Config.Options.materialEnabled(MaterialNames.PLATINUM)) {
				logic.getDimension(-1).addOre(Materials.getMaterialByName("platinum").getBlock(Names.NETHERORE).getDefaultState(), 2, 4,  10, 0,  200);
			}

			if (com.mcmoddev.basemetals.util.Config.Options.materialEnabled(MaterialNames.SILVER)) {
				logic.getDimension(-1).addOre(Materials.getMaterialByName("silver").getBlock(Names.NETHERORE).getDefaultState(), 8, 8,  10, 0,  200);
			}

			if (com.mcmoddev.basemetals.util.Config.Options.materialEnabled(MaterialNames.TIN)) {
				logic.getDimension(-1).addOre(Materials.getMaterialByName("tin").getBlock(Names.NETHERORE).getDefaultState(), 10, 12,  20, 0,  200);
			}

			if (com.mcmoddev.basemetals.util.Config.Options.materialEnabled(MaterialNames.ZINC)) {
				logic.getDimension(-1).addOre(Materials.getMaterialByName("zinc").getBlock(Names.NETHERORE).getDefaultState(), 6, 8,  12, 0,  200);
			}


		}

		//Modern Metals
		if (Loader.isModLoaded("modernmetals")) {
			if (com.mcmoddev.modernmetals.util.Config.Options.enableAluminum) {
				logic.getDimension(-1).addOre(Materials.getMaterialByName("aluminum").getBlock(Names.NETHERORE).getDefaultState(), 10, 8,  10, 0,  200);
			}

			if (com.mcmoddev.modernmetals.util.Config.Options.enableCadmium) {
				logic.getDimension(-1).addOre(Materials.getMaterialByName("cadmium").getBlock(Names.NETHERORE).getDefaultState(), 4, 8,  10, 0,  200);
			}

			if (com.mcmoddev.modernmetals.util.Config.Options.enableChromium) {
				logic.getDimension(-1).addOre(Materials.getMaterialByName("chromium").getBlock(Names.NETHERORE).getDefaultState(), 4, 8,  10, 0,  200);
			}

			if (com.mcmoddev.modernmetals.util.Config.Options.enableIridium) {
				logic.getDimension(-1).addOre(Materials.getMaterialByName("iridium").getBlock(Names.NETHERORE).getDefaultState(), 6, 8,  10, 0,  200);
			}

			if (com.mcmoddev.modernmetals.util.Config.Options.enableMagnesium) {
				logic.getDimension(-1).addOre(Materials.getMaterialByName("magnesium").getBlock(Names.NETHERORE).getDefaultState(), 6, 8,  10, 0,  200);
			}

			if (com.mcmoddev.modernmetals.util.Config.Options.enableManganese) {
				logic.getDimension(-1).addOre(Materials.getMaterialByName("manganese").getBlock(Names.NETHERORE).getDefaultState(), 6, 8,  10, 0,  200);
			}

			if (com.mcmoddev.modernmetals.util.Config.Options.enableOsmium) {
				logic.getDimension(-1).addOre(Materials.getMaterialByName("osmium").getBlock(Names.NETHERORE).getDefaultState(), 10, 8,  10, 0,  200);
			}

			if (com.mcmoddev.modernmetals.util.Config.Options.enablePlutonium) {
				logic.getDimension(-1).addOre(Materials.getMaterialByName("plutonium").getBlock(Names.NETHERORE).getDefaultState(), 4, 4,  10, 0,  200);
			}

			if (com.mcmoddev.modernmetals.util.Config.Options.enableRutile) {
				logic.getDimension(-1).addOre(Materials.getMaterialByName("rutile").getBlock(Names.NETHERORE).getDefaultState(), 8, 8,  10, 0,  200);
			}

			if (com.mcmoddev.modernmetals.util.Config.Options.enableTantalum) {
				logic.getDimension(-1).addOre(Materials.getMaterialByName("tantalum").getBlock(Names.NETHERORE).getDefaultState(), 8, 8,  10, 0,  200);
			}

			if (com.mcmoddev.modernmetals.util.Config.Options.enableTitanium) {
				logic.getDimension(-1).addOre(Materials.getMaterialByName("titanium").getBlock(Names.NETHERORE).getDefaultState(), 4, 4,  10, 0,  200);
			}

			if (com.mcmoddev.modernmetals.util.Config.Options.enableTungsten) {
				logic.getDimension(-1).addOre(Materials.getMaterialByName("tungsten").getBlock(Names.NETHERORE).getDefaultState(), 8, 8,  10, 0,  200);
			}

			if (com.mcmoddev.modernmetals.util.Config.Options.enableUranium) {
				logic.getDimension(-1).addOre(Materials.getMaterialByName("uranium").getBlock(Names.NETHERORE).getDefaultState(), 2, 4,  10, 0,  200);
			}

			if (com.mcmoddev.modernmetals.util.Config.Options.enableZirconium) {
				logic.getDimension(-1).addOre(Materials.getMaterialByName("zirconium").getBlock(Names.NETHERORE).getDefaultState(), 8, 8,  10, 0,  200);
			}
		}

		return logic;
	}
}
