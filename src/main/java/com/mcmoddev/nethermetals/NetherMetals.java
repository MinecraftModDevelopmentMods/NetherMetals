package com.mcmoddev.nethermetals;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mcmoddev.lib.block.BlockExplosiveOre;
import com.mcmoddev.nethermetals.proxy.CommonProxy;
import com.mcmoddev.lib.util.ConfigBase.Options;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
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
		updateJSON = "https://raw.githubusercontent.com/MinecraftModDevelopment/NetherMetals/master/update.json")
public class NetherMetals {

	@Instance
	public static NetherMetals instance;

	/** ID of this Mod */
	public static final String MODID = "nethermetals";

	/** Display name of this Mod */
	public static final String NAME = "Nether Metals";

	/**
	 * Version number, in Major.Minor.Build format. The minor number is
	 * increased whenever a change is made that has the potential to break
	 * compatibility with other mods that depend on this one.
	 */
	public static final String VERSION = "1.2.0-beta2";

	public static Logger logger;

	@SidedProxy(clientSide = "com.mcmoddev.nethermetals.proxy.ClientProxy", serverSide = "com.mcmoddev.nethermetals.proxy.ServerProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void onFingerprintViolation(FMLFingerprintViolationEvent event) {
		logger.warn("Invalid fingerprint detected!");
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = LogManager.getFormatterLogger(MODID);
//		logger.setParent(FMLLog.getLogger());
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
	
    public static boolean hasMMDLib() {
        return Loader.isModLoaded("mmdlib");
    }
        
    public static boolean hasOreSpawn() {
        return Loader.isModLoaded("orespawn");
    }
    public static boolean hasTinkers() {
        return Loader.isModLoaded("tinkersconstruct");
    }
    public static boolean hasModernMetals() {
        return Loader.isModLoaded("modernmetals");
    }
    public static boolean hasBaseMetals() {
        return Loader.isModLoaded("basemetals");
    }

	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event) {
		boolean silk = false;
		if (event.getPlayer() != null && event.getPlayer().getHeldItemMainhand() != null) {
			NBTTagList var15 = event.getPlayer().getHeldItemMainhand().getEnchantmentTagList();
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
				int randomNum = new Random().nextInt((100 - 1) + 1) + 1;
				if (randomNum <= Options.explosionChance() || Options.explosionChance() > 100) {
					event.getWorld().createExplosion(event.getPlayer(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), 4.0F, true);
					//if (ConfigHandler.isAngerPigmen())
						//ModularityApi.angerPigmen(e.getPos(), e.getWorld(), e.getPlayer(), ConfigHandler.getAngerPigmenRange());
				}
			}
		}
	}
}
