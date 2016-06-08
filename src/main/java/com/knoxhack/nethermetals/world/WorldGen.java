package com.knoxhack.nethermetals.world;

import java.util.Random;

import com.knoxhack.nethermetals.ConfigHandler;
import com.knoxhack.nethermetals.blocks.ModBlocks;


import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGen implements IWorldGenerator {

	private WorldGenerator gen_nether_coal_ore;			// Generates Coal Ore (used in Nether)
	private WorldGenerator gen_nether_diamond_ore;		// Generates Diamond Ore (used in Nether)
	private WorldGenerator gen_nether_emerald_ore;		// Generates Emerald Ore (used in Nether)
	private WorldGenerator gen_nether_gold_ore;			// Generates Gold Ore (used in Nether)
	private WorldGenerator gen_nether_iron_ore;			// Generates Iron Ore (used in Nether)
	private WorldGenerator gen_nether_lapis_ore;		// Generates Lapis Ore (used in Nether)
	private WorldGenerator gen_nether_redstone_ore;		// Generates Redstone Ore (used in Nether)



	public WorldGen() {

		//@Vanilla Ores
		this.gen_nether_coal_ore = new WorldGenMinable(ModBlocks.nethercoalOre.getDefaultState(), ConfigHandler.getNetherCoalOreSpawnProb(), BlockHelper.forBlock(Blocks.netherrack));
		this.gen_nether_diamond_ore = new WorldGenMinable(ModBlocks.netherdiamondOre.getDefaultState(), ConfigHandler.getNetherDiamondOreSpawnProb(), BlockHelper.forBlock(Blocks.netherrack));
		this.gen_nether_emerald_ore = new WorldGenMinable(ModBlocks.netheremeraldOre.getDefaultState(), ConfigHandler.getNetherEmeraldOreSpawnProb(), BlockHelper.forBlock(Blocks.netherrack));
		this.gen_nether_gold_ore = new WorldGenMinable(ModBlocks.nethergoldOre.getDefaultState(), ConfigHandler.getNetherGoldOreSpawnProb(), BlockHelper.forBlock(Blocks.netherrack));
		this.gen_nether_iron_ore = new WorldGenMinable(ModBlocks.netherironOre.getDefaultState(), ConfigHandler.getNetherIronOreSpawnProb(), BlockHelper.forBlock(Blocks.netherrack));
		this.gen_nether_lapis_ore = new WorldGenMinable(ModBlocks.netherlapisOre.getDefaultState(), ConfigHandler.getNetherLapisOreSpawnProb(), BlockHelper.forBlock(Blocks.netherrack));
		this.gen_nether_redstone_ore = new WorldGenMinable(ModBlocks.netherredstoneOre.getDefaultState(), ConfigHandler.getNetherRedstoneOreSpawnProb(), BlockHelper.forBlock(Blocks.netherrack));
	    

	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		switch (world.provider.getDimensionId()) {
		case 0: // Overworld
			break;
		case -1: // Nether
			// Vanilla
			this.runGenerator(this.gen_nether_coal_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_nether_diamond_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_nether_emerald_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_nether_gold_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_nether_iron_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_nether_lapis_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_nether_redstone_ore, world, random, chunkX, chunkZ, 5, 0, 200);



			break;
		case 1: // End
			break;
		}
	}

	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i++) {
			int x = chunk_X * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunk_Z * 16 + rand.nextInt(16);
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
}
