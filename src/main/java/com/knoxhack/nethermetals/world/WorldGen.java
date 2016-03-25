package com.knoxhack.nethermetals.world;

import java.util.Random;

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
	//@formatter:off

	private WorldGenerator gen_nether_copper_ore; 	// Generates Tutorial Ore (used in Overworld)
	private WorldGenerator gen_nether_tin_ore;		// Generates Cobblestone (used in End)
	private WorldGenerator gen_nether_lead_ore;		// Generates Cobblestone (used in End)
	private WorldGenerator gen_nether_silver_ore;		// Generates Cobblestone (used in End)
	private WorldGenerator gen_nether_zinc_ore;		// Generates Cobblestone (used in End)
	private WorldGenerator gen_nether_nickel_ore;		// Generates Cobblestone (used in End)

	//@formatter:on

	public WorldGen() {

	    this.gen_nether_copper_ore = new WorldGenMinable(ModBlocks.nethercopperOre.getDefaultState(), 16, BlockHelper.forBlock(Blocks.netherrack));
	    this.gen_nether_tin_ore = new WorldGenMinable(ModBlocks.nethertinOre.getDefaultState(), 16, BlockHelper.forBlock(Blocks.netherrack));
	    this.gen_nether_lead_ore = new WorldGenMinable(ModBlocks.netherleadOre.getDefaultState(), 16, BlockHelper.forBlock(Blocks.netherrack));
	    this.gen_nether_silver_ore = new WorldGenMinable(ModBlocks.nethersilverOre.getDefaultState(), 16, BlockHelper.forBlock(Blocks.netherrack));
	    this.gen_nether_zinc_ore = new WorldGenMinable(ModBlocks.netherzincOre.getDefaultState(), 16, BlockHelper.forBlock(Blocks.netherrack));
	    this.gen_nether_nickel_ore = new WorldGenMinable(ModBlocks.nethernickelOre.getDefaultState(), 16, BlockHelper.forBlock(Blocks.netherrack));
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.getDimensionId()) {
		case 0: // Overworld
			break;
		case -1: // Nether
			this.runGenerator(this.gen_nether_copper_ore, world, random, chunkX, chunkZ, 20, 0, 200);
			this.runGenerator(this.gen_nether_lead_ore, world, random, chunkX, chunkZ, 20, 0, 200);
			this.runGenerator(this.gen_nether_tin_ore, world, random, chunkX, chunkZ, 20, 0, 200);
			this.runGenerator(this.gen_nether_silver_ore, world, random, chunkX, chunkZ, 20, 0, 200);
			this.runGenerator(this.gen_nether_zinc_ore, world, random, chunkX, chunkZ, 20, 0, 200);
			this.runGenerator(this.gen_nether_nickel_ore, world, random, chunkX, chunkZ, 20, 0, 200);

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