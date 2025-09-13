package minevalley.core.api.users.events.punishment;

import minevalley.core.api.users.User;
import minevalley.core.api.users.events.UserEvent;

import javax.annotation.Nonnull;

/**
 * This event gets called when a user is freezed.
 */
@SuppressWarnings("unused")
public class UserFreezeEvent extends UserEvent {

    public UserFreezeEvent(@Nonnull User user) {
        super(user);
    }
}