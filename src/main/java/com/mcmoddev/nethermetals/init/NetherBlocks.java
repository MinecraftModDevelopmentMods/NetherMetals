package com.mcmoddev.nethermetals.init;

import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.init.Materials;
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
		
		createNetherOreWrapper(Options.isMaterialEnabled("enableCoalNetherOre"), "coal");
		createNetherOreWrapper(Options.isMaterialEnabled("enableDiamondNetherOre"), "diamond");
		createNetherOreWrapper(Options.isMaterialEnabled("enableEmeraldNetherOre"), "emerald");
		createNetherOreWrapper(Options.isMaterialEnabled("enableGoldNetherOre"), "gold");
		createNetherOreWrapper(Options.isMaterialEnabled("enableIronNetherOre"), "iron");
		createNetherOreWrapper(Options.isMaterialEnabled("enableLapisNetherOre"), "lapis");
		createNetherOreWrapper(Options.isMaterialEnabled("enableRedstoneNetherOre"), "redstone");

		if (Loader.isModLoaded("basemetals")) {
			createNetherOreWrapper(Options.isMaterialEnabled("enableAntimonyNetherOre"), "antimony");
			createNetherOreWrapper(Options.isMaterialEnabled("enableBismuthNetherOre"), "bismuth");
			createNetherOreWrapper(Options.isMaterialEnabled("enableCopperNetherOre"), "copper");
			createNetherOreWrapper(Options.isMaterialEnabled("enableLeadNetherOre"), "lead");
			createNetherOreWrapper(Options.isMaterialEnabled("enableMercuryNetherOre"), "mercury");
			createNetherOreWrapper(Options.isMaterialEnabled("enableNickelNetherOre"), "nickel");
			createNetherOreWrapper(Options.isMaterialEnabled("enablePlatinumNetherOre"), "platinum");
			createNetherOreWrapper(Options.isMaterialEnabled("enableSilverNetherOre"), "silver");
			createNetherOreWrapper(Options.isMaterialEnabled("enableTinNetherOre"), "tin");
			createNetherOreWrapper(Options.isMaterialEnabled("enableZincNetherOre"), "zinc");
		}
		
		if (Loader.isModLoaded("modernmetals")) {
			createNetherOreWrapper(Options.isMaterialEnabled("enableAluminumNetherOre"), "aluminum");
			createNetherOreWrapper(Options.isMaterialEnabled("enableCadmiumNetherOre"), "cadmium");
			createNetherOreWrapper(Options.isMaterialEnabled("enableChromiumNetherOre"), "chromium");
			createNetherOreWrapper(Options.isMaterialEnabled("enableIridiumNetherOre"), "iridium");
			createNetherOreWrapper(Options.isMaterialEnabled("enableMagnesiumNetherOre"), "magnesium");
			createNetherOreWrapper(Options.isMaterialEnabled("enableManganeseNetherOre"), "manganese");
			createNetherOreWrapper(Options.isMaterialEnabled("enableOsmiumNetherOre"), "osmium");
			createNetherOreWrapper(Options.isMaterialEnabled("enablePlutoniumNetherOre"), "plutonium");
			createNetherOreWrapper(Options.isMaterialEnabled("enableRutileNetherOre"), "rutile");
			createNetherOreWrapper(Options.isMaterialEnabled("enableTantalumNetherOre"), "tantalum");
			createNetherOreWrapper(Options.isMaterialEnabled("enableTitaniumNetherOre"), "titanium");
			createNetherOreWrapper(Options.isMaterialEnabled("enableTungstenNetherOre"), "tungsten");
			createNetherOreWrapper(Options.isMaterialEnabled("enableUraniumNetherOre"), "uranium");
			createNetherOreWrapper(Options.isMaterialEnabled("enableZirconiumNetherOre"), "zirconium");
		}
		
		initDone = true;
	}

	private static void createNetherOreWrapper(boolean enabled, String materialName ) {
		if (enabled && Materials.hasMaterial(materialName)) {
			create(Names.NETHERORE, Materials.getMaterialByName(materialName), ItemGroups.blocksTab);
		}
	}	
}
