package com.mcmoddev.nethermetals.init;

import com.mcmoddev.nethermetals.util.Config.Options;
import com.mcmoddev.lib.material.MetalMaterial;

/**
 * This class initializes all of the materials in Nether Metals. It also
 * contains utility methods for looking up materials by name and finding the
 * tool and armor material equivalents for a given material.
 *
 * @author DrCyano
 *
 */
public abstract class Materials extends com.mcmoddev.lib.init.Materials {

	/** Adamantine */
	public static MetalMaterial adamantine;
	/** Antimony */
	public static MetalMaterial antimony;
	/** Aquarium */
	public static MetalMaterial aquarium;
	/** Bismuth */
	public static MetalMaterial bismuth;
	/** Brass */
	public static MetalMaterial brass;
	/** Bronze */
	public static MetalMaterial bronze;
	/** Cold-Iron */
	public static MetalMaterial coldiron;
	/** Copper */
	public static MetalMaterial copper;
	/** Cupronickel */
	public static MetalMaterial cupronickel;
	/** Electrum */
	public static MetalMaterial electrum;
	/** Invar */
	public static MetalMaterial invar;
	/** Lead */
	public static MetalMaterial lead;
	/** Mercury */
	public static MetalMaterial mercury;
	/** Mithril */
	public static MetalMaterial mithril;
	/** Nickel */
	public static MetalMaterial nickel;
	/** Pewter */
	public static MetalMaterial pewter;
	/** Platinum */
	public static MetalMaterial platinum;
	/** Silver */
	public static MetalMaterial silver;
	/** Star-Steel */
	public static MetalMaterial starsteel;
	/** Steel */
	public static MetalMaterial steel;
	/** Tin */
	public static MetalMaterial tin;
	/** Zinc */
	public static MetalMaterial zinc;
	
	
	/** Aluminum */
	public static MetalMaterial aluminum;
	/** Aluminum-Brass*/
	public static MetalMaterial aluminumBrass;
	/** Cadmium */
	public static MetalMaterial cadmium;
	/** Chromium */
	public static MetalMaterial chromium;
	/** Galvanized Steel */
	public static MetalMaterial galvanizedSteel;
	/** Iridium */
	public static MetalMaterial iridium;
	/** Magnesium */
	public static MetalMaterial magnesium;
	/** Manganese */
	public static MetalMaterial manganese;
	/** Nichrome */
	public static MetalMaterial nichrome;
	/** Osmium */
	public static MetalMaterial osmium;
	/** Plutonium */
	public static MetalMaterial plutonium;
	/** Rutile */
	public static MetalMaterial rutile;
	/** Stainless Steel */
	public static MetalMaterial stainlessSteel;
	/** Tantalum */
	public static MetalMaterial tantalum;
	/** Titanium */
	public static MetalMaterial titanium;
	/** Tungsten */
	public static MetalMaterial tungsten;
	/** Uranium */
	public static MetalMaterial uranium;
	/** Zirconium */
	public static MetalMaterial zirconium;

	
	private static boolean initDone = false;

	protected Materials() {
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
			antimony = createMaterial("antimony", 1, 1, 1, 0xFFD8E3DE);
			antimony.materialType = MetalMaterial.MaterialType.METAL;
		}

		if (Options.enableBismuthNetherOre) {
			bismuth = createMaterial("bismuth", 1, 1, 1, 0xFFDDD7CB);
			bismuth.materialType = MetalMaterial.MaterialType.METAL;
		}

		if (Options.enableCopperNetherOre) {
			copper = createMaterial("copper", 4, 4, 5, 0xFFFF9F78);
			copper.materialType = MetalMaterial.MaterialType.METAL;
		}

		if (Options.enableLeadNetherOre) {
			lead = createMaterial("lead", 1, 1, 1, 0xFF7B7B7B).setBaseDamage(4f);
			lead.materialType = MetalMaterial.MaterialType.METAL;
		}

		if (Options.enableMercuryNetherOre) {
			mercury = createMaterial("mercury", 1, 1, 1, 0);
			mercury.materialType = MetalMaterial.MaterialType.METAL;
		}


		if (Options.enableNickelNetherOre) {
			nickel = createMaterial("nickel", 4, 4, 7, 0xFFEEFFEB);
			nickel.materialType = MetalMaterial.MaterialType.METAL;
		}

