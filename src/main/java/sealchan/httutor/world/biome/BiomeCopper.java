package sealchan.httutor.world.biome;

import java.util.Random;

import net.minecraft.block.BlockDirt;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMinable;
import sealchan.httutor.init.BlockInit;
import sealchan.httutor.world.gen.ModWGCopperTree;

public class BiomeCopper extends Biome 
{
	//protected static final WorldGenAbstractTree TREE = new ModWGCopperTree();
	
	public BiomeCopper()
	{
		super(new BiomeProperties("Copper").setBaseHeight(1.5F).setHeightVariation(1.2F).setTemperature(0.6F).setRainDisabled().setWaterColor(16711680));
		
		topBlock = Blocks.DIRT.getDefaultState();
		fillerBlock = BlockInit.ORE_COPPER_STONE.getDefaultState();
		
		this.decorator.coalGen = new WorldGenMinable(BlockInit.PLANK_COPPER.getDefaultState(), 10);
		this.decorator.treesPerChunk = 2;
		
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		
		this.spawnableCreatureList.add(new SpawnListEntry(EntityWither.class, 10, 1, 5));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityDragon.class, 5, 1, 2));
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand)
	{
		return new ModWGCopperTree();
	}
}
