package com.mcmoddev.nethermetals.util;

import com.mcmoddev.nethermetals.NetherMetals;

import java.io.File;
import java.util.HashSet;

import com.mcmoddev.lib.registry.CrusherRecipeRegistry;

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
public class Config extends com.mcmoddev.lib.util.ConfigBase {

	private static Configuration configuration;
	private static final String CONFIG_FILE = "config/NetherMetals.cfg";
	private static final String ORESPAWN = "OreSpawn";
	private static final String NETHERORE = "Nether Ores";
	private static final String COMPAT = "Mod Compat";
	private static final String GENERAL = "General";
	private static final String REQUIRE_MMD_ORE_SPAWN = "requireMMDOreSpawn";

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
		Options.thingEnabled("enableFurnaceSmelting", configuration.getBoolean("enableFurnaceSmelting", GENERAL, true, "EnableFurnaceSmelting"));
		Options.explosionChance( configuration.get("mean", "OreExplosionChance", 2, "Explosion Percentage Chance\nSet to 0 to not explode").getInt());
		Options.angerPigmenRange( configuration.get("mean", "PigmenAngerRange", 20, "Anger Pigmen Range\nRequires PigmenAnger").getInt());
		Options.thingEnabled("smeltToIngots", configuration.getBoolean("smeltToIngots", GENERAL, false, "By default nether ores smelt to 2 standard ores - with this option you get 2 ingots"));
		Options.thingEnabled("makeDusts", configuration.getBoolean("makeDusts", GENERAL, false, "Normally hitting a Nether Ore with a Crackhammer gives you 2 normal ores. With this option you get 4 dusts"));

		//Nether Ores
		Options.materialEnabled("enableCoalNetherOre", configuration.getBoolean("enableCoalNetherOre", NETHERORE, true, "Enable Coal Nether Ore"));
		Options.materialEnabled("enableDiamondNetherOre", configuration.getBoolean("enableDiamondNetherOre", NETHERORE, true, "Enable Diamond Nether Ore"));
		Options.materialEnabled("enableEmeraldNetherOre", configuration.getBoolean("enableEmeraldNetherOre", NETHERORE, true, "Enable Emerald Nether Ore"));
		Options.materialEnabled("enableGoldNetherOre", configuration.getBoolean("enableGoldNetherOre", NETHERORE, true, "Enable Gold Nether Ore"));
		Options.materialEnabled("enableIronNetherOre", configuration.getBoolean("enableIronNetherOre", NETHERORE, true, "Enable Iron Nether Ore"));
		Options.materialEnabled("enableLapisNetherOre", configuration.getBoolean("enableLapisNetherOre", NETHERORE, true, "Enable Lapis Nether Ore"));
		Options.materialEnabled("enableRedstoneNetherOre", configuration.getBoolean("enableRedstoneNetherOre", NETHERORE, true, "Enable Redstone Nether Ore"));

