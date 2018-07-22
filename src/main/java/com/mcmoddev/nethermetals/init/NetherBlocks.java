package com.mcmoddev.nethermetals.init;

import java.util.Arrays;
import java.util.List;

import com.mcmoddev.lib.block.BlockMMDNetherOre;
import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.data.SharedStrings;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.util.Oredicts;

import net.minecraft.block.Block;

/**
 * This class initializes all blocks in Nether Metals.
 *
 * @author Jasmine Iwanek
 *
 */
public final class NetherBlocks extends com.mcmoddev.lib.init.Blocks {
	/**
	 *
	 */
	public static void init() {
		final List<String> knownMaterials = Arrays.asList("coal", "diamond", "emerald", "gold", "iron", "lapis",
				"redstone", "antimony", "bismuth", "copper", "lead", "mercury", "nickel", "platinum",
				"silver", "tin", "zinc", "aluminum", "cadmium", "chromium", "iridium", "magnesium",
				"manganese", "osmium", "plutonium", "rutile", "tantalum", "titanium", "tungsten",
				"uranium", "zirconium");
		Materials.getAllMaterials().stream()
		.map(material -> material.getName())
		.filter(knownMaterials::contains)
		.filter(Materials::hasMaterial)
		.forEach(NetherBlocks::createOreWrapper);
	}

	private static void createOreWrapper(final String materialName) {
		final List<String> vanillaMats = Arrays.asList("coal", "diamond", "emerald", "gold", "iron", "lapis", "redstone");

		if (vanillaMats.contains(materialName)) {
			createVanillaOreWrapper(materialName);
		} else {
			create(Names.NETHERORE, materialName);
		}
	}

	private static void createVanillaOreWrapper(final String materialName) {
		final MMDMaterial material = Materials.getMaterialByName(materialName);
		material.addNewBlock(Names.NETHERORE, addBlock(new BlockMMDNetherOre(material), Names.NETHERORE.toString(), material, ItemGroups.getTab(SharedStrings.TAB_BLOCKS)));
		final Block block = material.getBlock(Names.NETHERORE);
		final String oredict = getOredictFromName(Names.NETHERORE);
		if ((oredict != null) && (block != null)) {
			Oredicts.registerOre(oredict + material.getCapitalizedName(), block);
		}
	}
}
