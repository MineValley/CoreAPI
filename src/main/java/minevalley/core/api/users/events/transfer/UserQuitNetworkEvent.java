package minevalley.core.api.users.events.transfer;

import lombok.Getter;
import minevalley.core.api.server.ServerType;
import minevalley.core.api.users.ProxyUser;
import minevalley.core.api.users.events.ProxyUserEvent;

import javax.annotation.Nonnull;

/**
 * This event is called when a user quits the proxy network.
 */
@SuppressWarnings("unused")
public class UserQuitNetworkEvent extends ProxyUserEvent {

    private final @Getter(onMethod_ = @Nonnull) ServerType server;

    public UserQuitNetworkEvent(@Nonnull ProxyUser user, @Nonnull ServerType server) {
        super(user);
        this.server = server;
    }
}