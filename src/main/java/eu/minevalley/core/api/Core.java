package eu.minevalley.core.api;

import com.google.gson.Gson;
import eu.minevalley.core.api.database.DatabaseEntry;
import eu.minevalley.core.api.database.DatabaseEntryCollection;
import eu.minevalley.core.api.database.DatabaseTable;
import eu.minevalley.core.api.database.Value;
import eu.minevalley.core.api.helpers.CountdownHelper;
import eu.minevalley.core.api.helpers.EventHelper;
import eu.minevalley.core.api.helpers.RabbitHelper;
import eu.minevalley.core.api.utils.Countdown;
import eu.minevalley.core.api.utils.ItemBuilder;
import eu.minevalley.core.api.utils.gui.GuiBuilder;
import eu.minevalley.core.api.utils.gui.GuiItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.Metadatable;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public final class Core {

    private static CoreServer server;

    public Core(CoreServer server) {
        Core.server = server;
    }


    public static int scheduleSyncRepeatingTask(long period, long delay, BukkitRunnable runnable) {
        return server.scheduleSyncRepeatingTask(period, delay, runnable);
    }

    public static int scheduleSyncRepeatingTask(long period, long delay, Runnable runnable) {
        return server.scheduleSyncRepeatingTask(period, delay, runnable);
    }

    public static int scheduleAsyncRepeatingTask(long period, long delay, Runnable runnable) {
        return server.scheduleAsyncRepeatingTask(period, delay, runnable);
    }


    public static int scheduleSyncDelayedTask(long delay, BukkitRunnable runnable) {
        return server.scheduleSyncDelayedTask(delay, runnable);
    }

    public static int scheduleSyncDelayedTask(long delay, Runnable runnable) {
        return server.scheduleSyncDelayedTask(delay, runnable);
    }

    public static int scheduleSyncDelayedTask(BukkitRunnable runnable) {
        return server.scheduleSyncDelayedTask(runnable);
    }

    public static int scheduleSyncDelayedTask(Runnable runnable) {
        return server.scheduleSyncDelayedTask(runnable);
    }

    public static int scheduleAsyncDelayedTask(long delay, Runnable runnable) {
        return server.scheduleAsyncDelayedTask(delay, runnable);
    }

    public static int scheduleAsyncDelayedTask(Runnable runnable) {
        return server.scheduleAsyncDelayedTask(runnable);
    }


    public static BukkitTask runTask(Runnable runnable) {
        return server.runTask(runnable);
    }

    public static BukkitTask runTaskAsync(Runnable runnable) {
        return server.runTaskAsync(runnable);
    }


    public static BukkitTask runTaskTimer(long period, long delay, BukkitRunnable runnable) {
        return server.runTaskTimer(period, delay, runnable);
    }

    public static BukkitTask runTaskTimer(long period, long delay, Runnable runnable) {
        return server.runTaskTimer(period, delay, runnable);
    }

    public static BukkitTask runTaskTimerAsync(long period, long delay, BukkitRunnable runnable) {
        return server.runTaskTimerAsync(period, delay, runnable);
    }

    public static BukkitTask runTaskTimerAsync(long period, long delay, Runnable runnable) {
        return server.runTaskTimerAsync(period, delay, runnable);
    }


    public static BukkitTask runTaskLater(long delay, BukkitRunnable runnable) {
        return server.runTaskLater(delay, runnable);
    }

    public static BukkitTask runTaskLater(long delay, Runnable runnable) {
        return server.runTaskLater(delay, runnable);
    }

    public static BukkitTask runTaskLaterAsync(long delay, BukkitRunnable runnable) {
        return server.runTaskLaterAsync(delay, runnable);
    }

    public static BukkitTask runTaskLaterAsync(long delay, Runnable runnable) {
        return server.runTaskLaterAsync(delay, runnable);
    }


    public static boolean isCurrentlyRunning(int taskId) {
        return server.isCurrentlyRunning(taskId);
    }

    public static void cancelTask(int taskId) {
        server.cancelTask(taskId);
    }

    public static void registerListeners(Listener listener) {
        server.registerListeners(listener);
    }

    //

    public static CountdownHelper getCountdownHelper() {
        return server.getCountdownHelper();
    }

    public static EventHelper getEventHelper() {
        return server.getEventHelper();
    }

    public static RabbitHelper getRabbitHelper() {
        return server.getRabbitHelper();
    }

    //

    public static DatabaseEntry databaseEntry(String tableName, ResultSet resultSet, int index) {
        return server.databaseEntry(tableName, resultSet, index);
    }

    public static DatabaseEntry databaseEntry(String tableName, Value searchValue) {
        return server.databaseEntry(tableName, searchValue);
    }

    public static DatabaseEntryCollection databaseEntryCollection(String tableName, List<DatabaseEntry> entries) {
        return server.databaseEntryCollection(tableName, entries);
    }

    public static DatabaseEntryCollection databaseEntryCollection(String tableName, Value searchValue) {
        return server.databaseEntryCollection(tableName, searchValue);
    }

    public static DatabaseTable databaseTable(String tableName) {
        return server.databaseTable(tableName);
    }

    //

    public static void setMetadata(Metadatable metadatable, String key, Object value) {
        server.setMetadata(metadatable, key, value);
    }

    public static void removeMetadata(Metadatable metadatable, String key) {
        server.removeMetadata(metadatable, key);
    }

    public static Object getMetadata(Metadatable metadatable, String key) {
        return server.getMetadata(metadatable, key);
    }

    public static Gson getGson() {
        return server.getGson();
    }

    //

    public static GuiBuilder gui(Inventory inventory) {
        return server.gui(inventory);
    }

    public static GuiBuilder gui(int size) {
        return server.gui(size);
    }

    public static GuiItem guiItem(ItemStack itemStack, Consumer<Player> consumer) {
        return server.guiItem(itemStack, consumer);
    }

    public static Countdown createCountdown() {
        return server.createCountdown();
    }

    public static ItemBuilder createItem(Material material) {
        return server.createItem(material);
    }

    public static ItemBuilder createItem(Material material, short data) {
        return server.createItem(material, data);
    }

    public static ItemBuilder createItem(Player player) {
        return server.createItem(player);
    }

    public static ItemBuilder createItem(UUID uniqueId) {
        return server.createItem(uniqueId);
    }

    public static ItemBuilder createItem(String url) {
        return server.createItem(url);
    }
}