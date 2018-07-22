package com.mcmoddev.nethermetals.util;

import com.mcmoddev.nethermetals.NetherMetals;
import com.mcmoddev.lib.data.SharedStrings;
import com.mcmoddev.lib.init.Materials;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLMissingMappingsEvent;
import net.minecraftforge.fml.common.event.FMLMissingMappingsEvent.MissingMapping;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(value = { Side.CLIENT, Side.SERVER }, modid = NetherMetals.MODID)
public final class EventHandler {

	private EventHandler() {
		throw new IllegalAccessError(SharedStrings.NOT_INSTANTIABLE);
	}

	/**
	 *
	 * @param event The Event.
	 */
	@SubscribeEvent
	public void onRemap(final FMLMissingMappingsEvent event) {
		for (final MissingMapping mapping : event.get()) {
			if (mapping.resourceLocation.getResourceDomain().equals(NetherMetals.MODID)) {
				if (mapping.type.equals(GameRegistry.Type.BLOCK)) {
					// Dummy
				} else if (mapping.type.equals(GameRegistry.Type.ITEM)) {
					// Dummy
				}
			}
		}
	}
}
