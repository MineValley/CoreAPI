package minevalley.core.api.crafting;

import minevalley.core.api.Core;
import minevalley.core.api.OnlineUser;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface IndustrialWorkbench {

    /**
     * Mapping of the Shulker-Workbench Item Positions/Orders
     */
    int[][] SHULKER_WORKBENCH_MAPPING = new int[][]{
            {0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4},
            {6, 9}, {7, 10}, {8, 11}, {9, 12}, {10, 13},
            {11, 18}, {12, 19}, {13, 20}, {14, 21}, {15, 22},
            {16, 27}, {17, 28}, {18, 29}, {19, 30}, {20, 31},
            {21, 36}, {22, 37}, {23, 38}, {24, 39}, {25, 40},
            {26, 25} // Output item
    };

    /**
     * Default Workbench-Item
     */
    ItemStack WORKBENCH_ITEM = Core.createItem(Material.PINK_SHULKER_BOX).build();

    /**
     * List with all the content in the Workbench
     *
     * @return Workbench Content
     */
    List<ItemStack> content();

    /**
     * Method to destroy the workbench and drop all items
     */
    void destroy();

    /**
     * Update the workbench to check if new recipes are available
     */
    void update();

    /**
     * Perform the craft in the workbench
     *
     * @param user The user which crafts the item
     */
    void craft(OnlineUser user);

    /**
     * Closes the Workbench and stores the items into the shulker
     *
     * @param user The user to close the workbench
     */
    void close(OnlineUser user);

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
     * @param level Powerlevel of the workbench
     * @ TODO: 24.05.2023 Implementation
     */
    void setPowerLevel(int level);

    /**
     * Gets the workbench power level
     *
     * @return Powerlevel of the workbench
     * @ TODO: 24.05.2023 Implementation
     */
    int getPowerLevel();

}
