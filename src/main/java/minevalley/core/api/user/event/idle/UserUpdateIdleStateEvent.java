package minevalley.core.api.user.event.idle;

import minevalley.core.api.user.ProxyUser;
import minevalley.core.api.user.event.ProxyUserEvent;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public abstract class UserUpdateIdleStateEvent extends ProxyUserEvent {

    public UserUpdateIdleStateEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}