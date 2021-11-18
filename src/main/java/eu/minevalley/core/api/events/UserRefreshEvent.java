package eu.minevalley.core.api.events;

import eu.minevalley.core.api.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@RequiredArgsConstructor @Getter
public final class UserRefreshEvent extends Event {

    public static final HandlerList HANDLER_LIST = new HandlerList();

    private final User user;

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}