package minevalley.core.api.user.event.service.team;

import minevalley.core.api.user.ProxyUser;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class UserEnterTeamServiceEvent extends UserUpdateTeamServiceEvent {

    public UserEnterTeamServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}