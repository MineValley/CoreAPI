package minevalley.core.api.regions.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Chunk;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import javax.annotation.Nonnull;

@Getter
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class ServerStartChunkLoadEvent extends Event {

    public static final HandlerList HANDLER_LIST = new HandlerList();

    private final Chunk chunk;

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public @Nonnull HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}