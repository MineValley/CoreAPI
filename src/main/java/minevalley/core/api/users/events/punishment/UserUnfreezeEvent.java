package minevalley.core.api.users.events.punishment;

import minevalley.core.api.users.User;
import minevalley.core.api.users.events.UserEvent;

/**
 * This event gets called when a user is unfreezed.
 */
@SuppressWarnings("unused")
public class UserUnfreezeEvent extends UserEvent {

    public UserUnfreezeEvent(User user) {
        super(user);
    }
}