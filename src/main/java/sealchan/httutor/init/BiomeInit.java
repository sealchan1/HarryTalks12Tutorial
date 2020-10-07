package sealchan.httutor.init;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import sealchan.httutor.world.biome.BiomeCopper;

public class BiomeInit 
{
	public static final Biome COPPER = new BiomeCopper();
	
	public static void registerBiomes()
	{
		InitBiome(COPPER, "Copper", BiomeType.WARM, Type.HILLS, Type.MOUNTAIN, Type.DRY);
	}
	
	private static Biome InitBiome(Biome biome, String name, BiomeType biomeType, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		System.out.println("HTTutor Biome registered");
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));
		BiomeManager.addSpawnBiome(biome);
		System.out.println("HTTutor Biome added");
		return biome;
	}
}
