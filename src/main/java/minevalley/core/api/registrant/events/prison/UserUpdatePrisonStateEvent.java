package minevalley.core.api.registrant.events.prison;

import minevalley.core.api.registrant.ProxyUser;
import minevalley.core.api.registrant.events.ProxyUserEvent;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public abstract class UserUpdatePrisonStateEvent extends ProxyUserEvent {

    public UserUpdatePrisonStateEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}