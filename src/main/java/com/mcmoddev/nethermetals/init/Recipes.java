package com.mcmoddev.nethermetals.init;

import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.registry.CrusherRecipeRegistry;
import com.mcmoddev.nethermetals.NetherMetals;
import com.mcmoddev.nethermetals.util.Config.Options;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class Recipes {

	private Recipes() {
		throw new IllegalAccessError("Not a instantiable class");
	}

	public static void init() {

		// Vanilla
		recipeWrapper(true, Materials.getMaterialByName("coal"));
		recipeWrapper(true, Materials.getMaterialByName("diamond"));
		recipeWrapper(true, Materials.getMaterialByName("emerald"));
		recipeWrapper(true, Materials.getMaterialByName("gold"));
		recipeWrapper(true, Materials.getMaterialByName("iron"));
		recipeWrapper(true, Materials.getMaterialByName("lapis"));
		recipeWrapper(true, Materials.getMaterialByName("redstone"));

		/*
		GameRegistry.addSmelting(Materials.getMaterialByName("coal").getBlock(Names.NETHERORE), new ItemStack(Blocks.COAL_ORE, 2), 1.0f);
		GameRegistry.addSmelting(Materials.getMaterialByName("diamond").getBlock(Names.NETHERORE), new ItemStack(Blocks.DIAMOND_ORE, 2), 1.0f);
		GameRegistry.addSmelting(Materials.getMaterialByName("emerald").getBlock(Names.NETHERORE), new ItemStack(Blocks.EMERALD_ORE, 2), 1.0f);
		GameRegistry.addSmelting(Materials.getMaterialByName("gold").getBlock(Names.NETHERORE), new ItemStack(Blocks.GOLD_ORE, 2), 1.0f);
		GameRegistry.addSmelting(Materials.getMaterialByName("iron").getBlock(Names.NETHERORE), new ItemStack(Blocks.IRON_ORE, 2), 1.0f);
		GameRegistry.addSmelting(Materials.getMaterialByName("lapis").getBlock(Names.NETHERORE), new ItemStack(Blocks.LAPIS_ORE, 2), 1.0f);
		GameRegistry.addSmelting(Materials.getMaterialByName("redstone").getBlock(Names.NETHERORE), new ItemStack(Blocks.REDSTONE_ORE, 2), 1.0f);

		// Vanilla BM Hammer Compat
		if (Loader.isModLoaded("basemetals")) {
			CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("coal").getBlock(Names.NETHERORE), new ItemStack(Blocks.COAL_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("diamond").getBlock(Names.NETHERORE), new ItemStack(Blocks.DIAMOND_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("emerald").getBlock(Names.NETHERORE), new ItemStack(Blocks.EMERALD_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("gold").getBlock(Names.NETHERORE), new ItemStack(Blocks.GOLD_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("iron").getBlock(Names.NETHERORE), new ItemStack(Blocks.IRON_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("lapis").getBlock(Names.NETHERORE), new ItemStack(Blocks.LAPIS_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("redstone").getBlock(Names.NETHERORE), new ItemStack(Blocks.REDSTONE_ORE, 2));
		}
		*/

		// Base Metals
		if (Loader.isModLoaded("basemetals")) {
			recipeWrapper(true, Materials.getMaterialByName("antimony"));
			recipeWrapper(true, Materials.getMaterialByName("bismuth"));
			recipeWrapper(true, Materials.getMaterialByName("copper"));
			recipeWrapper(true, Materials.getMaterialByName("lead"));
			recipeWrapper(true, Materials.getMaterialByName("mercury"));
			recipeWrapper(true, Materials.getMaterialByName("nickel"));
			recipeWrapper(true, Materials.getMaterialByName("platinum"));
			recipeWrapper(true, Materials.getMaterialByName("silver"));
			recipeWrapper(true, Materials.getMaterialByName("tin"));
			recipeWrapper(true, Materials.getMaterialByName("zinc"));
		}

		// Modern Metals
		if (Loader.isModLoaded("modernmetals")) {
			recipeWrapper(true, Materials.getMaterialByName("aluminum"));
			recipeWrapper(true, Materials.getMaterialByName("cadmium"));
			recipeWrapper(true, Materials.getMaterialByName("chromium"));
			recipeWrapper(true, Materials.getMaterialByName("iridium"));
			recipeWrapper(true, Materials.getMaterialByName("magnesium"));
			recipeWrapper(true, Materials.getMaterialByName("manganese"));
			recipeWrapper(true, Materials.getMaterialByName("osmium"));
			recipeWrapper(true, Materials.getMaterialByName("plutonium"));
			recipeWrapper(true, Materials.getMaterialByName("rutile"));
			recipeWrapper(true, Materials.getMaterialByName("tantalum"));
			recipeWrapper(true, Materials.getMaterialByName("titanium"));
			recipeWrapper(true, Materials.getMaterialByName("tungsten"));
			recipeWrapper(true, Materials.getMaterialByName("uranium"));
			recipeWrapper(true, Materials.getMaterialByName("zirconium"));
		}
	}

	private static void recipeWrapper(boolean enabled, MMDMaterial material) {
		if (enabled) {
			if (material != null) {
				if (material.getBlock(Names.NETHERORE) != null) {
					boolean makeDusts = false;
					boolean smeltToIngots = false;
					if (Options.enableFurnaceSmelting) {
						if (smeltToIngots == true) {
							if (material.getItem(Names.INGOT) != null) {
								GameRegistry.addSmelting(material.getBlock(Names.NETHERORE), new ItemStack(material.getItem(Names.INGOT), 2), 1.0f);
							} else {
								NetherMetals.logger.error("ingot was null for material " + material.getName());
							}
						} else {
							if (material.getBlock(Names.ORE) != null) {
								GameRegistry.addSmelting(material.getBlock(Names.NETHERORE), new ItemStack(material.getBlock(Names.ORE), 2), 1.0f);
							} else {
								NetherMetals.logger.error("ore was null for material " + material.getName());
							}
						}
					}
					if (makeDusts == true) {
						if (material.getItem(Names.POWDER) != null) {
						CrusherRecipeRegistry.addNewCrusherRecipe(material.getBlock(Names.NETHERORE), new ItemStack(material.getItem(Names.POWDER), 4));
						} else {
							NetherMetals.logger.error("powder was null for material " + material.getName());
						}
					} else {
						if (material.getBlock(Names.ORE) != null) {
							CrusherRecipeRegistry.addNewCrusherRecipe(material.getBlock(Names.NETHERORE), new ItemStack(material.getBlock(Names.ORE), 2));
						} else {
							NetherMetals.logger.error("ore was null" + material.getName());
						}
					}
				} else {
					NetherMetals.logger.error("oreNether was null");
				}
			}
		}
	}
}
