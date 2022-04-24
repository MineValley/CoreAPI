package minevalley.core.api.crafting;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import minevalley.core.api.User;
import org.bukkit.inventory.ItemStack;

@Getter
@RequiredArgsConstructor
public class CraftingProcess {

    private final User user;
    private final Recipe recipe;

    @Setter
    private ItemStack result;
}