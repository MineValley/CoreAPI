package minevalley.core.api.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.User;
import minevalley.core.api.regions.Cuboid;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerMoveEvent;


/**
 * This event is called when a user enters a cuboid.
 */
@RequiredArgsConstructor
@Getter
public class UserEnterCuboidEvent extends Event implements Cancellable {

    public static final HandlerList HANDLER_LIST = new HandlerList();

    private final User user;
    private final Cuboid from, to;
    private final PlayerMoveEvent event;
    private boolean cancelled = false;

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = true;
        event.setCancelled(true);
        user.getPlayer().setVelocity(event.getFrom().toVector().subtract(event.getTo().toVector()));
    }
}