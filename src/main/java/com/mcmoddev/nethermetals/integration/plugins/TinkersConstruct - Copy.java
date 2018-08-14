package com.mcmoddev.nethermetals.integration.plugins;

import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.integration.IIntegration;
import com.mcmoddev.lib.integration.IntegrationInitEvent;
import com.mcmoddev.lib.integration.MMDPlugin;
import com.mcmoddev.lib.integration.plugins.TinkersConstructBase;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.util.ConfigBase.Options;
import com.mcmoddev.lib.util.Oredicts;
import com.mcmoddev.nethermetals.NetherMetals;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.smeltery.MeltingRecipe;

/**
 *
 * @author Jasmine Iwanek
 *
 */
@MMDPlugin(
		addonId = NetherMetals.MODID,
		pluginId = TinkersConstruct.PLUGIN_MODID,
		versions = TinkersConstruct.PLUGIN_MODID
		+ "@[1.12.2-2.7.4.0,);")
public final class TinkersConstruct extends TinkersConstructBase implements IIntegration {

	private boolean registered = false;

	@Override
	public void init() {
		if (!Options.isModEnabled(PLUGIN_MODID)) {
			return;
		}

		MinecraftForge.EVENT_BUS.register(this);
	}

	/**
	 *
	 * @param event
	 *            The Event.
	 */
	@SubscribeEvent
	public void registerExtraMeltings(final IntegrationInitEvent event) {
		if (this.registered) {
			return;
		}
		Materials.getAllMaterials().stream().filter(this::isMaterialEmpty).filter(this::hasOre)
				.filter(this::hasFluid).forEach(material -> {
					final RecipeMatch input = RecipeMatch
							.of(Oredicts.ORE_NETHER + material.getCapitalizedName(), 576);
					final MeltingRecipe recipe = new MeltingRecipe(input,
							FluidRegistry.getFluid(material.getName()));
					TinkerRegistry.registerMelting(recipe);
				});
		this.registered = true;
	}

	private boolean hasFluid(final MMDMaterial material) {
		return FluidRegistry.getFluid(material.getName()) != null;
	}

	private boolean hasOre(final MMDMaterial material) {
		return material.hasBlock(Names.NETHERORE);
	}

	private boolean isMaterialEmpty(final MMDMaterial material) {
		return !material.isEmpty();
	}
}
