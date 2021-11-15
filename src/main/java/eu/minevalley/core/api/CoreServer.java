package eu.minevalley.core.api;

import eu.minevalley.core.api.database.DatabaseEntry;
import eu.minevalley.core.api.database.DatabaseEntryCollection;
import eu.minevalley.core.api.database.DatabaseTable;
import eu.minevalley.core.api.database.Value;

import java.sql.ResultSet;
import java.util.List;

public interface CoreServer {

    DatabaseEntry databaseEntry(String tableName, ResultSet resultSet, int index);

    DatabaseEntry databaseEntry(String tableName, Value searchValue);


    DatabaseEntryCollection databaseEntryCollection(String tableName, List<DatabaseEntry> entries);

    DatabaseEntryCollection databaseEntryCollection(String tableName, Value searchValue);


    DatabaseTable databaseTable(String tableName);
}