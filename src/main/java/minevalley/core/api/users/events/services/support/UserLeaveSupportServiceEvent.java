package minevalley.core.api.users.events.services.support;

import minevalley.core.api.users.ProxyUser;
import minevalley.core.api.users.events.services.team.UserUpdateTeamServiceEvent;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class UserLeaveSupportServiceEvent extends UserUpdateSupportServiceEvent {

    public UserLeaveSupportServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}