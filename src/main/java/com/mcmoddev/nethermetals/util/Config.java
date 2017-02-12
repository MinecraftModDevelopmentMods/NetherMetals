package com.mcmoddev.nethermetals.util;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import com.mcmoddev.nethermetals.NetherMetals;
import com.mcmoddev.basemetals.registry.CrusherRecipeRegistry;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.MissingModsException;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.versioning.ArtifactVersion;
import net.minecraftforge.fml.common.versioning.DefaultArtifactVersion;

/**
 * @author Jasmine Iwanek
 *
 */
public class Config {

	private static Configuration configuration;
	private static final String CONFIG_FILE = "config/NetherMetals.cfg";
	private static final String ORESPAWN_CFG_PATH = "orespawn";
	private static final String ORESPAWN = "OreSpawn";
	private static final String NETHERORE = "Nether Ores";
	private static final String COMPAT = "Mod Compat";
	private static final String GENERAL = "General";
	private static final String MMDLIB = "MMD Lib";

	@SubscribeEvent
	public void onConfigChange(ConfigChangedEvent.OnConfigChangedEvent e) {
		if (e.getModID().equals(NetherMetals.MODID)) {
			init();
		}
	}

	public static void init() {
		if (configuration == null) {
			configuration = new Configuration(new File(CONFIG_FILE));
			MinecraftForge.EVENT_BUS.register(new Config());
		}
		
		//General
		Options.enableFurnaceSmelting = configuration.getBoolean("enableFurnaceSmelting", GENERAL, true, "EnableFurnaceSmelting");
		Options.explosionChance = configuration.get("mean", "OreExplosionChance", 2, "Explosion Percentage Chance\nSet to 0 to not explode").getInt();
		Options.angerPigmenRange = configuration.get("mean", "PigmenAngerRange", 20, "Anger Pigmen Range\nRequires PigmenAnger").getInt();
		//Nether Ores
		Options.enableAntimonyNetherOre = configuration.getBoolean("enableAntimonyNetherOre", NETHERORE, true, "Enable Antimony Nether Ore");
		Options.enableBismuthNetherOre = configuration.getBoolean("enableBismuthNetherOre", NETHERORE, true, "Enable Antimony Nether Ore");
		Options.enableCopperNetherOre = configuration.getBoolean("enableCopperNetherOre", NETHERORE, true, "Enable Antimony Nether Ore");
		Options.enableLeadNetherOre = configuration.getBoolean("enableLeadNetherOre", NETHERORE, true, "Enable Antimony Nether Ore");
		Options.enableMercuryNetherOre = configuration.getBoolean("enableMercuryNetherOre", NETHERORE, true, "Enable Antimony Nether Ore");
		Options.enableNickelNetherOre = configuration.getBoolean("enableNickelNetherOre", NETHERORE, true, "Enable Antimony Nether Ore");
		Options.enablePlatinumNetherOre = configuration.getBoolean("enablePlatinumNetherOre", NETHERORE, true, "Enable Antimony Nether Ore");
		Options.enableSilverNetherOre = configuration.getBoolean("enableSilverNetherOre", NETHERORE, true, "Enable Antimony Nether Ore");
		Options.enableTinNetherOre = configuration.getBoolean("enableTinNetherOre", NETHERORE, true, "Enable Antimony Nether Ore");
		Options.enableZincNetherOre = configuration.getBoolean("enableZincNetherOre", NETHERORE, true, "Enable Antimony Nether Ore");
		Options.enableAluminumNetherOre = configuration.getBoolean("enableAluminumNetherOre", NETHERORE, true, "Enable Aluminum Nether Ore");
		Options.enableCadmiumNetherOre = configuration.getBoolean("enableCadmiumNetherOre", NETHERORE, true, "Enable Cadmium Nether Ore");
		Options.enableChromiumNetherOre = configuration.getBoolean("enableChromiumNetherOre", NETHERORE, true, "Enable Chromium Nether Ore");
		Options.enableIridiumNetherOre = configuration.getBoolean("enableIridiumNetherOre", NETHERORE, true, "Enable Iridium Nether Ore");
		Options.enableMagnesiumNetherOre = configuration.getBoolean("enableMagnesiumNetherOre", NETHERORE, true, "Enable Magnesium Nether Ore");
		Options.enableManganeseNetherOre = configuration.getBoolean("enableManganeseNetherOre", NETHERORE, true, "Enable Manganese Nether Ore");
		Options.enableOsmiumNetherOre = configuration.getBoolean("enableOsmiumNetherOre", NETHERORE, true, "Enable Osmium Nether Ore");
		Options.enablePlutoniumNetherOre = configuration.getBoolean("enablePlutoniumNetherOre", NETHERORE, true, "Enable Plutonium Nether Ore");
		Options.enableRutileNetherOre = configuration.getBoolean("enableRutileNetherOre", NETHERORE, true, "Enable Rutile Nether Ore");
		Options.enableTantalumNetherOre = configuration.getBoolean("enableTantalumNetherOre", NETHERORE, true, "Enable Tantalum Nether Ore");
		Options.enableTitaniumNetherOre = configuration.getBoolean("enableTitaniumNetherOre", NETHERORE, true, "Enable Titanium Nether Ore");
		Options.enableTungstenNetherOre = configuration.getBoolean("enableTungstenNetherOre", NETHERORE, true, "Enable Tungsten Nether Ore");
		Options.enableUraniumNetherOre = configuration.getBoolean("enableUraniumNetherOre", NETHERORE, true, "Enable Uranium Nether Ore");
		Options.enableZirconiumNetherOre = configuration.getBoolean("enableZirconiumNetherOre", NETHERORE, true, "Enable ZirconiumN Nether Ore");

		//Mod Compat
		Options.requireMMDLib = configuration.getBoolean("requireMMDLib", MMDLIB, true, "Require MMD Lib");
		Options.requireMMDOreSpawn = configuration.getBoolean("requireMMDOreSpawn", ORESPAWN, true, "Require MMD OreSpawn");
		Options.enableVeinminer = configuration.getBoolean("enableVeinminer", COMPAT, true, "Enable Veinminer Support");
		Options.enableTinkersConstruct = configuration.getBoolean("enableTinkersConstruct", COMPAT, false, "Enable Tinkers Construct Support");

		if (configuration.hasChanged()) {
			configuration.save();
		}

		if (com.mcmoddev.nethermetals.util.Config.Options.requireMMDOreSpawn) {
			if (!Loader.isModLoaded("orespawn")) {
				final HashSet<ArtifactVersion> orespawnMod = new HashSet<>();
				orespawnMod.add(new DefaultArtifactVersion("1.1.0"));
				throw new MissingModsException(orespawnMod, "orespawn", "MMD Ore Spawn Mod");
			}
			final Path oreSpawnFile = Paths.get(ORESPAWN_CFG_PATH, NetherMetals.MODID + ".json");
			if (!(oreSpawnFile.toFile().exists())) {
				try {
					Files.createDirectories(oreSpawnFile.getParent());
				}
				catch (final IOException ex) {
					//NetherMetals.logger.error("Failed to write file " + oreSpawnFile, ex);
		}
		}
		}	
	}

