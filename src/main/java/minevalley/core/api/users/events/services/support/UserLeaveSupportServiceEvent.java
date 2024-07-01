package minevalley.core.api.users.events.services.support;

import minevalley.core.api.users.User;
import minevalley.core.api.users.events.services.team.UserUpdateTeamServiceEvent;

public class UserLeaveSupportServiceEvent extends UserUpdateTeamServiceEvent {

    public UserLeaveSupportServiceEvent(User user) {
        super(user);
    }
}