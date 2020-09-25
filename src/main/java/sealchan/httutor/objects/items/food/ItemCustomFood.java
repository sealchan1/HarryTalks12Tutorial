package sealchan.httutor.objects.items.food;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import sealchan.httutor.Main;
import sealchan.httutor.init.ItemInit;
import sealchan.httutor.util.interfaces.IHasModel;

public class ItemCustomFood extends ItemFood implements IHasModel
{
	public ItemCustomFood(String name, int amount, boolean isWolfFood) 
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
	
}
