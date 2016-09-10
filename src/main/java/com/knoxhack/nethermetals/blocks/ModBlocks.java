package com.knoxhack.nethermetals.blocks;

import java.util.HashMap;
import java.util.Map;

import com.knoxhack.nethermetals.Main;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class ModBlocks {

	private static final Map<String, Block> allBlocks = new HashMap<>();

	public static Block coal_ore;
	public static Block diamond_ore;
	public static Block emerald_ore;
	public static Block gold_ore;
	public static Block iron_ore;
	public static Block lapis_ore;
	public static Block redstone_ore;

	public static Block antimony_ore;
	public static Block bismuth_ore;
	public static Block copper_ore;
	public static Block lead_ore;
	public static Block mercury_ore;
	public static Block nickel_ore;
	public static Block platinum_ore;
	public static Block silver_ore;
	public static Block tin_ore;
	public static Block zinc_ore;

	public static Block aluminum_ore;
	public static Block cadmium_ore;
	public static Block chromium_ore;
	public static Block iridium_ore;
	public static Block magnesium_ore;
	public static Block manganese_ore;
	public static Block osmium_ore;
	public static Block plutonium_ore;
	public static Block rutile_ore;
	public static Block tantalum_ore;
	public static Block titanium_ore;
	public static Block tungsten_ore;
	public static Block uranium_ore;
	public static Block zirconium_ore;

	public static void createBlocks() {

		// Vanilla
		coal_ore = createOre("coal", 4.0f, 15.0f);
		diamond_ore = createOre("diamond", 15.0f, 20.0f);
		emerald_ore = createOre("emerald", 4.0f, 15.0f);
		gold_ore = createOre("gold", 10.0f, 15.0f);
		iron_ore = createOre("iron", 4.0f, 15.0f);
		lapis_ore = createOre("lapis", 4.0f, 15.0f);
		redstone_ore = createOre("redstone", 4.0f, 15.0f);

		// Base Metals
		antimony_ore = createOre("antimony", 4.0f, 15.0f);
		bismuth_ore = createOre("bismuth", 4.0f, 15.0f);
		copper_ore = createOre("copper", 4.0f, 15.0f);
		lead_ore = createOre("lead", 4.0f, 15.0f);
		mercury_ore = createOre("mercury", 4.0f, 15.0f);
		nickel_ore = createOre("nickel", 4.0f, 15.0f);
		platinum_ore = createOre("platinum", 4.0f, 15.0f);
		silver_ore = createOre("silver", 10.0f, 15.0f);
		tin_ore = createOre("tin", 4.0f, 15.0f);
		zinc_ore = createOre("zinc", 4.0f, 15.0f);

		// Modern Metals
		aluminum_ore = createOre("aluminum", 4.0f, 15.0f);
		cadmium_ore = createOre("cadmium", 4.0f, 15.0f);
		chromium_ore = createOre("chromium", 4.0f, 15.0f);
		iridium_ore = createOre("iridium", 4.0f, 15.0f);
		magnesium_ore = createOre("magnesium", 4.0f, 15.0f);
		manganese_ore = createOre("manganese", 4.0f, 15.0f);
		osmium_ore = createOre("osmium", 4.0f, 15.0f);
		plutonium_ore = createOre("plutonium", 4.0f, 15.0f);
		rutile_ore = createOre("rutile", 4.0f, 15.0f);
		tantalum_ore = createOre("tantalum", 4.0f, 15.0f);
		titanium_ore = createOre("titanium", 4.0f, 15.0f);
		tungsten_ore = createOre("tungsten", 4.0f, 15.0f);
		uranium_ore = createOre("uranium", 4.0f, 15.0f);
		zirconium_ore = createOre("zirconium", 4.0f, 15.0f);
	}

	private static Block addBlock(Block block, String name) {
		ResourceLocation location = new ResourceLocation(Main.MODID, name);
		block.setRegistryName(location);
		block.setUnlocalizedName(location.toString());
		GameRegistry.register(block);

		ItemBlock itemBlock = new ItemBlock(block);
		itemBlock.setRegistryName(location);
		itemBlock.setUnlocalizedName(location.toString());
		GameRegistry.register(itemBlock);

		allBlocks.put(name, block);
		return block;
	}

	private static Block createOre(String name, float Hardness, float Resistance) {
		return addBlock(new ModBlockOre(Hardness, Resistance), "nether_" + name + "_ore");
	}

	@SideOnly(Side.CLIENT)
	public static void registerItemRenders(FMLInitializationEvent event) {
		for(String name : allBlocks.keySet()){
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
			.register(net.minecraft.item.Item.getItemFromBlock(allBlocks.get(name)), 0, 
				new ModelResourceLocation(new ResourceLocation(Main.MODID, name), "inventory"));
		}
	}
}
