package com.mcmoddev.nethermetals.init;

import java.util.Arrays;
import java.util.List;

import com.mcmoddev.lib.block.*;
import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.data.SharedStrings;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.util.Oredicts;
import com.mcmoddev.nethermetals.NetherMetals;

import net.minecraft.block.Block;

/**
 * This class initializes all blocks in Nether Metals.
 *
 * @author Jasmine Iwanek
 *
 */
public class NetherBlocks extends com.mcmoddev.lib.init.Blocks {
	/**
	 *
	 */
	public static void init() {
/*		Materials.init();
		ItemGroups.init();
*/
		List<String> knownMaterials = Arrays.asList("coal", "diamond", "emerald", "gold", "iron", "lapis",
				"redstone", "antimony", "bismuth", "copper", "lead", "mercury", "nickel", "platinum",
				"silver", "tin", "zinc", "aluminum", "cadmium", "chromium", "iridium", "magnesium",
				"manganese", "osmium", "plutonium", "rutile", "tantalum", "titanium", "tungsten",
				"uranium", "zirconium");
		Materials.getAllMaterials().stream()
		.map(mat -> mat.getName())
		.filter(knownMaterials::contains)
		.forEach(NetherBlocks::createNetherOreWrapper);
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

	private static void createBasicNetherOreWrapper(String materialName ) {
		create(Names.NETHERORE, materialName);
	}
	
	private static void createNetherOreWrapper(String materialName) {
		List<String> vanillaMats = Arrays.asList("coal", "diamond", "emerald", "gold", "iron", "lapis", "redstone");
		NetherMetals.logger.fatal("Creating NetherOre for material named %s", materialName);
		if (vanillaMats.contains(materialName))
			createVanillaNetherOreWrapper(materialName);
		else
			createBasicNetherOreWrapper(materialName);
	}
}
