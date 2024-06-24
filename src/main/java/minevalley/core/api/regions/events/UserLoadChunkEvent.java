package minevalley.core.api.regions.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.users.OnlineUser;
import org.bukkit.Chunk;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
@RequiredArgsConstructor
public class UserLoadChunkEvent extends Event {

    public static final HandlerList HANDLER_LIST = new HandlerList();
    private final OnlineUser user;
    private final Chunk chunk;

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}