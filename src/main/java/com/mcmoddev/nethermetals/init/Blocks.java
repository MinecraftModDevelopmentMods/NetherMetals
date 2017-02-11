package com.mcmoddev.nethermetals.init;

import com.mcmoddev.nethermetals.util.Config.Options;

/**
 * This class initializes all blocks in Modern Metals.
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

		MaterialsNetherOre.init();
		ItemGroups.init();

		if (Options.enableAntimonyNetherOre) {
			createNetherOre(MaterialsNetherOre.antimony);	

		}
		if (Options.enableBismuthNetherOre) {
			createNetherOre(MaterialsNetherOre.bismuth);
		}		
		if (Options.enableCopperNetherOre) {
			createNetherOre(MaterialsNetherOre.copper);
		}		
		if (Options.enableLeadNetherOre) {
			createNetherOre(MaterialsNetherOre.lead);
		}		
		if (Options.enableMercuryNetherOre) {
			createNetherOre(MaterialsNetherOre.mercury);
		}		
		if (Options.enableNickelNetherOre) {
			createNetherOre(MaterialsNetherOre.nickel);
		}		
		if (Options.enablePlatinumNetherOre) {
			createNetherOre(MaterialsNetherOre.platinum);
		}		
		if (Options.enableSilverNetherOre) {
			createNetherOre(MaterialsNetherOre.silver);
		}		
		if (Options.enableTinNetherOre) {
			createNetherOre(MaterialsNetherOre.tin);
		}		
		if (Options.enableZincNetherOre) {
			createNetherOre(MaterialsNetherOre.zinc);
		}
		
		
		
		

		initDone = true;
	}
}
