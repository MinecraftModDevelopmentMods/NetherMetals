package com.mcmoddev.nethermetals;

import java.util.Random;
import java.util.logging.Logger;

import com.mcmoddev.lib.blocks.BlockExplosiveOre;
import com.mcmoddev.nethermetals.proxy.CommonProxy;
import com.mcmoddev.nethermetals.util.Config.Options;

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
@Mod(modid = NetherMetals.MODID, name = NetherMetals.NAME, version = NetherMetals.VERSION, dependencies = "required-after:Forge;after:modularity;after:modernmetals;after:basemetals", acceptedMinecraftVersions = "[1.10.2,)", updateJSON = "https://raw.githubusercontent.com/MinecraftModDevelopment/NetherMetals/master/update.json")
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
	public static final String VERSION = "1.2.0";

	public static Logger logger;

	@SidedProxy(clientSide = "com.mcmoddev.nethermetals.proxy.ClientProxy", serverSide = "com.mcmoddev.nethermetals.proxy.ServerProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = Logger.getLogger(MODID);
//		logger.setParent(FMLLog.getLogger());
		
		NetherMetals.proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		NetherMetals.proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		NetherMetals.proxy.postInit(event);
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
	public void onBlockBreak(BlockEvent.BreakEvent e) {
		boolean silk = false;
		if (e.getPlayer() != null && e.getPlayer().getHeldItem(e.getPlayer().swingingHand) != null) {
			NBTTagList var15 = e.getPlayer().getHeldItem(e.getPlayer().swingingHand).getEnchantmentTagList();
			if (var15 != null) {
				for (int nbttaglist3 = 0; nbttaglist3 < var15.tagCount(); ++nbttaglist3) {
					short l1 = var15.getCompoundTagAt(nbttaglist3).getShort("id");
					if (Enchantment.getEnchantmentByID(l1) != null && Enchantment.getEnchantmentByID(l1) == Enchantments.SILK_TOUCH)
						silk = true;
				}
			}
			if ((!silk && e.getWorld().provider.getDimension() == -1)
					&& ((e.getState().getBlock() instanceof BlockExplosiveOre
							&& ((BlockExplosiveOre) e.getState().getBlock()).doesExplode())
							|| e.getState().getBlock() == Blocks.QUARTZ_ORE)) {
				int randomNum = new Random().nextInt((100 - 1) + 1) + 1;
				if (randomNum <= Options.getExplosionChance() || Options.getExplosionChance() > 100) {
					e.getWorld().createExplosion(e.getPlayer(), e.getPos().getX(), e.getPos().getY(), e.getPos().getZ(), 4.0F, true);
					//if (ConfigHandler.isAngerPigmen())
						//ModularityApi.angerPigmen(e.getPos(), e.getWorld(), e.getPlayer(), ConfigHandler.getAngerPigmenRange());
				}
			}
		}
	}
}