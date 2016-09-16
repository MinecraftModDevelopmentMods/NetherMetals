package com.knoxhack.nethermetals;

import java.io.IOException;
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
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION,
		dependencies = "required-after:Forge;after:basemetals;after:modernmetals",
		acceptedMinecraftVersions = "1.9,)",
		updateJSON = "https://raw.githubusercontent.com/nfinit-gaming/Nether-Metals/master/update.json")

public class Main {

	@Instance
	public static Main INSTANCE = null;

	public static final String MODID = "nethermetals";
	public static final String MODNAME = "Nether Metals";
	public static final String VERSION = "1.2.0";

	/** All ore-spawn files discovered in the ore-spawn folder */
	// public static final List<Path> oreSpawnConfigFiles = new LinkedList<>();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		INSTANCE = this;

		// vanilla config loader
		ConfigHandler.startConfig(event);

		// load config
		final Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		final Path oreSpawnFolder = Paths.get(event.getSuggestedConfigurationFile().toPath().getParent().toString(), "orespawn");
		if (ConfigHandler.requireOreSpawn) {
			// Base Metals
			if (Loader.isModLoaded("basemetals")) {
				final Path bmoreSpawnFile = Paths.get(oreSpawnFolder.toString(), MODID + "-bmores" + ".json");
				if (!Files.exists(bmoreSpawnFile)) {
					try {
						Files.createDirectories(bmoreSpawnFile.getParent());
						Files.write(bmoreSpawnFile, Arrays.asList(DataConstants.BM_ORESPAWN_JSON.split("\n")), Charset.forName("UTF-8"));
					} catch (IOException e) {
						FMLLog.severe(MODID + ": Error: Failed to write file " + bmoreSpawnFile);
					}
				}
			}

			// Modern Metals
			if (Loader.isModLoaded("modernmetals")) {
				final Path mmoreSpawnFile = Paths.get(oreSpawnFolder.toString(), MODID + "-mmores" + ".json");
				if (!Files.exists(mmoreSpawnFile)) {
					try {
						Files.createDirectories(mmoreSpawnFile.getParent());
						Files.write(mmoreSpawnFile, Arrays.asList(DataConstants.MM_ORESPAWN_JSON.split("\n")), Charset.forName("UTF-8"));
					} catch (IOException e) {
						FMLLog.severe(MODID + ": Error: Failed to write file " + mmoreSpawnFile);
					}
				}
			}
		}

		config.save();

		Main.proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		Main.proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		Main.proxy.postInit(event);
	}

	@SidedProxy(clientSide="com.knoxhack.nethermetals.ClientProxy", serverSide="com.knoxhack.nethermetals.ServerProxy")
	public static CommonProxy proxy;
}
