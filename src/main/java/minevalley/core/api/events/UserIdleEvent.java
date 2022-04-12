package minevalley.core.api.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.User;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * This event gets called when a user is marked as idle (afk).
 */
@Getter
@RequiredArgsConstructor
public class UserIdleEvent extends Event {

    public static final HandlerList HANDLER_LIST = new HandlerList();
    private static User user;

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}