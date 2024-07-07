package minevalley.core.api.trashcans.events;

import lombok.Getter;
import minevalley.core.api.users.User;
import org.bukkit.inventory.ItemStack;

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

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }
}
