package com.mcmoddev.nethermetals.util;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import com.mcmoddev.nethermetals.NetherMetals;
import com.mcmoddev.basemetals.registry.CrusherRecipeRegistry;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
//import net.minecraftforge.common.config.*;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.MissingModsException;
//import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.versioning.ArtifactVersion;
//import net.minecraftforge.fml.common.versioning.*;
import net.minecraftforge.fml.common.versioning.DefaultArtifactVersion;

/**
 * @author p455w0rd
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
		Options.explosionChance = configuration.get("mean", "OreExplosionChance", 2, "Explosion Percentage Chance\nSet to 0 to not explode").getInt();
		Options.angerPigmenRange = configuration.get("mean", "PigmenAngerRange", 20, "Anger Pigmen Range\nRequires PigmenAnger").getInt();

		//Nether Ores
		Options.enableAluminumNetherOre = configuration.getBoolean("EnableAluminumNetherOre", NETHERORE, true, "Enable Aluminum Nether Ores");
       
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
		public static boolean requireMMDLib = true;

		public static boolean requireMMDOreSpawn = true;
		public static boolean enableAluminumNetherOre = true;
		public static boolean enableTinkersConstruct = false;
		public static boolean enableVeinminer = false;
		public static int explosionChance = 0;
		public static int angerPigmenRange = 0;
		public static boolean angerPigmen = false;

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
