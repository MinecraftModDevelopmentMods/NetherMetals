package com.mcmoddev.orespawn;

import com.mcmoddev.lib.data.SharedStrings;
import com.mcmoddev.nethermetals.NetherMetals;
import com.mcmoddev.orespawn.api.os3.OS3API;
import com.mcmoddev.orespawn.api.plugin.IOreSpawnPlugin;
import com.mcmoddev.orespawn.api.plugin.OreSpawnPlugin;

@OreSpawnPlugin(modid = NetherMetals.MODID, resourcePath = SharedStrings.ORESPAWN_MODID)
public final class NetherMetalsOreSpawn implements IOreSpawnPlugin {

	@Override
	public void register(final OS3API apiInterface) {
		// Intentionally blank - we don't have anything to do here
	}
}
