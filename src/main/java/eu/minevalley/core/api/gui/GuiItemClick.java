package eu.minevalley.core.api.gui;

import eu.minevalley.proxima.api.user.ProxyUser;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;

import javax.annotation.Nonnull;

public record GuiItemClick(@Nonnull ProxyUser user,
                           @Nonnull ClickType clickType,
                           @Nonnull InventoryAction inventoryAction) {
}