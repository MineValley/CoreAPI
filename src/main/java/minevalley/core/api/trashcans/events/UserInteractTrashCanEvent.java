package minevalley.core.api.trashcans.events;

import lombok.Getter;
import minevalley.core.api.users.User;
import minevalley.core.api.users.events.UserEvent;
import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;

/**
 * The {@code UserInteractTrashCanEvent} is triggered on any interaction with a trash can.
 * This event is the base class for all trash can interaction events.
 *
 * @see minevalley.core.api.trashcans.events.TrashCanClearEvent
 * @see minevalley.core.api.trashcans.events.UserAddItemTrashCanEvent
 * @see minevalley.core.api.trashcans.events.UserRemoveItemTrashCanEvent
 */
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

    /**
     * Returns whether the event is cancelled.
     *
     * @return {@code true} if the event is cancelled, {@code false} otherwise.
     */
    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Sets whether the event is cancelled.
     *
     * @param cancel {@code true} to cancel the event, {@code false} otherwise.
     */
    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
