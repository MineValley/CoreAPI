package eu.minevalley.core.api.user.event.prison;

import eu.minevalley.core.api.user.ProxyUser;
import eu.minevalley.core.api.user.event.ProxyUserEvent;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public abstract class UserUpdatePrisonStateEvent extends ProxyUserEvent {

    public UserUpdatePrisonStateEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}