package com.knoxhack.nethermetals.crafting;

import com.knoxhack.nethermetals.blocks.ModBlocks;
import com.knoxhack.nethermetals.items.ModItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModCrafting {

	public static void initCrafting() {
		GameRegistry.addRecipe(new ItemStack(ModBlocks.nethercopperOre),	"##","##",	'#', ModItems.netheraxe);
		//or: GameRegistry.addRecipe(new ItemStack(ModBlocks.tutorialBlock), new Object[]{"##","##", '#', ModItems.tutorialItem});

		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.nethersword), Blocks.iron_ore, new ItemStack(Items.dye, 1, 4));
		//or: GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tutorialItem), new Object[]{Items.redstone, new ItemStack(Items.dye, 1, 4)});

		GameRegistry.addSmelting(Items.diamond, new ItemStack(ModItems.nethersword), 1.0f);
	}
}
