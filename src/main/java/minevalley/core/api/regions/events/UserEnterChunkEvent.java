package minevalley.core.api.regions.events;

import lombok.Getter;
import lombok.Setter;
import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.events.OnlineUserEvent;
import org.bukkit.Chunk;
import org.bukkit.event.Cancellable;

import javax.annotation.Nonnull;

/**
 * This event is called when a user enters a chunk.
 */
@Getter
@SuppressWarnings("unused")
public class UserEnterChunkEvent extends OnlineUserEvent implements Cancellable {

    @Setter
    private boolean cancelled = false;
    private final Chunk from, to;

    public UserEnterChunkEvent(@Nonnull OnlineUser user, @Nonnull Chunk from, @Nonnull Chunk to) {
        super(user);
        this.from = from;
        this.to = to;
    }
}