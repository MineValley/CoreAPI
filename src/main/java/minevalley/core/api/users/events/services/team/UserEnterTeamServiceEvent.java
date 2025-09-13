package minevalley.core.api.users.events.services.team;

import minevalley.core.api.users.ProxyUser;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class UserEnterTeamServiceEvent extends UserUpdateTeamServiceEvent {

    public UserEnterTeamServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}