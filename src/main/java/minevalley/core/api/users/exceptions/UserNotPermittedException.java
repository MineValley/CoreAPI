package minevalley.core.api.users.exceptions;

import lombok.Getter;
import minevalley.core.api.users.User;

import javax.annotation.Nonnull;

@Getter
@SuppressWarnings("unused")
public class UserNotPermittedException extends RuntimeException {

    private final User user;

    public UserNotPermittedException(@Nonnull User user) {
        super("User " + user.getName() + " is not permitted to perform this action.");
        this.user = user;
    }

    public UserNotPermittedException(@Nonnull User user, @Nonnull String message) {
        super(message);
        this.user = user;
    }
}