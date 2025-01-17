package minevalley.core.api.users.events.services.support;

import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.events.services.team.UserUpdateTeamServiceEvent;

@SuppressWarnings("unused")
public class UserEnterSupportServiceEvent extends UserUpdateTeamServiceEvent {

    public UserEnterSupportServiceEvent(OnlineUser user) {
        super(user);
    }
}