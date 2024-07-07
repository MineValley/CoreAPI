package minevalley.core.api.trashcans.events;

import lombok.Getter;
import minevalley.core.api.users.User;

/**
 * The {@code FractionalClearTrashCanEvent} is triggered when a trash can is cleared by a user as part of a fractional service.
 * This event is never automatically triggered by the system nor by regular players emptying the trash can.
 *
 * @see UserInteractTrashCanEvent
 */
@Getter
public class TrashCanClearEvent extends UserInteractTrashCanEvent {

    /**
     * Constructor for {@code FractionalClearTrashCanEvent.}
     *
     * @param user the user performing the interaction
     */
    public TrashCanClearEvent(User user) {
        super(user);
    }
}
