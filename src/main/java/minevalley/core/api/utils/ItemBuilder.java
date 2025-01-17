package minevalley.core.api.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.util.Set;

@SuppressWarnings("unused")
public interface ItemBuilder {

    /**
     * Sets the item's display name.
     *
     * @param displayName display name as {@link Component}
     * @return this item-builder
     * @throws IllegalArgumentException if the display name is null
     */
    @Nonnull
    @Contract("_ -> this")
    ItemBuilder setDisplayName(@Nonnull Component displayName) throws IllegalArgumentException;

    /**
     * Sets the item's lore.
     *
     * @param lore lore as {@link Component}
     * @return this item-builder
     * @throws IllegalArgumentException if the lore is null
     */
    @Nonnull
    @Contract("_ -> this")
    ItemBuilder setLore(@Nonnull Component... lore) throws IllegalArgumentException;

    /**
     * Sets the item's durability.
     *
     * @param durability durability of the item as integer
     * @return this item-builder
     * @throws IllegalArgumentException      if the durability is negative
     * @throws UnsupportedOperationException if the item is not damageable
     */
    @Nonnull
    @Contract("_ -> this")
    ItemBuilder setDurability(@Nonnegative int durability) throws IllegalArgumentException, UnsupportedOperationException;

    /**
     * Sets the item's custom model data.
     *
     * @param customModelData custom model data of the item as integer
     * @return this item-builder
     * @throws IllegalArgumentException if the custom model data is negative
     */
    @Nonnull
    @Contract("_ -> this")
    ItemBuilder setCustomModelData(@Nonnegative int customModelData) throws IllegalArgumentException;

    /**
     * Sets the item's amount.
     *
     * @param amount amount of the item as integer
     * @return this item-builder
     * @throws IllegalArgumentException if the amount is negative or above 64
     */
    @Nonnull
    @Contract("_ -> this")
    ItemBuilder setAmount(@Nonnegative int amount) throws IllegalArgumentException;

    /**
     * Sets the item's unbreakable state.
     *
     * @param unbreakable unbreakable state of the item
     * @return this item-builder
     */
    @Nonnull
    @Contract("_ -> this")
    ItemBuilder setUnbreakable(boolean unbreakable);

    /**
     * Adds item flags to the item.
     *
     * @param flags flags to add
     * @return this item-builder
     * @throws IllegalArgumentException if the flags are null
     */
    @Nonnull
    @Contract("_ -> this")
    ItemBuilder addItemFlags(@Nonnull ItemFlag... flags) throws IllegalArgumentException;

    /**
     * Removes item flags from the item.
     *
     * @param flags flags to remove
     * @return this item-builder
     * @throws IllegalArgumentException if the flags are null
     */
    @Nonnull
    @Contract("_ -> this")
    ItemBuilder removeItemFlags(@Nonnull ItemFlag... flags) throws IllegalArgumentException;

    /**
     * Gets a copy of the item's item flags list.
     *
     * @return copy of the item's item flags list
     */
    @Nonnull
    @Contract(pure = true)
    Set<ItemFlag> getItemFlags();

    /**
     * Sets the item's color.
     *
     * @param hexColor color as hex string
     * @return this item-builder
     * @throws IllegalArgumentException      if the hex color is invalid or null
     * @throws UnsupportedOperationException if the item is not dyeable
     */
    @Nonnull
    @Contract("_ -> this")
    ItemBuilder setColor(@Nonnull String hexColor) throws IllegalArgumentException, UnsupportedOperationException;

    /**
     * Sets the item's color.
     *
     * @param decimalColor color as decimal integer
     * @return this item-builder
     * @throws IllegalArgumentException      if the decimal color is invalid
     * @throws UnsupportedOperationException if the item is not dyeable
     */
    @Nonnull
    @Contract("_ -> this")
    ItemBuilder setColor(@Nonnegative int decimalColor) throws IllegalArgumentException, UnsupportedOperationException;

    /**
     * Converts this builder with its parameters into an itemstack
     *
     * @return built itemstack
     */
    @Nonnull
    @Contract(value = "-> new", pure = true)
    ItemStack build();
}