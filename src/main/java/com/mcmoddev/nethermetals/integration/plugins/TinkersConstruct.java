package com.mcmoddev.nethermetals.integration.plugins;

import com.mcmoddev.nethermetals.NetherMetals;
import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.integration.IIntegration;
import com.mcmoddev.lib.integration.MMDPlugin;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.util.ConfigBase.Options;
import com.mcmoddev.lib.integration.plugins.TinkersConstructBase;

import net.minecraftforge.fml.common.Loader;

/**
 *
 * @author Jasmine Iwanek
 *
 */
@MMDPlugin(addonId = NetherMetals.MODID,
pluginId = TinkersConstruct.PLUGIN_MODID)
public final class TinkersConstruct extends TinkersConstructBase implements IIntegration {

	@Override
	public void init() {
		if (!Options.isModEnabled(TinkersConstruct.PLUGIN_MODID)) {
			return;
		}

		registerExtraMeltingWrapper(Materials.getMaterialByName("coal"), 144);
		registerExtraMeltingWrapper(Materials.getMaterialByName("diamond"), 144);
		registerExtraMeltingWrapper(Materials.getMaterialByName("emerald"), 144);
		registerExtraMeltingWrapper(Materials.getMaterialByName("gold"), 144);
		registerExtraMeltingWrapper(Materials.getMaterialByName("iron"), 144);
		registerExtraMeltingWrapper(Materials.getMaterialByName("lapis"), 144);
		registerExtraMeltingWrapper(Materials.getMaterialByName("redstone"), 144);
		
		if( Loader.isModLoaded("basemetals") ) {
			registerExtraMeltingWrapper(Materials.getMaterialByName("antimony"), 144);
			registerExtraMeltingWrapper(Materials.getMaterialByName("bismuth"), 144);
			registerExtraMeltingWrapper(Materials.getMaterialByName("copper"), 144);
			registerExtraMeltingWrapper(Materials.getMaterialByName("lead"), 144);
			registerExtraMeltingWrapper(Materials.getMaterialByName("mercury"), 144);
			registerExtraMeltingWrapper(Materials.getMaterialByName("nickel"), 144);
			registerExtraMeltingWrapper(Materials.getMaterialByName("platinum"), 144);
			registerExtraMeltingWrapper(Materials.getMaterialByName("silver"), 144);
			registerExtraMeltingWrapper(Materials.getMaterialByName("tin"), 144);
			registerExtraMeltingWrapper(Materials.getMaterialByName("zinc"), 144);
		}
		
		if( Loader.isModLoaded("modernmetals") ) {
			registerExtraMeltingWrapper(Materials.getMaterialByName("aluminum"), 144);
			registerExtraMeltingWrapper(Materials.getMaterialByName("cadmium"), 144);
			registerExtraMeltingWrapper(Materials.getMaterialByName("chromium"), 144);
			registerExtraMeltingWrapper(Materials.getMaterialByName("iridium"), 144);
			registerExtraMeltingWrapper(Materials.getMaterialByName("magnesium"), 144);
			registerExtraMeltingWrapper(Materials.getMaterialByName("manganese"), 144);
			registerExtraMeltingWrapper(Materials.getMaterialByName("osmium"), 144);
			registerExtraMeltingWrapper(Materials.getMaterialByName("plutonium"), 144);
			registerExtraMeltingWrapper(Materials.getMaterialByName("rutile"),  144);
			registerExtraMeltingWrapper(Materials.getMaterialByName("tantalum"), 144);
			registerExtraMeltingWrapper(Materials.getMaterialByName("titanium"), 144);
			registerExtraMeltingWrapper(Materials.getMaterialByName("tungsten"), 144);
			registerExtraMeltingWrapper(Materials.getMaterialByName("uranium"), 144);
			registerExtraMeltingWrapper(Materials.getMaterialByName("zirconium"), 144);
		}
	}
	
	private static void registerExtraMeltingWrapper(final MMDMaterial material, final int quantity) {
		registerExtraMelting(material, material.getBlock(Names.NETHERORE), quantity);		
	}
}
