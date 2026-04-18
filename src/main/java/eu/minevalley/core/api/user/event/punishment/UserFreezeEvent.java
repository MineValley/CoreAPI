package eu.minevalley.core.api.user.event.punishment;

import eu.minevalley.core.api.user.User;

import javax.annotation.Nonnull;

/**
 * This event gets called when a user is freezed.
 */
@SuppressWarnings("unused")
public class UserFreezeEvent extends UserUpdateFreezeStateEvent {

    public UserFreezeEvent(@Nonnull User user) {
        super(user);
    }
}