package eu.minevalley.core.api.misc;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public interface ItemBuilder {

    ItemBuilder setDisplayName(String displayName);

    ItemBuilder setLore(String... lore);

    ItemBuilder setDurability(short durability);

    ItemBuilder setAmount(int amount);

    ItemStack getItemStack();

    ItemMeta getItemMeta();

    ItemStack build();
}