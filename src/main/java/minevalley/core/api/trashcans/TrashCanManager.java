package minevalley.core.api.trashcans;

import lombok.Setter;
import minevalley.core.api.Depends;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

/**
 * This manager is handled by another module! Do not change the manager-attribute.
 * <br>
 * Due to the circumstance that your module might load before this manager's handler, it is necessary not to call any
 * of the functions below on module start without using a scheduler!
 */
@Depends("TrashCans")
public class TrashCanManager {

    @Setter
    private static Manager manager;

    /**
     * Adds new ItemStack to the trash can. If the trash can is full, the operation will be cancelled.
     * <p>
     *
     * @param block     the block of the trash can
     * @param itemStack the item to add
     *                  <p><b>Note:</b> If the {@code amount} of the {@code itemStack} is greater than 1, the item will be split into multiple ItemStacks.</p>
     * @throws IllegalArgumentException  if the block is not a trash can
     */
    public static void addItem(Block block, ItemStack itemStack) throws IllegalArgumentException  {
        manager.addItem(block, itemStack);
    }

    /**
     * Removes an ItemStack from the trash can. If the trash can is empty, the operation will be cancelled.
     * <br>
     * <p>
     * <b>Note:</b> Every replica of the ItemStack will be removed. The order or the amount of the ItemStacks in the TrashCan does not matter.
     *
     * @throws IllegalArgumentException if the block is not a trash can
     */
    public static void removeItem(Block block, ItemStack itemStack) throws IllegalArgumentException  {
        manager.removeItem(block, itemStack);
    }

    /**
     * Clears the trash can at given block.
     *
     * @param block the block of the trash can
     * @throws IllegalArgumentException if the block is not a trash can
     */
    public static void clear(Block block) throws IllegalArgumentException  {
        manager.clear(block);
    }

    /**
     * Returns the nearest trash can to the given location.
     *
     * @param location the location to search from
     * @return the nearest trash can
     */
    public static Block getNearestTrashCan(Location location) {
        return manager.getNearestTrashCan(location);
    }

    /**
     * Returns the peak ItemStack of the trash can.
     *
     * @param block the block of the trash can
     * @return the peak ItemStack - if empty {@code null} will be returned.
     * @throws IllegalArgumentException if the block is not a trash can
     */
    public static ItemStack getPeak(Block block) throws IllegalArgumentException  {
        return manager.getPeak(block);
    }

    /**
     * Returns whether the given block is a trash can.
     *
     * @param block the block to check
     * @return {@code true} if the block is a trash can, {@code false} otherwise
     */
    public static boolean isTrashCan(Block block) {
        return manager.isTrashCan(block);
    }

    /**
     * Returns whether the trash can is full.
     *
     * @param block the block of the trash can
     * @return {@code true} if the trash can is full, {@code false} otherwise
     * @throws IllegalArgumentException if the block is not a trash can
     */
    public static boolean isFull(Block block) throws IllegalArgumentException  {
        return manager.isFull(block);
    }

    /**
     * Returns whether the trash can is empty.
     *
     * @param block the block of the trash can
     * @return {@code true} if the trash can is empty, {@code false} otherwise
     * @throws IllegalArgumentException if the block is not a trash can
     */
    public static boolean isEmpty(Block block) throws IllegalArgumentException  {
        return manager.isEmpty(block);
    }

    public interface Manager {

        void addItem(Block block, ItemStack itemStack);

        void removeItem(Block block, ItemStack itemStack);

        void clear(Block block);

        Block getNearestTrashCan(Location location);

        ItemStack getPeak(Block block);

        boolean isTrashCan(Block block);

        boolean isFull(Block block);

        boolean isEmpty(Block block);

    }
}
