package com.mcmoddev.nethermetals.blocks;

import net.minecraft.creativetab.CreativeTabs;

public class ModBlockOre extends ExplosiveBlock {

	protected ModBlockOre(float Hardness, float Resistance) {
		super();

		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(Hardness);
		this.setResistance(Resistance);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
}
