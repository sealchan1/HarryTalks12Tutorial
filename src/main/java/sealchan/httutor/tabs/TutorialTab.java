package sealchan.httutor.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import sealchan.httutor.init.ItemInit;

public class TutorialTab extends CreativeTabs
{
	public TutorialTab(String label) 
	{
		super(label);
		// super("tutorialtab");

		this.setBackgroundImageName("tutorial.png");
		
	}

	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(ItemInit.INGOT_COPPER);
	}

}
