package minevalley.core.api.registrant.events.services.team;

import minevalley.core.api.registrant.ProxyUser;
import minevalley.core.api.registrant.events.ProxyUserEvent;

import javax.annotation.Nonnull;

public abstract class UserUpdateTeamServiceEvent extends ProxyUserEvent {

    public UserUpdateTeamServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}