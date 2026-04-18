package eu.minevalley.core.api.user.event.service.support;

import eu.minevalley.core.api.user.ProxyUser;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class UserEnterSupportServiceEvent extends UserUpdateSupportServiceEvent {

    public UserEnterSupportServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}