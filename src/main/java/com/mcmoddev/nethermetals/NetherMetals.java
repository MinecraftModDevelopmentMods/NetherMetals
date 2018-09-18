package com.mcmoddev.nethermetals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mcmoddev.lib.data.SharedStrings;
import com.mcmoddev.nethermetals.proxy.CommonProxy;
import com.mcmoddev.nethermetals.util.NMeConfig;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
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
@Mod(
		modid = NetherMetals.MODID,
		name = NetherMetals.NAME,
		version = NetherMetals.VERSION,
		dependencies = "required-after:forge@[14.21.0.2327,);after:basemetals;after:baseminerals;after:modernmetals",
		certificateFingerprint = "@FINGERPRINT@",
		acceptedMinecraftVersions = "[1.12,)",
		updateJSON = SharedStrings.UPDATE_JSON_URL + "NetherMetals/master/update.json")
public final class NetherMetals {

	@Instance(value = NetherMetals.MODID)
	public static NetherMetals instance;

	/** ID of this Mod. */
	public static final String MODID = "nethermetals";

	/** Display name of this Mod. */
	public static final String NAME = "Nether Metals";

	/**
	 * Version number, in Major.Minor.Build format. The minor number is increased whenever a change
	 * is made that has the potential to break compatibility with other mods that depend on this
	 * one.
	 */
	public static final String VERSION = "1.2.0-beta4";

	public static final Logger LOGGER = LogManager.getFormatterLogger(NetherMetals.MODID);

	private static final String PROXY_BASE = SharedStrings.MMD_PROXY_GROUP + MODID
			+ SharedStrings.DOT_PROXY_DOT;

	@SidedProxy(
			clientSide = PROXY_BASE + SharedStrings.CLIENTPROXY,
			serverSide = PROXY_BASE + SharedStrings.SERVERPROXY)
	public static CommonProxy proxy;

	@EventHandler
	public void onFingerprintViolation(final FMLFingerprintViolationEvent event) {
		LOGGER.warn(SharedStrings.INVALID_FINGERPRINT);
	}

	@EventHandler
	public void constructing(final FMLConstructionEvent event) {
		NMeConfig.init();
	}

	@EventHandler
	public void preInit(final FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@EventHandler
	public void init(final FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void postInit(final FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}
