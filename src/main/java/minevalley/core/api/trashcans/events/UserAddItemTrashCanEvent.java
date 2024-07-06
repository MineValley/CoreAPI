package minevalley.core.api.trashcans.events;

import lombok.Getter;
import minevalley.core.api.trashcans.enums.TrashCanInteraction;
import minevalley.core.api.users.User;
import org.bukkit.inventory.ItemStack;

@Getter
public class UserAddItemTrashCanEvent extends UserInteractTrashCanEvent {

    private final ItemStack itemStack;

    public UserAddItemTrashCanEvent(User user, TrashCanInteraction trashCanInteraction, ItemStack itemStack) {
        super(user, trashCanInteraction);
        this.itemStack = itemStack;
    }
}
