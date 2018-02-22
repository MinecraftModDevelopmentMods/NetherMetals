package com.mcmoddev.nethermetals.proxy;

import com.mcmoddev.nethermetals.NetherMetals;
import com.mcmoddev.nethermetals.init.*;
import com.mcmoddev.lib.client.registrations.RegistrationHelper;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraft.block.*;

public class ClientProxy extends CommonProxy {

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);

		for (final String name : NetherBlocks.getBlockRegistry().keySet()) {
			// RegistrationHelper.registerItemRender(name);
			registerRenderOuter(NetherBlocks.getBlockByName(name));
		}
	}

	public void registerRenderOuter(Block block) {
		if ((block instanceof BlockDoor) || (block instanceof BlockSlab))
			return; // do not add door blocks or slabs

		if (block != null) {
			registerRender(Item.getItemFromBlock(block), NetherBlocks.getNameOfBlock(block));
		}
	}

	public void registerRender(Item item, String name) {
		final ItemModelMesher itemModelMesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		if (!item.getRegistryName().getResourceDomain().equals(NetherMetals.MODID))
			return;
		itemModelMesher.register(item, 0, new ModelResourceLocation(new ResourceLocation(item.getRegistryName().getResourceDomain(), name), "inventory"));
	}
}
