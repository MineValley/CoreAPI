package minevalley.core.api.users.events.services.support;

import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.events.OnlineUserEvent;

@SuppressWarnings("unused")
public abstract class UserUpdateSupportServiceEvent extends OnlineUserEvent {

    public UserUpdateSupportServiceEvent(OnlineUser user) {
        super(user);
    }
}