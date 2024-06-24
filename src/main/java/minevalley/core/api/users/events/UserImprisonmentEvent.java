package minevalley.core.api.users.events;

import lombok.Getter;
import minevalley.core.api.users.User;

/**
 * This event gets called when a user is getting imprisoned.
 */
@Getter
public class UserImprisonmentEvent extends UserEvent {

    public UserImprisonmentEvent(User user) {
        super(user);
    }
}