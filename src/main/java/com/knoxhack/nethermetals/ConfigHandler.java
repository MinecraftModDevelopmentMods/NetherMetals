package com.knoxhack.nethermetals;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {

	public static Configuration config;

	private static final String COMMENTS = Main.MODNAME + " Config\n For " + Main.MODNAME + " \n"
			+ " For " + Main.MODNAME + " " + Main.VERSION;

	private static final String ORE_SPAWN_PROB_COMMENT = "Spawn Probability\nSet to zero to disable ore spawning of this type";

	public static boolean requireOreSpawn = true;

	private static int ironOreSpawnProb = 0;
	private static int diamondOreSpawnProb = 0;
	private static int redstoneOreSpawnProb = 0;
	private static int goldOreSpawnProb = 0;
	private static int emeraldOreSpawnProb = 0;
	private static int coalOreSpawnProb = 0;
	private static int lapisOreSpawnProb = 0;

	public static void startConfig(FMLPreInitializationEvent event) {
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load(); // only need to load config once during pre initializeSoundEvents
		updateConfigInfo();
	}

	public static void updateConfigInfo() {
		try {
			config.addCustomCategoryComment(Configuration.CATEGORY_GENERAL, COMMENTS);

			requireOreSpawn = config.getBoolean("using_orespawn", "options", requireOreSpawn,
					"If false, then Base Metals will not require DrCyano's Ore Spawn mod. \n" +
					"Set to false if using another mod to manually handle ore generation.");

			ironoreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "NetherIronOreSpawnProb",         14, ORE_SPAWN_PROB_COMMENT).getInt();
			diamondoreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "NetherDIamondOreSpawnProb",    5, ORE_SPAWN_PROB_COMMENT).getInt();
			redstoneoreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "NetherRedstoneOreSpawnProb", 12, ORE_SPAWN_PROB_COMMENT).getInt();
			lapisoreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "NetherLapisOreSpawnProb",        8, ORE_SPAWN_PROB_COMMENT).getInt();
			emeraldoreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "NetherEmeraldOreSpawnProb",    5, ORE_SPAWN_PROB_COMMENT).getInt();
			goldoreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "NetherGoldOreSpawnProb",          8, ORE_SPAWN_PROB_COMMENT).getInt();
			coaloreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "NetherICoalOreSpawnProb",        16, ORE_SPAWN_PROB_COMMENT).getInt();

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
}
