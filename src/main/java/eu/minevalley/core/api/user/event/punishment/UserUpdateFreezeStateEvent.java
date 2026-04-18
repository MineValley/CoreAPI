package eu.minevalley.core.api.user.event.punishment;

import eu.minevalley.core.api.user.User;
import eu.minevalley.core.api.user.event.UserEvent;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public abstract class UserUpdateFreezeStateEvent extends UserEvent {

    public UserUpdateFreezeStateEvent(@Nonnull User user) {
        super(user);
    }
}