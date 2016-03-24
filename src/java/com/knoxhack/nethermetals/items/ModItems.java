package com.knoxhack.nethermetals.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModItems {

	public static Item nethersword;

	public static void createItems() {
		GameRegistry.registerItem(nethersword = new SwordItem("Nether_Sword"), "Nether_Sword");
	}

}
