package minevalley.core.api.armorstand.modifiers;

import org.bukkit.inventory.ItemStack;

public interface EquipmentModifier {

    /**
     * Get the item in the armorstands left hand
     *
     * @return item in left hand
     */
    ItemStack getLeftHand();

    /**
     * Set the item in the armorstands left hand
     *
     * @param itemStack item to set
     * @return this
     */
    EquipmentModifier setLeftHand(ItemStack itemStack);

    /**
     * Get the item in the armorstands right hand
     *
     * @return item in right hand
     */
    ItemStack getRightHand();

    /**
     * Set the item in the armorstands right hand
     *
     * @param itemStack item to set
     * @return this
     */
    EquipmentModifier setRightHand(ItemStack itemStack);

    /**
     * Get the item in the armorstands helmet slot
     *
     * @return item in helmet slot
     */
    ItemStack getHelmet();

    /**
     * Set the item in the armorstands helmet slot
     *
     * @param helmet item to set
     * @return this
     */
    EquipmentModifier setHelmet(ItemStack helmet);

    /**
     * Get the item in the armorstands chestplate slot
     *
     * @return item in chestplate slot
     */
    ItemStack getChestplate();

    /**
     * Set the item in the armorstands chestplate slot
     *
     * @param chestplate item to set
     * @return this
     */
    EquipmentModifier setChestplate(ItemStack chestplate);

    /**
     * Get the item in the armorstands leggings slot
     *
     * @return item in leggings slot
     */
    ItemStack getLeggings();

    /**
     * Set the item in the armorstands leggings slot
     *
     * @param leggings item to set
     * @return this
     */
    EquipmentModifier setLeggings(ItemStack leggings);

    /**
     * Get the item in the armorstands boots slot
     *
     * @return item in boots slot
     */
    ItemStack getBoots();

    /**
     * Set the item in the armorstands boots slot
     *
     * @param boots item to set
     * @return this
     */
    EquipmentModifier setBoots(ItemStack boots);

    /**
     * Update the armorstands equipment
     */
    void updateEquipment();
}
