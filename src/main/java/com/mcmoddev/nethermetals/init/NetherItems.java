package com.mcmoddev.nethermetals.init;

import com.mcmoddev.basemetals.init.ItemGroups;
import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.init.Items;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.material.MMDMaterial.MaterialType;
import com.mcmoddev.lib.util.TabContainer;
import com.mcmoddev.nethermetals.util.Config.Options;

import net.minecraft.item.ItemStack;

public class NetherItems extends Items {
	private static boolean initDone = false;
	private static TabContainer myTabs = new TabContainer(ItemGroups.blocksTab, ItemGroups.itemsTab, ItemGroups.toolsTab);

	protected NetherItems() {
		throw new IllegalAccessError("Not a instantiable class");
	}

	/**
	 *
	 */
	public static void init() {
		if (initDone) {
			return;
		}

		NetherBlocks.init();
		Items.init();
		
		if( Options.enableCoalNetherOre && !Materials.getMaterialByName("coal").hasItem(Names.INGOT)) {
			Materials.getMaterialByName("coal").addNewItem(Names.INGOT, net.minecraft.init.Items.COAL);
		}
		
		if(Options.enableDiamondNetherOre && !Materials.getMaterialByName("diamond").hasItem(Names.INGOT)) {
			Materials.getMaterialByName("diamond").addNewItem(Names.INGOT, net.minecraft.init.Items.DIAMOND);
		}

		if(Options.enableEmeraldNetherOre && !Materials.getMaterialByName("emerald").hasItem(Names.INGOT)) {
			Materials.getMaterialByName("emerald").addNewItem(Names.INGOT, net.minecraft.init.Items.EMERALD);
		}

		if(Options.enableGoldNetherOre && !Materials.getMaterialByName("gold").hasItem(Names.INGOT)) {
			Materials.getMaterialByName("gold").addNewItem(Names.INGOT, net.minecraft.init.Items.GOLD_INGOT);
		}

		if(Options.enableIronNetherOre && !Materials.getMaterialByName("iron").hasItem(Names.INGOT)) {
			Materials.getMaterialByName("iron").addNewItem(Names.INGOT, net.minecraft.init.Items.IRON_INGOT);
		}

		if(Options.enableLapisNetherOre && !Materials.getMaterialByName("lapis").hasItem(Names.POWDER)) {
			Materials.getMaterialByName("lapis").addNewItem(Names.POWDER, net.minecraft.init.Items.DYE);
		}

		if(Options.enableRedstoneNetherOre && !Materials.getMaterialByName("redstone").hasItem(Names.POWDER)) {
			Materials.getMaterialByName("redstone").addNewItem(Names.POWDER, net.minecraft.init.Items.REDSTONE);
		}
		
		initDone = true;
	}

}
