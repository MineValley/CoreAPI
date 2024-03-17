package minevalley.core.api.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.users.User;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * This event gets called when a user is unfreezed.
 */
@Getter
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class UserUnfreezeEvent extends Event {

    public static final HandlerList HANDLER_LIST = new HandlerList();
    private final User user;

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}