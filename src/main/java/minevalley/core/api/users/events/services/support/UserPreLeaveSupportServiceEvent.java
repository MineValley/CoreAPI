package minevalley.core.api.users.events.services.support;

import minevalley.core.api.users.ProxyUser;

import javax.annotation.Nonnull;

/**
 * This event is called when a user is requested to leave the support service, before the action is processed.
 */
@SuppressWarnings("unused")
public class UserPreLeaveSupportServiceEvent extends UserUpdateSupportServiceEvent {

    public UserPreLeaveSupportServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}