		Options.materialEnabled("enableAntimonyNetherOre", configuration.getBoolean("enableAntimonyNetherOre", NETHERORE, true, "Enable Antimony Nether Ore"));
		Options.materialEnabled("enableBismuthNetherOre", configuration.getBoolean("enableBismuthNetherOre", NETHERORE, true, "Enable Bismuth Nether Ore"));
		Options.materialEnabled("enableCopperNetherOre", configuration.getBoolean("enableCopperNetherOre", NETHERORE, true, "Enable Copper Nether Ore"));
		Options.materialEnabled("enableLeadNetherOre", configuration.getBoolean("enableLeadNetherOre", NETHERORE, true, "Enable Lead Nether Ore"));
		Options.materialEnabled("enableMercuryNetherOre", configuration.getBoolean("enableMercuryNetherOre", NETHERORE, true, "Enable Mercury Nether Ore"));
		Options.materialEnabled("enableNickelNetherOre", configuration.getBoolean("enableNickelNetherOre", NETHERORE, true, "Enable Nickel Nether Ore"));
		Options.materialEnabled("enablePlatinumNetherOre", configuration.getBoolean("enablePlatinumNetherOre", NETHERORE, true, "Enable Platinum Nether Ore"));
		Options.materialEnabled("enableSilverNetherOre", configuration.getBoolean("enableSilverNetherOre", NETHERORE, true, "Enable Silver Nether Ore"));
		Options.materialEnabled("enableTinNetherOre", configuration.getBoolean("enableTinNetherOre", NETHERORE, true, "Enable Tin Nether Ore"));
		Options.materialEnabled("enableZincNetherOre", configuration.getBoolean("enableZincNetherOre", NETHERORE, true, "Enable Zinc Nether Ore"));
		Options.materialEnabled("enableAluminumNetherOre", configuration.getBoolean("enableAluminumNetherOre", NETHERORE, true, "Enable Aluminum Nether Ore"));
		Options.materialEnabled("enableCadmiumNetherOre", configuration.getBoolean("enableCadmiumNetherOre", NETHERORE, true, "Enable Cadmium Nether Ore"));
		Options.materialEnabled("enableChromiumNetherOre", configuration.getBoolean("enableChromiumNetherOre", NETHERORE, true, "Enable Chromium Nether Ore"));
		Options.materialEnabled("enableIridiumNetherOre", configuration.getBoolean("enableIridiumNetherOre", NETHERORE, true, "Enable Iridium Nether Ore"));
		Options.materialEnabled("enableMagnesiumNetherOre", configuration.getBoolean("enableMagnesiumNetherOre", NETHERORE, true, "Enable Magnesium Nether Ore"));
		Options.materialEnabled("enableManganeseNetherOre", configuration.getBoolean("enableManganeseNetherOre", NETHERORE, true, "Enable Manganese Nether Ore"));
		Options.materialEnabled("enableOsmiumNetherOre", configuration.getBoolean("enableOsmiumNetherOre", NETHERORE, true, "Enable Osmium Nether Ore"));
		Options.materialEnabled("enablePlutoniumNetherOre", configuration.getBoolean("enablePlutoniumNetherOre", NETHERORE, true, "Enable Plutonium Nether Ore"));
		Options.materialEnabled("enableRutileNetherOre", configuration.getBoolean("enableRutileNetherOre", NETHERORE, true, "Enable Rutile Nether Ore"));
		Options.materialEnabled("enableTantalumNetherOre", configuration.getBoolean("enableTantalumNetherOre", NETHERORE, true, "Enable Tantalum Nether Ore"));
		Options.materialEnabled("enableTitaniumNetherOre", configuration.getBoolean("enableTitaniumNetherOre", NETHERORE, true, "Enable Titanium Nether Ore"));
		Options.materialEnabled("enableTungstenNetherOre", configuration.getBoolean("enableTungstenNetherOre", NETHERORE, true, "Enable Tungsten Nether Ore"));
		Options.materialEnabled("enableUraniumNetherOre", configuration.getBoolean("enableUraniumNetherOre", NETHERORE, true, "Enable Uranium Nether Ore"));
		Options.materialEnabled("enableZirconiumNetherOre", configuration.getBoolean("enableZirconiumNetherOre", NETHERORE, true, "Enable Zirconium Nether Ore"));

		//Mod Compat
		Options.thingEnabled(REQUIRE_MMD_ORE_SPAWN, configuration.getBoolean(REQUIRE_MMD_ORE_SPAWN, ORESPAWN, true, "Require MMD OreSpawn"));
		Options.modEnabled("enableVeinminer", configuration.getBoolean("enableVeinminer", COMPAT, true, "Enable Veinminer Support"));
		Options.modEnabled("enableTinkersConstruct", configuration.getBoolean("enableTinkersConstruct", COMPAT, false, "Enable Tinkers Construct Support"));

		if (configuration.hasChanged()) {
			configuration.save();
		}

		if (Options.isThingEnabled(REQUIRE_MMD_ORE_SPAWN)) {
			if (!Loader.isModLoaded("orespawn")) {
				final HashSet<ArtifactVersion> orespawnMod = new HashSet<>();
				orespawnMod.add(new DefaultArtifactVersion("3.2.2"));
				throw new MissingModsException(orespawnMod, "orespawn", "MMD Ore Spawn Mod");
			}
		}
	}

	public static void postInit() {
		CrusherRecipeRegistry.getInstance().clearCache();
	}
}
