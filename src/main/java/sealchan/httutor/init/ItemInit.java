package sealchan.httutor.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import sealchan.httutor.objects.armor.ArmorBase;
import sealchan.httutor.objects.items.ItemBase;
import sealchan.httutor.objects.items.food.ItemCustomFood;
import sealchan.httutor.objects.items.food.ItemRice;
import sealchan.httutor.objects.tools.ToolAxe;
import sealchan.httutor.objects.tools.ToolHoe;
import sealchan.httutor.objects.tools.ToolPickaxe;
import sealchan.httutor.objects.tools.ToolShovel;
import sealchan.httutor.objects.tools.ToolSword;
import sealchan.httutor.util.Reference;

public class ItemInit 
{
	public static List<Item> ITEMS = new ArrayList<Item>();
	
	// Materials
	// Copper HTML notation: d69b85, light: 0.161
	public static final ToolMaterial TOOL_COPPER = EnumHelper.addToolMaterial("tool_copper", 2, 180, 5.0F, 1.5F, 5);
	public static final ArmorMaterial ARMOR_COPPER = EnumHelper.addArmorMaterial("armor_copper", 
			Reference.MOD_ID + ":copper", 13, new int[]{2, 5, 5, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	
	// Armor
	public static final Item BOOTS_COPPER = new ArmorBase("boots_copper", ARMOR_COPPER, 1, EntityEquipmentSlot.FEET);
	public static final Item CHESTPLATE_COPPER = new ArmorBase("chestplate_copper", ARMOR_COPPER, 1, EntityEquipmentSlot.CHEST);
	public static final Item HELMET_COPPER = new ArmorBase("helmet_copper", ARMOR_COPPER, 1, EntityEquipmentSlot.HEAD);
	public static final Item LEGGINGS_COPPER = new ArmorBase("leggings_copper", ARMOR_COPPER, 2, EntityEquipmentSlot.LEGS);
	
	// Food
	public static final Item RICE_BOWL = new ItemCustomFood("rice_bowl", 8, false);
	public static final Item RICE = new ItemRice("rice", 1, false);
	
	// Items
	public static final Item INGOT_COPPER = new ItemBase("ingot_copper");
	
	// Tools
	public static final Item AXE_COPPER = new ToolAxe("axe_copper", TOOL_COPPER);
	public static final Item HOE_COPPER = new ToolHoe("hoe_copper", TOOL_COPPER);
	public static final Item PICKAXE_COPPER = new ToolPickaxe("pickaxe_copper", TOOL_COPPER);
	public static final Item SHOVEL_COPPER = new ToolShovel("shovel_copper", TOOL_COPPER);
	public static final Item SWORD_COPPER = new ToolSword("sword_copper", TOOL_COPPER);
}
