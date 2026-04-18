package eu.minevalley.core.api.server.events.item;

import eu.minevalley.core.api.server.events.ProxyServerEvents;
import eu.minevalley.core.api.user.ProxyUser;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

/**
 * This event is called when an item is added to a user's inventory
 */
@SuppressWarnings("unused")
public class ServerAddItemEvent extends ProxyServerEvents {

    private final @Getter(onMethod_ = @Nonnull) ProxyUser user;
    private final @Getter(onMethod_ = @Nonnull) ItemStack item;

    public ServerAddItemEvent(@Nonnull ProxyUser user, @Nonnull ItemStack item) {
        this.user = user;
        this.item = item;
    }
}
