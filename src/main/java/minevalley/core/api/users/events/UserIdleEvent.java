package minevalley.core.api.users.events;

import minevalley.core.api.users.User;

/**
 * This event gets called when a user is marked as idle (afk).
 */
public class UserIdleEvent extends UserEvent {

    public UserIdleEvent(User user) {
        super(user);
    }
}