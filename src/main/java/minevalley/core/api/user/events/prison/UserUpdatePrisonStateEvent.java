package minevalley.core.api.user.events.prison;

import minevalley.core.api.user.ProxyUser;
import minevalley.core.api.user.events.ProxyUserEvent;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public abstract class UserUpdatePrisonStateEvent extends ProxyUserEvent {

    public UserUpdatePrisonStateEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}