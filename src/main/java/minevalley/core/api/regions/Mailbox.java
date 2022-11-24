package minevalley.core.api.regions;

import jdk.nashorn.internal.ir.Block;
import org.bukkit.inventory.ItemStack;

public interface Mailbox {

    Block getBlock();

    ItemStack[] getContents();

    void add(ItemStack itemStack);

    void clear();
}
