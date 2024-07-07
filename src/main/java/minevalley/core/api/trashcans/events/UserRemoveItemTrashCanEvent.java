package minevalley.core.api.trashcans.events;

import lombok.Getter;
import minevalley.core.api.users.User;
import org.bukkit.inventory.ItemStack;

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

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }
}
