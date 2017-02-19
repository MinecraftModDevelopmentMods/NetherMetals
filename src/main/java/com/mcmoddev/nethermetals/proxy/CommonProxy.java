package com.mcmoddev.nethermetals.proxy;

import com.mcmoddev.nethermetals.util.Config;
import com.mcmoddev.nethermetals.util.CreativeTabNMe;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.nethermetals.init.*;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		Config.init();
		Materials.init();
//		ItemGroups.init();
		CreativeTabs tab = new CreativeTabNMe();
		Blocks.init();
		FMLInterModComms.sendFunctionMessage("orespawn", "api", "com.mcmoddev.orespawn.NetherMetalsOreSpawn");

/*
		final Path oreSpawnFolder = Paths.get(event.getSuggestedConfigurationFile().toPath().getParent().toString(), "orespawn");
		if (ConfigHandler.requireOreSpawn) {
			// Base Metals
			if (Loader.isModLoaded("basemetals")) {
				final Path bmoreSpawnFile = Paths.get(oreSpawnFolder.toString(), NetherMetals.MODID + "-bmores" + ".json");
				if (!(bmoreSpawnFile.toFile().exists())) {
					try {
						Files.createDirectories(bmoreSpawnFile.getParent());
						Files.write(bmoreSpawnFile, Arrays.asList(DataConstants.BM_ORESPAWN_JSON.split("\n")), Charset.forName("UTF-8"));
					} catch (IOException e) {
						FMLLog.severe(NetherMetals.MODID + ": Error: Failed to write file " + bmoreSpawnFile);
					}
				}
			}

			// Modern Metals
			if (Loader.isModLoaded("modernmetals")) {
				final Path mmoreSpawnFile = Paths.get(oreSpawnFolder.toString(), NetherMetals.MODID + "-mmores" + ".json");
				if (!(mmoreSpawnFile.toFile().exists())) {
					try {
						Files.createDirectories(mmoreSpawnFile.getParent());
						Files.write(mmoreSpawnFile, Arrays.asList(DataConstants.MM_ORESPAWN_JSON.split("\n")), Charset.forName("UTF-8"));
					} catch (IOException e) {
						FMLLog.severe(NetherMetals.MODID + ": Error: Failed to write file " + mmoreSpawnFile);
					}
				}
			}
		}
*/
	}

	public void init(FMLInitializationEvent event) {
		Recipes.init();
	}

	public void postInit(FMLPostInitializationEvent event) {
		Config.postInit();
	}
}
