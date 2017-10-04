package com.mcmoddev.nethermetals.integration.plugins;

import java.util.ArrayList;
import java.util.List;

import com.mcmoddev.basemetals.init.Materials;
import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.integration.IIntegration;
import com.mcmoddev.lib.integration.MMDPlugin;
import com.mcmoddev.lib.integration.plugins.MekanismBase;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.util.ConfigBase.Options;
import com.mcmoddev.nethermetals.NetherMetals;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
    	List<MMDMaterial> myMats = new ArrayList<>();
    	
    	Materials.getAllMaterials().stream().filter((mat) -> mat.hasBlock(Names.NETHERORE)).forEach((mat) -> myMats.add(mat));
    	for( MMDMaterial mat : myMats ) {
    		final Item clump = mat.getItem(Names.CLUMP);
    		final Item powder = mat.getItem(Names.POWDER);
    		final Block ore = mat.getBlock(Names.NETHERORE);
    		final Item shard = mat.getItem(Names.SHARD);
    		
    		if( gasExists(mat.getName()) || gasExists(mat.getCapitalizedName()) ) {
    			addEnrichmentChamberRecipe(new ItemStack(ore), new ItemStack(powder, 4));
    			addPurificationChamberRecipe(new ItemStack(ore), new ItemStack(clump, 6));
    			addChemicalInjectionChamberRecipe(new ItemStack(ore), new ItemStack(shard, 8));
    			addChemicalDissolutionChamberRecipe(new ItemStack(ore), mat.getName(), 2000);
    		}
    	}
    }
}
