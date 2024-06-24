package minevalley.core.api.users.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.users.User;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
@RequiredArgsConstructor
public abstract class UserEvent extends Event {

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