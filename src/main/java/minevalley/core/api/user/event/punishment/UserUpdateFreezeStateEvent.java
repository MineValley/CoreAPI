package minevalley.core.api.user.event.punishment;

import minevalley.core.api.user.User;
import minevalley.core.api.user.event.UserEvent;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public abstract class UserUpdateFreezeStateEvent extends UserEvent {

    public UserUpdateFreezeStateEvent(@Nonnull User user) {
        super(user);
    }
}