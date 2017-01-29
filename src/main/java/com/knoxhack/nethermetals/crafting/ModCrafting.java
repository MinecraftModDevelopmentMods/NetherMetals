package com.knoxhack.nethermetals.crafting;

import com.mcmoddev.basemetals.registry.CrusherRecipeRegistry;
//import dank.modularity.framework.common.init.FrameworkContent;
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
		/*
		if (Loader.isModLoaded("modularity")) {
			GameRegistry.addSmelting(ModBlocks.copper_ore, new ItemStack(FrameworkContent.resourceOre, 2, 0), 1.0f);
			GameRegistry.addSmelting(ModBlocks.lead_ore, new ItemStack(FrameworkContent.resourceOre, 2, 3), 1.0f);
			GameRegistry.addSmelting(ModBlocks.silver_ore, new ItemStack(FrameworkContent.resourceOre, 2, 2), 1.0f);
			GameRegistry.addSmelting(ModBlocks.tin_ore, new ItemStack(FrameworkContent.resourceOre, 2, 1), 1.0f);
		}
		*/

		// Vanilla BM Hammer Compat
		if (Loader.isModLoaded("basemetals")) {
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.coal_ore, new ItemStack(Blocks.COAL_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.diamond_ore, new ItemStack(Blocks.DIAMOND_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.emerald_ore, new ItemStack(Blocks.EMERALD_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.gold_ore, new ItemStack(Blocks.GOLD_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.iron_ore, new ItemStack(Blocks.IRON_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.lapis_ore, new ItemStack(Blocks.LAPIS_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.redstone_ore, new ItemStack(Blocks.REDSTONE_ORE, 2));
		}

		// Base Metals
		if (Loader.isModLoaded("basemetals")) {
			if (com.mcmoddev.basemetals.util.Config.Options.ENABLE_ANTIMONY) {
				GameRegistry.addSmelting(ModBlocks.antimony_ore, new ItemStack(BMMaterials.antimony.ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.antimony_ore, new ItemStack(BMMaterials.antimony.ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.ENABLE_BISMUTH) {
				GameRegistry.addSmelting(ModBlocks.bismuth_ore, new ItemStack(BMMaterials.bismuth.ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.bismuth_ore, new ItemStack(BMMaterials.bismuth.ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.ENABLE_COPPER) {
				GameRegistry.addSmelting(ModBlocks.copper_ore, new ItemStack(BMMaterials.copper.ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.copper_ore, new ItemStack(BMMaterials.copper.ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.ENABLE_LEAD) {
				GameRegistry.addSmelting(ModBlocks.lead_ore, new ItemStack(BMMaterials.lead.ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.lead_ore, new ItemStack(BMMaterials.lead.ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.ENABLE_MERCURY) {
				GameRegistry.addSmelting(ModBlocks.mercury_ore, new ItemStack(BmBlocks.mercury_ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.mercury_ore, new ItemStack(BmBlocks.mercury_ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.ENABLE_NICKEL) {
				GameRegistry.addSmelting(ModBlocks.nickel_ore, new ItemStack(BMMaterials.nickel.ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.nickel_ore, new ItemStack(BMMaterials.nickel.ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.ENABLE_PLATINUM) {
				GameRegistry.addSmelting(ModBlocks.platinum_ore, new ItemStack(BMMaterials.platinum.ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.platinum_ore, new ItemStack(BMMaterials.platinum.ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.ENABLE_SILVER) {
				GameRegistry.addSmelting(ModBlocks.silver_ore, new ItemStack(BMMaterials.silver.ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.silver_ore, new ItemStack(BMMaterials.silver.ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.ENABLE_TIN) {
				GameRegistry.addSmelting(ModBlocks.tin_ore, new ItemStack(BMMaterials.tin.ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.tin_ore, new ItemStack(BMMaterials.tin.ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.ENABLE_ZINC) {
				GameRegistry.addSmelting(ModBlocks.zinc_ore, new ItemStack(BMMaterials.zinc.ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.zinc_ore, new ItemStack(BMMaterials.zinc.ore, 2));
			}
		}

		// Modern Metals
		if (Loader.isModLoaded("modernmetals")) {
			if (com.mcmoddev.modernmetals.util.Config.Options.ENABLE_ALUMINUM) {
				GameRegistry.addSmelting(ModBlocks.aluminum_ore, new ItemStack(MMMaterials.aluminum.ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.aluminum_ore, new ItemStack(MMMaterials.aluminum.ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.ENABLE_CADMIUM) {
				GameRegistry.addSmelting(ModBlocks.cadmium_ore, new ItemStack(MMMaterials.cadmium.ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.cadmium_ore, new ItemStack(MMMaterials.cadmium.ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.ENABLE_CHROMIUM) {
				GameRegistry.addSmelting(ModBlocks.chromium_ore, new ItemStack(MMMaterials.chromium.ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.chromium_ore, new ItemStack(MMMaterials.chromium.ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.ENABLE_IRIDIUM) {
				GameRegistry.addSmelting(ModBlocks.iridium_ore, new ItemStack(MMMaterials.iridium.ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.iridium_ore, new ItemStack(MMMaterials.iridium.ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.ENABLE_MAGNESIUM) {
				GameRegistry.addSmelting(ModBlocks.magnesium_ore, new ItemStack(MMMaterials.magnesium.ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.magnesium_ore, new ItemStack(MMMaterials.magnesium.ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.ENABLE_MANGANESE) {
				GameRegistry.addSmelting(ModBlocks.manganese_ore, new ItemStack(MMMaterials.manganese.ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.manganese_ore, new ItemStack(MMMaterials.manganese.ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.ENABLE_OSMIUM) {
				GameRegistry.addSmelting(ModBlocks.osmium_ore, new ItemStack(MMMaterials.osmium.ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.osmium_ore, new ItemStack(MMMaterials.osmium.ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.ENABLE_PLUTONIUM) {
				GameRegistry.addSmelting(ModBlocks.plutonium_ore, new ItemStack(MMMaterials.plutonium.ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.plutonium_ore, new ItemStack(MMMaterials.plutonium.ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.ENABLE_RUTILE) {
				GameRegistry.addSmelting(ModBlocks.rutile_ore, new ItemStack(MMMaterials.rutile.ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.rutile_ore, new ItemStack(MMMaterials.rutile.ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.ENABLE_TANTALUM) {
				GameRegistry.addSmelting(ModBlocks.tantalum_ore, new ItemStack(MMMaterials.tantalum.ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.tantalum_ore, new ItemStack(MMMaterials.tantalum.ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.ENABLE_TITANIUM) {
				GameRegistry.addSmelting(ModBlocks.titanium_ore, new ItemStack(MMMaterials.titanium.ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.titanium_ore, new ItemStack(MMMaterials.titanium.ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.ENABLE_TUNGSTEN) {
				GameRegistry.addSmelting(ModBlocks.tungsten_ore, new ItemStack(MMMaterials.tungsten.ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.tungsten_ore, new ItemStack(MMMaterials.tungsten.ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.ENABLE_URANIUM) {
				GameRegistry.addSmelting(ModBlocks.uranium_ore, new ItemStack(MMMaterials.uranium.ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.uranium_ore, new ItemStack(MMMaterials.uranium.ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.ENABLE_ZIRCONIUM) {
				GameRegistry.addSmelting(ModBlocks.zirconium_ore, new ItemStack(MMMaterials.zirconium.ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.zirconium_ore, new ItemStack(MMMaterials.zirconium.ore, 2));
			}
		}
	}
}
