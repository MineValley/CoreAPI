package minevalley.core.api.users.events.services.support;

import minevalley.core.api.users.ProxyUser;
import minevalley.core.api.users.events.ProxyUserEvent;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public abstract class UserUpdateSupportServiceEvent extends ProxyUserEvent {

    public UserUpdateSupportServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}