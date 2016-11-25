package com.knoxhack.nethermetals;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.knoxhack.nethermetals.data.DataConstants;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {

	public static Configuration config;

	private static final String COMMENTS = Main.MODNAME + " Config\n For " + Main.MODNAME + " \n"
			+ " For " + Main.MODNAME + " " + Main.VERSION;
	 //public static final List<Path> oreSpawnConfigFiles = new LinkedList<>();

	private static final String ORE_SPAWN_PROB_COMMENT = "Spawn Probability\nSet to zero to disable ore spawning of this type";

	private static String ORESPANE_CFG_PATH = "orespawn";

	public static boolean requireOreSpawn = true;

	private static int ironOreSpawnProb = 0;
	private static int diamondOreSpawnProb = 0;
	private static int redstoneOreSpawnProb = 0;
	private static int goldOreSpawnProb = 0;
	private static int emeraldOreSpawnProb = 0;
	private static int coalOreSpawnProb = 0;
	private static int lapisOreSpawnProb = 0;
	private static int explosionChance = 0;
	private static int angerPigmenRange = 0;
	private static boolean angerPigmen = false;

	public static void startConfig(FMLPreInitializationEvent event) {
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load(); // only need to load config once during pre initializeSoundEvents
		updateConfigInfo();
		
		final Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		Path oreSpawnFolder = Paths.get(ORESPANE_CFG_PATH);;
		if (ConfigHandler.requireOreSpawn) {
			// Base Metals
		 {
				final Path bmoreSpawnFile = Paths.get(oreSpawnFolder.toString(), Main.MODID + "-base_metals_ores" + ".json");
				if (!Files.exists(bmoreSpawnFile)) {
					try {
						Files.createDirectories(bmoreSpawnFile.getParent());
						Files.write(bmoreSpawnFile, Arrays.asList(DataConstants.BM_ORESPAWN_JSON.split("\n")), Charset.forName("UTF-8"));
					} catch (IOException e) {
						FMLLog.severe(Main.MODID + ": Error: Failed to write file " + bmoreSpawnFile);
					}
				}
			}

			// Modern Metals
			if (Loader.isModLoaded("modernmetals")) {
				final Path mmoreSpawnFile = Paths.get(oreSpawnFolder.toString(), Main.MODID + "-modern_metals_ores" + ".json");
				if (!Files.exists(mmoreSpawnFile)) {
					try {
						Files.createDirectories(mmoreSpawnFile.getParent());
						Files.write(mmoreSpawnFile, Arrays.asList(DataConstants.MM_ORESPAWN_JSON.split("\n")), Charset.forName("UTF-8"));
					} catch (IOException e) {
						FMLLog.severe(Main.MODID + ": Error: Failed to write file " + mmoreSpawnFile);
					}
				}
			}
		}
		config.save();
	}

	public static void updateConfigInfo() {
		try {
			config.addCustomCategoryComment(Configuration.CATEGORY_GENERAL, COMMENTS);

			requireOreSpawn = config.getBoolean("using_orespawn", "options", requireOreSpawn,
					"If false, then Base Metals will not require DrCyano's Ore Spawn mod. \n" +
					"Set to false if using another mod to manually handle ore generation.");

			ironOreSpawnProb = config.get(Configuration.CATEGORY_GENERAL,     "NetherIronOreSpawnProb",     14, ORE_SPAWN_PROB_COMMENT).getInt();
			diamondOreSpawnProb = config.get(Configuration.CATEGORY_GENERAL,  "NetherDiamondOreSpawnProb",   5, ORE_SPAWN_PROB_COMMENT).getInt();
			redstoneOreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "NetherRedstoneOreSpawnProb", 12, ORE_SPAWN_PROB_COMMENT).getInt();
			lapisOreSpawnProb = config.get(Configuration.CATEGORY_GENERAL,    "NetherLapisOreSpawnProb",     8, ORE_SPAWN_PROB_COMMENT).getInt();
			emeraldOreSpawnProb = config.get(Configuration.CATEGORY_GENERAL,  "NetherEmeraldOreSpawnProb",   5, ORE_SPAWN_PROB_COMMENT).getInt();
			goldOreSpawnProb = config.get(Configuration.CATEGORY_GENERAL,     "NetherGoldOreSpawnProb",      8, ORE_SPAWN_PROB_COMMENT).getInt();
			coalOreSpawnProb = config.get(Configuration.CATEGORY_GENERAL,     "NetherCoalOreSpawnProb",     16, ORE_SPAWN_PROB_COMMENT).getInt();

			explosionChance = config.get("mean", "OreExplosionChance", 2, "Explosion Percentage Chance\nSet to 0 to not explode").getInt();
			angerPigmenRange = config.get("mean", "PigmenAngerRange", 20, "Anger Pigmen Range\nRequires PigmenAnger").getInt();
			angerPigmen = config.get("mean", "PigmenAnger", true, "Anger Pigmen When Ores Explode\nSet to false to not anger").getBoolean();

			config.get(Configuration.CATEGORY_GENERAL, "NetherIronOreSpawnProb",     14, ORE_SPAWN_PROB_COMMENT).getInt();
			config.get(Configuration.CATEGORY_GENERAL, "NetherDiamondOreSpawnProb",   5, ORE_SPAWN_PROB_COMMENT).getInt();
			config.get(Configuration.CATEGORY_GENERAL, "NetherRedstoneOreSpawnProb", 12, ORE_SPAWN_PROB_COMMENT).getInt();
			config.get(Configuration.CATEGORY_GENERAL, "NetherEmeraldOreSpawnProb",   5, ORE_SPAWN_PROB_COMMENT).getInt();
			config.get(Configuration.CATEGORY_GENERAL, "NetherGoldOreSpawnProb",      8, ORE_SPAWN_PROB_COMMENT).getInt();
			config.get(Configuration.CATEGORY_GENERAL, "NetherLapisOreSpawnProb",     8, ORE_SPAWN_PROB_COMMENT).getInt();
			config.get(Configuration.CATEGORY_GENERAL, "NetherCoalOreSpawnProb",     16, ORE_SPAWN_PROB_COMMENT).getInt();
		} catch (Exception e) {
			Main.proxy.info("failed to load or read the config file");
		} finally {
			if (config.hasChanged()) {
				config.save();
			}
		}
	}

	public static int getIronOreSpawnProb() {
		return ironOreSpawnProb;
	}

	public static int getDiamondOreSpawnProb() {
		return diamondOreSpawnProb;
	}

	public static int getGoldOreSpawnProb() {
		return goldOreSpawnProb;
	}

	public static int getCoalOreSpawnProb() {
		return coalOreSpawnProb;
	}

	public static int getEmeraldOreSpawnProb() {
		return emeraldOreSpawnProb;
	}

	public static int getRedstoneOreSpawnProb() {
		return redstoneOreSpawnProb;
	}

	public static int getLapisOreSpawnProb() {
		return lapisOreSpawnProb;
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
