package minevalley.core.api.utils;

import org.bukkit.inventory.ItemStack;

public interface ItemBuilder {

    /**
     * Defines the item's display-name
     *
     * @param displayName name of the item as string
     * @return this item-builder
     */
    ItemBuilder setDisplayName(String displayName);

    /**
     * Defines the item's lore
     *
     * @param lore lore of the item as string(s)
     * @return this item-builder
     */
    ItemBuilder setLore(String... lore);

    /**
     * Defines the item's durability
     *
     * @param durability durability of the item as short
     * @return this item-builder
     */
    ItemBuilder setDurability(int durability);

    ItemBuilder setData(int data);

    /**
     * Defines the item's amount
     *
     * @param amount amount of the item as integer
     * @return this item-builder
     */
    ItemBuilder setAmount(int amount);

    /**
     * Hides the durability-bar in the players inventory
     *
     * @return this item-builder
     */
    ItemBuilder hideAttributes();

    ItemBuilder setLeatherArmorColor(String hexColor);

    ItemBuilder setLeatherArmorColor(int decimalColor);

    /**
     * Converts this builder with its parameters into an itemstack
     *
     * @return built itemstack
     */
    ItemStack build();
}