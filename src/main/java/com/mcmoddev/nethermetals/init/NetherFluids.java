package com.mcmoddev.nethermetals.init;

import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.nethermetals.util.Config.Options;
import com.mcmoddev.lib.init.Fluids;

public class NetherFluids extends Fluids {
	private static boolean initDone = false;

	private NetherFluids() {
		throw new IllegalAccessError("Not a instantiable class");
	}

	/**
	 *
	 */
	public static void init() {
		if (initDone) {
			return;
		}
		
		Fluids.init();

  		if (Options.enableCoalNetherOre && Materials.getMaterialByName("coal").getFluid() == null) {
			addFluid(Materials.getMaterialByName("coal"), 2000, 10000, 769, 10);
			addFluidBlock(Materials.getMaterialByName("coal"));
		}
  		
		if (Options.enableDiamondNetherOre && Materials.getMaterialByName("diamond").getFluid() == null) {
			addFluid(Materials.getMaterialByName("diamond"), 2000, 10000, 769, 10);
			addFluidBlock(Materials.getMaterialByName("diamond"));
		}
		
		if (Options.enableEmeraldNetherOre && Materials.getMaterialByName("emerald").getFluid() == null) {
			addFluid(Materials.getMaterialByName("emerald"), 2000, 10000, 769, 10);
			addFluidBlock(Materials.getMaterialByName("emerald"));
		}

		if (Options.enableGoldNetherOre && Materials.getMaterialByName("gold").getFluid() == null) {
			addFluid(Materials.getMaterialByName("gold"), 2000, 10000, 769, 10);
			addFluidBlock(Materials.getMaterialByName("gold"));
		}

		if (Options.enableIronNetherOre && Materials.getMaterialByName("iron").getFluid() == null) {
			addFluid(Materials.getMaterialByName("iron"), 2000, 10000, 769, 10);
			addFluidBlock(Materials.getMaterialByName("iron"));
		}
		
		if (Options.enableRedstoneNetherOre && Materials.getMaterialByName("redstone").getFluid() == null) {
			addFluid(Materials.getMaterialByName("redstone"), 2000, 10000, 769, 10);
			addFluidBlock(Materials.getMaterialByName("redstone"));
		}
		
		initDone = true;
	}
}
