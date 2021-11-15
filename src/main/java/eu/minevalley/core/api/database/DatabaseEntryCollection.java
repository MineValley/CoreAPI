package eu.minevalley.core.api.database;

import java.util.List;

public interface DatabaseEntryCollection {

    List<DatabaseEntry> getEntries();

    void remove();
}