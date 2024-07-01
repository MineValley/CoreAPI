package minevalley.core.api.users.events.services.support;

import minevalley.core.api.users.User;
import minevalley.core.api.users.events.services.team.UserUpdateTeamServiceEvent;

public class UserEnterSupportServiceEvent extends UserUpdateTeamServiceEvent {

    public UserEnterSupportServiceEvent(User user) {
        super(user);
    }
}