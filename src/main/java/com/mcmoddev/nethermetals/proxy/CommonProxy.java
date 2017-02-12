package com.mcmoddev.nethermetals.proxy;

import com.mcmoddev.nethermetals.util.Config;
import com.mcmoddev.nethermetals.util.CreativeTabNMe;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.nethermetals.init.*;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		Config.init();
		Materials.init();
//		ItemGroups.init();
		CreativeTabs tab = new CreativeTabNMe();
		Blocks.init();
		FMLInterModComms.sendFunctionMessage("orespawn", "api", "com.mcmoddev.orespawn.NetherMetalsOreSpawn");
	}

	public void init(FMLInitializationEvent event) {
		Recipes.init();
	}

	public void postInit(FMLPostInitializationEvent event) {
		Config.postInit();
	}
}
