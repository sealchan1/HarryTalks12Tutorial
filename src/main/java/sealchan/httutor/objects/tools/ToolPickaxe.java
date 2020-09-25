package sealchan.httutor.objects.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemPickaxe;
import sealchan.httutor.Main;
import sealchan.httutor.init.ItemInit;
import sealchan.httutor.util.interfaces.IHasModel;

public class ToolPickaxe extends ItemPickaxe implements IHasModel
{

	public ToolPickaxe(String name, ToolMaterial material) 
	{
		super(material);

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
