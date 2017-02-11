package com.mcmoddev.nethermetals.crafting;

import com.mcmoddev.basemetals.registry.CrusherRecipeRegistry;
import com.mcmoddev.basemetals.init.Materials;
import com.mcmoddev.nethermetals.util.Config.Options;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModCrafting {

	private ModCrafting() {
		throw new IllegalAccessError("Not a instantiable class");
	}

	public static void initCrafting() {

		if (Options.enableFurnaceSmelting) {
   
			// Vanilla
			GameRegistry.addSmelting(Materials.getMaterialByName("coal").oreNether, new ItemStack(Blocks.COAL_ORE, 2), 1.0f);
			GameRegistry.addSmelting(Materials.getMaterialByName("diamond").oreNether, new ItemStack(Blocks.DIAMOND_ORE, 2), 1.0f);
			GameRegistry.addSmelting(Materials.getMaterialByName("emerald").oreNether, new ItemStack(Blocks.EMERALD_ORE, 2), 1.0f);
			GameRegistry.addSmelting(Materials.getMaterialByName("gold").oreNether, new ItemStack(Blocks.GOLD_ORE, 2), 1.0f);
			GameRegistry.addSmelting(Materials.getMaterialByName("iron").oreNether, new ItemStack(Blocks.IRON_ORE, 2), 1.0f);
			/*
			GameRegistry.addSmelting(ModBlocks.lapisOre, new ItemStack(Blocks.LAPIS_ORE, 2), 1.0f);
			GameRegistry.addSmelting(ModBlocks.redstoneOre, new ItemStack(Blocks.REDSTONE_ORE, 2), 1.0f);
			 */

			// Vanilla BM Hammer Compat
			if (Loader.isModLoaded("basemetals")) {
				CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("coal").oreNether, new ItemStack(Blocks.COAL_ORE, 2));
				CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("diamond").oreNether, new ItemStack(Blocks.DIAMOND_ORE, 2));
				CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("emerald").oreNether, new ItemStack(Blocks.EMERALD_ORE, 2));
				CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("gold").oreNether, new ItemStack(Blocks.GOLD_ORE, 2));
				CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("iron").oreNether, new ItemStack(Blocks.IRON_ORE, 2));
				/*
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.lapisOre, new ItemStack(Blocks.LAPIS_ORE, 2));
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.redstoneOre, new ItemStack(Blocks.REDSTONE_ORE, 2));
				*/
			}

			// Base Metals
			if (Loader.isModLoaded("basemetals")) {

				if (com.mcmoddev.basemetals.util.Config.Options.enableAntimony) {
					GameRegistry.addSmelting(Materials.getMaterialByName("antimony").oreNether, new ItemStack(Materials.getMaterialByName("antimony").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("antimony").oreNether, new ItemStack(Materials.getMaterialByName("antimony").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enableBismuth) {
					GameRegistry.addSmelting(Materials.getMaterialByName("bismuth").oreNether, new ItemStack(Materials.getMaterialByName("bismuth").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("bismuth").oreNether, new ItemStack(Materials.getMaterialByName("bismuth").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enableCopper) {
					GameRegistry.addSmelting(Materials.getMaterialByName("copper").oreNether, new ItemStack(Materials.getMaterialByName("copper").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("copper").oreNether, new ItemStack(Materials.getMaterialByName("copper").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enableLead) {
					GameRegistry.addSmelting(Materials.getMaterialByName("lead").oreNether, new ItemStack(Materials.getMaterialByName("lead").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("lead").oreNether, new ItemStack(Materials.getMaterialByName("lead").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enableMercury) {
					GameRegistry.addSmelting(Materials.getMaterialByName("mercury").oreNether, new ItemStack(Materials.getMaterialByName("mercury").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("mercury").oreNether, new ItemStack(Materials.getMaterialByName("mercury").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enableNickel) {
					GameRegistry.addSmelting(Materials.getMaterialByName("nickel").oreNether, new ItemStack(Materials.getMaterialByName("nickel").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("nickel").oreNether, new ItemStack(Materials.getMaterialByName("nickel").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enablePlatinum) {
					GameRegistry.addSmelting(Materials.getMaterialByName("platinum").oreNether, new ItemStack(Materials.getMaterialByName("platinum").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("platinum").oreNether, new ItemStack(Materials.getMaterialByName("platinum").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enableSilver) {
					GameRegistry.addSmelting(Materials.getMaterialByName("silver").oreNether, new ItemStack(Materials.getMaterialByName("silver").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("silver").oreNether, new ItemStack(Materials.getMaterialByName("silver").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enableTin) {
					GameRegistry.addSmelting(Materials.getMaterialByName("tin").oreNether, new ItemStack(Materials.getMaterialByName("tin").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("tin").oreNether, new ItemStack(Materials.getMaterialByName("tin").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enableZinc) {
					GameRegistry.addSmelting(Materials.getMaterialByName("zinc").oreNether, new ItemStack(Materials.getMaterialByName("zinc").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("zinc").oreNether, new ItemStack(Materials.getMaterialByName("zinc").ore, 2));
				}
			}

			// Modern Metals
			if (Loader.isModLoaded("modernmetals")) {
				if (com.mcmoddev.modernmetals.util.Config.Options.enableAluminum) {
					GameRegistry.addSmelting(Materials.getMaterialByName("aluminum").oreNether, new ItemStack(Materials.getMaterialByName("aluminum").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("aluminum").oreNether, new ItemStack(Materials.getMaterialByName("aluminum").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableCadmium) {
					GameRegistry.addSmelting(Materials.getMaterialByName("cadmium").oreNether, new ItemStack(Materials.getMaterialByName("cadmium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("cadmium").oreNether, new ItemStack(Materials.getMaterialByName("cadmium").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableChromium) {
					GameRegistry.addSmelting(Materials.getMaterialByName("chromium").oreNether, new ItemStack(Materials.getMaterialByName("chromium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("chromium").oreNether, new ItemStack(Materials.getMaterialByName("chromium").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableIridium) {
					GameRegistry.addSmelting(Materials.getMaterialByName("iridium").oreNether, new ItemStack(Materials.getMaterialByName("iridium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("iridium").oreNether, new ItemStack(Materials.getMaterialByName("iridium").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableMagnesium) {
					GameRegistry.addSmelting(Materials.getMaterialByName("magnesium").oreNether, new ItemStack(Materials.getMaterialByName("magnesium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("magnesium").oreNether, new ItemStack(Materials.getMaterialByName("magnesium").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableManganese) {
					GameRegistry.addSmelting(Materials.getMaterialByName("manganese").oreNether, new ItemStack(Materials.getMaterialByName("manganese").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("manganese").oreNether, new ItemStack(Materials.getMaterialByName("manganese").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableOsmium) {
					GameRegistry.addSmelting(Materials.getMaterialByName("osmium").oreNether, new ItemStack(Materials.getMaterialByName("osmium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("osmium").oreNether, new ItemStack(Materials.getMaterialByName("osmium").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enablePlutonium) {
					GameRegistry.addSmelting(Materials.getMaterialByName("plutonium").oreNether, new ItemStack(Materials.getMaterialByName("plutonium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("plutonium").oreNether, new ItemStack(Materials.getMaterialByName("plutonium").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableRutile) {
					GameRegistry.addSmelting(Materials.getMaterialByName("rutile").oreNether, new ItemStack(Materials.getMaterialByName("rutile").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("rutile").oreNether, new ItemStack(Materials.getMaterialByName("rutile").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableTantalum) {
					GameRegistry.addSmelting(Materials.getMaterialByName("tantalum").oreNether, new ItemStack(Materials.getMaterialByName("tantalum").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("tantalum").oreNether, new ItemStack(Materials.getMaterialByName("tantalum").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableTitanium) {
					GameRegistry.addSmelting(Materials.getMaterialByName("titanium").oreNether, new ItemStack(Materials.getMaterialByName("titanium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("titanium").oreNether, new ItemStack(Materials.getMaterialByName("titanium").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableTungsten) {
					GameRegistry.addSmelting(Materials.getMaterialByName("tungsten").oreNether, new ItemStack(Materials.getMaterialByName("tungsten").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("tungsten").oreNether, new ItemStack(Materials.getMaterialByName("tungsten").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableUranium) {
					GameRegistry.addSmelting(Materials.getMaterialByName("uranium").oreNether, new ItemStack(Materials.getMaterialByName("uranium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("uranium").oreNether, new ItemStack(Materials.getMaterialByName("uranium").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableZirconium) {
					GameRegistry.addSmelting(Materials.getMaterialByName("zirconium").oreNether, new ItemStack(Materials.getMaterialByName("zirconium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("zirconium").oreNether, new ItemStack(Materials.getMaterialByName("zirconium").ore, 2));
				}
			}
		}
	}
}
