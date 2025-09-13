package minevalley.core.api.users.events.services.team;

import minevalley.core.api.users.ProxyUser;
import minevalley.core.api.users.events.ProxyUserEvent;

import javax.annotation.Nonnull;

public abstract class UserUpdateTeamServiceEvent extends ProxyUserEvent {

    public UserUpdateTeamServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}