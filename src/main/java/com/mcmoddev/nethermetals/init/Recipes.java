package com.mcmoddev.nethermetals.init;

import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.registry.CrusherRecipeRegistry;
import com.mcmoddev.nethermetals.NetherMetals;
import com.mcmoddev.lib.util.ConfigBase.Options;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class Recipes {

	private Recipes() {
		throw new IllegalAccessError("Not a instantiable class");
	}

	public static void init() {

		// Vanilla
		recipeWrapper(true, "coal");
		recipeWrapper(true, "diamond");
		recipeWrapper(true, "emerald");
		recipeWrapper(true, "gold");
		recipeWrapper(true, "iron");
		recipeWrapper(true, "lapis");
		recipeWrapper(true, "redstone");

		// Base Metals
		if (Loader.isModLoaded("basemetals")) {
			recipeWrapper(true, "antimony");
			recipeWrapper(true, "bismuth");
			recipeWrapper(true, "copper");
			recipeWrapper(true, "lead");
			recipeWrapper(true, "mercury");
			recipeWrapper(true, "nickel");
			recipeWrapper(true, "platinum");
			recipeWrapper(true, "silver");
			recipeWrapper(true, "tin");
			recipeWrapper(true, "zinc");
		}

		// Modern Metals
		if (Loader.isModLoaded("modernmetals")) {
			recipeWrapper(true, "aluminum");
			recipeWrapper(true, "cadmium");
			recipeWrapper(true, "chromium");
			recipeWrapper(true, "iridium");
			recipeWrapper(true, "magnesium");
			recipeWrapper(true, "manganese");
			recipeWrapper(true, "osmium");
			recipeWrapper(true, "plutonium");
			recipeWrapper(true, "rutile");
			recipeWrapper(true, "tantalum");
			recipeWrapper(true, "titanium");
			recipeWrapper(true, "tungsten");
			recipeWrapper(true, "uranium");
			recipeWrapper(true, "zirconium");
		}
	}

	private static void recipeWrapper(boolean enabled, String materialName) {
		if (enabled && Materials.hasMaterial(materialName)) {
			MMDMaterial material = Materials.getMaterialByName(materialName);
			if (material.getBlock(Names.NETHERORE) != null) {
				boolean makeDusts = Options.isThingEnabled("makeDusts");
				boolean smeltToIngots = Options.isThingEnabled("smeltToIngots");
				if (Options.isThingEnabled("enableFurnaceSmelting")) {
					if (smeltToIngots) {
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
				if (makeDusts) {
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
			}
		}
	}
}
