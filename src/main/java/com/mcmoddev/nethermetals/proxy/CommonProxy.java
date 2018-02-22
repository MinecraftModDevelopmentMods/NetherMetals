package com.mcmoddev.nethermetals.proxy;

import com.mcmoddev.nethermetals.util.Config;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.integration.IntegrationManager;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.oregen.FallbackGenerator;
import com.mcmoddev.lib.util.ConfigBase.Options;
import com.mcmoddev.lib.util.Oredicts;
import com.mcmoddev.nethermetals.NetherMetals;
import com.mcmoddev.nethermetals.init.*;

import java.util.HashSet;
import java.util.Random;

import com.mcmoddev.lib.block.BlockMMDNetherOre;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.MissingModsException;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.versioning.ArtifactVersion;
import net.minecraftforge.fml.common.versioning.DefaultArtifactVersion;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		Config.init();

		if ((Options.requireMMDOreSpawn()) && (!Loader.isModLoaded("orespawn"))) {
			if(Options.fallbackOrespawn()) {
				GameRegistry.registerWorldGenerator(new FallbackGenerator(), 0);
			} else {
				final HashSet<ArtifactVersion> orespawnMod = new HashSet<>();
				orespawnMod.add(new DefaultArtifactVersion("3.1.0"));
				throw new MissingModsException(orespawnMod, "orespawn", "MMD Ore Spawn Mod (fallback generator disabled, MMD OreSpawn enabled)");
			}
		}
		
		ItemGroups.init();
		NetherBlocks.init();
		ItemGroups.setupIcons("lapis");

		MinecraftForge.EVENT_BUS.register(this);
		IntegrationManager.INSTANCE.preInit(event);
		IntegrationManager.INSTANCE.runCallbacks("preInit");
	}

	public void init(FMLInitializationEvent event) {
		Recipes.init();
	}

	public void postInit(FMLPostInitializationEvent event) {
		Config.postInit();
	}
	
	// even though no items are directly created there are ItemBlock instances that need registered as well
	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event) {
		// NetherMetals doesn't do any of its own materials, just its own blocks
		// so it actually needs this helper :)
		for( MMDMaterial mat : Materials.getAllMaterials()) {
			for( Item item : mat.getItems() ) {
				if( item.getRegistryName().getResourceDomain().equals(NetherMetals.MODID) ) {
					event.getRegistry().register(item);
				}
			}
		}
		Oredicts.registerItemOreDictionaryEntries();
		Oredicts.registerBlockOreDictionaryEntries();
	}
	
	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event) {
		// NetherMetals doesn't do any of its own materials, just its own blocks
		// so it actually needs this helper :)
		for( MMDMaterial mat : Materials.getAllMaterials()) {
			for( Block block : mat.getBlocks() ) {
				if( block.getRegistryName().getResourceDomain().equals(NetherMetals.MODID) ) {
					((BlockMMDNetherOre)block).explode();
					event.getRegistry().register(block);
					NetherMetals.logger.fatal("registered block %s", block.getRegistryName());
				}
			}
		}
	}
	
	public void angerPigmen(BlockPos pos, World world, EntityPlayer player, int range) {
		int rr = range / 2;
		BlockPos work1 = new BlockPos(pos).add(-rr,-rr,-rr);
		BlockPos work2 = new BlockPos(pos).add(+rr,+rr,+rr);
		AxisAlignedBB bb = new AxisAlignedBB(work1, work2);
		for( final EntityLivingBase entity : world.getEntitiesWithinAABB(EntityPigZombie.class, bb) ) {
			entity.setRevengeTarget(player);
		}
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
			
			if ( (!silk && event.getWorld().provider.getDimension() == -1) &&
				 ( ( event.getState().getBlock() instanceof BlockMMDNetherOre && 
				   ((BlockMMDNetherOre) event.getState().getBlock()).doesExplode() ) ||
				   ( event.getState().getBlock() == Blocks.QUARTZ_ORE) ) ) {
				int randomNum = new Random().nextInt((100 - 1) + 1) + 1;
				if (randomNum <= Options.explosionChance() || Options.explosionChance() > 100) {
					event.getWorld().createExplosion(event.getPlayer(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), 4.0F, true);
					if (Options.angerPigmenRange() > 0 )
 						this.angerPigmen(event.getPos(), event.getWorld(), event.getPlayer(), Options.angerPigmenRange());
				}
			}
		}
	}
}
