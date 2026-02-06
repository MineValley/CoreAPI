package minevalley.core.api.utils;

import io.papermc.paper.datacomponent.item.JukeboxPlayable;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.components.EquippableComponent;
import org.bukkit.inventory.meta.components.FoodComponent;
import org.bukkit.inventory.meta.components.ToolComponent;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
     * Sets the item's display name.
     *
     * @param displayName display name
     * @param color       color that will be applied on the display name
     * @param decorations text decorations that will be applied on the display name
     * @return this item-builder
     * @throws IllegalArgumentException if the display name, color or decorations is null
     */
    @Nonnull
    @Contract("_, _, _ -> this")
    default ItemBuilder setDisplayName(@Nonnull String displayName, @Nonnull TextColor color, @Nonnull TextDecoration... decorations) throws IllegalArgumentException {
        return setDisplayName(Component.text(displayName, color).decoration(TextDecoration.ITALIC, false)
                .decorations(Arrays.stream(decorations).collect(Collectors.toMap(decoration -> decoration, decoration -> TextDecoration.State.TRUE))));
    }

    /**
     * Sets the item's lore.
     *
     * @param lore lore as {@link Component}
     * @return this item-builder
     * @throws IllegalArgumentException if the lore is null
     */
    @Nonnull
    @Contract("_ -> this")
    ItemBuilder setLore(@Nonnull List<? extends Component> lore) throws IllegalArgumentException;

    /**
     * Sets the item's lore.
     *
     * @param lore lore as {@link Component}
     * @return this item-builder
     * @throws IllegalArgumentException if the lore is null
     */
    @Nonnull
    @Contract("_ -> this")
    default ItemBuilder setLore(@Nonnull Component... lore) throws IllegalArgumentException {
        return setLore(Arrays.asList(lore));
    }

    /**
     * Sets the item's lore.
     *
     * @param color color that will be applied on every line of the lore
     * @param lore  lore as {@link Component}
     * @return this item-builder
     * @throws IllegalArgumentException if lore or color is null
     */
    @Nonnull
    @Contract("_, _ -> this")
    default ItemBuilder setLore(@Nonnull TextColor color, @Nonnull String... lore) throws IllegalArgumentException {
        return setLore(Arrays.stream(lore).map(s -> Component.text(s, color).decoration(TextDecoration.ITALIC, false)).toList());
    }

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
     * Adds custom item flags to the item.
     *
     * @param flags flags to add
     * @return this
     * @throws IllegalArgumentException if the flags are null
     */
    @Nonnull
    @Contract("_ -> this")
    ItemBuilder addCustomItemFlags(@Nonnull CustomItemFlag... flags) throws IllegalArgumentException;

    /**
     * Removes custom item flags from the item.
     *
     * @param flags flags to remove
     * @return this
     * @throws IllegalArgumentException if the flags are null
     */
    @Nonnull
    @Contract("_ -> this")
    ItemBuilder removeCustomItemFlags(@Nonnull CustomItemFlag... flags) throws IllegalArgumentException;

    /**
     * Gets a copy of the item's custom item flags list.
     *
     * @return copy of the item's custom item flags list
     */
    @Nonnull
    @Contract(pure = true)
    Set<CustomItemFlag> getCustomItemFlags();

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
     * Sets the max stack size of the item.
     *
     * @param maxStackSize max stack size of the item as integer
     * @return this item-builder
     * @throws IllegalArgumentException if the max stack size is negative or above 64
     */
    @Nonnull
    @Contract("_ -> this")
    ItemBuilder setMaxStackSize(@Nonnegative int maxStackSize) throws IllegalArgumentException;

    /**
     * Sets whether the item's tooltip should be hidden.
     *
     * @param hideTooltip whether the item's tooltip should be hidden
     * @return this item-builder
     */
    @Nonnull
    @Contract("_ -> this")
    ItemBuilder setHideToolTip(boolean hideTooltip);

    /**
     * Sets whether the item should have the glider effect (elytra flying animation).
     *
     * @param glider whether the item should have the glider effect
     * @return this item-builder
     */
    @Nonnull
    @Contract("_ -> this")
    ItemBuilder setGlider(boolean glider);

    /**
     * Sets whether the item should be fire resistant.
     *
     * @param fireResistant whether the item should be fire resistant
     * @return this item-builder
     */
    @Nonnull
    @Contract("_ -> this")
    ItemBuilder setFireResistant(boolean fireResistant);

    /**
     * Sets the food component of the item. This will make the item edible and give it the specified food properties.
     *
     * @param food food component to set, or null to remove the food component from the item
     * @return this item-builder
     */
    @Nonnull
    @Contract("_ -> this")
    @SuppressWarnings("UnstableApiUsage")
    ItemBuilder setFood(@Nullable FoodComponent food);

    /**
     * Sets the tool component of the item. This will make the item a tool and give it the specified tool properties.
     *
     * @param tool tool component to set, or null to remove the tool component from the item
     * @return this item-builder
     */
    @Nonnull
    @Contract("_ -> this")
    @SuppressWarnings("UnstableApiUsage")
    ItemBuilder setTool(@Nullable ToolComponent tool);

    /**
     * Sets the equippable component of the item. This will make the item equippable and give it the specified equippable properties.
     *
     * @param equippable equippable component to set, or null to remove the equippable component from the item
     * @return this item-builder
     */
    @Nonnull
    @Contract("_ -> this")
    @SuppressWarnings("UnstableApiUsage")
    ItemBuilder setEquippable(@Nullable EquippableComponent equippable);

    /**
     * Sets the jukebox playable component of the item. This will make the item playable in a jukebox and give it the specified jukebox playable properties.
     *
     * @param jukeboxPlayable jukebox playable component to set, or null to remove the jukebox playable component from the item
     * @return this item-builder
     */
    @Nonnull
    @Contract("_ -> this")
    @SuppressWarnings("UnstableApiUsage")
    ItemBuilder setJukeboxPlayable(@Nullable JukeboxPlayable jukeboxPlayable);

    /**
     * Converts this builder with its parameters into an itemstack
     *
     * @return built itemstack
     */
    @Nonnull
    @Contract(value = "-> new", pure = true)
    ItemStack build();
}