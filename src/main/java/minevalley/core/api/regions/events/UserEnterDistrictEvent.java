package minevalley.core.api.regions.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.regions.District;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * This event is called when a user enters a district.
 */
@RequiredArgsConstructor
@Getter
public class UserEnterDistrictEvent extends Event {

    public static final HandlerList HANDLER_LIST = new HandlerList();

    private final OnlineUser user;
    private final District district;

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}