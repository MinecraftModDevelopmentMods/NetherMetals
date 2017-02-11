package com.mcmoddev.nethermetals.init;

import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.nethermetals.util.Config.Options;

/**
 * This class initializes all blocks in Nether Metals.
 *
 * @author Jasmine Iwanek
 *
 */
public class Blocks extends com.mcmoddev.lib.init.Blocks {

	private static boolean initDone = false;

	/**
	 *
	 */
	public static void init() {
		if (initDone) {
			return;
		}

		Materials.init();
		ItemGroups.init();

		if (Options.enableAntimonyNetherOre) {
			createNetherOre(Materials.getMaterialByName("antimony"));

		}
		if (Options.enableBismuthNetherOre) {
			createNetherOre(Materials.getMaterialByName("bismuth"));
		}		
		if (Options.enableCopperNetherOre) {
			createNetherOre(Materials.getMaterialByName("copper"));
		}		
		if (Options.enableLeadNetherOre) {
			createNetherOre(Materials.getMaterialByName("lead"));
		}		
		if (Options.enableMercuryNetherOre) {
			createNetherOre(Materials.getMaterialByName("mercury"));
		}		
		if (Options.enableNickelNetherOre) {
			createNetherOre(Materials.getMaterialByName("nickel"));
		}		
		if (Options.enablePlatinumNetherOre) {
			createNetherOre(Materials.getMaterialByName("platinum"));
		}		
		if (Options.enableSilverNetherOre) {
			createNetherOre(Materials.getMaterialByName("silver"));
		}		
		if (Options.enableTinNetherOre) {
			createNetherOre(Materials.getMaterialByName("tin"));
		}		
		if (Options.enableZincNetherOre) {
			createNetherOre(Materials.getMaterialByName("zinc"));
		}

		initDone = true;
	}
}
