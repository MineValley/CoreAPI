package minevalley.core.api.users.events.punishment;

import minevalley.core.api.users.User;
import minevalley.core.api.users.events.UserEvent;

import javax.annotation.Nonnull;

/**
 * This event gets called when a user is unfreezed.
 */
@SuppressWarnings("unused")
public class UserUnfreezeEvent extends UserEvent {

    public UserUnfreezeEvent(@Nonnull User user) {
        super(user);
    }
}