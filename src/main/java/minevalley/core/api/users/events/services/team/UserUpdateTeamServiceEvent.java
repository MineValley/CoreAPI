package minevalley.core.api.users.events.services.team;

import minevalley.core.api.users.User;
import minevalley.core.api.users.events.UserEvent;

public abstract class UserUpdateTeamServiceEvent extends UserEvent {

    public UserUpdateTeamServiceEvent(User user) {
        super(user);
    }
}