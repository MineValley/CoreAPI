package minevalley.core.api.registrant.events.idle;

import minevalley.core.api.registrant.ProxyUser;
import minevalley.core.api.registrant.events.ProxyUserEvent;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public abstract class UserUpdateIdleStateEvent extends ProxyUserEvent {

    public UserUpdateIdleStateEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}