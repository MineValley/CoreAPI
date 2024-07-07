package minevalley.core.api.trashcans.events;

import lombok.Getter;
import lombok.Setter;
import minevalley.core.api.users.User;
import org.bukkit.inventory.ItemStack;

/**
 * The {@code UserAddItemTrashCanEvent} is triggered when a user adds an item to a trash can.
 * This event is only triggered when the action is allowed by the system, for example, when the trash can is not full.
 *
 * @see UserInteractTrashCanEvent
 */
@Setter
@Getter
public class UserAddItemTrashCanEvent extends UserInteractTrashCanEvent {

    private ItemStack itemStack;

    /**
     * Constructor for {@code UserAddItemTrashCanEvent.}
     *
     * @param user      the user performing the interaction
     * @param itemStack the added item
     */
    public UserAddItemTrashCanEvent(User user, ItemStack itemStack) {
        super(user);
        this.itemStack = itemStack;
    }
}
