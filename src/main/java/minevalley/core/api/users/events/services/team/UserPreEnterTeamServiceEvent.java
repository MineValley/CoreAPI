package minevalley.core.api.users.events.services.team;

import minevalley.core.api.users.ProxyUser;

import javax.annotation.Nonnull;

/**
 * This event is called when a user is requested to enter the team service, before the action is processed.
 */
@SuppressWarnings("unused")
public class UserPreEnterTeamServiceEvent extends UserUpdateTeamServiceEvent {

    public UserPreEnterTeamServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}