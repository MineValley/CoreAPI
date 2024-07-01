package minevalley.core.api.users.events.prison;

import lombok.Getter;
import minevalley.core.api.users.User;
import minevalley.core.api.users.events.UserEvent;

/**
 * This event gets called when a user is getting imprisoned.
 */
@Getter
public class UserImprisonmentEvent extends UserEvent {

    public UserImprisonmentEvent(User user) {
        super(user);
    }
}