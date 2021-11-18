package eu.minevalley.core.api;

import eu.minevalley.core.api.database.DatabaseEntry;
import eu.minevalley.core.api.database.DatabaseEntryCollection;
import eu.minevalley.core.api.database.DatabaseTable;
import eu.minevalley.core.api.database.Value;
import eu.minevalley.core.api.helpers.CountdownHelper;
import eu.minevalley.core.api.helpers.EventHelper;
import eu.minevalley.core.api.helpers.RabbitHelper;
import eu.minevalley.core.api.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

public interface CoreServer {

    void registerListeners(Listener listener);

    CountdownHelper getCountdownHelper();

    EventHelper getEventHelper();

    RabbitHelper getRabbitHelper();


    DatabaseEntry databaseEntry(String tableName, ResultSet resultSet, int index);

    DatabaseEntry databaseEntry(String tableName, Value searchValue);


    DatabaseEntryCollection databaseEntryCollection(String tableName, List<DatabaseEntry> entries);

    DatabaseEntryCollection databaseEntryCollection(String tableName, Value searchValue);


    DatabaseTable databaseTable(String tableName);


    ItemBuilder createItem(Material material);

    ItemBuilder createItem(Material material, short data);

    ItemBuilder createItem(Player player);

    ItemBuilder createItem(UUID uniqueId);

    ItemBuilder createItem(String url);
}