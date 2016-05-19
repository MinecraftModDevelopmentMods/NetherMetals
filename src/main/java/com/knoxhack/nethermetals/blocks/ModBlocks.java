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

    public static Block netherironOre;
    public static Block netherlapisOre;
    public static Block netherredstoneOre;
    public static Block netherdiamondOre;
    public static Block nethergoldOre;
    public static Block nethercoalOre;

    public static void createBlocks() {
		GameRegistry.registerBlock(nethercopperOre = new ModBlockOre("nether_copper_ore", Material.ROCK, ModBlocks.nethercopperOre, 1, 1), "nether_copper_ore");
		GameRegistry.registerBlock(nethertinOre = new ModBlockOre("nether_tin_ore", Material.ROCK, ModBlocks.nethertinOre, 1, 1), "nether_tin_ore");
		GameRegistry.registerBlock(netherleadOre = new ModBlockOre("nether_lead_ore", Material.ROCK, ModBlocks.netherleadOre, 1, 1), "nether_lead_ore");
		GameRegistry.registerBlock(nethersilverOre = new ModBlockOre2("nether_silver_ore", Material.ROCK, ModBlocks.nethersilverOre, 1, 1), "nether_silver_ore");
		GameRegistry.registerBlock(netherzincOre = new ModBlockOre("nether_zinc_ore", Material.ROCK, ModBlocks.netherzincOre, 1, 1), "nether_zinc_ore");
		GameRegistry.registerBlock(nethernickelOre = new ModBlockOre("nether_nickel_ore", Material.ROCK, ModBlocks.nethernickelOre, 1, 1), "nether_nickel_ore");
    
		GameRegistry.registerBlock(netherironOre = new ModBlockOre("nether_iron_ore", Material.ROCK, ModBlocks.netherironOre, 1, 1), "nether_iron_ore");
		GameRegistry.registerBlock(netherlapisOre = new ModBlockOre("nether_lapis_ore", Material.ROCK, ModBlocks.netherlapisOre, 1, 1), "nether_lapis_ore");
		GameRegistry.registerBlock(netherredstoneOre = new ModBlockOre("nether_redstone_ore", Material.ROCK, ModBlocks.netherredstoneOre, 1, 1), "nether_redstone_ore");
		GameRegistry.registerBlock(netherdiamondOre = new ModBlockOre3("nether_diamond_ore", Material.ROCK, ModBlocks.netherdiamondOre, 1, 1), "nether_diamond_ore");
		GameRegistry.registerBlock(nethergoldOre = new ModBlockOre2("nether_gold_ore", Material.ROCK, ModBlocks.nethergoldOre, 1, 1), "nether_gold_ore");
		GameRegistry.registerBlock(nethercoalOre = new ModBlockOre("nether_coal_ore", Material.ROCK, ModBlocks.nethercoalOre, 1, 1), "nether_coal_ore");
    }
}
