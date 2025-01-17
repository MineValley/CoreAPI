package minevalley.core.api.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.users.OnlineUser;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
@RequiredArgsConstructor
public class PlaySoundEvent extends Event {

    private final @Getter(onMethod_ = @Nonnull) OnlineUser user;
    private final @Getter(onMethod_ = @Nonnull) String sound;

    private @Getter boolean muffled;

    private final static @Getter(onMethod_ = @Nonnull) HandlerList handlerList = new HandlerList();

    @Override
    public @Nonnull HandlerList getHandlers() {
        return handlerList;
    }

    public void muffle() {
        this.muffled = true;
    }
}