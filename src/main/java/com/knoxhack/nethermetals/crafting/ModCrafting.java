package com.knoxhack.nethermetals.crafting;

import com.knoxhack.nethermetals.blocks.ModBlocks;

import cyano.basemetals.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;


public final class ModCrafting {

	public static void initCrafting() {

		GameRegistry.addSmelting(ModBlocks.nethercopperOre, new ItemStack(Blocks.copper_ore, 2), 1.0f);
		GameRegistry.addSmelting(ModBlocks.netherleadOre, new ItemStack(Blocks.lead_ore, 2), 1.0f);
		GameRegistry.addSmelting(ModBlocks.nethertinOre, new ItemStack(Blocks.tin_ore, 2), 1.0f);
		GameRegistry.addSmelting(ModBlocks.nethersilverOre, new ItemStack(Blocks.silver_ore, 2), 1.0f);
		GameRegistry.addSmelting(ModBlocks.netherzincOre, new ItemStack(Blocks.zinc_ore, 2), 1.0f);
		GameRegistry.addSmelting(ModBlocks.nethernickelOre, new ItemStack(Blocks.nickel_ore, 2), 1.0f);

		
		
		
		
		
		
	}
}
