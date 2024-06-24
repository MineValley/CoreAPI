package minevalley.core.api.users.events;

import minevalley.core.api.users.User;


public class UserFreezeEvent extends UserEvent {

    public UserFreezeEvent(User user) {
        super(user);
    }
}