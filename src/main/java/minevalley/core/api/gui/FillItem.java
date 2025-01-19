package minevalley.core.api.gui;

import minevalley.core.api.Core;
import minevalley.core.api.users.OnlineUser;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.Consumer;

public record FillItem(@Nonnull ItemStack itemStack, @Nullable Consumer<GuiItemClick> callback) {

    public FillItem {
        if (itemStack == null) throw new IllegalArgumentException("ItemStack cannot be null");
    }

    @SuppressWarnings("unused")
    public void accept(final @Nonnull InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player player)) return;
        final OnlineUser user = Core.getOnlineUser(player);
        if (callback != null) callback.accept(new GuiItemClick(user, event.getClick(), event.getAction()));
    }
}
