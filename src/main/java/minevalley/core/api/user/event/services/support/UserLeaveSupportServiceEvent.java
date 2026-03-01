package minevalley.core.api.user.event.services.support;

import minevalley.core.api.user.ProxyUser;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class UserLeaveSupportServiceEvent extends UserUpdateSupportServiceEvent {

    public UserLeaveSupportServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}