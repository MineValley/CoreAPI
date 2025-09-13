package minevalley.core.api.users.events.services.support;

import minevalley.core.api.users.ProxyUser;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class UserEnterSupportServiceEvent extends UserUpdateSupportServiceEvent {

    public UserEnterSupportServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}