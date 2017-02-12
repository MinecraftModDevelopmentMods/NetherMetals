package com.mcmoddev.nethermetals.init;

import com.mcmoddev.nethermetals.NetherMetals;
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

		nmmat.init();
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
			createNetherOre(nmmat.getMaterialByName("antimony"));

		}
		if (Options.enableBismuthNetherOre) {
			createNetherOre(nmmat.getMaterialByName("bismuth"));
		}		
		if (Options.enableCopperNetherOre) {
			createNetherOre(nmmat.getMaterialByName("copper"));
		}		
		if (Options.enableLeadNetherOre) {
			createNetherOre(nmmat.getMaterialByName("lead"));
		}		
		if (Options.enableMercuryNetherOre) {
			createNetherOre(nmmat.getMaterialByName("mercury"));
		}		
		if (Options.enableNickelNetherOre) {
			createNetherOre(nmmat.getMaterialByName("nickel"));
		}		
		if (Options.enablePlatinumNetherOre) {
			createNetherOre(nmmat.getMaterialByName("platinum"));
		}		
		if (Options.enableSilverNetherOre) {
			createNetherOre(nmmat.getMaterialByName("silver"));
		}		
		if (Options.enableTinNetherOre) {
			createNetherOre(nmmat.getMaterialByName("tin"));
		}		
		if (Options.enableZincNetherOre) {
			createNetherOre(nmmat.getMaterialByName("zinc"));
		}
		
		

		if (Options.enableAluminumNetherOre) {
			createNetherOre(nmmat.getMaterialByName("aluminum"));
		}		
		if (Options.enableCadmiumNetherOre) {
			createNetherOre(nmmat.getMaterialByName("cadmium"));
		}		
		if (Options.enableChromiumNetherOre) {
			createNetherOre(nmmat.getMaterialByName("chromium"));
		}		
		if (Options.enableIridiumNetherOre) {
			createNetherOre(nmmat.getMaterialByName("iridium"));
		}		
		if (Options.enableMagnesiumNetherOre) {
			createNetherOre(nmmat.getMaterialByName("magnesium"));
		}		
		if (Options.enableManganeseNetherOre) {
			createNetherOre(nmmat.getMaterialByName("manganese"));
		}		
		if (Options.enableOsmiumNetherOre) {
			createNetherOre(nmmat.getMaterialByName("osmium"));
		}		
		if (Options.enablePlutoniumNetherOre) {
			createNetherOre(nmmat.getMaterialByName("plutonium"));
		}		
		if (Options.enableRutileNetherOre) {
			createNetherOre(nmmat.getMaterialByName("rutile"));
		}		
		if (Options.enableTantalumNetherOre) {
			createNetherOre(nmmat.getMaterialByName("tantalum"));
		}		
		if (Options.enableTitaniumNetherOre) {
			createNetherOre(nmmat.getMaterialByName("titanium"));
		}		
		if (Options.enableTungstenNetherOre) {
			createNetherOre(nmmat.getMaterialByName("tungsten"));
		}		
		if (Options.enableUraniumNetherOre) {
			createNetherOre(nmmat.getMaterialByName("uranium"));
		}		
		if (Options.enableZirconiumNetherOre) {
			createNetherOre(nmmat.getMaterialByName("zirconium"));
		}
		
		
		initDone = true;
	}
}
