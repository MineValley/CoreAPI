package minevalley.core.api.regions.events;

import lombok.Getter;
import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.events.OnlineUserEvent;
import org.bukkit.Chunk;

import javax.annotation.Nonnull;

@Getter
@SuppressWarnings("unused")
public class UserLoadChunkEvent extends OnlineUserEvent {

    private final Chunk chunk;

    public UserLoadChunkEvent(@Nonnull OnlineUser user, @Nonnull Chunk chunk) {
        super(user);
        this.chunk = chunk;
    }
}