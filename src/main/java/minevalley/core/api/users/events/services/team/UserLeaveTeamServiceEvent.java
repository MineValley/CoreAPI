package minevalley.core.api.users.events.services.team;

import minevalley.core.api.users.User;

public class UserLeaveTeamServiceEvent extends UserUpdateTeamServiceEvent {

    public UserLeaveTeamServiceEvent(User user) {
        super(user);
    }
}