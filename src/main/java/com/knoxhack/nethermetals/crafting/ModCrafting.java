package com.knoxhack.nethermetals.crafting;

import com.mcmoddev.basemetals.registry.CrusherRecipeRegistry;
import com.mcmoddev.lib.init.Materials;
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
			if (com.mcmoddev.basemetals.util.Config.Options.enableAntimony) {
				GameRegistry.addSmelting(ModBlocks.antimony_ore, new ItemStack(Materials.getMaterialByName("antimony").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.antimony_ore, new ItemStack(Materials.getMaterialByName("antimony").ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.enableBismuth) {
				GameRegistry.addSmelting(ModBlocks.bismuth_ore, new ItemStack(Materials.getMaterialByName("bismuth").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.bismuth_ore, new ItemStack(Materials.getMaterialByName("bismuth").ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.enableCopper) {
				GameRegistry.addSmelting(ModBlocks.copper_ore, new ItemStack(Materials.getMaterialByName("copper").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.copper_ore, new ItemStack(Materials.getMaterialByName("copper").ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.enableLead) {
				GameRegistry.addSmelting(ModBlocks.lead_ore, new ItemStack(Materials.getMaterialByName("lead").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.lead_ore, new ItemStack(Materials.getMaterialByName("lead").ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.enableMercury) {
				GameRegistry.addSmelting(ModBlocks.mercury_ore, new ItemStack(com.mcmoddev.basemetals.init.Blocks.mercury_ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.mercury_ore, new ItemStack(com.mcmoddev.basemetals.init.Blocks.mercury_ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.enableNickel) {
				GameRegistry.addSmelting(ModBlocks.nickel_ore, new ItemStack(Materials.getMaterialByName("nickel").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.nickel_ore, new ItemStack(Materials.getMaterialByName("nickel").ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.enablePlatinum) {
				GameRegistry.addSmelting(ModBlocks.platinum_ore, new ItemStack(Materials.getMaterialByName("platinum").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.platinum_ore, new ItemStack(Materials.getMaterialByName("platinum").ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.enableSilver) {
				GameRegistry.addSmelting(ModBlocks.silver_ore, new ItemStack(Materials.getMaterialByName("silver").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.silver_ore, new ItemStack(Materials.getMaterialByName("silver").ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.enableTin) {
				GameRegistry.addSmelting(ModBlocks.tin_ore, new ItemStack(Materials.getMaterialByName("tin").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.tin_ore, new ItemStack(Materials.getMaterialByName("tin").ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.enableZinc) {
				GameRegistry.addSmelting(ModBlocks.zinc_ore, new ItemStack(Materials.getMaterialByName("zinc").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.zinc_ore, new ItemStack(Materials.getMaterialByName("zinc").ore, 2));
			}
		}

		// Modern Metals
		if (Loader.isModLoaded("modernmetals")) {
			if (com.mcmoddev.modernmetals.util.Config.Options.enableAluminum) {
				GameRegistry.addSmelting(ModBlocks.aluminum_ore, new ItemStack(Materials.getMaterialByName("aluminum").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.aluminum_ore, new ItemStack(Materials.getMaterialByName("aluminum").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enableCadmium) {
				GameRegistry.addSmelting(ModBlocks.cadmium_ore, new ItemStack(Materials.getMaterialByName("cadmium").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.cadmium_ore, new ItemStack(Materials.getMaterialByName("cadmium").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enableChromium) {
				GameRegistry.addSmelting(ModBlocks.chromium_ore, new ItemStack(Materials.getMaterialByName("chromium").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.chromium_ore, new ItemStack(Materials.getMaterialByName("chromium").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enableIridium) {
				GameRegistry.addSmelting(ModBlocks.iridium_ore, new ItemStack(Materials.getMaterialByName("iridium").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.iridium_ore, new ItemStack(Materials.getMaterialByName("iridium").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enableMagnesium) {
				GameRegistry.addSmelting(ModBlocks.magnesium_ore, new ItemStack(Materials.getMaterialByName("magnesium").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.magnesium_ore, new ItemStack(Materials.getMaterialByName("magnesium").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enableManganese) {
				GameRegistry.addSmelting(ModBlocks.manganese_ore, new ItemStack(Materials.getMaterialByName("manganese").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.manganese_ore, new ItemStack(Materials.getMaterialByName("manganese").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enableOsmium) {
				GameRegistry.addSmelting(ModBlocks.osmium_ore, new ItemStack(Materials.getMaterialByName("osmium").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.osmium_ore, new ItemStack(Materials.getMaterialByName("osmium").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enablePlutonium) {
				GameRegistry.addSmelting(ModBlocks.plutonium_ore, new ItemStack(Materials.getMaterialByName("plutonium").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.plutonium_ore, new ItemStack(Materials.getMaterialByName("plutonium").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enableRutile) {
				GameRegistry.addSmelting(ModBlocks.rutile_ore, new ItemStack(Materials.getMaterialByName("rutile").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.rutile_ore, new ItemStack(Materials.getMaterialByName("rutile").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enableTantalum) {
				GameRegistry.addSmelting(ModBlocks.tantalum_ore, new ItemStack(Materials.getMaterialByName("tantalum").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.tantalum_ore, new ItemStack(Materials.getMaterialByName("tantalum").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enableTitanium) {
				GameRegistry.addSmelting(ModBlocks.titanium_ore, new ItemStack(Materials.getMaterialByName("titanium").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.titanium_ore, new ItemStack(Materials.getMaterialByName("titanium").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enableTungsten) {
				GameRegistry.addSmelting(ModBlocks.tungsten_ore, new ItemStack(Materials.getMaterialByName("tungsten").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.tungsten_ore, new ItemStack(Materials.getMaterialByName("tungsten").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enableUranium) {
				GameRegistry.addSmelting(ModBlocks.uranium_ore, new ItemStack(Materials.getMaterialByName("uranium").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.uranium_ore, new ItemStack(Materials.getMaterialByName("uranium").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enableZirconium) {
				GameRegistry.addSmelting(ModBlocks.zirconium_ore, new ItemStack(Materials.getMaterialByName("zirconium").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.zirconium_ore, new ItemStack(Materials.getMaterialByName("zirconium").ore, 2));
			}
		}
	}
}
