package insane96mcp.vulcanite.item;

import insane96mcp.vulcanite.item.materials.ModMaterial;
import insane96mcp.vulcanite.setup.Strings.Tooltips;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class ItemVulcaniteAxe extends AxeItem {
	public ItemVulcaniteAxe(String id) {
		super(ModMaterial.TOOL_VULCANITE, 6.5f, -3.2f, new Item.Properties().group(ItemGroup.TOOLS));

		setRegistryName(id);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent(Tooltips.Tool.smelting));
		tooltip.add(new TranslationTextComponent(Tooltips.Tool.bonusEfficiency));
		tooltip.add(new TranslationTextComponent(Tooltips.Weapon.moreDamage));
	}
}