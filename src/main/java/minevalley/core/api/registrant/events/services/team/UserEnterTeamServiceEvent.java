package minevalley.core.api.registrant.events.services.team;

import minevalley.core.api.registrant.ProxyUser;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class UserEnterTeamServiceEvent extends UserUpdateTeamServiceEvent {

    public UserEnterTeamServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}