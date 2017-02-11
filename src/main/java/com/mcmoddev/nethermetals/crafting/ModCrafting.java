package com.mcmoddev.nethermetals.crafting;

import com.mcmoddev.basemetals.registry.CrusherRecipeRegistry;
import com.mcmoddev.basemetals.init.Materials;
import com.mcmoddev.nethermetals.init.MaterialsNetherOre;
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

		/**
    
		// Vanilla
		GameRegistry.addSmelting(ModBlocks.coalOre, new ItemStack(Blocks.COAL_ORE, 2), 1.0f);
		GameRegistry.addSmelting(ModBlocks.diamondOre, new ItemStack(Blocks.DIAMOND_ORE, 2), 1.0f);
		GameRegistry.addSmelting(ModBlocks.emeraldOre, new ItemStack(Blocks.EMERALD_ORE, 2), 1.0f);
		GameRegistry.addSmelting(ModBlocks.goldOre, new ItemStack(Blocks.GOLD_ORE, 2), 1.0f);
		GameRegistry.addSmelting(ModBlocks.ironOre, new ItemStack(Blocks.IRON_ORE, 2), 1.0f);
		GameRegistry.addSmelting(ModBlocks.lapisOre, new ItemStack(Blocks.LAPIS_ORE, 2), 1.0f);
		GameRegistry.addSmelting(ModBlocks.redstoneOre, new ItemStack(Blocks.REDSTONE_ORE, 2), 1.0f);

		// Vanilla BM Hammer Compat
		if (Loader.isModLoaded("basemetals")) {
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.coalOre, new ItemStack(Blocks.COAL_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.diamondOre, new ItemStack(Blocks.DIAMOND_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.emeraldOre, new ItemStack(Blocks.EMERALD_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.goldOre, new ItemStack(Blocks.GOLD_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.ironOre, new ItemStack(Blocks.IRON_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.lapisOre, new ItemStack(Blocks.LAPIS_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.redstoneOre, new ItemStack(Blocks.REDSTONE_ORE, 2));
		}
**/
		// Base Metals
		if (Loader.isModLoaded("basemetals")) {
			if (com.mcmoddev.basemetals.util.Config.Options.enableAntimony) {
				GameRegistry.addSmelting(MaterialsNetherOre.getMaterialByName("antimony").oreNether, new ItemStack(Materials.getMaterialByName("antimony").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(MaterialsNetherOre.getMaterialByName("antimony").oreNether, new ItemStack(Materials.getMaterialByName("antimony").ore, 2));
			}
			
			
			
			/**
			if (com.mcmoddev.basemetals.util.Config.Options.enableBismuth) {
				GameRegistry.addSmelting(ModBlocks.bismuthOre, new ItemStack(Materials.getMaterialByName("bismuth").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.bismuthOre, new ItemStack(Materials.getMaterialByName("bismuth").ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.enableCopper) {
				GameRegistry.addSmelting(ModBlocks.copperOre, new ItemStack(Materials.getMaterialByName("copper").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.copperOre, new ItemStack(Materials.getMaterialByName("copper").ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.enableLead) {
				GameRegistry.addSmelting(ModBlocks.leadOre, new ItemStack(Materials.getMaterialByName("lead").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.leadOre, new ItemStack(Materials.getMaterialByName("lead").ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.enableMercury) {
				GameRegistry.addSmelting(ModBlocks.mercuryOre, new ItemStack(Materials.getMaterialByName("mercury").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.mercuryOre, new ItemStack(Materials.getMaterialByName("mercury").ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.enableNickel) {
				GameRegistry.addSmelting(ModBlocks.nickelOre, new ItemStack(Materials.getMaterialByName("nickel").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.nickelOre, new ItemStack(Materials.getMaterialByName("nickel").ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.enablePlatinum) {
				GameRegistry.addSmelting(ModBlocks.platinumOre, new ItemStack(Materials.getMaterialByName("platinum").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.platinumOre, new ItemStack(Materials.getMaterialByName("platinum").ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.enableSilver) {
				GameRegistry.addSmelting(ModBlocks.silverOre, new ItemStack(Materials.getMaterialByName("silver").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.silverOre, new ItemStack(Materials.getMaterialByName("silver").ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.enableTin) {
				GameRegistry.addSmelting(ModBlocks.tinOre, new ItemStack(Materials.getMaterialByName("tin").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.tinOre, new ItemStack(Materials.getMaterialByName("tin").ore, 2));
			}
			if (com.mcmoddev.basemetals.util.Config.Options.enableZinc) {
				GameRegistry.addSmelting(ModBlocks.zincOre, new ItemStack(Materials.getMaterialByName("zinc").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.zincOre, new ItemStack(Materials.getMaterialByName("zinc").ore, 2));
			}
		}

		// Modern Metals
		if (Loader.isModLoaded("modernmetals")) {
			if (com.mcmoddev.modernmetals.util.Config.Options.enableAluminum) {
				GameRegistry.addSmelting(ModBlocks.aluminumOre, new ItemStack(Materials.getMaterialByName("aluminum").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.aluminumOre, new ItemStack(Materials.getMaterialByName("aluminum").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enableCadmium) {
				GameRegistry.addSmelting(ModBlocks.cadmiumOre, new ItemStack(Materials.getMaterialByName("cadmium").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.cadmiumOre, new ItemStack(Materials.getMaterialByName("cadmium").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enableChromium) {
				GameRegistry.addSmelting(ModBlocks.chromiumOre, new ItemStack(Materials.getMaterialByName("chromium").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.chromiumOre, new ItemStack(Materials.getMaterialByName("chromium").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enableIridium) {
				GameRegistry.addSmelting(ModBlocks.iridiumOre, new ItemStack(Materials.getMaterialByName("iridium").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.iridiumOre, new ItemStack(Materials.getMaterialByName("iridium").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enableMagnesium) {
				GameRegistry.addSmelting(ModBlocks.magnesiumOre, new ItemStack(Materials.getMaterialByName("magnesium").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.magnesiumOre, new ItemStack(Materials.getMaterialByName("magnesium").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enableManganese) {
				GameRegistry.addSmelting(ModBlocks.manganeseOre, new ItemStack(Materials.getMaterialByName("manganese").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.manganeseOre, new ItemStack(Materials.getMaterialByName("manganese").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enableOsmium) {
				GameRegistry.addSmelting(ModBlocks.osmiumOre, new ItemStack(Materials.getMaterialByName("osmium").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.osmiumOre, new ItemStack(Materials.getMaterialByName("osmium").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enablePlutonium) {
				GameRegistry.addSmelting(ModBlocks.plutoniumOre, new ItemStack(Materials.getMaterialByName("plutonium").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.plutoniumOre, new ItemStack(Materials.getMaterialByName("plutonium").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enableRutile) {
				GameRegistry.addSmelting(ModBlocks.rutileOre, new ItemStack(Materials.getMaterialByName("rutile").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.rutileOre, new ItemStack(Materials.getMaterialByName("rutile").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enableTantalum) {
				GameRegistry.addSmelting(ModBlocks.tantalumOre, new ItemStack(Materials.getMaterialByName("tantalum").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.tantalumOre, new ItemStack(Materials.getMaterialByName("tantalum").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enableTitanium) {
				GameRegistry.addSmelting(ModBlocks.titaniumOre, new ItemStack(Materials.getMaterialByName("titanium").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.titaniumOre, new ItemStack(Materials.getMaterialByName("titanium").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enableTungsten) {
				GameRegistry.addSmelting(ModBlocks.tungstenOre, new ItemStack(Materials.getMaterialByName("tungsten").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.tungstenOre, new ItemStack(Materials.getMaterialByName("tungsten").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enableUranium) {
				GameRegistry.addSmelting(ModBlocks.uraniumOre, new ItemStack(Materials.getMaterialByName("uranium").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.uraniumOre, new ItemStack(Materials.getMaterialByName("uranium").ore, 2));
			}
			if (com.mcmoddev.modernmetals.util.Config.Options.enableZirconium) {
				GameRegistry.addSmelting(ModBlocks.zirconiumOre, new ItemStack(Materials.getMaterialByName("zirconium").ore, 2), 1.0f);
				CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.zirconiumOre, new ItemStack(Materials.getMaterialByName("zirconium").ore, 2));
			}
			
			**/
		}
	}
}}
