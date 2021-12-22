package minevalley.core.api.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.User;
import org.bukkit.Chunk;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


/**
 * This event is called when a user enters a region, no matter what type of region it is.
 */
@RequiredArgsConstructor
@Getter
public class UserEnterChunkEvent extends Event {

    public static final HandlerList HANDLER_LIST = new HandlerList();

    private final User user;
    private final Chunk from, to;

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}