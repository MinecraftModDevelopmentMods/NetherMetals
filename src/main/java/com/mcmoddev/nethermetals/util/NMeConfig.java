package com.mcmoddev.nethermetals.util;

import java.io.File;

import com.mcmoddev.nethermetals.NetherMetals;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * @author Jasmine Iwanek
 *
 */
public final class NMeConfig extends com.mcmoddev.lib.util.Config {

	private static Configuration configuration;
	private static final String CONFIG_FILE = "config/NetherMetals.cfg";
	private static final String NETHERORE = "Nether Ores";

	/**
	 *
	 * @param event
	 *            The Event.
	 */
	@SubscribeEvent
	public void onConfigChange(final ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.getModID().equals(NetherMetals.MODID)) {
			init();
		}
	}

	/**
	 *
	 */
	public static void init() {
		if (configuration == null) {
			configuration = new Configuration(new File(CONFIG_FILE));
			MinecraftForge.EVENT_BUS.register(new NMeConfig());
		}

		// General
		Options.explosionChance(configuration.get("mean", "OreExplosionChance", 2,
				"Explosion Percentage Chance\nSet to 0 to not explode").getInt());
		Options.angerPigmenRange(configuration
				.get("mean", "PigmenAngerRange", 20, "Anger Pigmen Range\nRequires PigmenAnger")
				.getInt());

		// Nether Ores
		Options.materialEnabled("enableCoalNetherOre", configuration
				.getBoolean("enableCoalNetherOre", NETHERORE, true, "Enable Coal Nether Ore"));
		Options.materialEnabled("enableDiamondNetherOre", configuration.getBoolean(
				"enableDiamondNetherOre", NETHERORE, true, "Enable Diamond Nether Ore"));
		Options.materialEnabled("enableEmeraldNetherOre", configuration.getBoolean(
				"enableEmeraldNetherOre", NETHERORE, true, "Enable Emerald Nether Ore"));
		Options.materialEnabled("enableGoldNetherOre", configuration
				.getBoolean("enableGoldNetherOre", NETHERORE, true, "Enable Gold Nether Ore"));
		Options.materialEnabled("enableIronNetherOre", configuration
				.getBoolean("enableIronNetherOre", NETHERORE, true, "Enable Iron Nether Ore"));
		Options.materialEnabled("enableLapisNetherOre", configuration
				.getBoolean("enableLapisNetherOre", NETHERORE, true, "Enable Lapis Nether Ore"));
		Options.materialEnabled("enableRedstoneNetherOre", configuration.getBoolean(
				"enableRedstoneNetherOre", NETHERORE, true, "Enable Redstone Nether Ore"));

		Options.materialEnabled("enableAntimonyNetherOre", configuration.getBoolean(
				"enableAntimonyNetherOre", NETHERORE, true, "Enable Antimony Nether Ore"));
		Options.materialEnabled("enableBismuthNetherOre", configuration.getBoolean(
				"enableBismuthNetherOre", NETHERORE, true, "Enable Bismuth Nether Ore"));
		Options.materialEnabled("enableCopperNetherOre", configuration
				.getBoolean("enableCopperNetherOre", NETHERORE, true, "Enable Copper Nether Ore"));
		Options.materialEnabled("enableLeadNetherOre", configuration
				.getBoolean("enableLeadNetherOre", NETHERORE, true, "Enable Lead Nether Ore"));
		Options.materialEnabled("enableMercuryNetherOre", configuration.getBoolean(
				"enableMercuryNetherOre", NETHERORE, true, "Enable Mercury Nether Ore"));
		Options.materialEnabled("enableNickelNetherOre", configuration
				.getBoolean("enableNickelNetherOre", NETHERORE, true, "Enable Nickel Nether Ore"));
		Options.materialEnabled("enablePlatinumNetherOre", configuration.getBoolean(
				"enablePlatinumNetherOre", NETHERORE, true, "Enable Platinum Nether Ore"));
		Options.materialEnabled("enableSilverNetherOre", configuration
				.getBoolean("enableSilverNetherOre", NETHERORE, true, "Enable Silver Nether Ore"));
		Options.materialEnabled("enableTinNetherOre", configuration.getBoolean("enableTinNetherOre",
				NETHERORE, true, "Enable Tin Nether Ore"));
		Options.materialEnabled("enableZincNetherOre", configuration
				.getBoolean("enableZincNetherOre", NETHERORE, true, "Enable Zinc Nether Ore"));
		Options.materialEnabled("enableAluminumNetherOre", configuration.getBoolean(
				"enableAluminumNetherOre", NETHERORE, true, "Enable Aluminum Nether Ore"));
		Options.materialEnabled("enableCadmiumNetherOre", configuration.getBoolean(
				"enableCadmiumNetherOre", NETHERORE, true, "Enable Cadmium Nether Ore"));
		Options.materialEnabled("enableChromiumNetherOre", configuration.getBoolean(
				"enableChromiumNetherOre", NETHERORE, true, "Enable Chromium Nether Ore"));
		Options.materialEnabled("enableIridiumNetherOre", configuration.getBoolean(
				"enableIridiumNetherOre", NETHERORE, true, "Enable Iridium Nether Ore"));
		Options.materialEnabled("enableMagnesiumNetherOre", configuration.getBoolean(
				"enableMagnesiumNetherOre", NETHERORE, true, "Enable Magnesium Nether Ore"));
		Options.materialEnabled("enableManganeseNetherOre", configuration.getBoolean(
				"enableManganeseNetherOre", NETHERORE, true, "Enable Manganese Nether Ore"));
		Options.materialEnabled("enableOsmiumNetherOre", configuration
				.getBoolean("enableOsmiumNetherOre", NETHERORE, true, "Enable Osmium Nether Ore"));
		Options.materialEnabled("enablePlutoniumNetherOre", configuration.getBoolean(
				"enablePlutoniumNetherOre", NETHERORE, true, "Enable Plutonium Nether Ore"));
		Options.materialEnabled("enableRutileNetherOre", configuration
				.getBoolean("enableRutileNetherOre", NETHERORE, true, "Enable Rutile Nether Ore"));
		Options.materialEnabled("enableTantalumNetherOre", configuration.getBoolean(
				"enableTantalumNetherOre", NETHERORE, true, "Enable Tantalum Nether Ore"));
		Options.materialEnabled("enableTitaniumNetherOre", configuration.getBoolean(
				"enableTitaniumNetherOre", NETHERORE, true, "Enable Titanium Nether Ore"));
		Options.materialEnabled("enableTungstenNetherOre", configuration.getBoolean(
				"enableTungstenNetherOre", NETHERORE, true, "Enable Tungsten Nether Ore"));
		Options.materialEnabled("enableUraniumNetherOre", configuration.getBoolean(
				"enableUraniumNetherOre", NETHERORE, true, "Enable Uranium Nether Ore"));
		Options.materialEnabled("enableZirconiumNetherOre", configuration.getBoolean(
				"enableZirconiumNetherOre", NETHERORE, true, "Enable Zirconium Nether Ore"));

		if (configuration.hasChanged()) {
			configuration.save();
		}
	}
}
