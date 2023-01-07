package minevalley.core.api.database;

import minevalley.core.api.Registrant;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import java.sql.Array;

public interface DatabaseEntry {

    /**
     * Removes the specific database entry from the table.
     */
    void remove();

    /**
     * Checks if the database-entry exists.
     *
     * @return true if the selected database entry exists in the table
     */
    boolean exists();

    /**
     * Changes a value of the selected entry.
     *
     * @param value value object with the column and the new value
     */
    void changeValue(Value value);

    /**
     * Gets the string at the given column.
     *
     * @param column name of the column
     * @return string at given column from the selected database entry
     */
    String getString(String column);

    /**
     * Gets the integer at the given column.
     *
     * @param column name of the column
     * @return integer at given column from the selected database entry
     */
    int getInteger(String column);

    /**
     * Gets the boolean at the given column.
     *
     * @param column name of the column
     * @return boolean at given column from the selected database entry
     */
    boolean getBoolean(String column);

    /**
     * Gets the double at the given column.
     *
     * @param column name of the column
     * @return double at given column from the selected database entry
     */
    double getDouble(String column);

    /**
     * Gets the float at the given column.
     *
     * @param column name of the column
     * @return float at given column from the selected database entry
     */
    float getFloat(String column);

    /**
     * Gets the long at the given column.
     *
     * @param column name of the column
     * @return long at given column from the selected database entry
     */
    long getLong(String column);

    /**
     * Gets the byte at the given column.
     *
     * @param column name of the column
     * @return byte at given column from the selected database entry
     */
    byte getByte(String column);

    /**
     * Gets the array at the given column.
     *
     * @param column name of the column
     * @return array at given column from the selected database entry
     */
    Array getArray(String column);

    /**
     * Gets the location at the given column (with pitch & yaw).
     *
     * @param column name of the column
     * @return location at given column from the selected database entry
     */
    Location getLocation(String column);

    /**
     * Gets the block at the given column.
     *
     * @param column name of the column
     * @return block at given column from the selected database entry
     */
    Block getBlock(String column);

    /**
     * Gets the registrant at the given column.
     *
     * @param column name of the column
     * @return registrant at given column from the selected database entry
     */
    Registrant getRegistrant(String column);

    /**
     * Gets the itemstack at the given column.
     *
     * @param column name of the column
     * @return itemstack at given column from the selected database entry
     */
    ItemStack getItemStack(String column);

    /**
     * Gets the itemstack[] at the given column.
     *
     * @param column name of the column
     * @return itemstack[] at given column from the selected database entry
     */
    ItemStack[] getItemStacks(String column);
}