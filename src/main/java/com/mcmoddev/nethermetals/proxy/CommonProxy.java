package com.mcmoddev.nethermetals.proxy;

import com.mcmoddev.nethermetals.util.Config;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.integration.IntegrationManager;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.nethermetals.NetherMetals;
import com.mcmoddev.nethermetals.init.*;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		Config.init();
		ItemGroups.init();
		NetherBlocks.init();
		ItemGroups.setupIcons();
		
		FMLInterModComms.sendFunctionMessage("orespawn", "api", "com.mcmoddev.orespawn.NetherMetalsOreSpawn");

		MinecraftForge.EVENT_BUS.register(this);
		IntegrationManager.INSTANCE.preInit(event);

	}

	public void init(FMLInitializationEvent event) {
		Recipes.init();
	}

	public void postInit(FMLPostInitializationEvent event) {
		Config.postInit();
	}
	
	// even though no items are directly created there are ItemBlock instances that need registered as well
	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event) {
		// NetherMetals doesn't do any of its own materials, just its own blocks
		// so it actually needs this helper :)
		for( MMDMaterial mat : Materials.getAllMaterials()) {
			for( Item item : mat.getItems() ) {
				if( item.getRegistryName().getResourceDomain().equals(NetherMetals.MODID) ) {
					event.getRegistry().register(item);
				}
			}
		}
	}
	
	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event) {
		// NetherMetals doesn't do any of its own materials, just its own blocks
		// so it actually needs this helper :)
		for( MMDMaterial mat : Materials.getAllMaterials()) {
			for( Block block : mat.getBlocks() ) {
				if( block.getRegistryName().getResourceDomain().equals(NetherMetals.MODID) ) {
					event.getRegistry().register(block);
				}
			}
		}
	}
}
