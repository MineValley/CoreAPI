package minevalley.core.api;

import com.google.gson.Gson;
import minevalley.core.api.database.DatabaseEntry;
import minevalley.core.api.database.DatabaseEntryCollection;
import minevalley.core.api.database.DatabaseTable;
import minevalley.core.api.database.Value;
import minevalley.core.api.helpers.CountdownHelper;
import minevalley.core.api.helpers.EventHelper;
import minevalley.core.api.helpers.RabbitHelper;
import minevalley.core.api.utils.Countdown;
import minevalley.core.api.utils.EventListener;
import minevalley.core.api.utils.ItemBuilder;
import minevalley.core.api.utils.command.PlayerCommand;
import minevalley.core.api.utils.gui.GuiBuilder;
import minevalley.core.api.utils.gui.GuiItem;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.Metadatable;
import org.bukkit.plugin.Plugin;
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

    /**
     * @deprecated Use {@link  BukkitTask runTaskTimer(long period, long delay, Runnable runnable)}
     * @param period Period in server ticks of the task
     * @param delay Delay in server ticks before executing first repeat
     * @param runnable Task to be executed
     * @return Task id number (-1 if scheduling failed)
     */
    @Deprecated
    public static int scheduleSyncRepeatingTask(long period, long delay, BukkitRunnable runnable) {
        return server.scheduleSyncRepeatingTask(period, delay, runnable);
    }

    /**
     * Schedules a repeating task.
     *
     * This task will be executed by the main server thread.
     * @param period Period in server ticks of the task
     * @param delay Delay in server ticks before executing first repeat
     * @param runnable Task to be executed
     * @return Task id number (-1 if scheduling failed)
     */
    public static int scheduleSyncRepeatingTask(long period, long delay, Runnable runnable) {
        return server.scheduleSyncRepeatingTask(period, delay, runnable);
    }

    /**
     * <b>Asynchronous tasks should never access any API in Bukkit. Great care
     * should be taken to assure the thread-safety of asynchronous tasks.</b>
     * <p>
     * Schedules a repeating task. This task will be executed by a thread
     * managed by the scheduler.
     *
     * @param period Period in server ticks of the task
     * @param delay Delay in server ticks before executing first repeat
     * @param runnable Task to be executed
     * @return Task id number (-1 if scheduling failed)
     * @deprecated This name is misleading, as it does not schedule "a sync"
     *     task, but rather, "an async" task
     */
    public static int scheduleAsyncRepeatingTask(long period, long delay, Runnable runnable) {
        return server.scheduleAsyncRepeatingTask(period, delay, runnable);
    }

    /**
     * @deprecated Use {@link BukkitTask runTaskLater(long delay, Runnable runnable)}
     * @param delay Delay in server ticks before executing task
     * @param runnable Task to be executed
     * @return Task id number (-1 if scheduling failed)
     */
    @Deprecated
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

    public static void registerEvent(Class<? extends Event> cls, EventListener listener) {
        server.registerEvent(cls, listener);
    }

    public static void unregisterEvent(Class<? extends Event> cls, EventListener listener) {
        server.unregisterEvent(cls, listener);
    }

    public static void registerListeners(Listener listener) {
        server.registerListeners(listener);
    }

    public static void registerCommand(PlayerCommand command) {
        server.registerCommand(command);
    }

    public static void sendTeamChatMessage(String message) {
        server.sendTeamChatMessage(message);
    }

    public static void sendTeamChatMessage(BaseComponent message) {
        server.sendTeamChatMessage(message);
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