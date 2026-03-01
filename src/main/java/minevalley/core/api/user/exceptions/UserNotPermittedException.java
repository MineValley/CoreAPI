package minevalley.core.api.user.exceptions;

import lombok.Getter;
import minevalley.core.api.user.User;

import javax.annotation.Nonnull;

/**
 * Exception thrown when a user attempts to perform an action they are not permitted to do.
 */
@Getter
@SuppressWarnings("unused")
public class UserNotPermittedException extends RuntimeException {

    /**
     * The user who is not permitted to perform the action.
     */
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