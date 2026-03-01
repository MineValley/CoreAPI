package minevalley.core.api.user.event.services.team;

import minevalley.core.api.user.ProxyUser;
import minevalley.core.api.user.event.ProxyUserEvent;

import javax.annotation.Nonnull;

public abstract class UserUpdateTeamServiceEvent extends ProxyUserEvent {

    public UserUpdateTeamServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}