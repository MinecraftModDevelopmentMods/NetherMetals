package com.knoxhack.nethermetals.client.render.blocks;

import com.knoxhack.nethermetals.Main;
import com.knoxhack.nethermetals.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class BlockRenderRegister {

	public static void registerBlockRenderer() {
		reg(ModBlocks.nethercopperOre);
		reg(ModBlocks.nethertinOre);
		reg(ModBlocks.netherleadOre);
		reg(ModBlocks.nethersilverOre);
		reg(ModBlocks.nethernickelOre);
		reg(ModBlocks.netherzincOre);
		
		reg(ModBlocks.netherironOre);
		reg(ModBlocks.netherlapisOre);
		reg(ModBlocks.netherredstoneOre);
		reg(ModBlocks.netherdiamondOre);
		reg(ModBlocks.nethergoldOre);

	}

	public static String modid = Main.MODID;

	public static void reg(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(modid + ":" + block.getUnlocalizedName().substring(5), "inventory"));
	}

}
