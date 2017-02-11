package com.mcmoddev.nethermetals.proxy;

import com.mcmoddev.nethermetals.util.Config;
import com.mcmoddev.nethermetals.util.CreativeTabNMe;
import com.mcmoddev.nethermetals.crafting.ModCrafting;
import com.mcmoddev.nethermetals.init.Blocks;
import com.mcmoddev.nethermetals.init.ItemGroups;
import com.mcmoddev.nethermetals.init.MaterialsNetherOre;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public static CreativeTabs tab;

	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
		Config.init();
		MaterialsNetherOre.init();
		ItemGroups.init();
		Blocks.init();
        tab = new CreativeTabNMe();
		FMLInterModComms.sendFunctionMessage("orespawn", "api", "com.mcmoddev.orespawn.NetherMetalsOreSpawn");
		Blocks.init();	}

	public void init(FMLInitializationEvent event) {
		ModCrafting.initCrafting();
	}

	public void postInit(FMLPostInitializationEvent event) {
	}
}
