package com.mcmoddev.nethermetals.init;

import com.mcmoddev.nethermetals.util.Config.Options;

import com.mcmoddev.lib.material.MetalMaterial;

/**
 * This class initializes all of the materials in Nether Metals.
 *
 * @author Jasmine Iwanek
 *
 */
public class MaterialsNetherOre extends com.mcmoddev.lib.init.Materials {

	/** Antimony */
	public static MetalMaterial antimony;
	public static MetalMaterial bismuth;
	public static MetalMaterial copper;
	public static MetalMaterial lead;
	public static MetalMaterial mercury;
	public static MetalMaterial nickel;
	public static MetalMaterial platinum;
	public static MetalMaterial silver;
	public static MetalMaterial tin;
	public static MetalMaterial zinc;



	private static boolean initDone = false;

	protected MaterialsNetherOre() {
		throw new IllegalAccessError("Not a instantiable class");
	}

	/**
	 *
	 */
	public static void init() {
		if (initDone) {
			return;
		}


		if (Options.enableAntimonyNetherOre) {
			antimony = createSpecialMaterial("antimony", 1, 1, 1, 0xFFD8E3DE);
			antimony.materialType = MetalMaterial.MaterialType.METAL;
		}
		if (Options.enableBismuthNetherOre) {
			bismuth = createSpecialMaterial("bismuth", 1, 1, 1, 0xFFDDD7CB);
			bismuth.materialType = MetalMaterial.MaterialType.METAL;
		}
		if (Options.enableCopperNetherOre) {
			copper = createSpecialMaterial("copper", 4, 4, 5, 0xFFFF9F78);
			copper.materialType = MetalMaterial.MaterialType.METAL;
		}
		if (Options.enableLeadNetherOre) {
			lead = createSpecialMaterial("lead", 1, 1, 1, 0xFF7B7B7B);
			lead.materialType = MetalMaterial.MaterialType.METAL;
		}
		if (Options.enableMercuryNetherOre) {
			mercury = createSpecialMaterial("mercury", 1, 1, 1, 0);
			mercury.materialType = MetalMaterial.MaterialType.METAL;
		}
		if (Options.enableNickelNetherOre) {
			nickel = createSpecialMaterial("nickel", 4, 4, 7, 0xFFEEFFEB);
			nickel.materialType = MetalMaterial.MaterialType.METAL;
		}
		if (Options.enablePlatinumNetherOre) {
			platinum = createSpecialMaterial("platinum", 3, 5, 15, 0xFFF2FFFF);
			platinum.materialType = MetalMaterial.MaterialType.METAL;
		}
		if (Options.enableSilverNetherOre) {
			silver = createSpecialMaterial("silver", 5, 4, 6, 0xFFFFFFFF);
			silver.materialType = MetalMaterial.MaterialType.METAL;
		}
		if (Options.enableTinNetherOre) {
			tin = createSpecialMaterial("tin", 3, 1, 2, 0xFFFFF7EE);
			tin.materialType = MetalMaterial.MaterialType.METAL;
		}
		if (Options.enableZincNetherOre) {
			zinc = createSpecialMaterial("zinc", 1, 1, 1, 0xFFBCBCBC);
			zinc.materialType = MetalMaterial.MaterialType.METAL;
			
		}



		initDone = true;
	}

	
}
