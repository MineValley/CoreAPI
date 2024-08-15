package minevalley.core.api.users.events.services.team;

import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.events.OnlineUserEvent;

public abstract class UserUpdateTeamServiceEvent extends OnlineUserEvent {

    public UserUpdateTeamServiceEvent(OnlineUser user) {
        super(user);
    }
}