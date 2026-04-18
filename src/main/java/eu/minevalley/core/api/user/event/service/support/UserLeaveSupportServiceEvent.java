package eu.minevalley.core.api.user.event.service.support;

import eu.minevalley.core.api.user.ProxyUser;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class UserLeaveSupportServiceEvent extends UserUpdateSupportServiceEvent {

    public UserLeaveSupportServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}