package minevalley.core.api.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.users.OnlineUser;
import org.bukkit.Chunk;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerMoveEvent;


/**
 * This event is called when a user enters a cuboid.
 */
@RequiredArgsConstructor
@Getter
@SuppressWarnings("unused")
public class UserEnterChunkEvent extends Event implements Cancellable {

    public static final HandlerList HANDLER_LIST = new HandlerList();

    private final OnlineUser user;
    private final Chunk from, to;
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