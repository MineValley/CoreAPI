package minevalley.core.api.modifiers;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@SuppressWarnings("unused")
public interface EquipmentModifier {

    /**
     * Get the item in the left hand
     *
     * @return item in left hand
     */
    @Nullable
    @Contract(pure = true)
    ItemStack getLeftHand();

    /**
     * Set the item in the left hand
     *
     * @param itemStack item to set
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    EquipmentModifier setLeftHand(@Nullable ItemStack itemStack);

    /**
     * Get the item in the right hand
     *
     * @return item in right hand
     */
    @Nullable
    @Contract(pure = true)
    ItemStack getRightHand();

    /**
     * Set the item in the right hand
     *
     * @param itemStack item to set
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    EquipmentModifier setRightHand(@Nullable ItemStack itemStack);

    /**
     * Get the item in the helmet slot
     *
     * @return item in helmet slot
     */
    @Nullable
    @Contract(pure = true)
    ItemStack getHelmet();

    /**
     * Set the item in the helmet slot
     *
     * @param helmet item to set
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    EquipmentModifier setHelmet(@Nullable ItemStack helmet);

    /**
     * Get the item in the chestplate slot
     *
     * @return item in chestplate slot
     */
    @Nullable
    ItemStack getChestplate();

    /**
     * Set the item in the chestplate slot
     *
     * @param chestplate item to set
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    EquipmentModifier setChestplate(@Nullable ItemStack chestplate);

    /**
     * Get the item in the leggings slot
     *
     * @return item in leggings slot
     */
    @Nullable
    @Contract(pure = true)
    ItemStack getLeggings();

    /**
     * Set the item in the leggings slot
     *
     * @param leggings item to set
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    EquipmentModifier setLeggings(@Nullable ItemStack leggings);

    /**
     * Get the item in the boots slot
     *
     * @return item in boots slot
     */
    @Nullable
    @Contract(pure = true)
    ItemStack getBoots();

    /**
     * Set the item in the boots slot
     *
     * @param boots item to set
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    EquipmentModifier setBoots(@Nullable ItemStack boots);

    /**
     * Update the equipment
     */
    void updateEquipment();
}
