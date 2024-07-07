package minevalley.core.api.trashcans.events.services.fractions;

import lombok.Getter;
import minevalley.core.api.trashcans.events.UserInteractTrashCanEvent;
import minevalley.core.api.users.User;

@Getter
public class FractionalClearTrashCanEvent extends UserInteractTrashCanEvent {

    /**
     * Constructor for {@code FractionalClearTrashCanEvent.}
     * @param user the user performing the interaction
     */
    public FractionalClearTrashCanEvent(User user) {
        super(user);
    }
}
