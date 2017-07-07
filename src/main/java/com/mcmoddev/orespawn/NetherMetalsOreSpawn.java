package com.mcmoddev.orespawn;

import com.mcmoddev.orespawn.api.os3.OS3API;
import com.mcmoddev.orespawn.api.plugin.IOreSpawnPlugin;
import com.mcmoddev.orespawn.api.plugin.OreSpawnPlugin;

@OreSpawnPlugin( modid="nethermetals", resourcePath="orespawn" )
public class NetherMetalsOreSpawn implements IOreSpawnPlugin {

	@Override
	public void register(OS3API apiInterface) {
		// Intentionally blank - we don't have anything to do here	
	}

}
