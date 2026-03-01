package minevalley.core.api.registrant.events.services.support;

import minevalley.core.api.registrant.ProxyUser;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class UserLeaveSupportServiceEvent extends UserUpdateSupportServiceEvent {

    public UserLeaveSupportServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}