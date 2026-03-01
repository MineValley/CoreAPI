package minevalley.core.api.user.exceptions;

import lombok.Getter;
import minevalley.core.api.user.User;

import javax.annotation.Nonnull;

/**
 * Exception thrown when a user is not online but an operation requires them to be.
 */
@Getter
public class UserNotOnlineException extends RuntimeException {

    /**
     * The user who is not online.
     */
    private final User user;

    public UserNotOnlineException(@Nonnull User user) {
        super("User " + user.getName() + " is not online.");
        this.user = user;
    }
}