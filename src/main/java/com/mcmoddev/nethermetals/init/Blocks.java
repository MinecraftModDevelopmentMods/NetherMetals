package com.mcmoddev.nethermetals.init;

import com.mcmoddev.nethermetals.util.Config.Options;

/**
 * This class initializes all blocks in Nether Metals.
 *
 * @author Jasmine Iwanek
 *
 */
public class Blocks extends com.mcmoddev.lib.init.Blocks {

	private static boolean initDone = false;
	public static com.mcmoddev.lib.init.Materials mmdlibMat;
	public static com.mcmoddev.basemetals.init.Materials bmmat;
	public static com.mcmoddev.modernmetals.init.Materials mmmat;
	public static com.mcmoddev.nethermetals.init.Materials nmmat;



	/**
	 *
	 */
	@SuppressWarnings("static-access")
	public static void init() {
		if (initDone) {
			return;
		}

		mmdlibMat.init();
		bmmat.init();
		mmmat.init();

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
			createNetherOre(mmdlibMat.getMaterialByName("antimony"));

		}
		if (Options.enableBismuthNetherOre) {
			createNetherOre(mmdlibMat.getMaterialByName("bismuth"));
		}		
		if (Options.enableCopperNetherOre) {
			createNetherOre(mmdlibMat.getMaterialByName("copper"));
		}		
		if (Options.enableLeadNetherOre) {
			createNetherOre(mmdlibMat.getMaterialByName("lead"));
		}		
		if (Options.enableMercuryNetherOre) {
			createNetherOre(mmdlibMat.getMaterialByName("mercury"));
		}		
		if (Options.enableNickelNetherOre) {
			createNetherOre(mmdlibMat.getMaterialByName("nickel"));
		}		
		if (Options.enablePlatinumNetherOre) {
			createNetherOre(mmdlibMat.getMaterialByName("platinum"));
		}		
		if (Options.enableSilverNetherOre) {
			createNetherOre(mmdlibMat.getMaterialByName("silver"));
		}		
		if (Options.enableTinNetherOre) {
			createNetherOre(mmdlibMat.getMaterialByName("tin"));
		}		
		if (Options.enableZincNetherOre) {
			createNetherOre(mmdlibMat.getMaterialByName("zinc"));
		}
		
		

		if (Options.enableAluminumNetherOre) {
			createNetherOre(mmdlibMat.getMaterialByName("aluminum"));
		}		
		if (Options.enableCadmiumNetherOre) {
			createNetherOre(mmdlibMat.getMaterialByName("cadmium"));
		}		
		if (Options.enableChromiumNetherOre) {
			createNetherOre(mmdlibMat.getMaterialByName("chromium"));
		}		
		if (Options.enableIridiumNetherOre) {
			createNetherOre(mmdlibMat.getMaterialByName("iridium"));
		}		
		if (Options.enableMagnesiumNetherOre) {
			createNetherOre(mmdlibMat.getMaterialByName("magnesium"));
		}		
		if (Options.enableManganeseNetherOre) {
			createNetherOre(mmdlibMat.getMaterialByName("manganese"));
		}		
		if (Options.enableOsmiumNetherOre) {
			createNetherOre(mmdlibMat.getMaterialByName("osmium"));
		}		
		if (Options.enablePlutoniumNetherOre) {
			createNetherOre(mmdlibMat.getMaterialByName("plutonium"));
		}		
		if (Options.enableRutileNetherOre) {
			createNetherOre(mmdlibMat.getMaterialByName("rutile"));
		}		
		if (Options.enableTantalumNetherOre) {
			createNetherOre(mmdlibMat.getMaterialByName("tantalum"));
		}		
		if (Options.enableTitaniumNetherOre) {
			createNetherOre(mmdlibMat.getMaterialByName("titanium"));
		}		
		if (Options.enableTungstenNetherOre) {
			createNetherOre(mmdlibMat.getMaterialByName("tungsten"));
		}		
		if (Options.enableUraniumNetherOre) {
			createNetherOre(mmdlibMat.getMaterialByName("uranium"));
		}		
		if (Options.enableZirconiumNetherOre) {
			createNetherOre(mmdlibMat.getMaterialByName("zirconium"));
		}
		
		
		initDone = true;
	}
}
