package minevalley.core.api.crafting;

import minevalley.core.api.users.OnlineUser;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface IndustrialWorkbench {

    /**
     * Gets the current workbench content
     * (Only contains the contents of the free slots)
     *
     * @return Workbench Content
     */
    List<ItemStack> getWorkbenchContent();

    /**
     * Destroy the workbench and drop all items
     */
    void destroy();

    /**
     * Update the workbench to check if new recipes are available
     */
    void update();

    /**
     * Perform the craft in the workbench
     *
     */
    void craft();

    /**
     * Closes the Workbench and stores the items into the shulker
     *
     */
    void close();

    /**
     * Open the workbench with the stored items
     *
     * @param user The user to open a workbench
     */
    void open(OnlineUser user);

    /**
     * Gets the inventory of the workbench
     *
     * @return Inventory Instance of the workbench
     */
    Inventory getInventory();

    /**
     * Sets the workbench power level
     *
     * @param level Power level of the workbench
     */
    void setPowerLevel(int level);

    /**
     * Gets the workbench power level
     *
     * @return Powerlevel of the workbench
     */
    int getPowerLevel();

}
