package minevalley.core.api.user.events.services.support;

import minevalley.core.api.user.ProxyUser;
import minevalley.core.api.user.events.ProxyUserEvent;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public abstract class UserUpdateSupportServiceEvent extends ProxyUserEvent {

    public UserUpdateSupportServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}