package com.knoxhack.nethermetals.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModBlocks {

    public static Block nethercopperOre;
    public static Block nethertinOre;
    public static Block netherleadOre;
    public static Block nethersilverOre;
    public static Block nethernickelOre;
    public static Block netherzincOre;


    public static void createBlocks() {
        GameRegistry.registerBlock(nethercopperOre = new BasicBlock("nether_copper_ore"), "nether_copper_ore");
        GameRegistry.registerBlock(nethertinOre = new BasicBlock("nether_tin_ore"), "nether_tin_ore");
        GameRegistry.registerBlock(netherleadOre = new BasicBlock("nether_lead_ore"), "nether_lead_ore");
        GameRegistry.registerBlock(nethersilverOre = new BasicBlock("nether_silver_ore"), "nether_silver_ore");
        GameRegistry.registerBlock(nethernickelOre = new BasicBlock("nether_nickel_ore"), "nether_nickel_ore");
        GameRegistry.registerBlock(netherzincOre = new BasicBlock("nether_zinc_ore"), "nether_zinc_ore");

    
    
    
    
    
    
    
    
    }
    
    
    
}