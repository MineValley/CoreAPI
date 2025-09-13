package minevalley.core.api.users.events.prison;

import minevalley.core.api.users.ProxyUser;
import minevalley.core.api.users.events.ProxyUserEvent;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public abstract class UserUpdatePrisonStateEvent extends ProxyUserEvent {

    public UserUpdatePrisonStateEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}