package minevalley.core.api.trashcans.events.services.fractions;

import lombok.Getter;
import minevalley.core.api.trashcans.enums.TrashCanInteraction;
import minevalley.core.api.trashcans.events.UserInteractTrashCanEvent;
import minevalley.core.api.users.User;

@Getter
public class FractionalClearTrashCanEvent extends UserInteractTrashCanEvent {

    public FractionalClearTrashCanEvent(User user, TrashCanInteraction trashCanInteraction) {
        super(user, trashCanInteraction);
    }
}
