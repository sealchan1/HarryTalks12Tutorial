package sealchan.httutor.objects.items.food;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import sealchan.httutor.Main;
import sealchan.httutor.init.BlockInit;
import sealchan.httutor.init.ItemInit;
import sealchan.httutor.util.interfaces.IHasModel;

public class ItemRice extends ItemFood implements IHasModel, IPlantable
{
	public ItemRice(String name, int amount, boolean isWolfFood) 
	{
		super(amount, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tutorialtab);
		
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, net.minecraft.world.World worldIn, BlockPos pos,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		ItemStack stack = player.getHeldItem(hand);
		IBlockState state = worldIn.getBlockState(pos);
		
		if(facing == EnumFacing.UP 
			&& player.canPlayerEdit(pos.offset(facing), facing, stack) 
			&& state.getBlock().canSustainPlant(state, worldIn, pos, EnumFacing.UP, this)
			&& worldIn.isAirBlock(pos.up()))
		{
			worldIn.setBlockState(pos.up(), BlockInit.RICE_PLANT.getDefaultState());
			stack.shrink(1);
			return EnumActionResult.SUCCESS;
		}
		
		return EnumActionResult.FAIL;
		//return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
	}  

	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) 
	{
		return EnumPlantType.Crop;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) 
	{
		return BlockInit.RICE_PLANT.getDefaultState();
	}
}
