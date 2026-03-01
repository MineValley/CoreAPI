package minevalley.core.api.user.event.service.support;

import minevalley.core.api.user.ProxyUser;

import javax.annotation.Nonnull;

/**
 * This event is called when a user is requested to enter the support service, before the action is processed.
 */
@SuppressWarnings("unused")
public class UserPreEnterSupportServiceEvent extends UserUpdateSupportServiceEvent {

    public UserPreEnterSupportServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}