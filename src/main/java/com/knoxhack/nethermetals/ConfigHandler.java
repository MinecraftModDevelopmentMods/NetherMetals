package com.knoxhack.nethermetals;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {

	public static Configuration config;

	private static final String comments = Main.MODNAME + " Config\n For Nether Metals \n"
			+ " For Nether Metals " + Main.VERSION;
	
	private static final String orespawnProbComment = "Spawn Probability\nSet to zero to disable ore spawning of this type";

	
	private static  int netherironoreSpawnProb = 0;
	private static  int netherdiamondoreSpawnProb = 0;
	private static  int netherredstoneoreSpawnProb = 0;
	private static  int nethergoldoreSpawnProb = 0;
	private static  int netheremeraldoreSpawnProb = 0;
	private static  int nethercoaloreSpawnProb = 0;
	private static  int netherlapisoreSpawnProb = 0;
	private static  int explosionChance = 0;
	private static  int angerPigmenRange = 0;
	private static  boolean angerPigmen = false;


	public static void startConfig(FMLPreInitializationEvent event)
	{
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load(); // only need to load config once during pre initializeSoundEvents
		updateConfigInfo();
	}

	public static void updateConfigInfo()
	{
		try {
			config.addCustomCategoryComment(Configuration.CATEGORY_GENERAL, comments);

			netherironoreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "NetherIronOreSpawnProb", 14, orespawnProbComment).getInt();
			netherdiamondoreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "NetherDIamondOreSpawnProb", 5, orespawnProbComment).getInt();
			netherredstoneoreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "NetherRedstoneOreSpawnProb", 12, orespawnProbComment).getInt();
			netherlapisoreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "NetherLapisOreSpawnProb", 8, orespawnProbComment).getInt();
			netheremeraldoreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "NetherEmeraldOreSpawnProb", 5, orespawnProbComment).getInt();
			nethergoldoreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "NetherGoldOreSpawnProb", 8, orespawnProbComment).getInt();
			nethercoaloreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "NetherICoalOreSpawnProb", 16, orespawnProbComment).getInt();

			explosionChance = config.get("mean","OreExplosionChance",2, "Explosion Percentage Chance\nSet to 0 to not explode").getInt();
			angerPigmenRange = config.get("mean","PigmenAngerRange",20, "Anger Pigmen Range\nRequires PigmenAnger").getInt();
			angerPigmen = config.get("mean","PigmenAnger",true, "Anger Pigmen When Ores Explode\nSet to false to not anger").getBoolean();

			config.get(Configuration.CATEGORY_GENERAL, "NetherIronOreSpawnProb", 14, orespawnProbComment).getInt();
			config.get(Configuration.CATEGORY_GENERAL, "NetherDiamondOreSpawnProb", 5, orespawnProbComment).getInt();
			config.get(Configuration.CATEGORY_GENERAL, "NetherRedstoneOreSpawnProb", 12, orespawnProbComment).getInt();
			config.get(Configuration.CATEGORY_GENERAL, "NetherEmeraldOreSpawnProb", 5, orespawnProbComment).getInt();
			config.get(Configuration.CATEGORY_GENERAL, "NetherGoldOreSpawnProb", 8, orespawnProbComment).getInt();
			config.get(Configuration.CATEGORY_GENERAL, "NetherLapisOreSpawnProb", 8, orespawnProbComment).getInt();
			config.get(Configuration.CATEGORY_GENERAL, "NetherCoalOreSpawnProb", 16, orespawnProbComment).getInt();


		} catch (Exception e) {
			Main.proxy.info("failed to load or read the config file");
		} finally {
			if (config.hasChanged()) {
				config.save();
			}
		}
	}




	public static int getNetherIronOreSpawnProb()
	{
		return netherironoreSpawnProb;
		
	}

	public static int getNetherDiamondOreSpawnProb()
	{
		return netherdiamondoreSpawnProb;
		
	}

	public static int getNetherGoldOreSpawnProb()
	{
		return nethergoldoreSpawnProb;
		
	}

	public static int getNetherCoalOreSpawnProb()
	{
		return nethercoaloreSpawnProb;
		
	}

	public static int getNetherEmeraldOreSpawnProb()
	{
		return netheremeraldoreSpawnProb;
		
	}

	public static int getNetherRedstoneOreSpawnProb()
	{
		return netherredstoneoreSpawnProb;
		
	}

	public static int getNetherLapisOreSpawnProb()
	{
		return netherlapisoreSpawnProb;
		
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
