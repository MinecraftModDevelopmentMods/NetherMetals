package com.mcmoddev.nethermetals.init;

import com.mcmoddev.lib.data.MaterialNames;
import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.data.SharedStrings;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.registry.CrusherRecipeRegistry;
import com.mcmoddev.lib.util.Config.Options;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class Recipes {

	private static final Names NAME = Names.NETHERORE;

	/**
	 *
	 */
	public static void init() {

		// Vanilla
		recipeWrapper(MaterialNames.COAL);
		recipeWrapper(MaterialNames.DIAMOND);
		recipeWrapper(MaterialNames.EMERALD);
		recipeWrapper(MaterialNames.GOLD);
		recipeWrapper(MaterialNames.IRON);
		recipeWrapper(MaterialNames.LAPIS);
		recipeWrapper(MaterialNames.REDSTONE);

		// Base Metals
		if (Loader.isModLoaded("basemetals")) {
			Materials.getMaterialsByMod("basemetals").stream()
			.forEach(mat -> recipeWrapper(mat));
		}

		// Modern Metals
		if (Loader.isModLoaded("modernmetals")) {
			Materials.getMaterialsByMod("modernmetals").stream()
			.forEach(mat -> recipeWrapper(mat));
		}
	}

	private static void recipeWrapper(final MMDMaterial material) {
		if ((!material.isEmpty()) && (material.hasBlock(NAME))) {
			doFurnaceSmelting(material);
			doMakeDusts(material);
		}
	}
	
	private static void recipeWrapper(final String materialName) {
		if (Materials.hasMaterial(materialName)) {
			final MMDMaterial material = Materials.getMaterialByName(materialName);
			if ((!material.isEmpty()) && (material.hasBlock(NAME))) {
				doFurnaceSmelting(material);
				doMakeDusts(material);
			}
		}
	}

	private static void doMakeDusts(final MMDMaterial material) {
		if ((Options.isThingEnabled("makeDusts")) && (material.hasItem(Names.POWDER))) {
			CrusherRecipeRegistry.addNewCrusherRecipe(material.getBlock(NAME),
					material.getItemStack(Names.POWDER, 4));
		} else if (material.hasBlock(Names.ORE)) {
			CrusherRecipeRegistry.addNewCrusherRecipe(material.getBlock(NAME),
					material.getBlockItemStack(Names.ORE, 2));
		}
	}

	private static void doFurnaceSmelting(final MMDMaterial material) {
		final int outputQty = 2;
		final float xp = 1.0f;
		if (Options.isThingEnabled("enableFurnaceSmelting")) {
			if ((Options.isThingEnabled("smeltToIngots")) && (material.hasItem(Names.INGOT))) {
				GameRegistry.addSmelting(material.getBlock(NAME),
						material.getItemStack(Names.INGOT, outputQty), xp);
			} else if (material.hasBlock(Names.ORE)) {
				GameRegistry.addSmelting(material.getBlock(NAME),
						material.getBlockItemStack(Names.ORE, outputQty), xp);
			}
		}
	}

	private Recipes() {
		throw new IllegalAccessError(SharedStrings.NOT_INSTANTIABLE);
	}
}
