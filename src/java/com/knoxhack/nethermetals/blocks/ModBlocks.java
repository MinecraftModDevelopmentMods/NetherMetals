package com.knoxhack.nethermetals.blocks;

import com.knoxhack.nethermetals.items.ModItems;

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



    public static void createBlocks() {
		GameRegistry.registerBlock(nethercopperOre = new ModBlockOre("nether_copper_ore", Material.rock, ModItems.netheraxe, 2, 4), "nether_copper_ore");
		GameRegistry.registerBlock(nethertinOre = new ModBlockOre("nether_tin_ore", Material.rock, ModItems.netheraxe, 2, 4), "nether_tin_ore");
		GameRegistry.registerBlock(netherleadOre = new ModBlockOre("nether_lead_ore", Material.rock, ModItems.netheraxe, 2, 4), "nether_lead_ore");
		GameRegistry.registerBlock(nethersilverOre = new ModBlockOre2("nether_silver_ore", Material.rock, ModItems.netheraxe, 2, 4), "nether_silver_ore");
		GameRegistry.registerBlock(netherzincOre = new ModBlockOre("nether_zinc_ore", Material.rock, ModItems.netheraxe, 2, 4), "nether_zinc_ore");
		GameRegistry.registerBlock(nethernickelOre = new ModBlockOre("nether_nickel_ore", Material.rock, ModItems.netheraxe, 2, 4), "nether_nickel_ore");

    
    
    
    
    
    
    
    }
    
    
    
}