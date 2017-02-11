package com.mcmoddev.nethermetals.blocks;
/**
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public final class ModBlocks {

	private static final Map<String, Block> blockRegistry = new HashMap<>();

	public static Block coalOre;
	public static Block diamondOre;
	public static Block emeraldOre;
	public static Block goldOre;
	public static Block ironOre;
	public static Block lapisOre;
	public static Block redstoneOre;

	public static Block antimonyOre;
	public static Block bismuthOre;
	public static Block copperOre;
	public static Block leadOre;
	public static Block mercuryOre;
	public static Block nickelOre;
	public static Block platinumOre;
	public static Block silverOre;
	public static Block tinOre;
	public static Block zincOre;

	public static Block aluminumOre;
	public static Block cadmiumOre;
	public static Block chromiumOre;
	public static Block iridiumOre;
	public static Block magnesiumOre;
	public static Block manganeseOre;
	public static Block osmiumOre;
	public static Block plutoniumOre;
	public static Block rutileOre;
	public static Block tantalumOre;
	public static Block titaniumOre;
	public static Block tungstenOre;
	public static Block uraniumOre;
	public static Block zirconiumOre;

	public static void createBlocks() {

		// Vanilla
		coalOre = createOre("coal", 4.0f, 15.0f);
		diamondOre = createOre("diamond", 15.0f, 20.0f);
		emeraldOre = createOre("emerald", 4.0f, 15.0f);
		goldOre = createOre("gold", 10.0f, 15.0f);
		ironOre = createOre("iron", 4.0f, 15.0f);
		lapisOre = createOre("lapis", 4.0f, 15.0f);
		redstoneOre = createOre("redstone", 4.0f, 15.0f);

		// Base Metals
		antimonyOre = createOre("antimony", 4.0f, 15.0f);
		bismuthOre = createOre("bismuth", 4.0f, 15.0f);
		copperOre = createOre("copper", 4.0f, 15.0f);
		leadOre = createOre("lead", 4.0f, 15.0f);
		mercuryOre = createOre("mercury", 4.0f, 15.0f);
		nickelOre = createOre("nickel", 4.0f, 15.0f);
		platinumOre = createOre("platinum", 4.0f, 15.0f);
		silverOre = createOre("silver", 10.0f, 15.0f);
		tinOre = createOre("tin", 4.0f, 15.0f);
		zincOre = createOre("zinc", 4.0f, 15.0f);

		// Modern Metals
		aluminumOre = createOre("aluminum", 4.0f, 15.0f);
		cadmiumOre = createOre("cadmium", 4.0f, 15.0f);
		chromiumOre = createOre("chromium", 4.0f, 15.0f);
		iridiumOre = createOre("iridium", 4.0f, 15.0f);
		magnesiumOre = createOre("magnesium", 4.0f, 15.0f);
		manganeseOre = createOre("manganese", 4.0f, 15.0f);
		osmiumOre = createOre("osmium", 4.0f, 15.0f);
		plutoniumOre = createOre("plutonium", 4.0f, 15.0f);
		rutileOre = createOre("rutile", 4.0f, 15.0f);
		tantalumOre = createOre("tantalum", 4.0f, 15.0f);
		titaniumOre = createOre("titanium", 4.0f, 15.0f);
		tungstenOre = createOre("tungsten", 4.0f, 15.0f);
		uraniumOre = createOre("uranium", 4.0f, 15.0f);
		zirconiumOre = createOre("zirconium", 4.0f, 15.0f);
	}

	private static Block addBlock(Block block, String name) {
		block.setRegistryName(name);
		block.setUnlocalizedName(block.getRegistryName().getResourceDomain() + "." + name);
		GameRegistry.register(block);
		blockRegistry.put(name, block);

		final ItemBlock itemBlock = new ItemBlock(block);
		itemBlock.setRegistryName(name);
		itemBlock.setUnlocalizedName(block.getRegistryName().getResourceDomain() + "." + name);
		GameRegistry.register(itemBlock);

//		OreDictionary.registerOre("oreNether" + StringUtils.capitalize(name), block);
		// block.setCreativeTab(tab);

		return block;
	}

	private static Block createOre(String name, float hardness, float resistance) {
		final Block block = addBlock(new ModBlockOre(hardness, resistance), "nether_" + name + "_ore");
		OreDictionary.registerOre("oreNether" + StringUtils.capitalize(name), block);
		return block;
	}

	public static Block getBlockByName(String name) {
		return blockRegistry.get(name);
	}

	public static Map<String, Block> getBlockRegistry() {
		return blockRegistry;
	}
}


**/
