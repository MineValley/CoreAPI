package eu.minevalley.core.api.database;

import java.util.List;

public interface DatabaseTable {

    List<DatabaseEntry> getEntries();

    void clear();

    void addEntry(Value... entries);
}