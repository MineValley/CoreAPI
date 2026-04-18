package eu.minevalley.core.api.user.event.transfer;

import eu.minevalley.core.api.server.ServerType;
import eu.minevalley.core.api.user.ProxyUser;
import eu.minevalley.core.api.user.event.ProxyUserEvent;
import lombok.Getter;

import javax.annotation.Nonnull;

/**
 * This event is called when a user enters the proxy network.
 */
@SuppressWarnings("unused")
public class UserEnterNetworkEvent extends ProxyUserEvent {

    private final @Getter(onMethod_ = @Nonnull) ServerType server;

    public UserEnterNetworkEvent(@Nonnull ProxyUser user, @Nonnull ServerType server) {
        super(user);
        this.server = server;
    }
}