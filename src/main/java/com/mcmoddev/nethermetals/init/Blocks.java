package com.mcmoddev.nethermetals.init;

import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.material.MetalMaterial;
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

	/**
	 *
	 */
	public static void init() {
		if (initDone) {
			return;
		}

		Materials.init();
//		ItemGroups.init();

		createNetherOreWrapper(Options.enableCoalNetherOre, Materials.getMaterialByName("coal"));
		createNetherOreWrapper(Options.enableDiamondNetherOre, Materials.getMaterialByName("diamond"));
		createNetherOreWrapper(Options.enableEmeraldNetherOre, Materials.getMaterialByName("emerald"));
		createNetherOreWrapper(Options.enableGoldNetherOre, Materials.getMaterialByName("gold"));
		createNetherOreWrapper(Options.enableIronNetherOre, Materials.getMaterialByName("iron"));
		createNetherOreWrapper(Options.enableLapisNetherOre, Materials.getMaterialByName("lapis"));
		createNetherOreWrapper(Options.enableRedstoneNetherOre, Materials.getMaterialByName("redstone"));

		createNetherOreWrapper(Options.enableAntimonyNetherOre, Materials.getMaterialByName("antimony"));
		createNetherOreWrapper(Options.enableBismuthNetherOre, Materials.getMaterialByName("bismuth"));
		createNetherOreWrapper(Options.enableCopperNetherOre, Materials.getMaterialByName("copper"));
		createNetherOreWrapper(Options.enableLeadNetherOre, Materials.getMaterialByName("lead"));
		createNetherOreWrapper(Options.enableMercuryNetherOre, Materials.getMaterialByName("mercury"));
		createNetherOreWrapper(Options.enableNickelNetherOre, Materials.getMaterialByName("nickel"));
		createNetherOreWrapper(Options.enablePlatinumNetherOre, Materials.getMaterialByName("platinum"));
		createNetherOreWrapper(Options.enableSilverNetherOre, Materials.getMaterialByName("silver"));
		createNetherOreWrapper(Options.enableTinNetherOre, Materials.getMaterialByName("tin"));
		createNetherOreWrapper(Options.enableZincNetherOre, Materials.getMaterialByName("zinc"));

		createNetherOreWrapper(Options.enableAluminumNetherOre, Materials.getMaterialByName("aluminum"));
		createNetherOreWrapper(Options.enableCadmiumNetherOre, Materials.getMaterialByName("cadmium"));
		createNetherOreWrapper(Options.enableChromiumNetherOre, Materials.getMaterialByName("chromium"));
		createNetherOreWrapper(Options.enableIridiumNetherOre, Materials.getMaterialByName("iridium"));
		createNetherOreWrapper(Options.enableMagnesiumNetherOre, Materials.getMaterialByName("magnesium"));
		createNetherOreWrapper(Options.enableManganeseNetherOre, Materials.getMaterialByName("manganese"));
		createNetherOreWrapper(Options.enableOsmiumNetherOre, Materials.getMaterialByName("osmium"));
		createNetherOreWrapper(Options.enablePlutoniumNetherOre, Materials.getMaterialByName("plutonium"));
		createNetherOreWrapper(Options.enableRutileNetherOre, Materials.getMaterialByName("rutile"));
		createNetherOreWrapper(Options.enableTantalumNetherOre, Materials.getMaterialByName("tantalum"));
		createNetherOreWrapper(Options.enableTitaniumNetherOre, Materials.getMaterialByName("titanium"));
		createNetherOreWrapper(Options.enableTungstenNetherOre, Materials.getMaterialByName("tungsten"));
		createNetherOreWrapper(Options.enableUraniumNetherOre, Materials.getMaterialByName("uranium"));
		createNetherOreWrapper(Options.enableZirconiumNetherOre, Materials.getMaterialByName("zirconium"));

		initDone = true;
	}

	private static void createNetherOreWrapper(boolean enabled, MetalMaterial material) {
		if (enabled) {
			if (material != null) {
				NetherMetals.logger.error("Creating Nether Ore for: " + material.getName());
				createNetherOre(material);				
			} else {
				NetherMetals.logger.error("material was null!");
			}
		}
	}
}
