package insane96mcp.vulcanite.item;

import insane96mcp.vulcanite.item.materials.ModMaterial;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import java.util.Map;

public class VulcaniteArmorItem extends ArmorItem {

    public VulcaniteArmorItem(EquipmentSlotType slot) {
        super(ModMaterial.ARMOR_VULCANITE, slot, new Properties().group(ItemGroup.COMBAT));
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if (enchantment.equals(Enchantments.FIRE_PROTECTION))
            return false;
        return super.canApplyAtEnchantingTable(stack, enchantment);
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(book);

        if (enchantments.containsKey(Enchantments.FIRE_PROTECTION))
            return false;

        return super.isBookEnchantable(stack, book);
    }
}
