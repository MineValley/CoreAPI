package minevalley.core.api.users.events.services.team;

import minevalley.core.api.users.OnlineUser;

@SuppressWarnings("unused")
public class UserLeaveTeamServiceEvent extends UserUpdateTeamServiceEvent {

    public UserLeaveTeamServiceEvent(OnlineUser user) {
        super(user);
    }
}