		if (Options.enablePlatinumNetherOre) {
			platinum = createRareMaterial("platinum", 3, 5, 15, 0xFFF2FFFF);
			platinum.materialType = MetalMaterial.MaterialType.METAL;
		}
		if (Options.enableSilverNetherOre) {
			silver = createMaterial("silver", 5, 4, 6, 0xFFFFFFFF);
			silver.materialType = MetalMaterial.MaterialType.METAL;
		}

		if (Options.enableTinNetherOre) {
			tin = createMaterial("tin", 3, 1, 2, 0xFFFFF7EE);
			tin.materialType = MetalMaterial.MaterialType.METAL;
		}
		if (Options.enableZincNetherOre) {
			zinc = createMaterial("zinc", 1, 1, 1, 0xFFBCBCBC);
			zinc.materialType = MetalMaterial.MaterialType.METAL;
		}
		
		
		
		
		if (Options.enableAluminumNetherOre) {
			aluminum = createMaterial("aluminum", 2.5, 3.75, 4.5, 0xFFC5C8C1);
			aluminum.materialType = MetalMaterial.MaterialType.METAL;
		}

		if (Options.enableAluminumNetherOre) {
			aluminumBrass = createAlloyMaterial("aluminumbrass", 1, 7.5, 4.5, 0xFFEBAA56);
			aluminumBrass.materialType = MetalMaterial.MaterialType.METAL;
		}

		if (Options.enableCadmiumNetherOre) {
			cadmium = createRareMaterial("cadmium", 2, 1, 4.5, 0xFFC9D4DA);
			cadmium.materialType = MetalMaterial.MaterialType.METAL;
		}

		if (Options.enableChromiumNetherOre) {
			chromium = createMaterial("chromium", 9, 3, 4.5, 0xFFCDCDCF);
			chromium.materialType = MetalMaterial.MaterialType.METAL;
		}


		if (Options.enableIridiumNetherOre) {
			iridium = createRareMaterial("iridium", 6.5, 3, 4.5, 0xFFF8EDCC);
			iridium.materialType = MetalMaterial.MaterialType.METAL;
		}

		if (Options.enableMagnesiumNetherOre) {
			magnesium = createMaterial("magnesium", 2.5, 3.5, 4.5, 0xFF7F7F77);
			magnesium.materialType = MetalMaterial.MaterialType.METAL;
		}

		if (Options.enableManganeseNetherOre) {
			manganese = createMaterial("manganese", 5, 2.75, 4.5, 0xFFF5CFDA);
			manganese.materialType = MetalMaterial.MaterialType.METAL;
		}

		if (Options.enableOsmiumNetherOre) {
			osmium = createMaterial("osmium", 7, 2.75, 4.5, 0xFF7C8E99);
			osmium.materialType = MetalMaterial.MaterialType.METAL;
		}

		if (Options.enablePlutoniumNetherOre) {
			plutonium = createRareMaterial("plutonium", 4, 7.5, 4.5, 0xFFB333EA);
			plutonium.materialType = MetalMaterial.MaterialType.METAL;
		}

		if (Options.enableRutileNetherOre) {
			rutile = createMaterial("rutile", 6, 0.25, 4.5, 0xFFBF928B);
			rutile.materialType = MetalMaterial.MaterialType.METAL;
		}


		if (Options.enableTantalumNetherOre) {
			tantalum = createMaterial("tantalum", 6.5, 17.5, 4.5, 0xFFC4BEC2);
			tantalum.materialType = MetalMaterial.MaterialType.METAL;
		}

		if (Options.enableTitaniumNetherOre) {
			titanium = createSpecialMaterial("titanium", 6.5, 16.25, 4.5, 0xFF73787E);
			titanium.materialType = MetalMaterial.MaterialType.METAL;
		}

		if (Options.enableTungstenNetherOre) {
			tungsten = createMaterial("tungsten", 7.5, 12.5, 4.5, 0xFF969696);
			tungsten.materialType = MetalMaterial.MaterialType.METAL;
		}

		if (Options.enableUraniumNetherOre) {
			uranium = createRareMaterial("uranium", 6, 16.25, 4.5, 0xFFA7B345);
			uranium.materialType = MetalMaterial.MaterialType.METAL;
		}

		if (Options.enableZirconiumNetherOre) {
			zirconium = createMaterial("zirconium", 5, 3.5, 4.5, 0xFF929793);
			zirconium.materialType = MetalMaterial.MaterialType.METAL;
		}

		initDone = true;
	}
}
