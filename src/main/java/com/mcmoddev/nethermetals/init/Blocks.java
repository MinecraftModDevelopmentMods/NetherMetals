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
	@SuppressWarnings("static-access")
	public static void init() {
		if (initDone) {
			return;
		}

		Materials.init();


		ItemGroups.init();
		
		
		
	/**	
		
		if (Options.enableZincNetherOre) {
			createNetherOre(Materials.getMaterialByName("coal"));
		}
		if (Options.enableZincNetherOre) {
			createNetherOre(Materials.getMaterialByName("diamond"));
		}
		if (Options.enableZincNetherOre) {
			createNetherOre(Materials.getMaterialByName("emerald"));
		}
		if (Options.enableZincNetherOre) {
			createNetherOre(Materials.getMaterialByName("gold"));
		}
		if (Options.enableZincNetherOre) {
			createNetherOre(Materials.getMaterialByName("iron"));
		}
		if (Options.enableZincNetherOre) {
			createNetherOre(Materials.getMaterialByName("lapis"));
		}
		if (Options.enableZincNetherOre) {
			createNetherOre(Materials.getMaterialByName("redstone"));
		}
		
		**/
		
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
		
		

		if (Options.enableAluminumNetherOre) {
			createNetherOre(Materials.getMaterialByName("aluminum"));
		}		
		if (Options.enableCadmiumNetherOre) {
			createNetherOre(Materials.getMaterialByName("cadmium"));
		}		
		if (Options.enableChromiumNetherOre) {
			createNetherOre(Materials.getMaterialByName("chromium"));
		}		
		if (Options.enableIridiumNetherOre) {
			createNetherOre(Materials.getMaterialByName("iridium"));
		}		
		if (Options.enableMagnesiumNetherOre) {
			createNetherOre(Materials.getMaterialByName("magnesium"));
		}		
		if (Options.enableManganeseNetherOre) {
			createNetherOre(Materials.getMaterialByName("manganese"));
		}		
		if (Options.enableOsmiumNetherOre) {
			createNetherOre(Materials.getMaterialByName("osmium"));
		}		
		if (Options.enablePlutoniumNetherOre) {
			createNetherOre(Materials.getMaterialByName("plutonium"));
		}		
		if (Options.enableRutileNetherOre) {
			createNetherOre(Materials.getMaterialByName("rutile"));
		}		
		if (Options.enableTantalumNetherOre) {
			createNetherOre(Materials.getMaterialByName("tantalum"));
		}		
		if (Options.enableTitaniumNetherOre) {
			createNetherOre(Materials.getMaterialByName("titanium"));
		}		
		if (Options.enableTungstenNetherOre) {
			createNetherOre(Materials.getMaterialByName("tungsten"));
		}		
		if (Options.enableUraniumNetherOre) {
			createNetherOre(Materials.getMaterialByName("uranium"));
		}		
		if (Options.enableZirconiumNetherOre) {
			createNetherOre(Materials.getMaterialByName("zirconium"));
		}
		
		
		initDone = true;
	}
}
