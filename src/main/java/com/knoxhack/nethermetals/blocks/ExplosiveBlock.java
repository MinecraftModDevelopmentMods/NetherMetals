package com.knoxhack.nethermetals.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ExplosiveBlock extends Block {

	private boolean explode;

	public ExplosiveBlock(Material p_i46399_1_, MapColor p_i46399_2_) {
		super(p_i46399_1_, p_i46399_2_);
	}

	public Block explode() {
		this.explode=true;
		return this;
	}

	public boolean doesExplode() {
		return explode;
	}

	public ExplosiveBlock(Material p_i45394_1_) {
		super(p_i45394_1_);
	}
}
