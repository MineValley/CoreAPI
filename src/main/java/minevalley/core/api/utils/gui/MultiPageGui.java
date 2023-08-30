package minevalley.core.api.utils.gui;

import minevalley.core.api.enums.InterfaceItem;
import minevalley.core.api.users.OnlineUser;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * <b>%i</b> will be replaced with the current page number
 */
public interface MultiPageGui {

    MultiPageGui setTitle(String title);

    MultiPageGui setItem(int slot, GuiItem guiItem);

    MultiPageGui setItem(int slot, ItemStack itemStack);

    MultiPageGui setItem(int slot, InterfaceItem item);

    MultiPageGui setPageDependantItem(int slot, Function<Integer, GuiItem> guiItemGenerator);

    MultiPageGui addItem(GuiItem guiItem);

    MultiPageGui addItem(ItemStack itemStack);

    MultiPageGui addItem(InterfaceItem item);

    MultiPageGui addInterfaceItems(InterfaceItem item, int... slots);

    MultiPageGui addInterfaceItemsInRange(InterfaceItem item, int from, int to);

    MultiPageGui unlockSlots(int... slots);

    MultiPageGui addFillSlots(int... slots);

    MultiPageGui removeFillSlots(int... slots);

    MultiPageGui fillWith(List<GuiItem> guiItems);

    MultiPageGui addCloser();

    MultiPageGui onClose(Consumer<OnlineUser> callback);

    MultiPageGui onClose(BiConsumer<OnlineUser, Inventory> callback);

    MultiPageGui onCloseButton(Consumer<OnlineUser> callback);

    int getSize();

    int getPageAmount();

    default void open(Player player) {
        open(player, 0);
    }

    default void open(OnlineUser user) {
        open(user, 0);
    }

    void open(Player player, int page);

    void open(OnlineUser user, int page);
}