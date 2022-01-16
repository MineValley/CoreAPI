package minevalley.core.api.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.User;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * This event is called, when a user is loaded or reloaded from the database.
 * It is used to change user-dependent data in modules when that user's data has been updated.
 * You can update a user manually by calling the refresh()-method.
 */
@RequiredArgsConstructor
@Getter
public final class UserRefreshEvent extends Event {

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