package sealchan.httutor.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import sealchan.httutor.objects.blocks.BlockBase;
import sealchan.httutor.objects.blocks.BlockRicePlant;
import sealchan.httutor.objects.blocks.BlockLeaf;
import sealchan.httutor.objects.blocks.BlockLogs;
import sealchan.httutor.objects.blocks.BlockPlank;
import sealchan.httutor.objects.blocks.BlockSaplings;
import sealchan.httutor.objects.blocks.ModLeaves;
import sealchan.httutor.objects.blocks.ModLog;
import sealchan.httutor.objects.blocks.ModSapling;
import sealchan.httutor.world.gen.ModWGCopperTree;

public class BlockInit 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block BLOCK_COPPER = new BlockBase("block_copper", Material.IRON);
	
	//public static final Block PLANKS = new BlockPlank("planks");
	//public static final Block LOGS = new BlockLogs("log");
	//public static final Block LEAVES = new BlockLeaf("leaves");
	//public static final Block SAPLINGS = new BlockSaplings("sapling");
	
	public static final Block PLANK_COPPER = new BlockBase("plank_copper", Material.WOOD);
	public static final Block LOG_COPPER = new ModLog("log_copper");
	public static final Block LEAVES_COPPER = new ModLeaves("leaves_copper");
	public static final Block SAPLING_COPPER = new ModSapling("sapling_copper", new ModWGCopperTree());
		
	//public static final Block ORE_END  = new BlockOres("ore_end", "end");
	//public static final Block ORE_OVERWORLD = new BlockOres("ore_overworld", "overworld");
	//public static final Block ORE_NETHER = new BlockOres("ore_nether", "nether");
	
	public static final Block ORE_COPPER_STONE = new BlockBase("ore_copper_stone", Material.ROCK);
	public static final Block ORE_ALUMINUM_STONE = new BlockBase("ore_aluminum_stone", Material.ROCK);
	public static final Block ORE_COPPER_NETHERRACK = new BlockBase("ore_copper_netherrack", Material.ROCK);
	public static final Block ORE_ALUMINUM_NETHERRACK = new BlockBase("ore_aluminum_netherrack", Material.ROCK);
	
	public static final Block RICE_PLANT = new BlockRicePlant("rice_plant");
	
}
