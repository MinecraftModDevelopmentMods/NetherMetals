package com.knoxhack.nethermetals.world;

import java.util.Random;

import com.knoxhack.nethermetals.ConfigHandler;
import com.knoxhack.nethermetals.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGen implements IWorldGenerator {

	private WorldGenerator gen_coal_ore;		// Generates Coal Ore
	private WorldGenerator gen_diamond_ore;		// Generates Diamond Ore
	private WorldGenerator gen_emerald_ore;		// Generates Emerald Ore
	private WorldGenerator gen_gold_ore;		// Generates Gold Ore
	private WorldGenerator gen_iron_ore;		// Generates Iron Ore
	private WorldGenerator gen_lapis_ore;		// Generates Lapis Ore
	private WorldGenerator gen_redstone_ore;	// Generates Redstone Ore

	public WorldGen() {

		final Block matchBlock = Blocks.NETHERRACK;
		// Vanilla
		this.gen_coal_ore = new WorldGenMinable(ModBlocks.coal_ore.getDefaultState(), ConfigHandler.getCoalOreSpawnProb(), BlockMatcher.forBlock(matchBlock));
		this.gen_diamond_ore = new WorldGenMinable(ModBlocks.diamond_ore.getDefaultState(), ConfigHandler.getDiamondOreSpawnProb(), BlockMatcher.forBlock(matchBlock));
		this.gen_emerald_ore = new WorldGenMinable(ModBlocks.emerald_ore.getDefaultState(), ConfigHandler.getEmeraldOreSpawnProb(), BlockMatcher.forBlock(matchBlock));
		this.gen_gold_ore = new WorldGenMinable(ModBlocks.gold_ore.getDefaultState(), ConfigHandler.getGoldOreSpawnProb(), BlockMatcher.forBlock(matchBlock));
		this.gen_iron_ore = new WorldGenMinable(ModBlocks.iron_ore.getDefaultState(), ConfigHandler.getIronOreSpawnProb(), BlockMatcher.forBlock(matchBlock));
		this.gen_lapis_ore = new WorldGenMinable(ModBlocks.lapis_ore.getDefaultState(), ConfigHandler.getLapisOreSpawnProb(), BlockMatcher.forBlock(matchBlock));
		this.gen_redstone_ore = new WorldGenMinable(ModBlocks.redstone_ore.getDefaultState(), ConfigHandler.getRedstoneOreSpawnProb(), BlockMatcher.forBlock(matchBlock));
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		switch (world.provider.getDimension()) {
		case 0: // Overworld
			break;
		case -1: // Nether
			// Vanilla
			this.runGenerator(this.gen_coal_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_diamond_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_emerald_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_gold_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_iron_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_lapis_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_redstone_ore, world, random, chunkX, chunkZ, 5, 0, 200);
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