	public static class Options {
		public static boolean requireMMDLib = false;

		public static boolean requireMMDOreSpawn = true;
		public static boolean enableTinkersConstruct = false;
		public static boolean enableVeinminer = false;
		public static int explosionChance = 0;
		public static int angerPigmenRange = 0;
		public static boolean angerPigmen = false;
		public static boolean enableAntimonyNetherOre = true;
		public static boolean enableBismuthNetherOre = true;
		public static boolean enableCopperNetherOre = true;
		public static boolean enableLeadNetherOre = true;
		public static boolean enableMercuryNetherOre = true;
		public static boolean enableNickelNetherOre = true;
		public static boolean enablePlatinumNetherOre = true;
		public static boolean enableSilverNetherOre = true;
		public static boolean enableTinNetherOre = true;
		public static boolean enableZincNetherOre = true;
		public static boolean enableFurnaceSmelting = true;
		
		public static boolean enableAluminumNetherOre = true;
		public static boolean enableCadmiumNetherOre = true;
		public static boolean enableChromiumNetherOre = true;
		public static boolean enableIridiumNetherOre = true;
		public static boolean enableMagnesiumNetherOre = true;
		public static boolean enableManganeseNetherOre = true;
		public static boolean enableOsmiumNetherOre = true;
		public static boolean enablePlutoniumNetherOre = true;
		public static boolean enableRutileNetherOre = true;
		public static boolean enableTantalumNetherOre = true;
		public static boolean enableTitaniumNetherOre = true;
		public static boolean enableTungstenNetherOre = true;
		public static boolean enableUraniumNetherOre = true;
		public static boolean enableZirconiumNetherOre = true;



		

		private Options() {
			throw new IllegalAccessError("Not a instantiable class");
		}

		public static int getExplosionChance() {
			return explosionChance;
		}

		public static boolean isAngerPigmen() {
			return angerPigmen;
		}

		public static int getAngerPigmenRange() {
			return angerPigmenRange;
		}
	}

	public static void postInit() {
		CrusherRecipeRegistry.getInstance().clearCache();
	}
}
