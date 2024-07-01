package minevalley.core.api.users.events.punishment;

import minevalley.core.api.users.User;
import minevalley.core.api.users.events.UserEvent;


public class UserFreezeEvent extends UserEvent {

    public UserFreezeEvent(User user) {
        super(user);
    }
}