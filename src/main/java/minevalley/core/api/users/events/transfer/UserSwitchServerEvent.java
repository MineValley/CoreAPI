package minevalley.core.api.users.events.transfer;

import lombok.Getter;
import minevalley.core.api.server.Server;
import minevalley.core.api.users.ProxyUser;
import minevalley.core.api.users.events.ProxyUserEvent;

import javax.annotation.Nonnull;

/**
 * This event is called when a user switches from one server to another within the proxy network.
 */
@SuppressWarnings("unused")
public class UserSwitchServerEvent extends ProxyUserEvent {

    private final @Getter(onMethod_ = @Nonnull) Server from, to;

    public UserSwitchServerEvent(@Nonnull ProxyUser user, @Nonnull Server from, @Nonnull Server server) {
        super(user);
        this.from = from;
        this.to = server;
    }
}