package minevalley.core.api.registrant.events.services.support;

import minevalley.core.api.registrant.ProxyUser;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class UserEnterSupportServiceEvent extends UserUpdateSupportServiceEvent {

    public UserEnterSupportServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}