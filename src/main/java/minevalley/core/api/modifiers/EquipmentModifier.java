package minevalley.core.api.modifiers;

import org.bukkit.inventory.ItemStack;

@SuppressWarnings("unused")
public interface EquipmentModifier {

    /**
     * Get the item in the left hand
     *
     * @return item in left hand
     */
    ItemStack getLeftHand();

    /**
     * Set the item in the left hand
     *
     * @param itemStack item to set
     * @return this
     */
    EquipmentModifier setLeftHand(ItemStack itemStack);

    /**
     * Get the item in the right hand
     *
     * @return item in right hand
     */
    ItemStack getRightHand();

    /**
     * Set the item in the right hand
     *
     * @param itemStack item to set
     * @return this
     */
    EquipmentModifier setRightHand(ItemStack itemStack);

    /**
     * Get the item in the helmet slot
     *
     * @return item in helmet slot
     */
    ItemStack getHelmet();

    /**
     * Set the item in the helmet slot
     *
     * @param helmet item to set
     * @return this
     */
    EquipmentModifier setHelmet(ItemStack helmet);

    /**
     * Get the item in the chestplate slot
     *
     * @return item in chestplate slot
     */
    ItemStack getChestplate();

    /**
     * Set the item in the chestplate slot
     *
     * @param chestplate item to set
     * @return this
     */
    EquipmentModifier setChestplate(ItemStack chestplate);

    /**
     * Get the item in the leggings slot
     *
     * @return item in leggings slot
     */
    ItemStack getLeggings();

    /**
     * Set the item in the leggings slot
     *
     * @param leggings item to set
     * @return this
     */
    EquipmentModifier setLeggings(ItemStack leggings);

    /**
     * Get the item in the boots slot
     *
     * @return item in boots slot
     */
    ItemStack getBoots();

    /**
     * Set the item in the boots slot
     *
     * @param boots item to set
     * @return this
     */
    EquipmentModifier setBoots(ItemStack boots);

    /**
     * Update the equipment
     */
    void updateEquipment();
}
