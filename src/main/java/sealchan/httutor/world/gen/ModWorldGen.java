package sealchan.httutor.world.gen;

import java.util.Random;
import java.util.function.Predicate;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import sealchan.httutor.init.BlockInit;

public class ModWorldGen implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) 
	{
		if(world.provider.getDimension() == -1)
		{
			generateNether(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}
		if (world.provider.getDimension() == 0)
		{
			generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}
		
	}

	private void generateNether(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider)
	{
		generateOre(BlockInit.ORE_ALUMINUM_NETHERRACK.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 100, random.nextInt(7) + 4, 18, 
				BlockMatcher.forBlock(Blocks.NETHERRACK));
		generateOre(BlockInit.ORE_COPPER_NETHERRACK.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 100, random.nextInt(7) + 4, 18, 
				BlockMatcher.forBlock(Blocks.NETHERRACK));
	}
	
	private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider)
	{
		generateOre(BlockInit.ORE_ALUMINUM_STONE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 16, 64, random.nextInt(7) + 4, 18, 
				BlockMatcher.forBlock(Blocks.STONE));
		generateOre(BlockInit.ORE_COPPER_STONE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 16, 64, random.nextInt(7) + 4, 18, 
				BlockMatcher.forBlock(Blocks.STONE));
	}


	private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances, 
			Predicate<IBlockState> replace)
	{
		int deltaY = maxY - minY;
		for(int i = 0; i < chances; i++)
		{
			BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));
			
			WorldGenMinable generator = new WorldGenMinable(ore, size, (com.google.common.base.Predicate<IBlockState>) replace);
			generator.generate(world, random, pos);
			
		}
	}




}
