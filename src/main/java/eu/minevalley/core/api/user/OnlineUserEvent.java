package eu.minevalley.core.api.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import javax.annotation.Nonnull;

@RequiredArgsConstructor
public abstract class OnlineUserEvent extends Event {

    private final @Getter(onMethod_ = @Nonnull) OnlineUser user;

    private final static @Getter(onMethod_ = @Nonnull) HandlerList handlerList = new HandlerList();

    @Override
    public @Nonnull HandlerList getHandlers() {
        return handlerList;
    }
}