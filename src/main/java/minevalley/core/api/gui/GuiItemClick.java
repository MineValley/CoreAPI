package minevalley.core.api.gui;

import minevalley.core.api.users.OnlineUser;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;

import javax.annotation.Nonnull;

public record GuiItemClick(@Nonnull OnlineUser user,
                           @Nonnull ClickType clickType,
                           @Nonnull InventoryAction inventoryAction) {
}