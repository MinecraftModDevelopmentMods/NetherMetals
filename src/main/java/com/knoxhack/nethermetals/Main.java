package com.knoxhack.nethermetals;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
		modid = Main.MODID,
		name = Main.MODNAME,
		version = Main.VERSION,
		dependencies = "required-after:Forge;required-after:basemetals",
		updateJSON = "https://raw.githubusercontent.com/nfinit-gaming/Nether-Metals/master/update.json")

public class Main {

    @Instance
    public static Main INSTANCE = null;

    public static final String MODID = "nethermetals";
    public static final String MODNAME = "Nether Metals";
    public static final String VERSION = "1.1.0";


    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	INSTANCE = this;
        Main.proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        Main.proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        Main.proxy.postInit(e);
    }
    
    @SidedProxy(clientSide="com.knoxhack.nethermetals.ClientProxy", serverSide="com.knoxhack.nethermetals.ServerProxy")
    public static CommonProxy proxy;    
}
