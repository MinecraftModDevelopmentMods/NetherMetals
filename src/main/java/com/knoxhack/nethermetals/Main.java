package com.knoxhack.nethermetals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.knoxhack.nethermetals.blocks.ExplosiveBlock;
import dank.modularity.api.ModularityApi;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION,
		dependencies = "required-after:forge;after:modularity;after:modernmetals;after:basemetals",
		acceptedMinecraftVersions = "1.10.2,)",
		updateJSON = "https://raw.githubusercontent.com/MinecraftModDevelopment/NetherMetals/master/update.json")

public class Main {

	@Instance
	public static Main INSTANCE = null;

	public static final String MODID = "nethermetals";
	public static final String MODNAME = "Nether Metals";
	public static final String VERSION = "1.2";

	/** All ore-spawn files discovered in the ore-spawn folder */

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		INSTANCE = this;
		MinecraftForge.EVENT_BUS.register(this);
		// vanilla config loader
		ConfigHandler.startConfig(event);
		Main.proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		Main.proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		Main.proxy.postInit(event);
	}

	@SidedProxy(clientSide = "com.knoxhack.nethermetals.ClientProxy", serverSide = "com.knoxhack.nethermetals.ServerProxy")
	public static CommonProxy proxy;

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
					&& ((e.getState().getBlock() instanceof ExplosiveBlock
							&& ((ExplosiveBlock) e.getState().getBlock()).doesExplode())
							|| e.getState().getBlock() == Blocks.QUARTZ_ORE)) {
				int randomNum = new Random().nextInt((100 - 1) + 1) + 1;
				if (randomNum <= ConfigHandler.getExplosionChance() || ConfigHandler.getExplosionChance() > 100) {
					e.getWorld().createExplosion(e.getPlayer(), e.getPos().getX(), e.getPos().getY(), e.getPos().getZ(), 4.0F, true);
					if (ConfigHandler.isAngerPigmen())
						ModularityApi.angerPigmen(e.getPos(), e.getWorld(), e.getPlayer(), ConfigHandler.getAngerPigmenRange());
				}
			}
		}
	}
}
