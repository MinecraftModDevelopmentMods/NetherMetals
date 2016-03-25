package com.knoxhack.nethermetals;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION, dependencies = "required-after:basemetals")
public class Main {

    public static final String MODID = "nethermetals";
    public static final String MODNAME = "Nether Metals";
    public static final String VERSION = "1.0.0";
    @Instance
    public static Main instance = new Main();

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
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