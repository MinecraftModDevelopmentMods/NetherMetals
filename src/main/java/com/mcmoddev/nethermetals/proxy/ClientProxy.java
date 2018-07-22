package com.mcmoddev.nethermetals.proxy;

import com.mcmoddev.lib.client.registrations.RegistrationHelper;
import com.mcmoddev.lib.init.Blocks;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public final class ClientProxy extends CommonProxy {

	/**
	 *
	 * @param event The Event.
	 */
	@Override
	public void preInit(final FMLPreInitializationEvent event) {
		super.preInit(event);

		for (final String name : Blocks.getBlockRegistry().keySet()) {
			RegistrationHelper.registerBlockRender(name);
		}
	}
}
