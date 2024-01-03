package minevalley.core.api.utils.armorstand;

import org.bukkit.inventory.ItemStack;

public interface EquipmentModifier {

    ItemStack getLeftHand();

    void setLeftHand(ItemStack itemStack);

    ItemStack getRightHand();

    void setRightHand(ItemStack itemStack);

    ItemStack getHelmet();

    void setHelmet(ItemStack helmet);

    ItemStack getChestplate();

    void setChestplate(ItemStack chestplate);

    ItemStack getLeggings();

    void setLeggings(ItemStack leggings);

    ItemStack getBoots();

    void setBoots(ItemStack boots);
}
