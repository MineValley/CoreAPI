package minevalley.core.api.user.event.punishment;

import minevalley.core.api.user.User;

import javax.annotation.Nonnull;

/**
 * This event gets called when a user is unfreezed.
 */
@SuppressWarnings("unused")
public class UserUnfreezeEvent extends UserUpdateFreezeStateEvent {

    public UserUnfreezeEvent(@Nonnull User user) {
        super(user);
    }
}