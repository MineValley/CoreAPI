package minevalley.core.api.users.events;

import minevalley.core.api.users.User;

/**
 * This event gets called when a user is unfreezed.
 */
public class UserUnfreezeEvent extends UserEvent {

    public UserUnfreezeEvent(User user) {
        super(user);
    }
}