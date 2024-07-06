package minevalley.core.api.trashcans.events;

import lombok.Getter;
import minevalley.core.api.trashcans.enums.TrashCanInteraction;
import minevalley.core.api.users.User;
import minevalley.core.api.users.events.UserEvent;

/**The {@code UserInteractTrashCanEvent} class represents a user interaction with a trash can.
        * This event is the base class for all trash can interaction events.
 * @see minevalley.core.api.trashcans.events.services.fractions.FractionalClearTrashCanEvent
 * @see minevalley.core.api.trashcans.events.UserAddItemTrashCanEvent
 * @see minevalley.core.api.trashcans.events.UserRemoveItemTrashCanEvent

 */
@Getter
public class UserInteractTrashCanEvent extends UserEvent {

    private final TrashCanInteraction trashCanInteraction;

    /**
     * Constructor for {@code UserInteractTrashCanEvent.}
     * @param user The user interacting with the trash can.
     * @param trashCanInteraction The interaction type with the trash can.
     */
    public UserInteractTrashCanEvent(User user, TrashCanInteraction trashCanInteraction) {
        super(user);
        this.trashCanInteraction = trashCanInteraction;
    }
}
