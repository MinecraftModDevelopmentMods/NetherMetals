package com.mcmoddev.nethermetals;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mcmoddev.lib.block.BlockExplosiveOre;
import com.mcmoddev.nethermetals.proxy.CommonProxy;
import com.mcmoddev.nethermetals.util.Config;
import com.mcmoddev.lib.util.ConfigBase.Options;
import com.mcmoddev.lib.data.SharedStrings;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * This is the entry point for this Mod.
 *
 * @author Jasmine Iwanek
 *
 */
@Mod(
		modid = NetherMetals.MODID,
		name = NetherMetals.NAME,
		version = NetherMetals.VERSION,
		dependencies = "required-after:forge@[13.20.1.2386,);after:basemetals;after:baseminerals;after:modernmetals",
		acceptedMinecraftVersions = "[1.11.2,)",
		certificateFingerprint = "@FINGERPRINT@",
		updateJSON = SharedStrings.UPDATE_JSON_URL + "NetherMetals/master/update.json")
public final class NetherMetals {

	@Instance(value = NetherMetals.MODID)
	public static NetherMetals instance;

	/** ID of this Mod. */
	public static final String MODID = "nethermetals";

	/** Display name of this Mod. */
	public static final String NAME = "Nether Metals";

	/**
	 * Version number, in Major.Minor.Build format. The minor number is
	 * increased whenever a change is made that has the potential to break
	 * compatibility with other mods that depend on this one.
	 */
	public static final String VERSION = "1.2.0-beta3";

	public static final Logger LOGGER = LogManager.getFormatterLogger(NetherMetals.MODID);

	private static final String PROXY_BASE = SharedStrings.MMD_PROXY_GROUP + MODID + SharedStrings.DOT_PROXY_DOT;

	@SidedProxy(clientSide = PROXY_BASE + SharedStrings.CLIENTPROXY, serverSide = PROXY_BASE
			+ SharedStrings.SERVERPROXY)
	public static CommonProxy proxy;

	@EventHandler
	public void onFingerprintViolation(final FMLFingerprintViolationEvent event) {
		LOGGER.warn(SharedStrings.INVALID_FINGERPRINT);
	}

	@EventHandler
	public void constructing(final FMLConstructionEvent event) {
		Config.init();
	}

	@EventHandler
	public void preInit(final FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@EventHandler
	public void init(final FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void postInit(final FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}

	@SubscribeEvent
	public void onBlockBreak(final BlockEvent.BreakEvent event) {
		boolean silk = false;
		if (event.getPlayer() != null && event.getPlayer().getHeldItemMainhand() != null) {
			final NBTTagList var15 = event.getPlayer().getHeldItemMainhand().getEnchantmentTagList();
			if (var15 != null) {
				for (int nbttaglist3 = 0; nbttaglist3 < var15.tagCount(); ++nbttaglist3) {
					short l1 = var15.getCompoundTagAt(nbttaglist3).getShort("id");
					if (Enchantment.getEnchantmentByID(l1) != null && Enchantment.getEnchantmentByID(l1) == Enchantments.SILK_TOUCH)
						silk = true;
				}
			}
			if ((!silk && event.getWorld().provider.getDimension() == -1)
					&& ((event.getState().getBlock() instanceof BlockExplosiveOre
							&& ((BlockExplosiveOre) event.getState().getBlock()).doesExplode())
							|| event.getState().getBlock() == Blocks.QUARTZ_ORE)) {
				final int randomNum = new Random().nextInt((100 - 1) + 1) + 1;
				if (randomNum <= Options.explosionChance() || Options.explosionChance() > 100) {
					event.getWorld().createExplosion(event.getPlayer(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), 4.0F, true);
					//if (ConfigHandler.isAngerPigmen())
						//ModularityApi.angerPigmen(e.getPos(), e.getWorld(), e.getPlayer(), ConfigHandler.getAngerPigmenRange())
				}
			}
		}
	}
}
