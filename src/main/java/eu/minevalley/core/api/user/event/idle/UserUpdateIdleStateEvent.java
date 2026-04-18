package eu.minevalley.core.api.user.event.idle;

import eu.minevalley.core.api.user.ProxyUser;
import eu.minevalley.core.api.user.event.ProxyUserEvent;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public abstract class UserUpdateIdleStateEvent extends ProxyUserEvent {

    public UserUpdateIdleStateEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}