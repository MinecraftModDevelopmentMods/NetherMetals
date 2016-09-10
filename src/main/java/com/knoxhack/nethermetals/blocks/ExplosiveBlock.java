package com.knoxhack.nethermetals.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;

public class ExplosiveBlock extends BlockOre {

	private boolean explode;

	public ExplosiveBlock() {
		super();
	}

	public Block explode() {
		this.explode = true;
		return this;
	}

	public boolean doesExplode() {
		return explode;
	}
}
