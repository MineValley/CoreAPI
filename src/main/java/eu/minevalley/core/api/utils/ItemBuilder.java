package eu.minevalley.core.api.utils;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public interface ItemBuilder {

    ItemBuilder setDisplayName(String displayName);

    ItemBuilder setLore(String... lore);

    ItemBuilder setDurability(short durability);

    ItemBuilder setAmount(int amount);

    ItemBuilder hideDurability();

    ItemStack getItemStack();

    ItemMeta getItemMeta();

    ItemStack build();
}