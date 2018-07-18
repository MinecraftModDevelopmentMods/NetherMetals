package com.mcmoddev.nethermetals.proxy;

import java.util.HashSet;

import com.mcmoddev.basemetals.data.MaterialNames;
import com.mcmoddev.lib.data.SharedStrings;
import com.mcmoddev.lib.oregen.FallbackGenerator;
import com.mcmoddev.lib.util.ConfigBase.Options;
import com.mcmoddev.nethermetals.init.ItemGroups;
import com.mcmoddev.nethermetals.init.Recipes;
import com.mcmoddev.nethermetals.util.Config;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.MissingModsException;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.versioning.ArtifactVersion;
import net.minecraftforge.fml.common.versioning.DefaultArtifactVersion;

public class CommonProxy {

	@SuppressWarnings("deprecation")
	public void preInit(final FMLPreInitializationEvent event) {
		Config.init();

		if ((Options.requireMMDOreSpawn()) && (!Loader.isModLoaded(SharedStrings.ORESPAWN_MODID))) {
			if(Options.fallbackOrespawn()) {
				GameRegistry.registerWorldGenerator(new FallbackGenerator(), 0);
			} else {
				final HashSet<ArtifactVersion> orespawnMod = new HashSet<>();
				orespawnMod.add(new DefaultArtifactVersion(SharedStrings.ORESPAWN_VERSION));
				throw new MissingModsException(orespawnMod, SharedStrings.ORESPAWN_MODID, SharedStrings.ORESPAWN_MISSING_TEXT);
			}
		}
		
		ItemGroups.init();
	}

	public void init(final FMLInitializationEvent event) {
		Recipes.init();

		ItemGroups.setupIcons(MaterialNames.LAPIS);
	}

	public void postInit(final FMLPostInitializationEvent event) {
		Config.postInit();
	}
	
}
