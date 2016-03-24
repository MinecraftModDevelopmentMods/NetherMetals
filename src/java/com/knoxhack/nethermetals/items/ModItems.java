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
		GameRegistry.registerItem(netherpickaxe = new SwordItem("Nether_Pickaxe"), "Nether_Pickaxe");
		GameRegistry.registerItem(nethersword = new SwordItem("Nether_Sword"), "Nether_Sword");
		GameRegistry.registerItem(netherspade = new SwordItem("Nether_Spade"), "Nether_Spade");
		GameRegistry.registerItem(netherhoe = new SwordItem("Nether_Hoe"), "Nether_Hoe");
		GameRegistry.registerItem(netheraxe = new SwordItem("Nether_Axe"), "Nether_Axe");
		GameRegistry.registerItem(netherhelmet = new SwordItem("Nether_Helmet"), "Nether_Helmet");
		GameRegistry.registerItem(netherchestplate = new SwordItem("Nether_Chestplate"), "Nether_Chestplate");
		GameRegistry.registerItem(netherleggings = new SwordItem("Nether_Leggings"), "Nether_Leggings");
		GameRegistry.registerItem(netherboots = new SwordItem("Nether_Boots"), "Nether_Boots");

		
		
		
	}

}
