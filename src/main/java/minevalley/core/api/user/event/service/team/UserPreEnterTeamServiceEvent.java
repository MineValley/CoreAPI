package minevalley.core.api.user.event.service.team;

import minevalley.core.api.user.ProxyUser;

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