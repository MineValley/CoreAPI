package minevalley.core.api.server.events.item;

import lombok.Getter;
import minevalley.core.api.server.events.ProxyServerEvents;
import minevalley.core.api.users.ProxyUser;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

/**
 * This event is called when a server requests an item to be added to a user's inventory
 */
@SuppressWarnings("unused")
public class ServerPreAddItemEvent extends ProxyServerEvents {

    private final @Getter(onMethod_ = @Nonnull) ProxyUser user;
    private final @Getter(onMethod_ = @Nonnull) ItemStack item;

    public ServerPreAddItemEvent(@Nonnull ProxyUser user, @Nonnull ItemStack item) {
        this.user = user;
        this.item = item;
    }
}