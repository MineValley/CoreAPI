package minevalley.core.api.user.event.prison;

import minevalley.core.api.user.ProxyUser;
import minevalley.core.api.user.event.ProxyUserEvent;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public abstract class UserUpdatePrisonStateEvent extends ProxyUserEvent {

    public UserUpdatePrisonStateEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}