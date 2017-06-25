package com.mcmoddev.nethermetals.init;

import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.material.MMDMaterial.MaterialType;
import com.mcmoddev.nethermetals.util.Config.Options;

public class NetherMaterials extends Materials {
	private static boolean initDone = false;

	protected NetherMaterials() {
		throw new IllegalAccessError("Not a instantiable class");
	}

	public static void init() {
		if (initDone) {
			return;
		}

		if( Options.enableCoalNetherOre && Materials.getMaterialByName("coal") == null ) {
			createMaterial("coal", MaterialType.MINERAL, 4, 4, 2, 0xFF151515);
		}
		
		if(Options.enableDiamondNetherOre && Materials.getMaterialByName("diamond") == null ) {
			createMaterial("diamond", MaterialType.GEM, 10, 15, 4, 0xFF8CF4E1);			
		}

		if(Options.enableEmeraldNetherOre && Materials.getMaterialByName("emerald") == null ) {
			createMaterial("emerald", MaterialType.GEM, 10, 15, 4, 0xFF82F6AC);
		}

		if(Options.enableGoldNetherOre && Materials.getMaterialByName("gold") == null ) {
			createMaterial("gold", MaterialType.METAL, 1, 1, 10, 0xFFFFFF8B);
		}

		if(Options.enableIronNetherOre && Materials.getMaterialByName("iron") == null ) {
			createMaterial("iron", MaterialType.METAL, 8, 8, 4.5, 0xFFD8D8D8);			
		}

		if(Options.enableLapisNetherOre && Materials.getMaterialByName("lapis") == null ) {
			createMaterial("lapis", MaterialType.MINERAL, 1, 1, 1, 0xFF7B7B7B);
		}

		if(Options.enableRedstoneNetherOre && Materials.getMaterialByName("redstone") == null ) {
			createMaterial("redstone", MaterialType.MINERAL, 1, 1, 1, 0xFF7B7B7B);
		}
	}
}
