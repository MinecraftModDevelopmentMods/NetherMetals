package com.knoxhack.nethermetals.world;

import java.util.Random;

import com.google.common.base.Predicate;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSingleMinable extends WorldGenerator {

	private IBlockState block;
	private Predicate<IBlockState> target;

	public WorldGenSingleMinable(IBlockState block, Predicate<IBlockState> target) {
		this.block = block;
		this.target = target;
	}

	public WorldGenSingleMinable(IBlockState block) {
		this(block, (Predicate<IBlockState>) BlockHelper.forBlock(Blocks.netherrack));
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		if (world.getBlockState(pos).getBlock().isReplaceableOreGen(world, pos, (com.google.common.base.Predicate<IBlockState>) this.target))
			world.setBlockState(pos, this.block);
		return true;
	}
}
