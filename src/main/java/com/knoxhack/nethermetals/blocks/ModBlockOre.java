package com.knoxhack.nethermetals.blocks;

import net.minecraft.block.BlockOre;
import net.minecraft.creativetab.CreativeTabs;

public class ModBlockOre extends BlockOre {

	protected ModBlockOre(float Hardness, float Resistance) {
		super();

		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(Hardness);
		this.setResistance(Resistance);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
}
