package sealchan.httutor.world.gen;

import java.util.Random;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import sealchan.httutor.init.BlockInit;
import sealchan.httutor.objects.blocks.BlockOres;
import sealchan.httutor.util.handlers.EnumHandler;

public class WorldGenCustomOres implements IWorldGenerator
{
	private WorldGenerator ore_nether_copper, ore_overworld_copper, ore_end_copper;
	private WorldGenerator ore_nether_aluminum, ore_overworld_aluminum, ore_end_aluminum;
	
	public WorldGenCustomOres() 
	{
		/*
		ore_nether_copper = 
				new WorldGenMinable(BlockInit.ORE_NETHER.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.COPPER), 
						9,
						BlockMatcher.forBlock(Blocks.NETHERRACK));
		ore_overworld_copper = 
				new WorldGenMinable(BlockInit.ORE_OVERWORLD.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.COPPER), 
						9,
						BlockMatcher.forBlock(Blocks.STONE));
		ore_end_copper = 
				new WorldGenMinable(BlockInit.ORE_END.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.COPPER), 
						9,
						BlockMatcher.forBlock(Blocks.END_STONE));
		
		ore_nether_aluminum = 
				new WorldGenMinable(BlockInit.ORE_NETHER.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.ALUMINUM), 
						9,
						BlockMatcher.forBlock(Blocks.NETHERRACK));
		ore_overworld_aluminum = 
				new WorldGenMinable(BlockInit.ORE_OVERWORLD.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.ALUMINUM), 
						9,
						BlockMatcher.forBlock(Blocks.STONE));
		ore_end_aluminum = 
				new WorldGenMinable(BlockInit.ORE_END.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.ALUMINUM), 
						9,
						BlockMatcher.forBlock(Blocks.END_STONE));
		//*/
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.getDimension())
		{
		case -1:
			runGenerator(ore_nether_copper, world, random, chunkX, chunkZ, 50, 0, 100);
			runGenerator(ore_nether_aluminum, world, random, chunkX, chunkZ, 50, 0, 100);
			break;
		case 0:
			runGenerator(ore_overworld_copper, world, random, chunkZ, chunkZ, 50, 40, 80);
			runGenerator(ore_overworld_aluminum, world, random, chunkZ, chunkZ, 50, 40, 80);
			break;
		case 1:
			runGenerator(ore_end_copper, world, random, chunkZ, chunkZ, 50, 0, 256);
			runGenerator(ore_end_aluminum, world, random, chunkZ, chunkZ, 50, 0, 256);
			break;
		}
		
	}
	
	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight)
	{
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256)  throw new IllegalArgumentException("Ore configured to generate out of bounds");
		
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chance; i++)
		{
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.generate(world, rand, new BlockPos(x, y, z));
		}
	}
	
}
