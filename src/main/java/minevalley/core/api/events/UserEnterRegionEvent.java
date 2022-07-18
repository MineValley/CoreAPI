package minevalley.core.api.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.OnlineUser;
import minevalley.core.api.regions.Region;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * This event is called when a user enters a region, no matter what type of region it is.
 */
@RequiredArgsConstructor
@Getter
public class UserEnterRegionEvent extends Event {

    public static final HandlerList HANDLER_LIST = new HandlerList();

    private final OnlineUser user;
    private final Region region;

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}