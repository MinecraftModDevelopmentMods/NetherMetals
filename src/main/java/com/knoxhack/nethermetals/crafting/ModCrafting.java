package com.knoxhack.nethermetals.crafting;

import cyano.basemetals.registry.CrusherRecipeRegistry;
import dank.modularity.framework.common.init.FrameworkContent;
import com.knoxhack.nethermetals.blocks.ModBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModCrafting {

	public static void initCrafting() {

		// Vanilla
		GameRegistry.addSmelting(ModBlocks.coal_ore, new ItemStack(Blocks.COAL_ORE, 2), 1.0f);
		GameRegistry.addSmelting(ModBlocks.diamond_ore, new ItemStack(Blocks.DIAMOND_ORE, 2), 1.0f);
		GameRegistry.addSmelting(ModBlocks.emerald_ore, new ItemStack(Blocks.EMERALD_ORE, 2), 1.0f); 
		GameRegistry.addSmelting(ModBlocks.gold_ore, new ItemStack(Blocks.GOLD_ORE, 2), 1.0f);
		GameRegistry.addSmelting(ModBlocks.iron_ore, new ItemStack(Blocks.IRON_ORE, 2), 1.0f);
		GameRegistry.addSmelting(ModBlocks.lapis_ore, new ItemStack(Blocks.LAPIS_ORE, 2), 1.0f);
		GameRegistry.addSmelting(ModBlocks.redstone_ore, new ItemStack(Blocks.REDSTONE_ORE, 2), 1.0f);

		// Modularity
		if(Loader.isModLoaded("modularity")) {
			GameRegistry.addSmelting(ModBlocks.copper_ore, new ItemStack(FrameworkContent.resourceOre, 2 , 0), 1.0f);
			GameRegistry.addSmelting(ModBlocks.lead_ore, new ItemStack(FrameworkContent.resourceOre, 2 , 3), 1.0f);
			GameRegistry.addSmelting(ModBlocks.silver_ore, new ItemStack(FrameworkContent.resourceOre, 2 , 2), 1.0f);
			GameRegistry.addSmelting(ModBlocks.tin_ore, new ItemStack(FrameworkContent.resourceOre, 2 , 1), 1.0f);
		}

		// Vanilla BM Hammer Compat
		if(Loader.isModLoaded("basemetals")) {
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.coal_ore, new ItemStack(Blocks.COAL_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.diamond_ore, new ItemStack(Blocks.DIAMOND_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.emerald_ore, new ItemStack(Blocks.EMERALD_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.gold_ore, new ItemStack(Blocks.GOLD_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.iron_ore, new ItemStack(Blocks.IRON_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.lapis_ore, new ItemStack(Blocks.LAPIS_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.redstone_ore, new ItemStack(Blocks.REDSTONE_ORE, 2));			
		}

		// Base Metals
		if(Loader.isModLoaded("basemetals")) {
//			GameRegistry.addSmelting(ModBlocks.antimony_ore, new ItemStack(BmBlocks.antimony_ore, 2), 1.0f);			// Not supported in BM 2.2.2
//			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.antimony_ore, new ItemStack(BmBlocks.antimony_ore, 2));	// Not supported in BM 2.2.2
//			GameRegistry.addSmelting(ModBlocks.bismuth_ore, new ItemStack(BmBlocks.bismuth_ore, 2), 1.0f);				// Not supported in BM 2.2.2
//			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.bismuth_ore, new ItemStack(BmBlocks.bismuth_ore, 2));	// Not supported in BM 2.2.2
			GameRegistry.addSmelting(ModBlocks.copper_ore, new ItemStack(BmBlocks.copper_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.copper_ore, new ItemStack(BmBlocks.copper_ore, 2));
			GameRegistry.addSmelting(ModBlocks.lead_ore, new ItemStack(BmBlocks.lead_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.lead_ore, new ItemStack(BmBlocks.lead_ore, 2));
			GameRegistry.addSmelting(ModBlocks.mercury_ore, new ItemStack(BmBlocks.mercury_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.mercury_ore, new ItemStack(BmBlocks.mercury_ore, 2));
			GameRegistry.addSmelting(ModBlocks.nickel_ore, new ItemStack(BmBlocks.nickel_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.nickel_ore, new ItemStack(BmBlocks.nickel_ore, 2));
			GameRegistry.addSmelting(ModBlocks.platinum_ore, new ItemStack(BmBlocks.platinum_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.platinum_ore, new ItemStack(BmBlocks.platinum_ore, 2));
			GameRegistry.addSmelting(ModBlocks.silver_ore, new ItemStack(BmBlocks.silver_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.silver_ore, new ItemStack(BmBlocks.silver_ore, 2));
			GameRegistry.addSmelting(ModBlocks.tin_ore, new ItemStack(BmBlocks.tin_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.tin_ore, new ItemStack(BmBlocks.tin_ore, 2));
			GameRegistry.addSmelting(ModBlocks.zinc_ore, new ItemStack(BmBlocks.zinc_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.zinc_ore, new ItemStack(BmBlocks.zinc_ore, 2));
		}

		// Modern Metals
		if(Loader.isModLoaded("modernmetals")) {
			GameRegistry.addSmelting(ModBlocks.aluminum_ore, new ItemStack(MmBlocks.aluminum_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.aluminum_ore, new ItemStack(MmBlocks.aluminum_ore, 2));
			GameRegistry.addSmelting(ModBlocks.cadmium_ore, new ItemStack(MmBlocks.cadmium_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.cadmium_ore, new ItemStack(MmBlocks.cadmium_ore, 2));
			GameRegistry.addSmelting(ModBlocks.chromium_ore, new ItemStack(MmBlocks.chromium_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.chromium_ore, new ItemStack(MmBlocks.chromium_ore, 2));
			GameRegistry.addSmelting(ModBlocks.iridium_ore, new ItemStack(MmBlocks.iridium_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.iridium_ore, new ItemStack(MmBlocks.iridium_ore, 2));
			GameRegistry.addSmelting(ModBlocks.magnesium_ore, new ItemStack(MmBlocks.magnesium_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.magnesium_ore, new ItemStack(MmBlocks.magnesium_ore, 2));
			GameRegistry.addSmelting(ModBlocks.manganese_ore, new ItemStack(MmBlocks.manganese_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.manganese_ore, new ItemStack(MmBlocks.manganese_ore, 2));
			GameRegistry.addSmelting(ModBlocks.osmium_ore, new ItemStack(MmBlocks.osmium_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.osmium_ore, new ItemStack(MmBlocks.osmium_ore, 2));
			GameRegistry.addSmelting(ModBlocks.plutonium_ore, new ItemStack(MmBlocks.plutonium_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.plutonium_ore, new ItemStack(MmBlocks.plutonium_ore, 2));
			GameRegistry.addSmelting(ModBlocks.rutile_ore, new ItemStack(MmBlocks.rutile_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.rutile_ore, new ItemStack(MmBlocks.rutile_ore, 2));
			GameRegistry.addSmelting(ModBlocks.tantalum_ore, new ItemStack(MmBlocks.tantalum_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.tantalum_ore, new ItemStack(MmBlocks.tantalum_ore, 2));
			GameRegistry.addSmelting(ModBlocks.titanium_ore, new ItemStack(MmBlocks.titanium_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.titanium_ore, new ItemStack(MmBlocks.titanium_ore, 2));
			GameRegistry.addSmelting(ModBlocks.tungsten_ore, new ItemStack(MmBlocks.tungsten_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.tungsten_ore, new ItemStack(MmBlocks.tungsten_ore, 2));
			GameRegistry.addSmelting(ModBlocks.uranium_ore, new ItemStack(MmBlocks.uranium_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.uranium_ore, new ItemStack(MmBlocks.uranium_ore, 2));
			GameRegistry.addSmelting(ModBlocks.zirconium_ore, new ItemStack(MmBlocks.zirconium_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.zirconium_ore, new ItemStack(MmBlocks.zirconium_ore, 2));
		}
	}
}
