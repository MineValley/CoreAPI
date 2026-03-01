package minevalley.core.api.user.events.services.team;

import minevalley.core.api.user.ProxyUser;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class UserLeaveTeamServiceEvent extends UserUpdateTeamServiceEvent {

    public UserLeaveTeamServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}