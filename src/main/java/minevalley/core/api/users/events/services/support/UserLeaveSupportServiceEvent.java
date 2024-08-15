package minevalley.core.api.users.events.services.support;

import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.events.services.team.UserUpdateTeamServiceEvent;

public class UserLeaveSupportServiceEvent extends UserUpdateTeamServiceEvent {

    public UserLeaveSupportServiceEvent(OnlineUser user) {
        super(user);
    }
}