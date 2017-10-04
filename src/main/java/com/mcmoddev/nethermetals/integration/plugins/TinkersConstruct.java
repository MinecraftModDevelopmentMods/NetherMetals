package com.mcmoddev.nethermetals.integration.plugins;

import com.mcmoddev.nethermetals.NetherMetals;

import net.minecraft.item.Item;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Loader;

import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.integration.IIntegration;
import com.mcmoddev.lib.integration.MMDPlugin;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.util.ConfigBase.Options;

/**
 *
 * @author Jasmine Iwanek
 *
 */
@MMDPlugin(addonId = NetherMetals.MODID,
		   pluginId = TinkersConstruct.PLUGIN_MODID, 
           preInitCallback="preInit", 
           initCallback="initCallback",
           postInitCallback="postInit")
public class TinkersConstruct extends com.mcmoddev.lib.integration.plugins.TinkersConstructBase implements IIntegration {

	private static boolean initDone = false;

	@Override
	public void init() {
		if (initDone || !com.mcmoddev.lib.util.ConfigBase.Options.isModEnabled("enableTinkersConstruct")) {
			return;
		}
		
		initDone = true;
	}
	
	public void preInit() {
		super.preInitSetup();
		registerMelting();
		super.setMaterialsVisible();
	}
	
	public void initCallback() {
		super.initSetup();
	}

	public void postInit() {
		super.postInitSetup();
	}

	private void registerMelting() {
		registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.basemetals.data.MaterialNames.COAL), Materials.getMaterialByName(com.mcmoddev.basemetals.data.MaterialNames.COAL), 576);
		registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.basemetals.data.MaterialNames.DIAMOND), Materials.getMaterialByName(com.mcmoddev.basemetals.data.MaterialNames.DIAMOND), 576);
		registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.basemetals.data.MaterialNames.EMERALD), Materials.getMaterialByName(com.mcmoddev.basemetals.data.MaterialNames.EMERALD), 576);
		registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.basemetals.data.MaterialNames.GOLD), Materials.getMaterialByName(com.mcmoddev.basemetals.data.MaterialNames.GOLD), 576);
		registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.basemetals.data.MaterialNames.IRON), Materials.getMaterialByName(com.mcmoddev.basemetals.data.MaterialNames.IRON), 576);
		// No such thing as a Lapis fluid in the code
		//registerExtraMeltingWrapper(Materials.getMaterialByName("lapis"), 576);
		registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.basemetals.data.MaterialNames.REDSTONE), Materials.getMaterialByName(com.mcmoddev.basemetals.data.MaterialNames.REDSTONE), 576);
		
		if( Loader.isModLoaded("basemetals") ) {
			registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.basemetals.data.MaterialNames.ANTIMONY), Materials.getMaterialByName(com.mcmoddev.basemetals.data.MaterialNames.ANTIMONY), 576);
			registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.basemetals.data.MaterialNames.BISMUTH), Materials.getMaterialByName(com.mcmoddev.basemetals.data.MaterialNames.BISMUTH), 576);
			registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.basemetals.data.MaterialNames.COPPER), Materials.getMaterialByName(com.mcmoddev.basemetals.data.MaterialNames.COPPER), 576);
			registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.basemetals.data.MaterialNames.LEAD), Materials.getMaterialByName(com.mcmoddev.basemetals.data.MaterialNames.LEAD), 576);
			registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.basemetals.data.MaterialNames.MERCURY), Materials.getMaterialByName(com.mcmoddev.basemetals.data.MaterialNames.MERCURY), 576);
			registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.basemetals.data.MaterialNames.NICKEL), Materials.getMaterialByName(com.mcmoddev.basemetals.data.MaterialNames.NICKEL), 576);
			registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.basemetals.data.MaterialNames.PLATINUM), Materials.getMaterialByName(com.mcmoddev.basemetals.data.MaterialNames.PLATINUM), 576);
			registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.basemetals.data.MaterialNames.SILVER), Materials.getMaterialByName(com.mcmoddev.basemetals.data.MaterialNames.SILVER), 576);
			registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.basemetals.data.MaterialNames.TIN), Materials.getMaterialByName(com.mcmoddev.basemetals.data.MaterialNames.TIN), 576);
			registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.basemetals.data.MaterialNames.ZINC), Materials.getMaterialByName(com.mcmoddev.basemetals.data.MaterialNames.ZINC), 576);
		}
		
		if( Loader.isModLoaded("modernmetals") ) {
            registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.ALUMINUM),Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.ALUMINUM), 576);
            registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.CADMIUM),Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.CADMIUM), 576);
            registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.CHROMIUM),Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.CHROMIUM), 576);
            registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.IRIDIUM),Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.IRIDIUM), 576);
            registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.MAGNESIUM),Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.MAGNESIUM), 576);
            registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.MANGANESE),Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.MANGANESE), 576);
            registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.OSMIUM),Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.OSMIUM), 576);
            registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.PLUTONIUM),Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.PLUTONIUM), 576);
            registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.RUTILE),Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.RUTILE),  576);
            registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.TANTALUM),Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.TANTALUM), 576);
            registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.TITANIUM),Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.TITANIUM), 576);
            registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.TUNGSTEN),Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.TUNGSTEN), 576);
            registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.URANIUM),Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.URANIUM), 576);
            registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.ZIRCONIUM),Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.ZIRCONIUM), 576);
            registerExtraMeltingWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.ZIRCONIUM),Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.ZIRCONIUM), 576);
		}
	}

	private static void registerExtraMeltingWrapper(boolean enabled, MMDMaterial material, int quantity) {
		if( enabled ) {
			FluidStack result = FluidRegistry.getFluidStack(material.getName(), quantity);
			registry.registerMelting(Item.getItemFromBlock(material.getBlock(Names.NETHERORE)), result);
		}	
	}
}
