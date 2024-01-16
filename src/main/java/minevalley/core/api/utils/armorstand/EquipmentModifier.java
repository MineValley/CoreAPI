package minevalley.core.api.utils.armorstand;

import org.bukkit.inventory.ItemStack;

public interface EquipmentModifier {

    ItemStack getLeftHand();

    EquipmentModifier setLeftHand(ItemStack itemStack);

    ItemStack getRightHand();

    EquipmentModifier setRightHand(ItemStack itemStack);

    ItemStack getHelmet();

    EquipmentModifier setHelmet(ItemStack helmet);

    ItemStack getChestplate();

    EquipmentModifier setChestplate(ItemStack chestplate);

    ItemStack getLeggings();

    EquipmentModifier setLeggings(ItemStack leggings);

    ItemStack getBoots();

    EquipmentModifier setBoots(ItemStack boots);

    void updateEquipment();
}
