package minevalley.core.api.users.events.transfer;

import lombok.Getter;
import minevalley.core.api.server.Server;
import minevalley.core.api.users.ProxyUser;
import minevalley.core.api.users.events.ProxyUserEvent;

import javax.annotation.Nonnull;

/**
 * This event is called when a user enters the proxy network.
 */
@SuppressWarnings("unused")
public class UserEnterNetworkEvent extends ProxyUserEvent {

    private final @Getter(onMethod_ = @Nonnull) Server server;

    public UserEnterNetworkEvent(@Nonnull ProxyUser user, @Nonnull Server server) {
        super(user);
        this.server = server;
    }
}