package minevalley.core.api.trashcans.events;

import lombok.Getter;
import minevalley.core.api.trashcans.enums.TrashCanInteraction;
import minevalley.core.api.users.User;
import org.bukkit.inventory.ItemStack;

@Getter
public class UserAddItemTrashCanEvent extends UserInteractTrashCanEvent {

    private final ItemStack itemStack;

    /**
     * Constructor for {@code UserAddItemTrashCanEvent.}
     * @param user the user performing the interaction
     * @param itemStack the added item
     */
    public UserAddItemTrashCanEvent(User user, ItemStack itemStack) {
        super(user, TrashCanInteraction.ADD_ITEM);
        this.itemStack = itemStack;
    }
}
