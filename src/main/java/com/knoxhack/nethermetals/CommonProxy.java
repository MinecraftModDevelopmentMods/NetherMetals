package com.knoxhack.nethermetals;

import com.knoxhack.nethermetals.blocks.ModBlocks;
import com.knoxhack.nethermetals.crafting.ModCrafting;
import com.knoxhack.nethermetals.items.ModItems;
import com.knoxhack.nethermetals.world.WorldGen;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        ModItems.createItems();
        ModBlocks.createBlocks();
    }

    public void init(FMLInitializationEvent e) {
        ModCrafting.initCrafting();
        GameRegistry.registerWorldGenerator(new WorldGen(), 0);

    }

    public void postInit(FMLPostInitializationEvent e) {

    }
    
    
    
}