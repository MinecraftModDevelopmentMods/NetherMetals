package com.mcmoddev.nethermetals.integration.plugins;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;

import com.mcmoddev.basemetals.data.MaterialNames;
import com.mcmoddev.basemetals.init.Materials;
import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.integration.IIntegration;
import com.mcmoddev.lib.integration.MMDPlugin;
import com.mcmoddev.lib.integration.plugins.MekanismBase;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.util.ConfigBase.Options;
import com.mcmoddev.nethermetals.NetherMetals;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

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
		final List<String> mekProvides = Arrays.asList(MaterialNames.IRON, MaterialNames.GOLD, 
				com.mcmoddev.modernmetals.data.MaterialNames.OSMIUM,
				MaterialNames.COPPER, MaterialNames.TIN, MaterialNames.SILVER, MaterialNames.LEAD);
		
		mekProvides.stream()
		.map(Materials::getMaterialByName)
		.filter(mat -> !mat.isEmpty())
		.filter(mat -> gasExists(mat.getName()))
		.forEach( mat -> {
			ItemStack clump = new ItemStack( ForgeRegistries.ITEMS.getValue(new ResourceLocation("mekanism", "clump")),
					6, mekProvides.indexOf(mat.getName()));
			ItemStack dust = new ItemStack( ForgeRegistries.ITEMS.getValue(new ResourceLocation("mekanism", "dust")),
					4, mekProvides.indexOf(mat.getName()));
			ItemStack shard = new ItemStack( ForgeRegistries.ITEMS.getValue(new ResourceLocation("mekanism", "shard")),
					8, mekProvides.indexOf(mat.getName()));
			final ItemStack netherOre = mat.getBlockItemStack(Names.NETHERORE);
			
			addEnrichmentChamberRecipe(netherOre, dust);
			addPurificationChamberRecipe(netherOre, clump);
			addChemicalInjectionChamberRecipe(netherOre, shard);
			addChemicalDissolutionChamberRecipe(netherOre, mat.getName(), 2000);
		});
		
		Materials.getAllMaterials().stream()
		.filter(material -> material.hasBlock(Names.NETHERORE) && material.hasItem(Names.POWDER))
		.filter(material -> gasExists(material.getName()))
		.filter(material -> !mekProvides.contains(material.getName()))
		.forEach(this::addMultRecipe);

		if (Materials.hasMaterial("lapis")) {
			final MMDMaterial material = Materials.getMaterialByName("lapis");
			addEnrichmentChamberRecipe(material.getBlockItemStack(Names.NETHERORE), new ItemStack(net.minecraft.init.Items.DYE, 24, 4));
		}

		if (Materials.hasMaterial("redstone")) {
			final MMDMaterial material = Materials.getMaterialByName("redstone");
			addEnrichmentChamberRecipe(material.getBlockItemStack(Names.NETHERORE), new ItemStack(net.minecraft.init.Items.REDSTONE, 24));
		}

		if (Materials.hasMaterial("coal")) {
			final MMDMaterial material = Materials.getMaterialByName("coal");
			addEnrichmentChamberRecipe(material.getBlockItemStack(Names.NETHERORE), new ItemStack(net.minecraft.init.Items.COAL, 4, 0));
		}

		if (Materials.hasMaterial("diamond")) {
			final MMDMaterial material = Materials.getMaterialByName("diamond");
			addEnrichmentChamberRecipe(material.getBlockItemStack(Names.NETHERORE), new ItemStack(net.minecraft.init.Items.DIAMOND, 4));
		}
		if (Materials.hasMaterial("emerald")) {
			final MMDMaterial material = Materials.getMaterialByName("emerald");
			addEnrichmentChamberRecipe(material.getBlockItemStack(Names.NETHERORE), new ItemStack(net.minecraft.init.Items.EMERALD, 4));
		}
	}

	private void addMultRecipe(@Nonnull final MMDMaterial material) {
		final ItemStack netherOre = material.getBlockItemStack(Names.NETHERORE);
		
		if (material.hasItem(Names.POWDER)) {
			addEnrichmentChamberRecipe(netherOre, material.getItemStack(Names.POWDER, 4));
		}
		if (material.hasItem(Names.CLUMP)) {
			addPurificationChamberRecipe(netherOre, material.getItemStack(Names.CLUMP, 6));
		}
		if (material.hasItem(Names.SHARD)) {
			addChemicalInjectionChamberRecipe(netherOre, material.getItemStack(Names.SHARD, 8));
		}
		addChemicalDissolutionChamberRecipe(netherOre, material.getName(), 2000);
	}
}
