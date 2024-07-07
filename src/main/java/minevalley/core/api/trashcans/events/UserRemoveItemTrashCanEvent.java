package minevalley.core.api.trashcans.events;

import lombok.Getter;
import minevalley.core.api.users.User;
import org.bukkit.inventory.ItemStack;

/** The {@code UserRemoveItemTrashCanEvent} is triggered when a user removes an item from a trash can.
 *  This event is only triggered when the action is allowed by the system, for example, when the trash can is not empty.
 *
 * @see UserInteractTrashCanEvent
 */
@Getter
public class UserRemoveItemTrashCanEvent extends UserInteractTrashCanEvent {

    private ItemStack itemStack;

    /**
     * Constructor for {@code UserRemoveItemTrashCanEvent.}
     * @param user the user performing the interaction
     * @param itemStack the removed item
     */
    public UserRemoveItemTrashCanEvent(User user, ItemStack itemStack) {
        super(user);
        this.itemStack = itemStack;
    }

    /**
     * Changes the item stack that was removed from the trash can.
     * @param itemStack the new item stack
     */
    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }
}
