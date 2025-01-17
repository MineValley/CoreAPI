package minevalley.core.api.users.events.services.team;

import minevalley.core.api.users.OnlineUser;

@SuppressWarnings("unused")
public class UserEnterTeamServiceEvent extends UserUpdateTeamServiceEvent {

    public UserEnterTeamServiceEvent(OnlineUser user) {
        super(user);
    }
}