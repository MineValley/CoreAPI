package minevalley.core.api.user.event.service.support;

import minevalley.core.api.user.ProxyUser;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class UserEnterSupportServiceEvent extends UserUpdateSupportServiceEvent {

    public UserEnterSupportServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}