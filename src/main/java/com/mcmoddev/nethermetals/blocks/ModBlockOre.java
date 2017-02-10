package com.mcmoddev.nethermetals.blocks;

import net.minecraft.creativetab.CreativeTabs;

public class ModBlockOre extends ExplosiveBlock {

	protected ModBlockOre(float hardness, float resistance) {
		super();

		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
}
