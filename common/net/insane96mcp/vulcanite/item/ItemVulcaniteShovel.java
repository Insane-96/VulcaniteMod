package net.insane96mcp.vulcanite.item;

import java.util.List;

import javax.annotation.Nullable;

import net.insane96mcp.vulcanite.Vulcanite;
import net.insane96mcp.vulcanite.init.ModItems;
import net.insane96mcp.vulcanite.lib.Properties;
import net.insane96mcp.vulcanite.lib.Strings.Names;
import net.insane96mcp.vulcanite.lib.Strings.Tooltips;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemVulcaniteShovel extends ItemSpade{
	public ItemVulcaniteShovel(String name, ToolMaterial material, CreativeTabs tab) {
		super(material);
		setRegistryName(name);
		setCreativeTab(tab);
	}

	@Override
	public String getTranslationKey(ItemStack stack) {
		return "item." + Vulcanite.RESOURCE_PREFIX + Names.VULCANITE_SHOVEL;
	}
	
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (GuiScreen.isShiftKeyDown() && Properties.config.showMoreInfo) {
			tooltip.add(I18n.format(Tooltips.Tool.adv_bonusEfficiency, Properties.config.toolsAndWeapons.bonusStats.efficencyInNether));
		}
		else {
			tooltip.add(I18n.format(Tooltips.Tool.base_bonusEfficiency));
			if (Properties.config.showMoreInfo)
				tooltip.add(I18n.format(Tooltips.General.shiftForMore));
		}
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return ItemStack.areItemsEqualIgnoreDurability(repair, new ItemStack(ModItems.vulcaniteIngotItem)) ? true : super.getIsRepairable(toRepair, repair);
  	}
}
