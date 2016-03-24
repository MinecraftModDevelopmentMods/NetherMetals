package com.knoxhack.nethermetals.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModItems {

	public static Item nethersword;
	public static Item netherspade;
	public static Item netherpickaxe;
	public static Item netherhoe;
	public static Item netheraxe;
	public static Item netherhelmet;
	public static Item netherchestplate;
	public static Item netherleggings;
	public static Item netherboots;	
	
	
	public static void createItems() {
		GameRegistry.registerItem(netherpickaxe = new SwordItem("nether_Pickaxe"), "nether_Pickaxe");
		GameRegistry.registerItem(nethersword = new SwordItem("nether_Sword"), "nether_Sword");
		GameRegistry.registerItem(netherspade = new SwordItem("nether_Spade"), "nether_Spade");
		GameRegistry.registerItem(netherhoe = new SwordItem("nether_Hoe"), "nether_Hoe");
		GameRegistry.registerItem(netheraxe = new SwordItem("nether_Axe"), "nether_Axe");
		GameRegistry.registerItem(netherhelmet = new SwordItem("nether_Helmet"), "nether_Helmet");
		GameRegistry.registerItem(netherchestplate = new SwordItem("nether_Chestplate"), "nether_Chestplate");
		GameRegistry.registerItem(netherleggings = new SwordItem("nether_Leggings"), "nether_Leggings");
		GameRegistry.registerItem(netherboots = new SwordItem("nether_Boots"), "nether_Boots");

		
		
		
	}

}
