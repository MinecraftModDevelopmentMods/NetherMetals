package com.mcmoddev.nethermetals.integration.plugins;

import com.mcmoddev.nethermetals.NetherMetals;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;
import java.util.ArrayList;

import com.mcmoddev.basemetals.init.Materials;
import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.integration.IIntegration;
import com.mcmoddev.lib.integration.MMDPlugin;
import com.mcmoddev.lib.integration.plugins.IC2Base;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.util.ConfigBase.Options;
import com.mcmoddev.lib.util.Oredicts;

@MMDPlugin(addonId=NetherMetals.MODID, pluginId = IC2.PLUGIN_MODID)
public class IC2 extends IC2Base implements IIntegration {
	@Override
	public void init() {
		if (!Options.isModEnabled(PLUGIN_MODID)) {
			return;
		}
		
		MinecraftForge.EVENT_BUS.register(this);
	}

    @SubscribeEvent
    public void regCallback(RegistryEvent.Register<IRecipe> ev) {
    	List<MMDMaterial> myMats = new ArrayList<>();
    	
    	Materials.getAllMaterials().stream().filter((mat) -> mat.hasBlock(Names.NETHERORE)).forEach(myMats::add);
    	for( MMDMaterial mat : myMats ) {
    		ItemStack output;
    		if( mat.hasItem(Names.CRUSHED)) {
    			output = new ItemStack( mat.getItem(Names.CRUSHED), 4 );
    		} else if( mat.hasItem(Names.POWDER) ) {
    			output = new ItemStack( mat.getItem(Names.POWDER), 4);
    		} else {
    			continue;
    		}
    		
    		addMaceratorRecipe(Oredicts.ORE_NETHER+mat.getCapitalizedName(), output);
    	}
    }
}

