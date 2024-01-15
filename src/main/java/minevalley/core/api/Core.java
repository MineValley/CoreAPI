package minevalley.core.api;

import com.google.gson.Gson;
import lombok.NonNull;
import minevalley.core.api.corporations.Group;
import minevalley.core.api.corporations.StateCompany;
import minevalley.core.api.corporations.business.Aktiengesellschaft;
import minevalley.core.api.corporations.business.Einzelunternehmen;
import minevalley.core.api.corporations.business.Kapitalgesellschaft;
import minevalley.core.api.corporations.business.Personengesellschaft;
import minevalley.core.api.database.DatabaseEntry;
import minevalley.core.api.database.DatabaseEntryCollection;
import minevalley.core.api.database.DatabaseTable;
import minevalley.core.api.database.Value;
import minevalley.core.api.economy.BankAccount;
import minevalley.core.api.enums.DebugType;
import minevalley.core.api.enums.InterfaceItem;
import minevalley.core.api.enums.Server;
import minevalley.core.api.modulepipeline.Container;
import minevalley.core.api.modulepipeline.PipelineReceiver;
import minevalley.core.api.phone.Telephone;
import minevalley.core.api.regions.*;
import minevalley.core.api.timing.Reminder;
import minevalley.core.api.timing.RepeatingTimer;
import minevalley.core.api.timing.Timer;
import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.User;
import minevalley.core.api.utils.EventListener;
import minevalley.core.api.utils.*;
import minevalley.core.api.utils.armorstand.FakeArmorStand;
import minevalley.core.api.utils.command.PlayerCommand;
import minevalley.core.api.utils.gui.GuiBuilder;
import minevalley.core.api.utils.gui.GuiItem;
import minevalley.core.api.utils.gui.MultiPageGui;
import minevalley.smart.api.Session;
import minevalley.smart.api.SmartApp;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import org.apache.logging.log4j.util.TriConsumer;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.Metadatable;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public final class Core {

    private static CoreServer server;

    public Core(CoreServer server) {
        Core.server = server;
    }

    public static JavaPlugin getInstance() {
        return server.getInstance();
    }

    public static int runSyncTaskNow(String taskName, Runnable runnable) {
        return runSyncTaskLater(taskName, 0, runnable);
    }

    public static int runAsyncTaskNow(String taskName, Runnable runnable) {
        return runAsyncTaskLater(taskName, 0, runnable);
    }

    public static int runSyncTaskLater(String taskName, long delay, Runnable runnable) {
        return server.runSyncTaskLater(taskName, delay, runnable);
    }

    public static int runAsyncTaskLater(String taskName, long delay, Runnable runnable) {
        return server.runAsyncTaskLater(taskName, delay, runnable);
    }

    public static int runSyncTaskPeriodically(String taskName, long delay, long period, Runnable runnable) {
        return server.runSyncTaskPeriodically(taskName, delay, period, runnable);
    }

    public static int runAsyncTaskPeriodically(String taskName, long delay, long period, Runnable runnable) {
        return server.runAsyncTaskPeriodically(taskName, delay, period, runnable);
    }

    /**
     * Check if the task currently running.
     * <p>
     * A repeating task might not be running currently, but will be running in
     * the future. A task that has finished, and does not repeat, will not be
     * running ever again.
     * <p>
     * Explicitly, a task is running if there exists a thread for it, and that
     * thread is alive.
     *
     * @param taskId The task to check.
     * @return If the task is currently running.
     */
    public static boolean isCurrentlyRunning(int taskId) {
        return server.isCurrentlyRunning(taskId);
    }

    /**
     * Removes task from scheduler.
     *
     * @param taskId Id number of task to be removed
     */
    public static void cancelTask(int taskId) {
        server.cancelTask(taskId);
    }

    /**
     * @param cls      class of event
     * @param listener listener to register
     * @deprecated use {@link #registerListener(Class, EventListener)} instead!
     */
    @Deprecated
    public static void registerEvent(Class<? extends Event> cls, EventListener listener) {
        server.registerListener(cls, listener);
    }

    public static void registerListener(Class<? extends Event> cls, EventListener<? extends Event> listener) {
        server.registerListener(cls, listener);
    }

    /**
     * @param cls      class of event
     * @param listener listener to unregister
     * @deprecated use {@link #unregisterListener(Class, EventListener)} instead!
     */
    @Deprecated
    public static void unregisterEvent(Class<? extends Event> cls, EventListener listener) {
        server.unregisterListener(cls, listener);
    }

    public static void unregisterListener(Class<? extends Event> cls, EventListener<? extends Event> listener) {
        server.unregisterListener(cls, listener);
    }

    /**
     * @param listener listener to register
     * @deprecated use {@link #registerListener(Listener)} instead!
     */
    @Deprecated
    public static void registerListeners(Listener listener) {
        server.registerListener(listener);
    }

    public static void registerListener(Listener listener) {
        server.registerListener(listener);
    }

    public static void registerPipeline(PipelineReceiver pipelineReceiver) {
        server.registerPipelineReceiver(pipelineReceiver);
    }

    public static void sendPipelineContainer(String pipelineName, Container container) {
        server.sendPipelineContainer(pipelineName, container);
    }

    public static void registerCommand(PlayerCommand command) {
        server.registerCommand(command);
    }

    /**
     * Sends a message to all online team-members
     *
     * @param message message as string
     */
    public static void sendTeamChatMessage(String message) {
        server.sendTeamChatMessage(message);
    }

    /**
     * Sends a message to all online team-members
     *
     * @param message message as base-component (useful for clickable messages)
     */
    public static void sendTeamChatMessage(BaseComponent[] message) {
        server.sendTeamChatMessage(message);
    }

    public static void sendDebug(DebugType type, String message) {
        server.sendDebug(type, removeColorCodes(message));
    }

    /**
     * Gets the specific database-entry from the specified table with the specified value in the column.
     * If there are more than one entry, that math the given description, this gets the first one.
     * If you want to get multiple entries, use database-collection, or database-table!
     *
     * @param tableName   name of the table as string
     * @param searchValue value according to which the entries are filtered in a specific column
     * @return the first database-entry that matches the given description
     */
    public static DatabaseEntry getDatabaseEntry(String tableName, Value searchValue) {
        return server.getDatabaseEntry(tableName, searchValue);
    }

    /**
     * Gets the specific database-entry from the specified table with the specified value in the column.
     * If there are more than one entry, that math the given description, this gets the first one.
     * If you want to get multiple entries, use database-collection, or database-table!
     *
     * @param tableName    name of the table as string
     * @param searchValues value according to which the entries are filtered in a specific column
     * @return the first database-entry that matches the given description
     */
    public static DatabaseEntry getDatabaseEntryAnd(String tableName, Value... searchValues) {
        return server.getDatabaseEntryAnd(tableName, searchValues);
    }

    /**
     * Gets the specific database-entry from the specified table with the specified value in the column.
     * If there are more than one entry, that math the given description, this gets the first one.
     * If you want to get multiple entries, use database-collection, or database-table!
     *
     * @param tableName    name of the table as string
     * @param searchValues value according to which the entries are filtered in a specific column
     * @return the first database-entry that matches the given description
     */
    public static DatabaseEntry getDatabaseEntryOr(String tableName, Value... searchValues) {
        return server.getDatabaseEntryOr(tableName, searchValues);
    }

    /**
     * Gets a database-collection from the specified table with the specified value in the column.
     * This gets all the entries that match the description. If you're searching for one single entry, use database-entry!
     *
     * @param tableName   name of the table as string
     * @param searchValue value according to which the entries are filtered in a specific column
     * @return a collection of all database-entries in this table, that matches the given description
     */
    public static DatabaseEntryCollection getDatabaseEntryCollection(String tableName, Value searchValue) {
        return server.getDatabaseEntryCollection(tableName, searchValue);
    }

    /**
     * Gets a database-collection from the specified table with the specified value in the column.
     * This gets all the entries that match the description. If you're searching for one single entry, use database-entry!
     *
     * @param tableName    name of the table as string
     * @param searchValues value according to which the entries are filtered in a specific column
     * @return a collection of all database-entries in this table, that matches the given description
     */
    public static DatabaseEntryCollection getDatabaseEntryCollectionAnd(String tableName, Value... searchValues) {
        return server.getDatabaseEntryCollectionAnd(tableName, searchValues);
    }

    /**
     * Gets a database-collection from the specified table with the specified value in the column.
     * This gets all the entries that match the description. If you're searching for one single entry, use database-entry!
     *
     * @param tableName    name of the table as string
     * @param searchValues value according to which the entries are filtered in a specific column
     * @return a collection of all database-entries in this table, that matches the given description
     */
    public static DatabaseEntryCollection getDatabaseEntryCollectionOr(String tableName, Value... searchValues) {
        return server.getDatabaseEntryCollectionOr(tableName, searchValues);
    }

    /**
     * Gets the database-table with the specific name.
     *
     * @param tableName name of the database-table
     * @return database-table with specific name
     */
    public static DatabaseTable getDatabaseTable(String tableName) {
        return server.getDatabaseTable(tableName);
    }

    /**
     * Sets the setting with the given key.
     * <p>
     * <b>Note:</b> When using the settings-method, do never change the settings manually via database!
     *
     * @param key   string of the key
     * @param value string of the (new) value
     */
    public static void setSetting(String key, String value) {
        server.setSetting(key, value);
    }

    /**
     * Gets the settings with the specific key.
     *
     * @param key string of the key with which the setting is saved
     * @return setting as string from the specific key
     */
    public static String getSetting(String key) {
        return server.getSetting(key);
    }


    /**
     * Gets the settings with the specific key.
     *
     * @param key          string of the key with which the setting is saved
     * @param defaultValue value that is returned, if the setting is null
     * @return setting as string from the specific key
     */
    public static String getSetting(String key, String defaultValue) {
        return Optional.ofNullable(server.getSetting(key)).orElse(defaultValue);
    }

    /**
     * Updates a statistic with the given key.
     * <p>
     * <b>Note:</b> When using the stats-method, do never change the settings manually via database!
     *
     * @param key   string of the key
     * @param value double of the (new) value
     */
    public static void updateStatistic(String key, double value) {
        server.updateStatistic(key, value);
    }

    /**
     * Gets the statistic with the specific key.
     *
     * @param key string of the key with which the statistic is saved
     * @return statistic as double from the specific key
     */
    public static double getStatistic(String key) {
        return server.getStatistic(key);
    }

    /**
     * Adds this object as a metadata to the metadatable object.
     *
     * @param metadatable object to which the metadata should be added
     * @param key         key under which the metadata can be found
     * @param value       object to be added as metadata
     */
    public static void setMetadata(Metadatable metadatable, String key, Object value) {
        server.setMetadata(metadatable, key, value);
    }

    /**
     * Removes all metadata-objects with the given key from the specific metadatable object.
     *
     * @param metadatable object from which the metadata should be removed
     * @param key         object
     */
    public static void removeMetadata(Metadatable metadatable, String key) {
        server.removeMetadata(metadatable, key);
    }

    /**
     * Gets a list of all metadata-values in link to the object.
     *
     * @param metadatable object to get linked data from
     * @param key         key of the metadata
     * @return list of all metadata-values
     */
    public static List<MetadataValue> getMetadata(Metadatable metadatable, String key) {
        return server.getMetadata(metadatable, key);
    }

    /**
     * Gets a players user object
     *
     * @param uniqueId uniqueId to get user from
     * @return user object of the given uniqueId
     */
    public static User getUser(String uniqueId) {
        return server.getUser(uniqueId);
    }

    public static OnlineUser getOnlineUser(Player player) {
        return server.getOnlineUser(player);
    }

    public static OnlineUser getOnlineUser(Session session) {
        return server.getOnlineUser(session);
    }

    /**
     * Gets the name of the player with the specific unique id
     *
     * @param uniqueId unique id of the player
     * @return name of the player
     */
    public static String getName(String uniqueId) {
        return server.getName(uniqueId);
    }

    /**
     * Gets the unique id of the player with the specific name
     *
     * @param name name of the player
     * @return unique id of the player
     */
    public static String getUniqueId(String name) {
        return server.getUniqueId(name);
    }

    /**
     * Removes the color-codes from a given string
     *
     * @param text string which could contain color-codes
     * @return string without any color-codes
     */
    public static String removeColorCodes(String text) {
        return server.removeColorCodes(text);
    }

    /**
     * Converts chat-color-codes to normal color-codes (&amp; -> &sect;)
     *
     * @param text string which could contain chat-color-codes
     * @return string with converted color-codes
     */
    public static String convertColorCodes(String text) {
        return server.convertColorCodes(text);
    }

    /**
     * Checks whether the given string contains a forbidden word.
     *
     * @param text text to check
     * @return true, if string contains forbidden words
     */
    public static boolean containsForbiddenWords(String text) {
        return server.containsForForbiddenWords(text);
    }

    /**
     * Creates a {@link Gson} instance that fits in a page for pretty printing.
     * Use this, to convert json-strings to specific objects and vice versa.
     *
     * @return an instance of Gson configured that fits in a page for pretty printing
     */
    public static Gson getGson() {
        return server.getGson();
    }

    /**
     * Gets a random integer with the given length.
     *
     * @param chars number of chars
     * @return random integer
     */
    public static int getRandomInteger(int chars) {
        return server.randomInteger(chars);
    }

    /**
     * Checks whether the given string is numeric and can be converted to an integer.
     * <p>
     * <b>Note:</b> This method also checks whether the integer exceeds the maximum value for integers.
     *
     * @param string string to verify
     * @return true, if the given string is numeric
     */
    public static boolean isInteger(String string) {
        return server.isInteger(string);
    }

    /**
     * Verifies that the given string is numeric and can be converted to a double.
     *
     * @param string string to verify
     * @return true, if the given string is numeric
     */
    public static boolean isDouble(String string) {
        return server.isDouble(string);
    }

    /**
     * Creates a readable string of the specific amount of money.
     *
     * @param amountInCents amount to convert
     * @return amount as x.xxx.xxx,xx€
     */
    public static String formatMoney(int amountInCents) {
        return server.formatMoney(amountInCents);
    }

    public static String getFormattedDate(long time) {
        return new SimpleDateFormat("dd. MMMM yyyy - HH:mm", Locale.GERMANY).format(new Date(time)) + " Uhr";
    }

    public static String formatRelativeTimestamp(long timestamp) {
        return server.formatRelativeTimestamp(timestamp);
    }

    public static String getCurrentTimeFormatted() {
        return getFormattedDate(System.currentTimeMillis());
    }

    public static String getCurrentDayTimeFormatted() {
        return getFormattedTime(System.currentTimeMillis());
    }

    public static String getFormattedTime(long time) {
        return new SimpleDateFormat("HH:mm", Locale.GERMANY).format(new Date(time)) + " Uhr";
    }

    /**
     * Creates new gui-builder with the specific size.
     *
     * @param size size of the inventory (has to be a multiple of 9)
     * @return new gui-builder
     */
    public static GuiBuilder createGui(int size) {
        return server.createGui(size);
    }

    public static MultiPageGui createMultiPageGui(int size) {
        return server.createMultiPageGui(size);
    }

    /**
     * Creates new gui-item, based on a specific itemstack with a specific callback.
     * Gui-items can be added to inventory-guis (built by gui-builder). If a player clicks the gui-item, the callback is called with the player-object.
     *
     * @param itemStack item which should be displayed in the inventory
     * @param consumer  consumer which gets called if a player clicks the item
     * @return gui-item-object to add to the gui-builder
     */
    public static GuiItem createGuiItem(ItemStack itemStack, Consumer<OnlineUser> consumer) {
        return server.createGuiItem(itemStack, consumer);
    }

    /**
     * Creates new gui-item, based on a specific itemstack with a specific callback.
     * Gui-items can be added to inventory-guis (built by gui-builder). If a player clicks the gui-item, the callback is called with the player-object.
     *
     * @param itemBuilder item which should be displayed in the inventory
     * @param consumer    consumer which gets called if a player clicks the item
     * @return gui-item-object to add to the gui-builder
     */
    public static GuiItem createGuiItem(ItemBuilder itemBuilder, Consumer<OnlineUser> consumer) {
        return server.createGuiItem(itemBuilder.build(), consumer);
    }

    /**
     * Creates new gui-item, based on a specific itemstack with a specific callback.
     * Gui-items can be added to inventory-guis (built by gui-builder). If a player clicks the gui-item, the callback is called with the player-object.
     *
     * @param item     item which should be displayed in the inventory
     * @param consumer consumer which gets called if a player clicks the item
     * @return gui-item-object to add to the gui-builder
     */
    public static GuiItem createGuiItem(InterfaceItem item, Consumer<OnlineUser> consumer) {
        return server.createGuiItem(item.toItemStack(), consumer);
    }

    /**
     * Creates new gui-item, based on a specific itemstack with a specific callback.
     * Gui-items can be added to inventory-guis (built by gui-builder). If a player clicks the gui-item, the callback is called with the player-object.
     *
     * @param itemStack item which should be displayed in the inventory
     * @param consumer  consumer which gets called if a player clicks the item
     * @return gui-item-object to add to the gui-builder
     */
    public static GuiItem createGuiItem(ItemStack itemStack, BiConsumer<OnlineUser, ClickType> consumer) {
        return server.createAdvancedGuiItem(itemStack, consumer);
    }

    /**
     * Creates new gui-item, based on a specific itemstack with a specific callback.
     * Gui-items can be added to inventory-guis (built by gui-builder). If a player clicks the gui-item, the callback is called with the player-object.
     *
     * @param itemBuilder item which should be displayed in the inventory
     * @param consumer    consumer which gets called if a player clicks the item
     * @return gui-item-object to add to the gui-builder
     */
    public static GuiItem createGuiItem(ItemBuilder itemBuilder, BiConsumer<OnlineUser, ClickType> consumer) {
        return server.createAdvancedGuiItem(itemBuilder.build(), consumer);
    }

    /**
     * Creates new gui-item, based on a specific itemstack with a specific callback.
     * Gui-items can be added to inventory-guis (built by gui-builder). If a player clicks the gui-item, the callback is called with the player-object.
     *
     * @param item     item which should be displayed in the inventory
     * @param consumer consumer which gets called if a player clicks the item
     * @return gui-item-object to add to the gui-builder
     */
    public static GuiItem createGuiItem(InterfaceItem item, BiConsumer<OnlineUser, ClickType> consumer) {
        return server.createAdvancedGuiItem(item.toItemStack(), consumer);
    }

    /**
     * Creates new gui-item, based on a specific itemstack with a specific callback.
     * Gui-items can be added to inventory-guis (built by gui-builder). If a player clicks the gui-item, the callback is called with the player-object.
     *
     * @param itemStack item which should be displayed in the inventory
     * @param consumer  consumer which gets called if a player clicks the item
     * @return gui-item-object to add to the gui-builder
     */
    public static GuiItem createGuiItem(ItemStack itemStack, TriConsumer<OnlineUser, ClickType, Inventory> consumer) {
        return server.createAdvancedGuiItem(itemStack, consumer);
    }

    /**
     * Creates new gui-item, based on a specific itemstack with a specific callback.
     * Gui-items can be added to inventory-guis (built by gui-builder). If a player clicks the gui-item, the callback is called with the player-object.
     *
     * @param itemBuilder item which should be displayed in the inventory
     * @param consumer    consumer which gets called if a player clicks the item
     * @return gui-item-object to add to the gui-builder
     */
    public static GuiItem createGuiItem(ItemBuilder itemBuilder, TriConsumer<OnlineUser, ClickType, Inventory> consumer) {
        return server.createAdvancedGuiItem(itemBuilder.build(), consumer);
    }

    /**
     * Creates new gui-item, based on a specific itemstack with a specific callback.
     * Gui-items can be added to inventory-guis (built by gui-builder). If a player clicks the gui-item, the callback is called with the player-object.
     *
     * @param item     item which should be displayed in the inventory
     * @param consumer consumer which gets called if a player clicks the item
     * @return gui-item-object to add to the gui-builder
     */
    public static GuiItem createGuiItem(InterfaceItem item, TriConsumer<OnlineUser, ClickType, Inventory> consumer) {
        return server.createAdvancedGuiItem(item.toItemStack(), consumer);
    }

    /**
     * Creates new gui-item, based on a specific itemstack without any callback.
     * Gui-items can be added to inventory-guis (built by gui-builder). If a player clicks the gui-item, the callback is called with the player-object.
     *
     * @param itemStack item which should be displayed in the inventory (use item-builder to create this item)
     * @return gui-item-object to add to the gui-builder
     */
    public static GuiItem createGuiItem(ItemStack itemStack) {
        return server.createGuiItem(itemStack, null);
    }

    /**
     * Creates new countdown-object.
     * Note: Don't use this method to realize cooldowns for player-actions. Use schedulers instead!
     *
     * @return new countdown-object
     */
    public static Countdown createCountdown() {
        return server.createCountdown();
    }

    /**
     * Starts the specific countdown.
     *
     * @param countdown countdown to start
     */
    public static void startCountdown(Countdown countdown) {
        server.startCountdown(countdown);
    }

    /**
     * Stops the specific countdown.
     *
     * @param countdown countdown to stop
     */
    public static void stopCountdown(Countdown countdown) {
        server.stopCountdown(countdown);
    }

    /**
     * Gets the servers main map.
     *
     * @return main map
     */
    public static World getMainWorld() {
        return Bukkit.getWorld("world");
    }

    /**
     * Gets the building map.
     *
     * @return building map
     */
    public static World getBuildingWorld() {
        return Bukkit.getWorld("bauteam");
    }

    public static World getPreBuildWorld() {
        return Bukkit.getWorld("prebuild");
    }

    public static World getPresetsWorld() {
        return Bukkit.getWorld("presets");
    }

    public static World getMineWorld() {
        return Bukkit.getWorld("mine");
    }

    public static World getDefaultMineWorld() {
        return Bukkit.getWorld("default_mine");
    }

    /**
     * Gets the shadow map.
     *
     * @return shadow map
     */
    public static World getShadowWorld() {
        return Bukkit.getWorld("shadow");
    }

    public static void transferFromShadowWorld(Area... areas) {
        server.transferFromShadow(areas);
    }

    public static void loadPreset(Area presetArea, Block presetPivot, Block mainWorldPivot) {
        server.loadPreset(presetArea, presetPivot, mainWorldPivot);
    }

    public static void restartAndClean() {
        server.restartAndClean();
    }

    /**
     * Creates a block which is only visible to specific players.
     *
     * @param block    block where the fake block is placed
     * @param material fake block's material
     * @param data     defines the special data for this block
     * @return fake block with the specific parameters
     */
    public static FakeBlock createFakeBlock(Block block, Material material, int data) {
        return server.createFakeBlock(block, material, data);
    }

    /**
     * Creates a block which is only visible to specific players.
     *
     * @param block    block where the fake block is placed
     * @param material fake block's material
     * @return fake block with the specific parameters
     */
    public static FakeBlock createFakeBlock(Block block, Material material) {
        return server.createFakeBlock(block, material, 0);
    }

    /**
     * Creates a new item-builder based on a specific material.
     *
     * @param itemStack itemstack the item-builder will base on
     * @return new item-builder
     */
    public static ItemBuilder createItem(ItemStack itemStack) {
        return server.createItem(itemStack);
    }

    /**
     * Creates a new item-builder based on a specific material.
     *
     * @param material material of the item to create
     * @return new item-builder
     */
    public static ItemBuilder createItem(Material material) {
        return server.createItem(material);
    }

    /**
     * Creates a new item-builder based on a specific material and data.
     *
     * @param material material of the item to create
     * @param data     specific data for the item as short
     * @return new item-builder
     */
    public static ItemBuilder createItem(Material material, int data) {
        return server.createItem(material, data);
    }

    /**
     * Creates a new item-builder from the players head.
     *
     * @param player player whose head is wanted
     * @return new item-builder
     */
    public static ItemBuilder createItem(Player player) {
        return server.createItem(player);
    }

    /**
     * Creates a new item-builder from the players head.
     *
     * @param user user whose head is wanted
     * @return new item-builder
     */
    public static ItemBuilder createItem(OnlineUser user) {
        return server.createItem(user.getPlayer());
    }

    /**
     * Creates a new item-builder from the players head.
     *
     * @param user user whose head is wanted
     * @return new item-builder
     */
    public static ItemBuilder createItem(User user) {
        return server.createItem(user.getPlayerHead());
    }

    /**
     * Creates a new item-builder from the players head based on its unique id.
     *
     * @param uniqueId unique id of the player whose head is wanted
     * @return new item-builder
     */
    public static ItemBuilder createItem(UUID uniqueId) {
        return server.createItem(uniqueId);
    }

    public static ItemBuilder createItem(String value, String signature) {
        return server.createItem(value, signature);
    }

    /**
     * Creates new item-builder out of a custom head, based on its link.
     * <p>
     * Example - head from <a href="https://minecraft-heads.com/custom-heads">head-database</a>:
     * The url to the head is:
     * 68c2f1f7e8cd6b00d30f0edaeefce38e889173c30c701fac0da860e0a2125ec8
     * <p>
     * You can use this url to get the head. It doesn't matter whether you're using the whole link (starting with "textures.minecraft.net") or just using the number, as shown above.
     * <p>
     * Note: Always cache heads you already created! Getting/creating new heads can be a waste of server-performance. A simple way to cash all heads used in inventories, is to load the with the onEnable()-method.
     *
     * @param url link to <span style="text-decoration:underline;">or</span> the id of the specific head
     * @return item-builder based on the chosen head
     */
    public static ItemBuilder createItem(String url) {
        return server.createItem(url);
    }

    /**
     * Creates the often used gray hover text to display a clickable message in chat.
     *
     * @param text text to be displayed
     * @return HoverEvent object to be put into .event()
     */
    public static HoverEvent createHoverText(String text) {
        return new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(text).color(ChatColor.GRAY).create());
    }

    /**
     * Creates a menu which can be sent to users chat.
     *
     * @param options clickable options (message and clickable)
     * @return new chat menu
     */
    public static ChatMenu createChatMenu(ChatMenu.Option... options) {
        return server.createChatMenu(options);
    }

    /**
     * Creates a menu which can be sent to users chat.
     *
     * @return new chat menu
     */
    public static ChatMenu createChatMenu() {
        return server.createChatMenu();
    }

    /**
     * Converts an inventory that is converted to a string back into the usual inventory object.
     *
     * @param inventory string to convert to inventory
     * @return inventory object
     */
    public static Inventory getInventoryFromString(String inventory) {
        return server.getInventoryFromString(inventory);
    }

    /**
     * Converts an inventory and its contents into a string. This method is used to save inventories to the database.
     *
     * @param inventory inventory to convert
     * @return inventory from string
     */
    public static String getStringFromInventory(Inventory inventory) {
        return server.getStringFromInventory(inventory);
    }

    /**
     * Gets the bank account with the specific iban.
     *
     * @param iban iban as string
     * @return bank account
     */
    public static BankAccount getBankAccount(String iban) {
        return server.getBankAccount(iban);
    }

    public static BankAccount getBankAccount(ItemStack bankCard) {
        return server.getBankAccount(bankCard);
    }

    /**
     * Creates a new bank account with the given holder.
     *
     * @param holder holder of this bank account
     * @return new bank account
     */
    public static BankAccount createBankAccount(Registrant holder) {
        return server.createBankAccount(holder);
    }

    /**
     * Gets the group (organization/company) with the specific name.
     *
     * @param name name as string
     * @return group with the specific name
     */
    public static Group getGroup(String name) {
        return server.getGroup(name);
    }

    /**
     * Gets the telephone with the specific telephone number.
     *
     * @param telephoneNumber telephone number to get telephone from
     * @return telephone with the specific telephone number
     */
    public static Telephone getTelephone(String telephoneNumber) {
        return server.getTelephone(telephoneNumber);
    }

    /**
     * Gets the registrant object that is represented by the specific string.
     *
     * @param id registrant as string
     * @return represented registrant
     */
    public static Registrant getRegistrant(String id) {
        return server.getRegistrant(id);
    }

    /**
     * Creates a boundary with the specific parameters.
     *
     * @param anchorPoint anchorPoint which is used to move the boundary
     * @param pullPoint   pull-point which is used to form the cuboid with the anchorpoint
     * @param callback    callback that is called if a player clicks this boundary
     * @return boundary with given parameters
     */
    public static Boundary createBoundary(@NonNull Location anchorPoint, @NonNull Location pullPoint, @NonNull Consumer<PlayerInteractEvent> callback) {
        return server.createBoundary(anchorPoint, pullPoint, callback);
    }

    /**
     * Creates a boundary with the specific parameters.
     *
     * @param anchorPoint anchorPoint which is used to move the boundary
     * @param vector      vector from anchor- to pull-point to form the cuboid
     * @param callback    callback that is called if a player clicks this boundary
     * @return boundary with given parameters
     */
    public static Boundary createBoundary(@NonNull Location anchorPoint, @NonNull Vector vector, @NonNull Consumer<PlayerInteractEvent> callback) {
        return server.createBoundary(anchorPoint, vector, callback);
    }

    /**
     * Starts a timer with the specific parameters.
     *
     * @param delay    delay after which this timer terminates (in minutes)
     * @param callback callback that is called when this timer terminates
     * @return timer with the specific parameters
     */
    public static Timer startTimer(int delay, @NonNull Runnable callback) {
        return server.startTimer(delay, callback);
    }

    /**
     * Starts a repeating timer with the specific parameters.
     * <p>
     * <b>Note:</b> The timer gets triggered immediately after calling this method without having any delay.
     * </p>
     *
     * @param period   period in which this repeating timer is called (in minutes)
     * @param callback callback that is called when this repeating timer reaches a period
     * @return repeating timer with the specific parameters.
     */
    public static RepeatingTimer startRepeatingTimer(int period, @NonNull Runnable callback) {
        return server.startRepeatingTimer(period, callback);
    }

    /**
     * Creates a reminder with the specific parameters.
     *
     * @param hours    hours on which this reminder is called
     * @param minutes  minutes on which this reminder is called
     * @param callback callback that is called when the given date/time is reached
     * @param weekdays weekdays on which this reminder is active
     * @return reminder with the specific parameters.
     */
    public static Reminder createReminder(int hours, int minutes, @NonNull Runnable callback, DayOfWeek... weekdays) {
        return server.createReminder(hours, minutes, callback, weekdays);
    }

    /**
     * Creates a reminder with the specific parameters.
     *
     * @param hours    hours on which this reminder is called
     * @param minutes  minutes on which this reminder is called
     * @param callback callback that is called when the given date/time is reached
     * @param weekdays weekdays on which this reminder is active
     * @return reminder with the specific parameters.
     */
    public static Reminder createReminder(int hours, int minutes, @NonNull Runnable callback, List<DayOfWeek> weekdays) {
        return server.createReminder(hours, minutes, callback, weekdays);
    }

    /**
     * Creates a reminder with the specific parameters.
     *
     * @param hours    hours on which this reminder is called
     * @param minutes  minutes on which this reminder is called
     * @param callback callback that is called when the given date/time is reached
     * @return reminder with the specific parameters.
     */
    public static Reminder createReminder(int hours, int minutes, @NonNull Runnable callback) {
        return server.createReminder(hours, minutes, callback, DayOfWeek.values());
    }

    /**
     * Creates a new Discord Webhook.
     *
     * @param url URL of Webhook
     * @return Webhook with given URL
     */
    public static Webhook createWebhook(String url) {
        return server.createWebhook(url);
    }

    /**
     * Creates an embedded message to be sent via webhook
     *
     * @return embedded message
     */
    public static Webhook.EmbeddedMessage createEmbeddedMessage() {
        return server.createEmbeddedMessage();
    }

    /**
     * Gets whether the server is currently in maintenance.
     *
     * @return true, if the server is in maintenance
     */
    public static boolean isMaintenance() {
        return server.isMaintenance();
    }

    /**
     * Creates a NPC with the specific parameters.
     *
     * @param skinUniqueId      unique id of the player that this npc adapts the skin from.
     * @param name              name that will be displayed above the head
     * @param location          location to spawn this npc to
     * @param focusNearPlayers  if true, this npc looks at nearby players
     * @param visibleToEveryone if true, this npc is visible to every player (you can't hide this npc from specific players when choosing this option!)
     * @return npc with specific parameters
     */
    public static NPC createNPC(UUID skinUniqueId, String name, Location location, boolean focusNearPlayers, boolean visibleToEveryone) {
        return server.createNPC(skinUniqueId, name, location, focusNearPlayers, visibleToEveryone);
    }

    public static NPC createNPC(UUID skinUniqueId, UUID uniqueId, String name, Location location, boolean focusNearPlayers, boolean visibleToEveryone) {
        return server.createNPC(skinUniqueId, uniqueId, name, location, focusNearPlayers, visibleToEveryone);
    }

    public static NPC createNPC(String value, String signature, String name, Location location, boolean focusNearPlayers, boolean visibleToEveryone) {
        return server.createNPC(value, signature, name, location, focusNearPlayers, visibleToEveryone);
    }

    public static void registerSmartApp(SmartApp app) {
        server.registerSmartApp(app);
    }

    public static List<SmartApp> getSmartApps() {
        return server.getSmartApps();
    }

    public static List<OnlineUser> getOnlineUsers() {
        return server.getOnlineUsers();
    }

    public static CarBarrier createCarBarrier(Location loc, int rotation, List<Block> barrierBlocks) {
        while (rotation < 0) rotation += 360;
        rotation %= 360;
        return server.createCarBarrier(loc, rotation, barrierBlocks);
    }

    public static Hologram createHologram(Location loc, boolean visibleToEveryone, String... lines) {
        return server.createHologram(loc, visibleToEveryone, lines);
    }

    public static String itemStackToString(ItemStack itemStack) {
        return server.itemStackToString(itemStack);
    }

    public static ItemStack itemStackFromString(String itemStack) {
        return server.itemStackFromString(itemStack);
    }

    public static String locationToString(Location location) {
        return server.locationToString(location);
    }

    public static Location locationFromString(String location) {
        return server.locationFromString(location);
    }

    public static String blockToString(Block block) {
        return server.blockToString(block);
    }

    public static Block blockFromString(String block) {
        return server.blockFromString(block);
    }

    /**
     * Gets the region with the specific id.
     *
     * @param id regions id
     * @return region with specific id
     */
    public static Region getRegion(int id) {
        return server.getRegion(id);
    }

    public static Region createRegion(List<Area> areas) {
        return server.createRegion(areas);
    }

    /**
     * Gets the region in which this location lies in.
     *
     * @param location location to get region
     * @return region in which this location lies in
     */
    public static List<Region> getRegions(Location location) {
        return getRegions(location.getBlock());
    }

    public static List<Region> getRegions(Block block) {
        return server.getRegions(block);
    }

    public static Residence getResidence(int id) {
        return server.getResidence(id);
    }

    public static Residence getResidence(Region region) {
        return server.getResidence(region);
    }

    public static List<Residence> getResidences(Location location) {
        return getResidences(location.getBlock());
    }

    public static List<Residence> getResidences(Block block) {
        return getRegions(block).stream().map(Core::getResidence).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static Residence getDominantResidence(Location location) {
        return getDominantResidence(location.getBlock());
    }

    public static Residence getDominantResidence(Block block) {
        return Optional.ofNullable((Residence) getApartment(block)).orElse(getPlot(block));
    }

    public static Plot getPlot(Location location) {
        return getPlot(location.getBlock());
    }

    public static Plot getPlot(Block block) {
        return (Plot) getResidences(block).stream().filter(r -> r instanceof Plot).findFirst().orElse(null);
    }

    public static Apartment getApartment(Location location) {
        return getApartment(location.getBlock());
    }

    public static Apartment getApartment(Block block) {
        return (Apartment) getResidences(block).stream().filter(r -> r instanceof Apartment).findFirst().orElse(null);
    }

    public static Plot createPlot(Region region, Street street, Registrant owner, int fertility, Sign plotSign,
                                  Block mailboxBlock, Area mailboxConnectedBlocks, Location teleportLocation) {
        return server.createPlot(region, street, owner, fertility, plotSign, mailboxBlock, mailboxConnectedBlocks,
                teleportLocation);
    }

    public static Apartment createApartment(Region region, Registrant landlord, int fertility, int rent,
                                            Sign apartmentSign, Block mailbox) {
        return server.createApartment(region, landlord, fertility, rent, apartmentSign, mailbox);
    }

    public static Apartment createApartment(Region region, ApartmentBlock block, int rent, Sign apartmentSign,
                                            Block mailbox) {
        return server.createApartment(region, block, rent, apartmentSign, mailbox);
    }

    // TODO: 05.06.2023
    @Deprecated
    public static ApartmentBlock createApartmentBlock(Street street, Location teleportLocation, Registrant landlord,
                                                      int fertility, Block mailboxBlock, Area mailboxConnectedBlocks,
                                                      Sign apartmentBlockSign, Sign bellSign, int maxFloors,
                                                      int defaultFloor, Area defaultFloorShadow, List<Area> roofShadows,
                                                      Area constructionFloorShadow, Vector constructionWorkerLocation,
                                                      List<Location> craftsmanLocations, Block[] damagedFloorBlocks) {
        return server.createApartmentBlock(street, teleportLocation, landlord, fertility, mailboxBlock,
                mailboxConnectedBlocks, apartmentBlockSign, bellSign, maxFloors, defaultFloor, defaultFloorShadow,
                roofShadows, constructionFloorShadow, constructionWorkerLocation, craftsmanLocations, damagedFloorBlocks);
    }

    // TODO: 05.06.2023
    @Deprecated
    public static ApartmentBlock createApartmentBlock(Street street, Location teleportLocation, Registrant landlord,
                                                      int fertility, Block mailboxBlock, Area mailboxConnectedBlocks,
                                                      Sign apartmentBlockSign, Sign bellSign, int floors,
                                                      List<Location> craftsmanLocations, Block[] damagedFloorBlocks) {
        return server.createApartmentBlock(street, teleportLocation, landlord, fertility, mailboxBlock,
                mailboxConnectedBlocks, apartmentBlockSign, bellSign, floors, craftsmanLocations, damagedFloorBlocks);
    }

    public static List<Residence> getLoadedResidences() {
        return server.getLoadedResidences();
    }

    public static List<Street> getStreets() {
        return server.getStreets();
    }

    public static Street getStreet(int id) {
        return server.getStreet(id);
    }

    public static Street createStreet(String name, String description) {
        return server.createStreet(name, description);
    }

    public static List<District> getDistricts() {
        return server.getDistricts();
    }

    public static District getDistrict(int id) {
        return server.getDistrict(id);
    }

    public static District getDistrict(Chunk chunk) {
        return server.getDistrict(chunk);
    }

    public static District getDistrict(Block block) {
        return getDistrict(block.getChunk());
    }

    public static District getDistrict(Location location) {
        return getDistrict(location.getChunk());
    }

    public static void updateDistricts() {
        server.updateDistricts();
    }

    public static RadioMast createRadioMast(String name, Block location, int range) {
        return server.createRadioMast(name, location, range);
    }

    public static RadioMast getNearestRadioMast(Location location) {
        return server.getNearestRadioMast(location);
    }

    /**
     * Gets an area object with the given locations.
     *
     * @param loc1 first location as block
     * @param loc2 second location as block
     * @return area with the given locations
     */
    public static Area getArea(Block loc1, Block loc2) {
        return server.getArea(loc1, loc2);
    }

    /**
     * Gets an area object with only one block.
     *
     * @param block block to create the area from
     * @return area consisting of the one specific block
     */
    public static Area getAreaOfBlock(Block block) {
        return server.getArea(block, block);
    }

    /**
     * Gets the area that is represented by a specific string.
     *
     * @param rawArea area as string
     * @return area that is represented by the specific string
     */
    public static Area getAreaFromString(String rawArea) {
        return server.getAreaFromString(rawArea);
    }

    public static int convertHexToDecimalColor(String hex) {
        return server.convertHexToDecimalColor(hex);
    }

    public static Einzelunternehmen createEinzelunternehmen(User owner) {
        return server.createEinzelunternehmen(owner);
    }

    public static Personengesellschaft createPersonengesellschaft(User owner, List<User> coOwners) {
        return server.createPersonengesellschaft(owner, coOwners);
    }

    public static Kapitalgesellschaft createKapitalgesellschaft(int address) {
        return server.createKapitalgesellschaft(address);
    }

    public static StateCompany createStateCompany(int address, StateCompany.Sector sector) {
        return server.createStateCompany(address, sector);
    }

    public static Aktiengesellschaft createAktiengesellschaft(int address, int stocks) {
        return server.createAktiengesellschaft(address, stocks);
    }

    public static List<StateCompany> getStateCompanies() {
        return server.getStateCompanies();
    }

    /**
     * Creates an armorstand with a consumer
     *
     * @return ArmorStand instance
     */
    public static FakeArmorStand createFakeArmorStand() {
        return server.createArmorStand(null);
    }

    /**
     * Creates an armorstand with a consumer
     *
     * @param location location to spawn the armorstand at.
     * @return ArmorStand instance
     */
    public static FakeArmorStand createFakeArmorStand(Location location) {
        return server.createArmorStand(location);
    }

    public static Server getServer() {
        return server.getServerType();
    }

    public static String convertToTransparent(String text) {
        return server.convertToTransparent(text);
    }
}