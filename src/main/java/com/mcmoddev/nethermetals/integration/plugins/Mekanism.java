package com.mcmoddev.nethermetals.integration.plugins;

import javax.annotation.Nonnull;

import com.mcmoddev.basemetals.init.Materials;
import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.integration.IIntegration;
import com.mcmoddev.lib.integration.MMDPlugin;
import com.mcmoddev.lib.integration.plugins.MekanismBase;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.util.ConfigBase.Options;
import com.mcmoddev.nethermetals.NetherMetals;

import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@MMDPlugin(addonId=NetherMetals.MODID, pluginId = Mekanism.PLUGIN_MODID)
public class Mekanism extends MekanismBase implements IIntegration {
	@Override
	public void init() {
		if (!Options.isModEnabled(PLUGIN_MODID)) {
			return;
		}

		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void regCallback(RegistryEvent.Register<IRecipe> event) {
		Materials.getAllMaterials().stream()
		.filter(material -> material.hasBlock(Names.NETHERORE) && material.hasItem(Names.POWDER))
		.forEach(this::addMultRecipe);
	}
	
	public void addMultRecipe(@Nonnull final MMDMaterial material) {
		addPurificationChamberRecipe(material.getBlockItemStack(Names.NETHERORE),
				material.getItemStack(Names.CLUMP, 6));
		addChemicalDissolutionChamberRecipe( material.getBlockItemStack(Names.NETHERORE),
				material.getName(), 2000 );
		if (material.hasItem(Names.POWDER))
			addEnrichmentChamberRecipe(material.getBlockItemStack(Names.NETHERORE),
					material.getItemStack(Names.POWDER, 4));
	}
}
