package eu.minevalley.core.api.trashcans.event;

import eu.minevalley.core.api.user.User;
import eu.minevalley.core.api.user.event.UserEvent;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;

/**
 * The {@code UserInteractTrashCanEvent} is triggered on any interaction with a trash can.
 * This event is the base class for all trash can interaction events.
 *
 * @see TrashCanClearEvent
 * @see UserAddItemTrashCanEvent
 * @see UserRemoveItemTrashCanEvent
 */
@Setter
@Getter
public abstract class UserInteractTrashCanEvent extends UserEvent implements Cancellable {

    private final Block block;
    private boolean cancelled;

    /**
     * Constructor for {@code UserInteractTrashCanEvent.}
     *
     * @param user The user interacting with the trash can.
     */
    public UserInteractTrashCanEvent(User user, Block block) {
        super(user);
        this.block = block;
    }
}
