package com.knoxhack.nethermetals.client.render.items;


import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.knoxhack.nethermetals.Main;
import com.knoxhack.nethermetals.items.ModItems;

public final class ItemRenderRegister {

	public static void registerItemRenderer() {
		reg(ModItems.nethersword);
		reg(ModItems.netherpickaxe);
		reg(ModItems.netherhoe);
		reg(ModItems.netheraxe);
		reg(ModItems.netherspade);
		reg(ModItems.netherhelmet);
		reg(ModItems.netherchestplate);
		reg(ModItems.netherleggings);
		reg(ModItems.netherboots);
	}

	//==========================================================================

	public static String modid = Main.MODID;

	public static void reg(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
