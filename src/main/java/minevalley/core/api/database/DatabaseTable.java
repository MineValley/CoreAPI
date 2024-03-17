package minevalley.core.api.database;

import java.util.List;

@SuppressWarnings("unused")
public interface DatabaseTable {

    /**
     * Gets all entries in the table
     *
     * @return list of all database-entries
     */
    List<DatabaseEntry> getEntries();

    /**
     * Removes all entries from this table
     */
    void clear();

    /**
     * Adds a new entry with the given values into the table
     *
     * @param entries values and their target column
     */
    void addEntry(Value... entries);
}