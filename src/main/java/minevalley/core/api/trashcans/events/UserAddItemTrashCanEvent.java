package minevalley.core.api.trashcans.events;

import lombok.Getter;
import minevalley.core.api.users.User;
import org.bukkit.inventory.ItemStack;

/** The {@code UserAddItemTrashCanEvent} is triggered when a user adds an item to a trash can.
 *  This event is only triggered when the action is allowed by the system, for example, when the trash can is not full.
 *
 * @see UserInteractTrashCanEvent
 */
@Getter
public class UserAddItemTrashCanEvent extends UserInteractTrashCanEvent {

    private ItemStack itemStack;

    /**
     * Constructor for {@code UserAddItemTrashCanEvent.}
     * @param user the user performing the interaction
     * @param itemStack the added item
     */
    public UserAddItemTrashCanEvent(User user, ItemStack itemStack) {
        super(user);
        this.itemStack = itemStack;
    }

    /**
     * Changes the item stack that was added to the trash can.
     * @param itemStack the new item stack
     */
    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }
}
