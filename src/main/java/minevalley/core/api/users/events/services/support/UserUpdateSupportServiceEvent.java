package minevalley.core.api.users.events.services.support;

import minevalley.core.api.users.User;
import minevalley.core.api.users.events.UserEvent;

public abstract class UserUpdateSupportServiceEvent extends UserEvent {

    public UserUpdateSupportServiceEvent(User user) {
        super(user);
    }
}