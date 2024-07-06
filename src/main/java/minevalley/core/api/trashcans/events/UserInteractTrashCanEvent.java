package minevalley.core.api.trashcans.events;

import lombok.Getter;
import minevalley.core.api.trashcans.enums.TrashCanInteraction;
import minevalley.core.api.users.User;
import minevalley.core.api.users.events.UserEvent;

@Getter
public class UserInteractTrashCanEvent extends UserEvent {

    private final TrashCanInteraction trashCanInteraction;

    public UserInteractTrashCanEvent(User user, TrashCanInteraction trashCanInteraction) {
        super(user);
        this.trashCanInteraction = trashCanInteraction;
    }
}
