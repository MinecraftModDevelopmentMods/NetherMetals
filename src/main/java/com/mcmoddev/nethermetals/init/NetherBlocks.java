package com.mcmoddev.nethermetals.init;

import com.mcmoddev.lib.block.*;
import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.data.SharedStrings;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.util.Oredicts;

import net.minecraft.block.Block;
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

		createVanillaNetherOreWrapper("coal");
		createVanillaNetherOreWrapper("diamond");
		createVanillaNetherOreWrapper("emerald");
		createVanillaNetherOreWrapper("gold");
		createVanillaNetherOreWrapper("iron");
		createVanillaNetherOreWrapper("lapis");
		createVanillaNetherOreWrapper("redstone");

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

	private static void createVanillaNetherOreWrapper(String materialName) {
		final MMDMaterial material = Materials.getMaterialByName(materialName);
			material.addNewBlock(Names.NETHERORE, addBlock(new BlockMMDNetherOre(material), Names.NETHERORE.toString(), material, ItemGroups.getTab(SharedStrings.TAB_BLOCKS)));
			final Block b = material.getBlock(Names.NETHERORE);
			final String oredict = getOredictFromName(Names.NETHERORE);
			if ((oredict != null) && (b != null)) {
				Oredicts.registerOre(oredict + material.getCapitalizedName(), b);
			}
	}

	private static void createNetherOreWrapper(String materialName ) {
		if (Materials.hasMaterial(materialName)) {
			create(Names.NETHERORE, materialName);
		}
	}	
}
