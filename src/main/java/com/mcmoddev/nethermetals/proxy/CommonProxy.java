package com.mcmoddev.nethermetals.proxy;

import com.mcmoddev.nethermetals.util.Config;
import com.mcmoddev.nethermetals.util.CreativeTabNMe;
import com.mcmoddev.nethermetals.crafting.ModCrafting;
import com.mcmoddev.nethermetals.init.Blocks;
import com.mcmoddev.nethermetals.init.ItemGroups;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public static CreativeTabs tab;
	public static com.mcmoddev.lib.init.Materials mmdlibMat;
	public static com.mcmoddev.basemetals.init.Materials bmmat;
	public static com.mcmoddev.modernmetals.init.Materials mmmat;
	public static com.mcmoddev.nethermetals.init.Materials nmmat;
	
	
	@SuppressWarnings("static-access")
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
		Config.init();
		mmdlibMat.init();

		ItemGroups.init();
		Blocks.init();
        tab = new CreativeTabNMe();
		FMLInterModComms.sendFunctionMessage("orespawn", "api", "com.mcmoddev.orespawn.NetherMetalsOreSpawn");
		Blocks.init();
	}

	public void init(FMLInitializationEvent event) {
		//ModCrafting.initCrafting();
	}

	public void postInit(FMLPostInitializationEvent event) {
		// Empty
	}
}
