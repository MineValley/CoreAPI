package minevalley.core.api.trashcans.events;

import lombok.Getter;
import minevalley.core.api.users.User;
import minevalley.core.api.users.events.UserEvent;
import org.bukkit.event.Cancellable;

/**The {@code UserInteractTrashCanEvent} class represents a user interaction with a trash can.
        * This event is the base class for all trash can interaction events.
 * @see minevalley.core.api.trashcans.events.services.fractions.FractionalClearTrashCanEvent
 * @see minevalley.core.api.trashcans.events.UserAddItemTrashCanEvent
 * @see minevalley.core.api.trashcans.events.UserRemoveItemTrashCanEvent

 */
@Getter
public class UserInteractTrashCanEvent extends UserEvent implements Cancellable {

    private boolean cancelled;

    /**
     * Constructor for {@code UserInteractTrashCanEvent.}
     * @param user The user interacting with the trash can.
     */
    public UserInteractTrashCanEvent(User user) {
        super(user);
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
