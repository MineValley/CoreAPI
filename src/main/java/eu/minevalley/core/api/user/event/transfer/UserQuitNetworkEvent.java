package eu.minevalley.core.api.user.event.transfer;

import eu.minevalley.core.api.server.ServerType;
import eu.minevalley.core.api.user.ProxyUser;
import eu.minevalley.core.api.user.event.ProxyUserEvent;
import lombok.Getter;

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