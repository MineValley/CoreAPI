package minevalley.core.api.users.exceptions;

import lombok.Getter;
import minevalley.core.api.users.User;

import javax.annotation.Nonnull;

@Getter
public class UserNotOnlineException extends RuntimeException {

    private final User user;

    public UserNotOnlineException(@Nonnull User user) {
        super("User " + user.getName() + " is not online.");
        this.user = user;
    }
}