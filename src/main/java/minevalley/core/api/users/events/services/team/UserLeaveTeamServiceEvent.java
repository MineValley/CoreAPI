package minevalley.core.api.users.events.services.team;

import minevalley.core.api.users.ProxyUser;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class UserLeaveTeamServiceEvent extends UserUpdateTeamServiceEvent {

    public UserLeaveTeamServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}