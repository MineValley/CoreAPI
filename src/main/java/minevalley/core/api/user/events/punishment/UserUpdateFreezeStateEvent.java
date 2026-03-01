package minevalley.core.api.user.events.punishment;

import minevalley.core.api.user.User;
import minevalley.core.api.user.events.UserEvent;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public abstract class UserUpdateFreezeStateEvent extends UserEvent {

    public UserUpdateFreezeStateEvent(@Nonnull User user) {
        super(user);
    }
}