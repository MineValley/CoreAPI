package minevalley.core.api.user.events.services.team;

import minevalley.core.api.user.ProxyUser;
import minevalley.core.api.user.events.ProxyUserEvent;

import javax.annotation.Nonnull;

public abstract class UserUpdateTeamServiceEvent extends ProxyUserEvent {

    public UserUpdateTeamServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}