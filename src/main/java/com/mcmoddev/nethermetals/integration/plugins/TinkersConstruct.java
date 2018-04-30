package com.mcmoddev.nethermetals.integration.plugins;

import com.mcmoddev.nethermetals.NetherMetals;
import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.integration.IIntegration;
import com.mcmoddev.lib.integration.IntegrationInitEvent;
import com.mcmoddev.lib.integration.MMDPlugin;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.util.ConfigBase.Options;
import com.mcmoddev.lib.util.Oredicts;
import com.mcmoddev.lib.integration.plugins.TinkersConstructBase;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.smeltery.MeltingRecipe;
import slimeknights.mantle.util.RecipeMatch;

/**
 *
 * @author Jasmine Iwanek
 *
 */
@MMDPlugin(addonId = NetherMetals.MODID, 
pluginId = TinkersConstruct.PLUGIN_MODID, 
versions=TinkersConstruct.PLUGIN_MODID+"@[1.12.2-2.7.4.0,);")
public class TinkersConstruct extends TinkersConstructBase implements IIntegration {

	@Override
	public void init() {
		if (!Options.isModEnabled(TinkersConstruct.PLUGIN_MODID)) {
			return;
		}

		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private boolean registered = false;
	
    @SubscribeEvent
    public void registerExtraMeltings(IntegrationInitEvent ev) {
		if (registered) return;
		registered = true;
		Materials.getAllMaterials().stream()
		.filter(this::isMaterialEmpty)
		.filter(this::hasNetherOre)
		.filter(this::hasFluid)
		.forEach(mat -> {
			RecipeMatch input = RecipeMatch.of(Oredicts.ORE_NETHER + mat.getCapitalizedName(), 576);
			MeltingRecipe rec = new MeltingRecipe(input, FluidRegistry.getFluid(mat.getName()));
			TinkerRegistry.registerMelting(rec);
		});
	}
	
	private boolean hasFluid(MMDMaterial mat) {
		return FluidRegistry.getFluid(mat.getName()) != null;
	}
	
	private boolean hasNetherOre(MMDMaterial mat) {
		return mat.hasBlock(Names.NETHERORE);
	}
	
	private boolean isMaterialEmpty(MMDMaterial mat) {
		return !mat.isEmpty();
	}	
}
