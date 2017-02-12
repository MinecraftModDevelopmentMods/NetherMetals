package com.mcmoddev.nethermetals.crafting;

import com.mcmoddev.basemetals.registry.CrusherRecipeRegistry;
import com.mcmoddev.nethermetals.init.Materials;
import com.mcmoddev.nethermetals.util.Config.Options;

import net.minecraft.init.Blocks;
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
					GameRegistry.addSmelting(nmmat.getMaterialByName("antimony").oreNether, new ItemStack(bmmat.getMaterialByName("antimony").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(nmmat.getMaterialByName("antimony").oreNether, new ItemStack(bmmat.getMaterialByName("antimony").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enableBismuth) {
					GameRegistry.addSmelting(nmmat.getMaterialByName("bismuth").oreNether, new ItemStack(bmmat.getMaterialByName("bismuth").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(nmmat.getMaterialByName("bismuth").oreNether, new ItemStack(bmmat.getMaterialByName("bismuth").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enableCopper) {
					GameRegistry.addSmelting(nmmat.getMaterialByName("copper").oreNether, new ItemStack(bmmat.getMaterialByName("copper").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(nmmat.getMaterialByName("copper").oreNether, new ItemStack(bmmat.getMaterialByName("copper").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enableLead) {
					GameRegistry.addSmelting(nmmat.getMaterialByName("lead").oreNether, new ItemStack(bmmat.getMaterialByName("lead").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(nmmat.getMaterialByName("lead").oreNether, new ItemStack(bmmat.getMaterialByName("lead").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enableMercury) {
					GameRegistry.addSmelting(nmmat.getMaterialByName("mercury").oreNether, new ItemStack(bmmat.getMaterialByName("mercury").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(nmmat.getMaterialByName("mercury").oreNether, new ItemStack(bmmat.getMaterialByName("mercury").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enableNickel) {
					GameRegistry.addSmelting(nmmat.getMaterialByName("nickel").oreNether, new ItemStack(bmmat.getMaterialByName("nickel").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(nmmat.getMaterialByName("nickel").oreNether, new ItemStack(bmmat.getMaterialByName("nickel").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enablePlatinum) {
					GameRegistry.addSmelting(nmmat.getMaterialByName("platinum").oreNether, new ItemStack(bmmat.getMaterialByName("platinum").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(nmmat.getMaterialByName("platinum").oreNether, new ItemStack(bmmat.getMaterialByName("platinum").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enableSilver) {
					GameRegistry.addSmelting(nmmat.getMaterialByName("silver").oreNether, new ItemStack(bmmat.getMaterialByName("silver").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(nmmat.getMaterialByName("silver").oreNether, new ItemStack(bmmat.getMaterialByName("silver").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enableTin) {
					GameRegistry.addSmelting(nmmat.getMaterialByName("tin").oreNether, new ItemStack(bmmat.getMaterialByName("tin").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(nmmat.getMaterialByName("tin").oreNether, new ItemStack(bmmat.getMaterialByName("tin").ore, 2));
				}
				if (com.mcmoddev.basemetals.util.Config.Options.enableZinc) {
					GameRegistry.addSmelting(nmmat.getMaterialByName("zinc").oreNether, new ItemStack(bmmat.getMaterialByName("zinc").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(nmmat.getMaterialByName("zinc").oreNether, new ItemStack(bmmat.getMaterialByName("zinc").ore, 2));
				}
			}

			// Modern Metals
			if (Loader.isModLoaded("modernmetals")) {
				if (com.mcmoddev.modernmetals.util.Config.Options.enableAluminum) {
					GameRegistry.addSmelting(nmmat.getMaterialByName("aluminum").oreNether, new ItemStack(mmmat.getMaterialByName("aluminum").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(nmmat.getMaterialByName("aluminum").oreNether, new ItemStack(mmmat.getMaterialByName("aluminum").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableCadmium) {
					GameRegistry.addSmelting(nmmat.getMaterialByName("cadmium").oreNether, new ItemStack(mmmat.getMaterialByName("cadmium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(nmmat.getMaterialByName("cadmium").oreNether, new ItemStack(mmmat.getMaterialByName("cadmium").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableChromium) {
					GameRegistry.addSmelting(nmmat.getMaterialByName("chromium").oreNether, new ItemStack(mmmat.getMaterialByName("chromium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(nmmat.getMaterialByName("chromium").oreNether, new ItemStack(mmmat.getMaterialByName("chromium").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableIridium) {
					GameRegistry.addSmelting(nmmat.getMaterialByName("iridium").oreNether, new ItemStack(mmmat.getMaterialByName("iridium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(nmmat.getMaterialByName("iridium").oreNether, new ItemStack(mmmat.getMaterialByName("iridium").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableMagnesium) {
					GameRegistry.addSmelting(nmmat.getMaterialByName("magnesium").oreNether, new ItemStack(mmmat.getMaterialByName("magnesium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(nmmat.getMaterialByName("magnesium").oreNether, new ItemStack(mmmat.getMaterialByName("magnesium").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableManganese) {
					GameRegistry.addSmelting(nmmat.getMaterialByName("manganese").oreNether, new ItemStack(mmmat.getMaterialByName("manganese").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(nmmat.getMaterialByName("manganese").oreNether, new ItemStack(mmmat.getMaterialByName("manganese").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableOsmium) {
					GameRegistry.addSmelting(nmmat.getMaterialByName("osmium").oreNether, new ItemStack(mmmat.getMaterialByName("osmium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(nmmat.getMaterialByName("osmium").oreNether, new ItemStack(mmmat.getMaterialByName("osmium").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enablePlutonium) {
					GameRegistry.addSmelting(nmmat.getMaterialByName("plutonium").oreNether, new ItemStack(mmmat.getMaterialByName("plutonium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(nmmat.getMaterialByName("plutonium").oreNether, new ItemStack(mmmat.getMaterialByName("plutonium").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableRutile) {
					GameRegistry.addSmelting(nmmat.getMaterialByName("rutile").oreNether, new ItemStack(mmmat.getMaterialByName("rutile").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(nmmat.getMaterialByName("rutile").oreNether, new ItemStack(mmmat.getMaterialByName("rutile").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableTantalum) {
					GameRegistry.addSmelting(nmmat.getMaterialByName("tantalum").oreNether, new ItemStack(mmmat.getMaterialByName("tantalum").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(nmmat.getMaterialByName("tantalum").oreNether, new ItemStack(mmmat.getMaterialByName("tantalum").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableTitanium) {
					GameRegistry.addSmelting(nmmat.getMaterialByName("titanium").oreNether, new ItemStack(mmmat.getMaterialByName("titanium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(nmmat.getMaterialByName("titanium").oreNether, new ItemStack(mmmat.getMaterialByName("titanium").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableTungsten) {
					GameRegistry.addSmelting(nmmat.getMaterialByName("tungsten").oreNether, new ItemStack(mmmat.getMaterialByName("tungsten").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(nmmat.getMaterialByName("tungsten").oreNether, new ItemStack(mmmat.getMaterialByName("tungsten").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableUranium) {
					GameRegistry.addSmelting(nmmat.getMaterialByName("uranium").oreNether, new ItemStack(mmmat.getMaterialByName("uranium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(nmmat.getMaterialByName("uranium").oreNether, new ItemStack(mmmat.getMaterialByName("uranium").ore, 2));
				}
				if (com.mcmoddev.modernmetals.util.Config.Options.enableZirconium) {
					GameRegistry.addSmelting(nmmat.getMaterialByName("zirconium").oreNether, new ItemStack(mmmat.getMaterialByName("zirconium").ore, 2), 1.0f);
					CrusherRecipeRegistry.addNewCrusherRecipe(nmmat.getMaterialByName("zirconium").oreNether, new ItemStack(mmmat.getMaterialByName("zirconium").ore, 2));
				}
			}
		}
	}

