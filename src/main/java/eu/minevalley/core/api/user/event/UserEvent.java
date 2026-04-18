package eu.minevalley.core.api.user.event;

import eu.minevalley.core.api.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import javax.annotation.Nonnull;

@RequiredArgsConstructor
public abstract class UserEvent extends Event {

    private final @Getter(onMethod_ = @Nonnull) User user;

    private final static @Getter(onMethod_ = @Nonnull) HandlerList handlerList = new HandlerList();

    public @Nonnull HandlerList getHandlers() {
        return handlerList;
    }
}