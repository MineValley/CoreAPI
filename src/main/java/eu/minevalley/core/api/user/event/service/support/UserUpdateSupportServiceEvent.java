package eu.minevalley.core.api.user.event.service.support;

import eu.minevalley.core.api.user.ProxyUser;
import eu.minevalley.core.api.user.event.ProxyUserEvent;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public abstract class UserUpdateSupportServiceEvent extends ProxyUserEvent {

    public UserUpdateSupportServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}