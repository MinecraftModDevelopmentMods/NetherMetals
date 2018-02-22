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
		
		createNetherOreWrapper("coal");
		createNetherOreWrapper("diamond");
		createNetherOreWrapper("emerald");
		createNetherOreWrapper("gold");
		createNetherOreWrapper("iron");
		createNetherOreWrapper("lapis");
		createNetherOreWrapper("redstone");

		if (Loader.isModLoaded("basemetals")) {
			createNetherOreWrapper("antimony");
			createNetherOreWrapper("bismuth");
			createNetherOreWrapper("copper");
			createNetherOreWrapper("lead");
			createNetherOreWrapper("mercury");
			createNetherOreWrapper("nickel");
			createNetherOreWrapper("platinum");
			createNetherOreWrapper("silver");
			createNetherOreWrapper("tin");
			createNetherOreWrapper("zinc");
		}
		
		if (Loader.isModLoaded("modernmetals")) {
			createNetherOreWrapper("aluminum");
			createNetherOreWrapper("cadmium");
			createNetherOreWrapper("chromium");
			createNetherOreWrapper("iridium");
			createNetherOreWrapper("magnesium");
			createNetherOreWrapper("manganese");
			createNetherOreWrapper("osmium");
			createNetherOreWrapper("plutonium");
			createNetherOreWrapper("rutile");
			createNetherOreWrapper("tantalum");
			createNetherOreWrapper("titanium");
			createNetherOreWrapper("tungsten");
			createNetherOreWrapper("uranium");
			createNetherOreWrapper("zirconium");
		}
		
		initDone = true;
	}

	private static void createNetherOreWrapper(String materialName ) {
		if (Materials.hasMaterial(materialName)) {
//			create(Names.NETHERORE, Materials.getMaterialByName(materialName));
			create(Names.NETHERORE, materialName);
		}
	}	
}
