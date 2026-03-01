package minevalley.core.api.user.events.idle;

import minevalley.core.api.user.ProxyUser;
import minevalley.core.api.user.events.ProxyUserEvent;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public abstract class UserUpdateIdleStateEvent extends ProxyUserEvent {

    public UserUpdateIdleStateEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}