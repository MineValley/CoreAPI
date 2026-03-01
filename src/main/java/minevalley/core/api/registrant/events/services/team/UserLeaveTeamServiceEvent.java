package minevalley.core.api.registrant.events.services.team;

import minevalley.core.api.registrant.ProxyUser;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class UserLeaveTeamServiceEvent extends UserUpdateTeamServiceEvent {

    public UserLeaveTeamServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}