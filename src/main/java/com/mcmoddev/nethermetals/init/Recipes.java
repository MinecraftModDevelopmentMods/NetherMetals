package com.mcmoddev.nethermetals.init;

import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.data.SharedStrings;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.registry.CrusherRecipeRegistry;
import com.mcmoddev.lib.util.ConfigBase.Options;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class Recipes {

	private static final Names NAME = Names.NETHERORE;

	private Recipes() {
		throw new IllegalAccessError(SharedStrings.NOT_INSTANTIABLE);
	}

	/**
	 *
	 */
	public static void init() {

		// Vanilla
		recipeWrapper("coal");
		recipeWrapper("diamond");
		recipeWrapper("emerald");
		recipeWrapper("gold");
		recipeWrapper("iron");
		recipeWrapper("lapis");
		recipeWrapper("redstone");

		// Base Metals
		if (Loader.isModLoaded("basemetals")) {
			recipeWrapper("antimony");
			recipeWrapper("bismuth");
			recipeWrapper("copper");
			recipeWrapper("lead");
			recipeWrapper("mercury");
			recipeWrapper("nickel");
			recipeWrapper("platinum");
			recipeWrapper("silver");
			recipeWrapper("tin");
			recipeWrapper("zinc");
		}

		// Modern Metals
		if (Loader.isModLoaded("modernmetals")) {
			recipeWrapper("aluminum");
			recipeWrapper("cadmium");
			recipeWrapper("chromium");
			recipeWrapper("iridium");
			recipeWrapper("magnesium");
			recipeWrapper("manganese");
			recipeWrapper("osmium");
			recipeWrapper("plutonium");
			recipeWrapper("rutile");
			recipeWrapper("tantalum");
			recipeWrapper("titanium");
			recipeWrapper("tungsten");
			recipeWrapper("uranium");
			recipeWrapper("zirconium");
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
		if (Options.isThingEnabled("enableFurnaceSmelting")) {
			if ((Options.isThingEnabled("smeltToIngots")) && (material.hasItem(Names.INGOT))) {
				GameRegistry.addSmelting(material.getBlock(NAME),
						material.getItemStack(Names.INGOT, 2), 1.0f);
			} else if (material.hasBlock(Names.ORE)) {
				GameRegistry.addSmelting(material.getBlock(NAME),
						material.getBlockItemStack(Names.ORE, 2), 1.0f);
			}
		}
	}
}
