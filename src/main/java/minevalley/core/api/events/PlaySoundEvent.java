package minevalley.core.api.events;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.users.OnlineUser;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@RequiredArgsConstructor
@Getter
public class PlaySoundEvent extends Event {

    public static final HandlerList HANDLER_LIST = new HandlerList();

    private final OnlineUser user;
    private final String sound;

    @Getter(AccessLevel.NONE)
    private boolean muffled;

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public void muffle() {
        this.muffled = true;
    }
}