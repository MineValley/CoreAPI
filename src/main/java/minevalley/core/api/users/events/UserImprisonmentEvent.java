package minevalley.core.api.users.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.users.OnlineUser;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * This event gets called when a user is getting imprisoned.
 */
@Getter
@RequiredArgsConstructor
public class UserImprisonmentEvent extends Event {

    public static final HandlerList HANDLER_LIST = new HandlerList();
    private final OnlineUser user;

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}