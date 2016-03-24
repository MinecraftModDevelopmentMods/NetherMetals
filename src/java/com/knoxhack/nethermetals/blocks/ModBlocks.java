package com.knoxhack.nethermetals.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModBlocks {

    public static Block nethercopperOre;


    public static void createBlocks() {
        GameRegistry.registerBlock(nethercopperOre = new BasicBlock("Nether_Copper_Ore"), "Nether_Copper_Ore");
    }
}