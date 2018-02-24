package com.mcmoddev.nethermetals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.mcmoddev.nethermetals.proxy.CommonProxy;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * This is the entry point for this Mod.
 *
 * @author Jasmine Iwanek
 *
 */
@Mod(modid = NetherMetals.MODID,
	name = NetherMetals.NAME,
	version = NetherMetals.VERSION,
	dependencies = "required-after:forge@[14.21.0.2327,);after:basemetals;after:baseminerals;after:modernmetals",
	certificateFingerprint = "@FINGERPRINT@",
	acceptedMinecraftVersions = "[1.12,)",
	updateJSON = "https://raw.githubusercontent.com/MinecraftModDevelopmentMods/NetherMetals/master/update.json")
public class NetherMetals {

	@Instance
	public static NetherMetals instance;

	/** ID of this Mod */
	public static final String MODID = "nethermetals";

	/** Display name of this Mod */
	public static final String NAME = "Nether Metals";

	/**
	 * Version number, in Major.Minor.Build format. The minor number is
	 * increased whenever a change is made that has the potential to break
	 * compatibility with other mods that depend on this one.
	 */
	public static final String VERSION = "1.2.0-beta2";

	public static Logger logger = LogManager.getFormatterLogger(NetherMetals.MODID);

	@SidedProxy(clientSide = "com.mcmoddev.nethermetals.proxy.ClientProxy", serverSide = "com.mcmoddev.nethermetals.proxy.ServerProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void onFingerprintViolation(FMLFingerprintViolationEvent event) {
		logger.warn("Invalid fingerprint detected!");
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
	
    public static boolean hasMMDLib() {
        return Loader.isModLoaded("mmdlib");
    }
        
    public static boolean hasOreSpawn() {
        return Loader.isModLoaded("orespawn");
    }
    public static boolean hasTinkers() {
        return Loader.isModLoaded("tinkersconstruct");
    }
    public static boolean hasModernMetals() {
        return Loader.isModLoaded("modernmetals");
    }
    public static boolean hasBaseMetals() {
        return Loader.isModLoaded("basemetals");
    }

}
