package com.mcmoddev.nethermetals.init;

import com.mcmoddev.basemetals.data.MaterialNames;
import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.data.SharedStrings;
import com.mcmoddev.lib.init.MMDCreativeTab;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.material.MMDMaterial;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * This class initializes all item groups in Nether Metals.
 *
 * @author Jasmine Iwanek
 *
 */
public class ItemGroups extends com.mcmoddev.lib.init.ItemGroups {
	public static final MMDCreativeTab blocksTab = getTab(SharedStrings.TAB_BLOCKS);

	private static boolean initDone = false;

	private ItemGroups() {
		throw new IllegalAccessError("Not a instantiable class");
	}

	/**
	 *
	 */
	public static void init() {
		if (initDone) {
			return;
		}

		initDone = true;
	}
	
	public static void setupIcons(String materialName) {
		if (Materials.hasMaterial(materialName)) {
			final MMDMaterial material = Materials.getMaterialByName(materialName);

			if ((blocksTab != null) && (material.hasBlock(Names.NETHERORE))) {
				blocksTab.setTabIconItem(Item.getItemFromBlock(material.getBlock(Names.NETHERORE)));
			}
/*
			if ((itemsTab != null) && (material.hasItem(Names.GEAR))) {
				itemsTab.setTabIconItem(material.getItem(Names.GEAR));
			}

			if ((toolsTab != null) && (material.hasItem(Names.PICKAXE))) {
				toolsTab.setTabIconItem(material.getItem(Names.PICKAXE));
			}

			if ((combatTab != null) && (material.hasItem(Names.SWORD))) {
				combatTab.setTabIconItem(material.getItem(Names.SWORD));
			}
*/
		}
	}
}
