package minevalley.core.api.registrant.events.services.support;

import minevalley.core.api.registrant.ProxyUser;
import minevalley.core.api.registrant.events.ProxyUserEvent;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public abstract class UserUpdateSupportServiceEvent extends ProxyUserEvent {

    public UserUpdateSupportServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}