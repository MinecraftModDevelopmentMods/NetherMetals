package com.mcmoddev.nethermetals.integration.plugins;

import com.mcmoddev.basemetals.init.Materials;
import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.integration.IIntegration;
import com.mcmoddev.lib.integration.MMDPlugin;
import com.mcmoddev.lib.integration.plugins.MekanismBase;
import com.mcmoddev.lib.util.ConfigBase.Options;
import com.mcmoddev.nethermetals.NetherMetals;

import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@MMDPlugin(addonId=NetherMetals.MODID, pluginId = Mekanism.PLUGIN_MODID)
public class Mekanism extends MekanismBase implements IIntegration {

	private static boolean initDone = false;

	@Override
	public void init() {
		if (initDone || !Options.isModEnabled(Mekanism.PLUGIN_MODID)) {
			return;
		}

		MinecraftForge.EVENT_BUS.register(this);
		
		initDone = true;
	}
	
    @SubscribeEvent
    public void regCallback(RegistryEvent.Register<IRecipe> ev) {
    	Materials.getAllMaterials().stream().filter(mat -> mat.hasBlock(Names.NETHERORE))
    	.filter( mat -> gasExists(mat.getName()) || gasExists(mat.getCapitalizedName()))
    	.forEach(mat -> {
    		addEnrichmentChamberRecipe(mat.getBlockItemStack(Names.NETHERORE), 
    				mat.getItemStack(Names.POWDER, 4));
    		addPurificationChamberRecipe(mat.getBlockItemStack(Names.NETHERORE),
    				mat.getItemStack(Names.CLUMP, 6));
    		addChemicalInjectionChamberRecipe(mat.getBlockItemStack(Names.NETHERORE),
    				mat.getItemStack(Names.SHARD, 8));
    		addChemicalDissolutionChamberRecipe(mat.getBlockItemStack(Names.NETHERORE),
    				mat.getName(), 2000);
    	});
    }
}
