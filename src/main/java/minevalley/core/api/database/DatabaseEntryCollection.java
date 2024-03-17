package minevalley.core.api.database;

import java.util.List;

@SuppressWarnings("unused")
public interface DatabaseEntryCollection {

    /**
     * Gets a list of all entries in this collection.
     *
     * @return list of database entries
     */
    List<DatabaseEntry> getEntries();

    /**
     * Removes every single entry of this collection from the database.
     */
    void remove();
}