package com.knoxhack.nethermetals.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModBlocks {

    public static Block nethercopperOre;
    public static Block nethertinOre;
    public static Block netherleadOre;
    public static Block nethersilverOre;
    public static Block nethernickelOre;
    public static Block netherzincOre;
    public static Block nethermercuryOre;
    public static Block netherplatinumOre;

    public static Block netherironOre;
    public static Block netherlapisOre;
    public static Block netherredstoneOre;
    public static Block netherdiamondOre;
    public static Block nethergoldOre;
    public static Block nethercoalOre;
    public static Block netheremeraldOre;

    public static void createBlocks() {
    	// Vanilla
    	GameRegistry.registerBlock(netherironOre = new ModBlockOre("nether_iron_ore", Material.rock, ModBlocks.netherironOre, 1, 1), "nether_iron_ore");
		GameRegistry.registerBlock(netherlapisOre = new ModBlockOre("nether_lapis_ore", Material.rock, ModBlocks.netherlapisOre, 1, 1), "nether_lapis_ore");
		GameRegistry.registerBlock(netherredstoneOre = new ModBlockOre("nether_redstone_ore", Material.rock, ModBlocks.netherredstoneOre, 1, 1), "nether_redstone_ore");
		GameRegistry.registerBlock(netherdiamondOre = new ModBlockOre3("nether_diamond_ore", Material.rock, ModBlocks.netherdiamondOre, 1, 1), "nether_diamond_ore");
		GameRegistry.registerBlock(nethergoldOre = new ModBlockOre2("nether_gold_ore", Material.rock, ModBlocks.nethergoldOre, 1, 1), "nether_gold_ore");
		GameRegistry.registerBlock(nethercoalOre = new ModBlockOre("nether_coal_ore", Material.rock, ModBlocks.nethercoalOre, 1, 1), "nether_coal_ore");
		GameRegistry.registerBlock(netheremeraldOre = new ModBlockOre("nether_emerald_ore", Material.rock, ModBlocks.netheremeraldOre, 1, 1), "nether_emerald_ore");

		// Base Metals
		GameRegistry.registerBlock(nethercopperOre = new ModBlockOre("nether_copper_ore", Material.rock, ModBlocks.nethercopperOre, 1, 1), "nether_copper_ore");
		GameRegistry.registerBlock(nethertinOre = new ModBlockOre("nether_tin_ore", Material.rock, ModBlocks.nethertinOre, 1, 1), "nether_tin_ore");
		GameRegistry.registerBlock(netherleadOre = new ModBlockOre("nether_lead_ore", Material.rock, ModBlocks.netherleadOre, 1, 1), "nether_lead_ore");
		GameRegistry.registerBlock(nethersilverOre = new ModBlockOre2("nether_silver_ore", Material.rock, ModBlocks.nethersilverOre, 1, 1), "nether_silver_ore");
		GameRegistry.registerBlock(netherzincOre = new ModBlockOre("nether_zinc_ore", Material.rock, ModBlocks.netherzincOre, 1, 1), "nether_zinc_ore");
		GameRegistry.registerBlock(nethernickelOre = new ModBlockOre("nether_nickel_ore", Material.rock, ModBlocks.nethernickelOre, 1, 1), "nether_nickel_ore");
		GameRegistry.registerBlock(nethermercuryOre = new ModBlockOre("nether_mercury_ore", Material.rock, ModBlocks.nethernickelOre, 1, 1), "nether_mercury_ore");
		GameRegistry.registerBlock(netherplatinumOre = new ModBlockOre("nether_platinum_ore", Material.rock, ModBlocks.nethernickelOre, 1, 1), "nether_platinum_ore");

		// TODO: Modern Metals
    }
}
