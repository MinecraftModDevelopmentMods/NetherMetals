package com.mcmoddev.nethermetals.util;

import java.util.Random;

import com.mcmoddev.lib.block.BlockMMDNetherOre;
import com.mcmoddev.lib.events.MMDLibRegisterBlocks;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.util.Oredicts;
import com.mcmoddev.lib.util.ConfigBase.Options;
import com.mcmoddev.nethermetals.NetherMetals;
import com.mcmoddev.nethermetals.init.NetherBlocks;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class EventHandler {
	@SubscribeEvent
	public static void mmdlibRegisterBlocks(final MMDLibRegisterBlocks ev) {
		ev.setActive(NetherMetals.MODID);
		NetherBlocks.init();
	}

	@SubscribeEvent
	public static void onRemapBlock(final RegistryEvent.MissingMappings<Block> event) {
		for (final RegistryEvent.MissingMappings.Mapping<Block> mapping : event.getAllMappings()) {
			if (mapping.key.getNamespace().equals(NetherMetals.MODID)) {
				// dummy
			}
		}
	}

	@SubscribeEvent
	public static void onRemapItem(final RegistryEvent.MissingMappings<Item> event) {
		for (final RegistryEvent.MissingMappings.Mapping<Item> mapping : event.getAllMappings()) {
			if (mapping.key.getNamespace().equals(NetherMetals.MODID)) {
				// dummy
			}
		}
	}

	// even though no items are directly created there are ItemBlock instances that need registered as well
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		// NetherMetals doesn't do any of its own materials, just its own blocks
		// so it actually needs this helper :)
		Materials.getAllMaterials().stream()
		.forEach( mat ->
			mat.getItems().stream()
			.map(itemStack -> itemStack.getItem())
			.filter(EventHandler::itemFilterFunc)
			.forEach(event.getRegistry()::register)
		);

		Oredicts.registerItemOreDictionaryEntries();
		Oredicts.registerBlockOreDictionaryEntries();
	}
	
	private static boolean itemFilterFunc(Item item) {
		return matchModId(item.getRegistryName());
	}
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		// NetherMetals doesn't do any of its own materials, just its own blocks
		// so it actually needs this helper :)
		Materials.getAllMaterials().stream()
		.forEach( mat ->
			mat.getBlocks().stream()
			.filter(EventHandler::blockFilterFunc)
			.forEach(event.getRegistry()::register)
		);
	}

	private static boolean blockFilterFunc(final Block block) {
		return matchModId(block.getRegistryName());
	}
	
	private static boolean matchModId(final ResourceLocation rl) {
		return rl.getNamespace().equals(NetherMetals.MODID);
	}
	
	public static void angerPigmen(final BlockPos pos, final World world, final EntityPlayer player, final int range) {
		final int rr = range / 2;
		final BlockPos work1 = new BlockPos(pos).add(-rr,-rr,-rr);
		final BlockPos work2 = new BlockPos(pos).add(+rr,+rr,+rr);
		final AxisAlignedBB bb = new AxisAlignedBB(work1, work2);
		for (final EntityLivingBase entity : world.getEntitiesWithinAABB(EntityPigZombie.class, bb)) {
			entity.setRevengeTarget(player);
		}
	}
	
	@SubscribeEvent
	public static void onBlockBreak(final BlockEvent.BreakEvent event) {
		final boolean silk = hasSilkTouch(event.getPlayer());
		final int currentDimension = event.getWorld().provider.getDimension();
		final Block targetBlock = event.getState().getBlock();
		final World w = event.getWorld();
		if ((event.getPlayer() != null) && (!event.getPlayer().getHeldItemMainhand().isEmpty())) {
			if (((!silk) && (currentDimension == -1)) && (isExplodingBlock(targetBlock))) {
				doExplode(event.getPos(), event.getPlayer(), w);
			}
		}
	}

	private static void doExplode(final BlockPos pos, final EntityPlayer player, final World w) {
		final int randomNum = new Random().nextInt((100 - 1) + 1) + 1;
		if (randomNum <= Options.explosionChance() || Options.explosionChance() > 100) {
			w.createExplosion(player, pos.getX(), pos.getY(), pos.getZ(), 4.0F, true);
			if (Options.angerPigmenRange() > 0 )
				angerPigmen(pos, w, player, Options.angerPigmenRange());
		}
	}

	private static boolean isExplodingBlock(final Block targetBlock) {
		if (((targetBlock instanceof BlockMMDNetherOre) && 
				(((BlockMMDNetherOre)targetBlock).doesExplode())) ||
				(targetBlock.equals(Blocks.QUARTZ_ORE))) {
			return true;
		}
		return false;
	}

	private static boolean hasSilkTouch(final EntityPlayer player) {
		if( (player == null) || (player.getHeldItemMainhand().isEmpty())) return false;
		final NBTTagList enchants = player.getHeldItemMainhand().getEnchantmentTagList();
		if (enchants != null) {
			for (int index = 0; index < enchants.tagCount(); index++) {
				short enchantId = enchants.getCompoundTagAt(index).getShort("id");
				if (Enchantment.getEnchantmentByID(enchantId) != null && 
						Enchantment.getEnchantmentByID(enchantId) == Enchantments.SILK_TOUCH)
					return true;
			}
		}
		return false;
	}
}