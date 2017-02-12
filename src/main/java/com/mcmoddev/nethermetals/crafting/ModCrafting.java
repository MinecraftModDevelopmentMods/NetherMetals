package com.mcmoddev.nethermetals.crafting;

import com.mcmoddev.basemetals.registry.CrusherRecipeRegistry;
import com.mcmoddev.nethermetals.util.Config.Options;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModCrafting {

	public static com.mcmoddev.lib.init.Materials mmdlibMat;
	public static com.mcmoddev.basemetals.init.Materials bmmat;
	public static com.mcmoddev.modernmetals.init.Materials mmmat;
	public static com.mcmoddev.nethermetals.init.Materials nmmat;
	private ModCrafting() {
		throw new IllegalAccessError("Not a instantiable class");
	}

	@SuppressWarnings("static-access")
	public static void initCrafting() {

		if (Options.enableFurnaceSmelting) {
/**
			// Vanilla
			GameRegistry.addSmelting(Materials.getMaterialByName("coal").oreNether, new ItemStack(Blocks.COAL_ORE, 2), 1.0f);
			GameRegistry.addSmelting(Materials.getMaterialByName("diamond").oreNether, new ItemStack(Blocks.DIAMOND_ORE, 2), 1.0f);
			GameRegistry.addSmelting(Materials.getMaterialByName("emerald").oreNether, new ItemStack(Blocks.EMERALD_ORE, 2), 1.0f);
			GameRegistry.addSmelting(Materials.getMaterialByName("gold").oreNether, new ItemStack(Blocks.GOLD_ORE, 2), 1.0f);
			GameRegistry.addSmelting(Materials.getMaterialByName("iron").oreNether, new ItemStack(Blocks.IRON_ORE, 2), 1.0f);
			/
			GameRegistry.addSmelting(ModBlocks.lapisOre, new ItemStack(Blocks.LAPIS_ORE, 2), 1.0f);
			GameRegistry.addSmelting(ModBlocks.redstoneOre, new ItemStack(Blocks.REDSTONE_ORE, 2), 1.0f);
			 /

			// Vanilla BM Hammer Compat
			if (Loader.isModLoaded("basemetals")) {
				CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("coal").oreNether, new ItemStack(Blocks.COAL_ORE, 2));
				CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("diamond").oreNether, new ItemStack(Blocks.DIAMOND_ORE, 2));
				CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("emerald").oreNether, new ItemStack(Blocks.EMERALD_ORE, 2));
				CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("gold").oreNether, new ItemStack(Blocks.GOLD_ORE, 2));
				CrusherRecipeRegistry.addNewCrusherRecipe(Materials.getMaterialByName("iron").oreNether, new ItemStack(Blocks.IRON_ORE, 2));
				/**
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.lapisOre, new ItemStack(Blocks.LAPIS_ORE, 2));
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.redstoneOre, new ItemStack(Blocks.REDSTONE_ORE, 2));
				**/
			}

			// Base Metals
			if (Loader.isModLoaded("basemetals")) {

				if (com.mcmoddev.basemetals.util.Config.Options.enableAntimony) {
					GameRegistry.addSmelting(mmdlibMat.getMaterialByName("antimony").oreNether, new ItemStack(mmdlibMat.getMaterialByName("antimony").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(mmdlibMat.getMaterialByName("antimony").oreNether, new ItemStack(mmdlibMat.getMaterialByName("antimony").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enableBismuth) {
					GameRegistry.addSmelting(mmdlibMat.getMaterialByName("bismuth").oreNether, new ItemStack(mmdlibMat.getMaterialByName("bismuth").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(mmdlibMat.getMaterialByName("bismuth").oreNether, new ItemStack(mmdlibMat.getMaterialByName("bismuth").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enableCopper) {
					GameRegistry.addSmelting(mmdlibMat.getMaterialByName("copper").oreNether, new ItemStack(mmdlibMat.getMaterialByName("copper").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(mmdlibMat.getMaterialByName("copper").oreNether, new ItemStack(mmdlibMat.getMaterialByName("copper").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enableLead) {
					GameRegistry.addSmelting(mmdlibMat.getMaterialByName("lead").oreNether, new ItemStack(mmdlibMat.getMaterialByName("lead").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(mmdlibMat.getMaterialByName("lead").oreNether, new ItemStack(mmdlibMat.getMaterialByName("lead").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enableMercury) {
					GameRegistry.addSmelting(mmdlibMat.getMaterialByName("mercury").oreNether, new ItemStack(mmdlibMat.getMaterialByName("mercury").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(mmdlibMat.getMaterialByName("mercury").oreNether, new ItemStack(mmdlibMat.getMaterialByName("mercury").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enableNickel) {
					GameRegistry.addSmelting(mmdlibMat.getMaterialByName("nickel").oreNether, new ItemStack(mmdlibMat.getMaterialByName("nickel").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(mmdlibMat.getMaterialByName("nickel").oreNether, new ItemStack(mmdlibMat.getMaterialByName("nickel").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enablePlatinum) {
					GameRegistry.addSmelting(mmdlibMat.getMaterialByName("platinum").oreNether, new ItemStack(mmdlibMat.getMaterialByName("platinum").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(mmdlibMat.getMaterialByName("platinum").oreNether, new ItemStack(mmdlibMat.getMaterialByName("platinum").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enableSilver) {
					GameRegistry.addSmelting(mmdlibMat.getMaterialByName("silver").oreNether, new ItemStack(mmdlibMat.getMaterialByName("silver").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(mmdlibMat.getMaterialByName("silver").oreNether, new ItemStack(mmdlibMat.getMaterialByName("silver").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enableTin) {
					GameRegistry.addSmelting(mmdlibMat.getMaterialByName("tin").oreNether, new ItemStack(mmdlibMat.getMaterialByName("tin").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(mmdlibMat.getMaterialByName("tin").oreNether, new ItemStack(mmdlibMat.getMaterialByName("tin").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enableZinc) {
					GameRegistry.addSmelting(mmdlibMat.getMaterialByName("zinc").oreNether, new ItemStack(mmdlibMat.getMaterialByName("zinc").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(mmdlibMat.getMaterialByName("zinc").oreNether, new ItemStack(mmdlibMat.getMaterialByName("zinc").ore, 2));
				}
			}

			// Modern Metals
			if (Loader.isModLoaded("modernmetals")) {
				if (com.mcmoddev.modernmetals.util.Config.Options.enableAluminum) {
					GameRegistry.addSmelting(mmdlibMat.getMaterialByName("aluminum").oreNether, new ItemStack(mmdlibMat.getMaterialByName("aluminum").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(mmdlibMat.getMaterialByName("aluminum").oreNether, new ItemStack(mmdlibMat.getMaterialByName("aluminum").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableCadmium) {
					GameRegistry.addSmelting(mmdlibMat.getMaterialByName("cadmium").oreNether, new ItemStack(mmdlibMat.getMaterialByName("cadmium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(mmdlibMat.getMaterialByName("cadmium").oreNether, new ItemStack(mmdlibMat.getMaterialByName("cadmium").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableChromium) {
					GameRegistry.addSmelting(mmdlibMat.getMaterialByName("chromium").oreNether, new ItemStack(mmdlibMat.getMaterialByName("chromium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(mmdlibMat.getMaterialByName("chromium").oreNether, new ItemStack(mmdlibMat.getMaterialByName("chromium").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableIridium) {
					GameRegistry.addSmelting(mmdlibMat.getMaterialByName("iridium").oreNether, new ItemStack(mmdlibMat.getMaterialByName("iridium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(mmdlibMat.getMaterialByName("iridium").oreNether, new ItemStack(mmdlibMat.getMaterialByName("iridium").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableMagnesium) {
					GameRegistry.addSmelting(mmdlibMat.getMaterialByName("magnesium").oreNether, new ItemStack(mmdlibMat.getMaterialByName("magnesium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(mmdlibMat.getMaterialByName("magnesium").oreNether, new ItemStack(mmdlibMat.getMaterialByName("magnesium").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableManganese) {
					GameRegistry.addSmelting(mmdlibMat.getMaterialByName("manganese").oreNether, new ItemStack(mmdlibMat.getMaterialByName("manganese").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(mmdlibMat.getMaterialByName("manganese").oreNether, new ItemStack(mmdlibMat.getMaterialByName("manganese").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableOsmium) {
					GameRegistry.addSmelting(mmdlibMat.getMaterialByName("osmium").oreNether, new ItemStack(mmdlibMat.getMaterialByName("osmium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(mmdlibMat.getMaterialByName("osmium").oreNether, new ItemStack(mmdlibMat.getMaterialByName("osmium").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enablePlutonium) {
					GameRegistry.addSmelting(mmdlibMat.getMaterialByName("plutonium").oreNether, new ItemStack(mmdlibMat.getMaterialByName("plutonium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(mmdlibMat.getMaterialByName("plutonium").oreNether, new ItemStack(mmdlibMat.getMaterialByName("plutonium").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableRutile) {
					GameRegistry.addSmelting(mmdlibMat.getMaterialByName("rutile").oreNether, new ItemStack(mmdlibMat.getMaterialByName("rutile").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(mmdlibMat.getMaterialByName("rutile").oreNether, new ItemStack(mmdlibMat.getMaterialByName("rutile").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableTantalum) {
					GameRegistry.addSmelting(mmdlibMat.getMaterialByName("tantalum").oreNether, new ItemStack(mmdlibMat.getMaterialByName("tantalum").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(mmdlibMat.getMaterialByName("tantalum").oreNether, new ItemStack(mmdlibMat.getMaterialByName("tantalum").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableTitanium) {
					GameRegistry.addSmelting(mmdlibMat.getMaterialByName("titanium").oreNether, new ItemStack(mmdlibMat.getMaterialByName("titanium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(mmdlibMat.getMaterialByName("titanium").oreNether, new ItemStack(mmdlibMat.getMaterialByName("titanium").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableTungsten) {
					GameRegistry.addSmelting(mmdlibMat.getMaterialByName("tungsten").oreNether, new ItemStack(mmdlibMat.getMaterialByName("tungsten").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(mmdlibMat.getMaterialByName("tungsten").oreNether, new ItemStack(mmdlibMat.getMaterialByName("tungsten").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableUranium) {
					GameRegistry.addSmelting(mmdlibMat.getMaterialByName("uranium").oreNether, new ItemStack(mmdlibMat.getMaterialByName("uranium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(mmdlibMat.getMaterialByName("uranium").oreNether, new ItemStack(mmdlibMat.getMaterialByName("uranium").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableZirconium) {
					GameRegistry.addSmelting(mmdlibMat.getMaterialByName("zirconium").oreNether, new ItemStack(mmdlibMat.getMaterialByName("zirconium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(mmdlibMat.getMaterialByName("zirconium").oreNether, new ItemStack(mmdlibMat.getMaterialByName("zirconium").ore, 2));
				}
			}
		}
	}

