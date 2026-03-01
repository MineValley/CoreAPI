package minevalley.core.api.user.event.service.team;

import minevalley.core.api.user.ProxyUser;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class UserLeaveTeamServiceEvent extends UserUpdateTeamServiceEvent {

    public UserLeaveTeamServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}