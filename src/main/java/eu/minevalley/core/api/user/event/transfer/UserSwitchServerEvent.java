package eu.minevalley.core.api.user.event.transfer;

import eu.minevalley.core.api.server.ServerType;
import eu.minevalley.core.api.user.ProxyUser;
import eu.minevalley.core.api.user.event.ProxyUserEvent;
import lombok.Getter;

import javax.annotation.Nonnull;

/**
 * This event is called when a user switches from one server to another within the proxy network.
 */
@SuppressWarnings("unused")
public class UserSwitchServerEvent extends ProxyUserEvent {

    private final @Getter(onMethod_ = @Nonnull) ServerType from, to;

    public UserSwitchServerEvent(@Nonnull ProxyUser user, @Nonnull ServerType from, @Nonnull ServerType server) {
        super(user);
        this.from = from;
        this.to = server;
    }
}