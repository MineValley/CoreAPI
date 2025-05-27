package minevalley.core.api.regions.events;

import lombok.AccessLevel;
import lombok.Getter;
import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.events.OnlineUserEvent;
import org.bukkit.block.Block;
import org.bukkit.event.Event;

import javax.annotation.Nonnull;

@Getter
@SuppressWarnings("unused")
public class UserInteractEnvironmentEvent extends OnlineUserEvent {

    private final Block block;
    private final boolean nativelyInterrupted;
    private final Event underlyingEvent;

    @Getter(AccessLevel.NONE)
    private boolean overwrite;

    public UserInteractEnvironmentEvent(@Nonnull OnlineUser user, @Nonnull Block block, boolean nativelyInterrupted, @Nonnull Event underlyingEvent) {
        super(user);
        this.block = block;
        this.nativelyInterrupted = nativelyInterrupted;
        this.underlyingEvent = underlyingEvent;
        this.overwrite = nativelyInterrupted;
    }

    public void allow() {
        overwrite = true;
    }

    public void deny() {
        overwrite = false;
    }

    public boolean isFinallyAllowed() {
        return overwrite;
    }
}