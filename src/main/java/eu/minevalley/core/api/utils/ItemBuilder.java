package eu.minevalley.core.api.utils;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public interface ItemBuilder {

    /**
     * Defines the item's display-name
     * @param displayName name of the item as string
     * @return this item-builder
     */
    ItemBuilder setDisplayName(String displayName);

    /**
     * Defines the item's lore
     * @param lore lore of the item as string(s)
     * @return this item-builder
     */
    ItemBuilder setLore(String... lore);

    /**
     * Defines the item's durability
     * @param durability durability of the item as short
     * @return this item-builder
     */
    ItemBuilder setDurability(short durability);

    /**
     * Defines the item's amount
     * @param amount amount of the item as integer
     * @return this item-builder
     */
    ItemBuilder setAmount(int amount);

    /**
     * Hides the durability-bar in the players inventory
     * @return this item-builder
     */
    ItemBuilder hideDurability();

    /**
     * Gets the item-meta of this builder
     * @return item-meta of this builder
     */
    ItemMeta getItemMeta();

    /**
     * Converts this builder with its parameters into an itemstack
     * @return built itemstack
     */
    ItemStack build();
}