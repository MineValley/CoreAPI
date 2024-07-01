package minevalley.core.api.users.events.services.team;

import minevalley.core.api.users.User;

public class UserEnterTeamServiceEvent extends UserUpdateTeamServiceEvent {

    public UserEnterTeamServiceEvent(User user) {
        super(user);
    }
}