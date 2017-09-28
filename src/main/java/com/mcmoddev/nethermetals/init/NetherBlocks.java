package com.mcmoddev.nethermetals.init;

import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.nethermetals.NetherMetals;
import com.mcmoddev.lib.util.ConfigBase.Options;

import net.minecraftforge.fml.common.Loader;

/**
 * This class initializes all blocks in Nether Metals.
 *
 * @author Jasmine Iwanek
 *
 */
public class NetherBlocks extends com.mcmoddev.lib.init.Blocks {

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
		
		createNetherOreWrapper(Options.isMaterialEnabled("enableCoalNetherOre"), Materials.getMaterialByName("coal"));
		createNetherOreWrapper(Options.isMaterialEnabled("enableDiamondNetherOre"), Materials.getMaterialByName("diamond"));
		createNetherOreWrapper(Options.isMaterialEnabled("enableEmeraldNetherOre"), Materials.getMaterialByName("emerald"));
		createNetherOreWrapper(Options.isMaterialEnabled("enableGoldNetherOre"), Materials.getMaterialByName("gold"));
		createNetherOreWrapper(Options.isMaterialEnabled("enableIronNetherOre"), Materials.getMaterialByName("iron"));
		createNetherOreWrapper(Options.isMaterialEnabled("enableLapisNetherOre"), Materials.getMaterialByName("lapis"));
		createNetherOreWrapper(Options.isMaterialEnabled("enableRedstoneNetherOre"), Materials.getMaterialByName("redstone"));

		if (Loader.isModLoaded("basemetals")) {
			createNetherOreWrapper(Options.isMaterialEnabled("enableAntimonyNetherOre"), Materials.getMaterialByName("antimony"));
			createNetherOreWrapper(Options.isMaterialEnabled("enableBismuthNetherOre"), Materials.getMaterialByName("bismuth"));
			createNetherOreWrapper(Options.isMaterialEnabled("enableCopperNetherOre"), Materials.getMaterialByName("copper"));
			createNetherOreWrapper(Options.isMaterialEnabled("enableLeadNetherOre"), Materials.getMaterialByName("lead"));
			createNetherOreWrapper(Options.isMaterialEnabled("enableMercuryNetherOre"), Materials.getMaterialByName("mercury"));
			createNetherOreWrapper(Options.isMaterialEnabled("enableNickelNetherOre"), Materials.getMaterialByName("nickel"));
			createNetherOreWrapper(Options.isMaterialEnabled("enablePlatinumNetherOre"), Materials.getMaterialByName("platinum"));
			createNetherOreWrapper(Options.isMaterialEnabled("enableSilverNetherOre"), Materials.getMaterialByName("silver"));
			createNetherOreWrapper(Options.isMaterialEnabled("enableTinNetherOre"), Materials.getMaterialByName("tin"));
			createNetherOreWrapper(Options.isMaterialEnabled("enableZincNetherOre"), Materials.getMaterialByName("zinc"));
		}
		
		if (Loader.isModLoaded("modernmetals")) {
			createNetherOreWrapper(Options.isMaterialEnabled("enableAluminumNetherOre"), Materials.getMaterialByName("aluminum"));
			createNetherOreWrapper(Options.isMaterialEnabled("enableCadmiumNetherOre"), Materials.getMaterialByName("cadmium"));
			createNetherOreWrapper(Options.isMaterialEnabled("enableChromiumNetherOre"), Materials.getMaterialByName("chromium"));
			createNetherOreWrapper(Options.isMaterialEnabled("enableIridiumNetherOre"), Materials.getMaterialByName("iridium"));
			createNetherOreWrapper(Options.isMaterialEnabled("enableMagnesiumNetherOre"), Materials.getMaterialByName("magnesium"));
			createNetherOreWrapper(Options.isMaterialEnabled("enableManganeseNetherOre"), Materials.getMaterialByName("manganese"));
			createNetherOreWrapper(Options.isMaterialEnabled("enableOsmiumNetherOre"), Materials.getMaterialByName("osmium"));
			createNetherOreWrapper(Options.isMaterialEnabled("enablePlutoniumNetherOre"), Materials.getMaterialByName("plutonium"));
			createNetherOreWrapper(Options.isMaterialEnabled("enableRutileNetherOre"), Materials.getMaterialByName("rutile"));
			createNetherOreWrapper(Options.isMaterialEnabled("enableTantalumNetherOre"), Materials.getMaterialByName("tantalum"));
			createNetherOreWrapper(Options.isMaterialEnabled("enableTitaniumNetherOre"), Materials.getMaterialByName("titanium"));
			createNetherOreWrapper(Options.isMaterialEnabled("enableTungstenNetherOre"), Materials.getMaterialByName("tungsten"));
			createNetherOreWrapper(Options.isMaterialEnabled("enableUraniumNetherOre"), Materials.getMaterialByName("uranium"));
			createNetherOreWrapper(Options.isMaterialEnabled("enableZirconiumNetherOre"), Materials.getMaterialByName("zirconium"));
		}
		initDone = true;
	}

	private static void createNetherOreWrapper(boolean enabled, MMDMaterial material) {
		if (enabled) {
			if (material != null) {
				create(com.mcmoddev.lib.data.Names.NETHERORE, material, ItemGroups.blocksTab);
			} else {
				NetherMetals.logger.error("material was null!");
			}
		}
	}
}
