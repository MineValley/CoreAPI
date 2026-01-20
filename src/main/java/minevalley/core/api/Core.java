package minevalley.core.api;

import com.google.gson.Gson;
import minevalley.core.api.armorstand.FakeArmorStand;
import minevalley.core.api.banking.BankAccount;
import minevalley.core.api.corporations.Group;
import minevalley.core.api.corporations.companies.*;
import minevalley.core.api.database.StatementBuilder;
import minevalley.core.api.discord.EmbeddedMessage;
import minevalley.core.api.discord.Webhook;
import minevalley.core.api.displays.BlockDisplay;
import minevalley.core.api.displays.ItemDisplay;
import minevalley.core.api.displays.TextDisplay;
import minevalley.core.api.enums.DebugType;
import minevalley.core.api.gui.FillItem;
import minevalley.core.api.gui.InventoryGui;
import minevalley.core.api.gui.MultiPageGui;
import minevalley.core.api.interaction.InteractionTrigger;
import minevalley.core.api.npc.NPC;
import minevalley.core.api.phone.Telephone;
import minevalley.core.api.server.Server;
import minevalley.core.api.team.Team;
import minevalley.core.api.timing.Reminder;
import minevalley.core.api.timing.RepeatingTimer;
import minevalley.core.api.timing.Timer;
import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.User;
import minevalley.core.api.utils.EventListener;
import minevalley.core.api.utils.*;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.*;
import java.util.function.Consumer;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public final class Core {

    private static CoreProvider provider;
    private static Proxy proxy;

    /**
     * Get the JavaPlugin instance of CorePlugin.
     * <br>
     * This gives you access to some Bukkit features that rely on this instance.
     *
     * @return JavaPlugin instance of CorePlugin
     */
    @Nonnull
    public static JavaPlugin getInstance() {
        return provider.getInstance();
    }

    /**
     * Get the {@link Server} object, granting access to all server-related features.
     *
     * @return Server object
     */
    @Nonnull
    public static Server server() {
        return provider.server();
    }

    /**
     * Get the {@link Proxy} object, granting access to all proxy-related features.
     *
     * @return Proxy object
     */
    @Nonnull
    public static Proxy proxy() {
        return proxy;
    }

    /**
     * Returns a task that will run on the next server tick.
     *
     * @param task the task to be run
     * @return a BukkitTask that contains the id number
     * @throws IllegalArgumentException if task is null
     */
    @Nonnull
    public static BukkitTask runSyncTaskNow(@Nonnull Runnable task) throws IllegalArgumentException {
        return provider.runSyncTaskLater(0, task);
    }

    /**
     * Returns a task that will run asynchronously.
     * <br>
     * <b>Note:</b> Asynchronous tasks should never access any API in Bukkit.
     *
     * @param task the task to be run
     * @return a BukkitTask that contains the id number
     * @throws IllegalArgumentException if task is null
     */
    @Nonnull
    public static BukkitTask runAsyncTaskNow(@Nonnull Runnable task) throws IllegalArgumentException {
        return provider.runAsyncTaskLater(0, task);
    }

    /**
     * Returns a task that will run after the specified number of server
     * ticks.
     *
     * @param delay the ticks to wait before running the task
     * @param task  the task to be run
     * @return a BukkitTask that contains the id number
     * @throws IllegalArgumentException if task is null
     */
    @Nonnull
    public static BukkitTask runSyncTaskLater(long delay, @Nonnull Runnable task) throws IllegalArgumentException {
        return provider.runSyncTaskLater(delay, task);
    }

    /**
     * Returns a task that will run asynchronously after the specified number
     * of server ticks.
     * <br>
     * <b>Note:</b> Asynchronous tasks should never access any API in Bukkit.
     *
     * @param task  the task to be run
     * @param delay the ticks to wait before running the task
     * @return a BukkitTask that contains the id number
     * @throws IllegalArgumentException if task is null
     */
    @Nonnull
    public static BukkitTask runAsyncTaskLater(long delay, @Nonnull Runnable task) throws IllegalArgumentException {
        return provider.runAsyncTaskLater(delay, task);
    }

    /**
     * Returns a task that will repeatedly run until canceled, starting after
     * the specified number of server ticks.
     *
     * @param delay  the ticks to wait before running the task
     * @param period the ticks to wait between runs
     * @param task   the task to be run
     * @return a BukkitTask that contains the id number
     * @throws IllegalArgumentException if task is null
     */
    @Nonnull
    public static BukkitTask runSyncTaskPeriodically(long delay, long period, @Nonnull Runnable task) throws IllegalArgumentException {
        return provider.runSyncTaskPeriodically(delay, period, task);
    }

    /**
     * Returns a task that will repeatedly run asynchronously until canceled,
     * starting after the specified number of server ticks.
     * <br>
     * <b>Note:</b> Asynchronous tasks should never access any API in Bukkit.
     *
     * @param delay  the ticks to wait before running the task for the first
     *               time
     * @param period the ticks to wait between runs
     * @param task   the task to be run
     * @return a BukkitTask that contains the id number
     * @throws IllegalArgumentException if task is null
     */
    @Nonnull
    public static BukkitTask runAsyncTaskPeriodically(long delay, long period, @Nonnull Runnable task) throws IllegalArgumentException {
        return provider.runAsyncTaskPeriodically(delay, period, task);
    }

    /**
     * Create a {@link StatementBuilder} based on the given SQL code.
     *
     * @param sql SQL code to prepare
     * @return a new {@link StatementBuilder} instance
     * @throws SQLException if a database access error occurs
     */
    @Nonnull
    @Contract("_ -> new")
    public static StatementBuilder prepareSQL(@Nonnull @Language("SQL") String sql) throws SQLException {
        return provider.prepareSQL(sql, false);
    }

    /**
     * Create a {@link StatementBuilder} based on the given SQL code.
     *
     * @param sql                   SQL code to prepare
     * @param retrieveGeneratedKeys whether to retrieve generated keys
     * @return a new {@link StatementBuilder} instance
     * @throws SQLException if a database access error occurs
     */
    @Nonnull
    @Contract("_, _ -> new")
    public static StatementBuilder prepareSQL(@Nonnull @Language("SQL") String sql, boolean retrieveGeneratedKeys) throws SQLException {
        return provider.prepareSQL(sql, retrieveGeneratedKeys);
    }

    /**
     * Generate a random id based on the given length that was not used in the given column and table.
     *
     * @param table         table to check
     * @param column        column to check
     * @param amountOfChars the amount of chars the id should have
     * @return a unique id
     * @throws IllegalArgumentException if the table is null, column is null or the amount of chars is less than 1
     * @throws SQLException             if a database access error occurs
     */
    @Contract("_, _, _ -> _")
    public static int generateUniqueId(@Nonnull String table, @Nonnull String column, int amountOfChars) throws IllegalArgumentException, SQLException {
        return provider.generateUniqueId(table, column, amountOfChars);
    }

    /**
     * Registers an event listener.
     *
     * @param cls      class of the event
     * @param listener listener to register
     * @throws IllegalArgumentException if the event class or listener is null
     */
    public static void registerListener(@Nonnull Class<? extends Event> cls, @Nonnull EventListener<? extends Event> listener) throws IllegalArgumentException {
        provider.registerListener(cls, listener);
    }

    /**
     * Unregisters an event listener.
     *
     * @param cls      class of the event
     * @param listener listener to unregister
     * @throws IllegalArgumentException if the event class or listener is null
     */
    public static void unregisterListener(@Nonnull Class<? extends Event> cls, @Nonnull EventListener<? extends Event> listener) throws IllegalArgumentException {
        provider.unregisterListener(cls, listener);
    }

    /**
     * Registers an event listener.
     *
     * @param listener listener to register
     * @throws IllegalArgumentException if the listener is null
     */
    public static void registerListener(@Nonnull Listener listener) throws IllegalArgumentException {
        provider.registerListener(listener);
    }

    /**
     * Calls an event.
     *
     * @param event event to call
     * @throws IllegalArgumentException if the event is null
     */
    public static void callEvent(@Nonnull Event event) throws IllegalArgumentException {
        provider.callEvent(event);
    }

    /**
     * Gets the user of with a specific unique id.
     * <br>
     * <strong>Note:</strong> If no user is found, this method returns null.
     *
     * @param uniqueId unique id to get user from
     * @return user object of the given unique id
     */
    @Nullable
    @Contract("null -> null")
    public static User getUser(@Nullable UUID uniqueId) {
        return provider.getUser(uniqueId);
    }

    /**
     * Gets the user of this specific player.
     * <br>
     * <strong>Note:</strong> If no user is found, a new one is created based on the player.
     *
     * @param player player to get user from
     * @return user object of the given player
     * @throws IllegalArgumentException if the player is null
     */
    @Nonnull
    public static OnlineUser getOnlineUser(@Nonnull Player player) throws IllegalArgumentException {
        return provider.getOnlineUser(player);
    }

    /**
     * Gets the name of the player with the specific unique id.
     * <br>
     * <strong>Note:</strong> If no player is found, this method returns null.
     * <p>
     * <strong>Runtime Optimization</strong>
     * <ul>
     *     <li>This method uses an internal cache</li>
     *     <li>If the player is online, no use of the mojang api is taken</li>
     * </ul>
     * </p>
     *
     * @param uniqueId unique id of the player
     * @return name of the player
     */
    @Nullable
    @Contract("null -> null")
    public static String getName(@Nullable UUID uniqueId) {
        return provider.getName(uniqueId);
    }

    /**
     * Gets the unique id of the player with the specific name.
     * <br>
     * <strong>Note:</strong> If no player is found, this method returns null.
     * <p>
     * <strong>Runtime Optimization</strong>
     *     <ul>
     *         <li>This method uses an internal cache</li>
     *         <li>If the player is online, no use of the mojang api is taken</li>
     * </p>
     *
     * @param name name of the player
     * @return unique id as UUID
     */
    @Nullable
    @Contract("null -> null")
    public static UUID getUniqueId(@Nullable String name) {
        return provider.getUniqueId(name);
    }

    public static Team team() {
        return provider.team();
    }

    /**
     * Sends a debug message to the console and to every online team-member that enabled this debug type.
     *
     * @param type    type of the debug message
     * @param message message as string
     */
    public static void sendDebug(@Nonnull DebugType type, @Nonnull String message) {
        provider.sendDebug(type, removeColorCodes(message));
    }

    /**
     * Sets the setting with the given key.
     * <p>
     * <b>Note:</b> When using the settings-method, do never change the settings manually via database!
     *
     * @param key   string of the key
     * @param value string of the (new) value
     * @throws IllegalArgumentException if the key or value is null
     */
    public static void setSetting(@Nonnull String key, @Nonnull String value) throws IllegalArgumentException {
        provider.setSetting(key, value);
    }

    /**
     * Gets the settings with the specific key.
     *
     * @param key string of the key with which the setting is saved
     * @return setting as string from the specific key
     */
    @Nullable
    @Contract("null -> null")
    public static String getSetting(String key) {
        return provider.getSetting(key);
    }


    /**
     * Gets the settings with the specific key.
     *
     * @param key          string of the key with which the setting is saved
     * @param defaultValue value that is returned, if the setting is null
     * @return setting as string from the specific key
     */
    @Nonnull
    public static String getSetting(String key, @Nonnull String defaultValue) {
        return Optional.ofNullable(provider.getSetting(key)).orElse(defaultValue);
    }

    /**
     * Updates a statistic with the given key.
     * <p>
     * <b>Note:</b> When using the stats-method, do never change the settings manually via database!
     *
     * @param key   string of the key
     * @param value double of the (new) value
     * @throws IllegalArgumentException if the key is null
     */
    public static void updateStatistic(@Nonnull String key, double value) throws IllegalArgumentException {
        provider.updateStatistic(key, value);
    }

    /**
     * Gets the statistic with the specific key.
     *
     * @param key string of the key with which the statistic is saved
     * @return statistic as double from the specific key
     * @throws IllegalArgumentException if the key is null
     */
    public static double getStatistic(@Nonnull String key) throws IllegalArgumentException {
        return provider.getStatistic(key);
    }

    /**
     * Removes the color-codes from a given string
     *
     * @param text string which could contain color-codes
     * @return string without any color-codes
     */
    @Contract("null -> null")
    public static String removeColorCodes(@Nullable String text) {
        return provider.removeColorCodes(text);
    }

    /**
     * Converts chat-color-codes to normal color-codes (&amp; -> &sect;)
     *
     * @param text string which could contain chat-color-codes
     * @return string with converted color-codes
     */
    @Contract("null -> null")
    public static String convertColorCodes(@Nullable String text) {
        return provider.convertColorCodes(text);
    }

    /**
     * Checks whether the given string contains a forbidden word.
     *
     * @param text text to check
     * @return true, if string contains forbidden words
     */
    @Contract("null -> false")
    public static boolean containsForbiddenWords(@Nullable String text) {
        return provider.containsForForbiddenWords(text);
    }

    /**
     * Creates a {@link Gson} instance that fits in a page for pretty printing.
     * Use this to convert json-strings to specific objects and vice versa.
     *
     * @return an instance of Gson configured that fits in a page for pretty printing
     */
    @Nonnull
    public static Gson getGson() {
        return provider.getGson();
    }

    /**
     * Gets a random integer with the given length.
     *
     * @param chars number of chars
     * @return random integer
     * @throws IllegalArgumentException if the chars are less than 1
     */
    public static int getRandomInteger(int chars) throws IllegalArgumentException {
        return provider.getRandomInteger(chars);
    }

    /**
     * Checks whether the given string is numeric and can be converted to an integer.
     * <p>
     * <b>Note:</b> This method also checks whether the integer exceeds the maximum value for integers.
     *
     * @param string string to verify
     * @return true, if the given string is numeric
     */
    @Contract("null -> false")
    public static boolean isInteger(@Nullable String string) {
        return provider.isInteger(string);
    }

    /**
     * Verifies that the given string is numeric and can be converted to a double.
     *
     * @param string string to verify
     * @return true, if the given string is numeric
     */
    @Contract("null -> false")
    public static boolean isDouble(@Nullable String string) {
        return provider.isDouble(string);
    }

    /**
     * Creates a readable string of the specific amount of money.
     *
     * @param amountInCents amount to convert
     * @return amount as x.xxx.xxx,xx€
     */
    @Nonnull
    public static String formatMoney(int amountInCents) {
        return provider.formatMoney(amountInCents);
    }

    @Nonnull
    public static String getFormattedDate(long time) {
        return new SimpleDateFormat("dd. MMMM yyyy - HH:mm", Locale.GERMANY).format(new Date(time)) + " Uhr";
    }

    @Nonnull
    public static String formatRelativeTimestamp(long timestamp) {
        return provider.formatRelativeTimestamp(timestamp);
    }

    @Nonnull
    public static String getCurrentTimeFormatted() {
        return getFormattedDate(System.currentTimeMillis());
    }

    @Nonnull
    public static String getCurrentDayTimeFormatted() {
        return getFormattedTime(System.currentTimeMillis());
    }

    @Nonnull
    public static String getFormattedTime(long time) {
        return new SimpleDateFormat("HH:mm", Locale.GERMANY).format(new Date(time)) + " Uhr";
    }

    /**
     * Creates a gui with a specific size.
     *
     * @param size size of the inventory
     * @return new gui-builder
     * @throws IllegalArgumentException if the size is invalid (negative, higher than 54 or not a multiple of 9 while being higher than 6)
     */
    @Nonnull
    public static InventoryGui createGui(@Nonnull Component title, @Nonnegative int size) throws IllegalArgumentException {
        return provider.createGUI(title, size);
    }

    /**
     * Creates a gui with multiple pages and a specific size.
     * <p>
     * The title of the inventory holds two variables:
     * <br>
     * {@code %i%} will be replaced with the current page number
     * <br>
     * {@code %o%} will be replaced with the amount of pages
     *
     * @param title     title of the inventory
     * @param size      size of the inventory
     * @param fillItems items to fill the inventory with
     * @return new gui-builder
     * @throws IllegalArgumentException if the size is invalid (negative, higher than 54 or not a multiple of 9 while being higher than 6)
     */
    @Nonnull
    public static MultiPageGui createMultiPageGui(@Nonnull Component title, @Nonnegative int size, @Nonnull List<FillItem> fillItems) throws IllegalArgumentException {
        return provider.createMultiPageGui(title, size, fillItems);
    }

    /**
     * Gets the main world.
     *
     * @return main world
     */
    @Nonnull
    public static World getMainWorld() {
        return provider.getMainWorld();
    }

    /**
     * Gets the building world.
     * <br>
     * <b>Note:</b> This world only exists on the main server.
     *
     * @return building map
     * @throws IllegalStateException if the method is called on any server but the main server
     */
    @Nonnull
    public static World getBuildingWorld() throws IllegalStateException {
        return provider.getBuildingWorld();
    }

    /**
     * Gets the presets world.
     * <br>
     * <b>Note:</b> This world only exists on the main server.
     *
     * @return building map
     * @throws IllegalStateException if the method is called on any server but the main server
     */
    @Nonnull
    public static World getPresetsWorld() throws IllegalStateException {
        return provider.getPresetsWorld();
    }

    /**
     * Creates a block which is only visible to specific players.
     *
     * @param block    block where the fake block is placed
     * @param material fake block's material
     * @param data     defines the special data for this block
     * @return fake block with the specific parameters
     * @throws IllegalArgumentException if one of the parameters is null or data is invalid
     */
    @Nonnull
    @Contract("_, _, _ -> new")
    public static FakeBlock createFakeBlock(@Nonnull Block block, @Nonnull Material material, int data) throws IllegalArgumentException {
        return provider.createFakeBlock(block, material, data);
    }

    /**
     * Creates a block which is only visible to specific players.
     *
     * @param block    block where the fake block is placed
     * @param material fake block's material
     * @return fake block with the specific parameters
     * @throws IllegalArgumentException if one of the parameters is null
     */
    @Nonnull
    @Contract("_, _ -> new")
    public static FakeBlock createFakeBlock(@Nonnull Block block, @Nonnull Material material) throws IllegalArgumentException {
        return provider.createFakeBlock(block, material, 0);
    }

    /**
     * Creates a block which is only visible to specific players.
     *
     * @param location location where the BlockDisplay is placed
     * @param material material of the BlockDisplay
     * @return BlockDisplay with the specific parameters
     * @throws IllegalArgumentException if one of the parameters is null or data is invalid
     */
    @Nonnull
    @Contract("_, _-> new")
    public static BlockDisplay createBlockDisplay(@Nonnull Location location, @Nonnull Material material) throws IllegalArgumentException {
        return provider.createBlockDisplay(location, material);
    }

    /**
     * Creates an ItemDisplay which is only visible to specific players.
     *
     * @param location  location where the ItemDisplay is placed
     * @param itemStack item stack of the ItemDisplay
     * @return ItemDisplay with the specific parameters
     * @throws IllegalArgumentException if one of the parameters is null or data is invalid
     */
    @Nonnull
    @Contract("_, _ -> new")
    public static ItemDisplay createItemDisplay(@Nonnull Location location, @Nonnull ItemStack itemStack) throws IllegalArgumentException {
        return provider.createItemDisplay(location, itemStack);
    }

    /**
     * Creates a text display which is only visible to specific players.
     *
     * @param location location where the TextDisplay is placed
     * @param text     text of the TextDisplay
     * @return TextDisplay with the specific parameters
     * @throws IllegalArgumentException if one of the parameters is null or data is invalid
     */
    @Nonnull
    @Contract("_, _ -> new")
    public static TextDisplay createTextDisplay(@Nonnull Location location, @Nonnull ComponentLike text) throws IllegalArgumentException {
        return provider.createTextDisplay(location, text);
    }

    /**
     * Creates a new item-builder based on a specific material.
     *
     * @param itemStack itemstack the item-builder will base on
     * @return new item-builder
     * @throws IllegalArgumentException if the itemstack is null
     */
    @Nonnull
    @Contract("_ -> new")
    public static ItemBuilder createItem(@Nonnull ItemStack itemStack) throws IllegalArgumentException {
        return provider.createItem(itemStack);
    }

    /**
     * Creates a new item-builder based on a specific material.
     *
     * @param material material of the item to create
     * @return new item-builder
     * @throws IllegalArgumentException if the material is null
     */
    @Nonnull
    @Contract("_ -> new")
    public static ItemBuilder createItem(@Nonnull Material material) throws IllegalArgumentException {
        return provider.createItem(material);
    }

    /**
     * Creates a new item-builder from the players head.
     *
     * @param player player whose head is wanted
     * @return new item-builder
     * @throws IllegalArgumentException if the player is null
     */
    @Nonnull
    @Contract("_ -> new")
    public static ItemBuilder createItem(@Nonnull Player player) throws IllegalArgumentException {
        return provider.createItem(player);
    }

    /**
     * Creates a new item-builder from the players head.
     *
     * @param user user whose head is wanted
     * @return new item-builder
     * @throws IllegalArgumentException if the user is null
     */
    @Nonnull
    @Contract("_ -> new")
    public static ItemBuilder createItem(@Nonnull OnlineUser user) throws IllegalArgumentException {
        return provider.createItem(user.player());
    }

    /**
     * Creates a new item-builder from the players head.
     *
     * @param user user whose head is wanted
     * @return new item-builder
     * @throws IllegalArgumentException if the user is null
     */
    @Nonnull
    @Contract("_ -> new")
    public static ItemBuilder createItem(@Nonnull User user) throws IllegalArgumentException {
        return provider.createItem(user.getPlayerHead());
    }

    /**
     * Creates a new item-builder from the players head based on its unique id.
     *
     * @param uniqueId unique id of the player whose head is wanted
     * @return new item-builder
     * @throws IllegalArgumentException if the unique id is null or no player is found matching the unique id
     */
    @Nonnull
    @Contract("_ -> new")
    public static ItemBuilder createItem(@Nonnull UUID uniqueId) throws IllegalArgumentException {
        return provider.createItem(uniqueId);
    }

    /**
     * Creates a new item-builder based on the given value and signature.
     *
     * @param value     value of the item
     * @param signature signature of the item
     * @return new item-builder
     * @throws IllegalArgumentException if the value or signature is null or no item could be created based on the given parameters
     */
    @Nonnull
    @Contract("_, _ -> new")
    public static ItemBuilder createItem(@Nonnull String value, @Nonnull String signature) throws IllegalArgumentException {
        return provider.createItem(value, signature);
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
     * Note: Always cache heads you already created! Getting/creating new heads can be a waste of server performance. A simple way to cash all heads used in inventories is to load the with the onEnable()-method.
     *
     * @param url link to <span style="text-decoration:underline;">or</span> the id of the specific head
     * @return item-builder based on the chosen head
     * @throws IllegalArgumentException if the url is null
     */
    @Nonnull
    @Contract("_ -> new")
    public static ItemBuilder createItem(@Nonnull String url) throws IllegalArgumentException {
        return provider.createItem(url);
    }

    /**
     * Converts an inventory that is converted to a string back into the usual inventory object.
     *
     * @param inventory string to convert to inventory
     * @return inventory object
     * @throws IllegalArgumentException if the inventory is null or invalid
     */
    @Nonnull
    public static Inventory getInventoryFromString(@Nonnull String inventory) throws IllegalArgumentException {
        return provider.getInventoryFromString(inventory);
    }

    /**
     * Converts an inventory and its contents into a string. This method is used to save inventories to the database.
     *
     * @param inventory inventory to convert
     * @return inventory from string
     * @throws IllegalArgumentException if the inventory is null or invalid
     */
    @Nonnull
    public static String getStringFromInventory(@Nonnull Inventory inventory) throws IllegalArgumentException {
        return provider.getStringFromInventory(inventory);
    }

    /**
     * Gets the bank account with the specific iban.
     *
     * @param iban iban as string
     * @return bank account
     */
    @Nullable
    @Contract("null -> null")
    public static BankAccount getBankAccount(@Nullable String iban) {
        return provider.getBankAccount(iban);
    }

    /**
     * Gets the bank account with the specific bank card.
     *
     * @param bankCard bank card as itemstack
     * @return bank account
     */
    @Nullable
    @Contract("null -> null")
    public static BankAccount getBankAccount(@Nullable ItemStack bankCard) {
        return provider.getBankAccount(bankCard);
    }

    /**
     * Creates a new bank account with the given holder.
     *
     * @param holder holder of this bank account
     * @return new bank account
     * @throws IllegalArgumentException if the holder is null
     */
    @Nonnull
    @Contract("_ -> new")
    public static BankAccount createBankAccount(@Nonnull Registrant holder) throws IllegalArgumentException {
        return provider.createBankAccount(holder);
    }

    /**
     * Get all groups.
     *
     * @return list of all groups
     */
    @Nonnull
    public static List<Group> getGroups() {
        return provider.getGroups();
    }

    /**
     * Gets the group (organization/company) with the specific name.
     *
     * @param name name as string
     * @return group with the specific name
     */
    @Nullable
    public static Group getGroup(@Nullable String name) {
        return provider.getGroup(name);
    }

    /**
     * Creates a new group of type 'Einzelunternehmen' with the given owner.
     *
     * @param owner owner of this group
     * @return new group
     * @throws IllegalArgumentException if the owner is null or is not allowed to create a group
     */
    @Nonnull
    @Contract("_ -> new")
    public static Einzelunternehmen createEinzelunternehmen(@Nonnull User owner) throws IllegalArgumentException {
        return provider.createEinzelunternehmen(owner);
    }

    /**
     * Creates a new group of type 'Personengesellschaft' with the given owner and co-owners.
     *
     * @param owner    owner of this group
     * @param coOwners co-owners of this group
     * @return new group
     * @throws IllegalArgumentException if one of the owners is null or not allowed to create a group
     */
    @Nonnull
    @Contract("_, _ -> new")
    @ApiStatus.Experimental
    public static Personengesellschaft createPersonengesellschaft(@Nonnull User owner, @Nonnull List<User> coOwners) throws IllegalArgumentException {
        return provider.createPersonengesellschaft(owner, coOwners);
    }

    /**
     * Creates a new group of type 'Kapitalgesellschaft' with the given address.
     *
     * @param address address of this group
     * @return new group
     * @throws IllegalArgumentException if the address cannot be found
     */
    @Nonnull
    @Contract("_ -> new")
    @ApiStatus.Experimental
    public static Kapitalgesellschaft createKapitalgesellschaft(int address) throws IllegalArgumentException {
        return provider.createKapitalgesellschaft(address);
    }

    /**
     * Creates a new group of type 'Staat' with the given address.
     *
     * @param address address of this group
     * @return new group
     * @throws IllegalArgumentException if the address cannot be found or the sector is null
     */
    @Nonnull
    @Contract("_, _ -> new")
    @ApiStatus.Experimental
    public static StateCompany createStateCompany(int address, @Nonnull StateCompany.Sector sector) throws IllegalArgumentException {
        return provider.createStateCompany(address, sector);
    }

    /**
     * Creates a new group of type 'Aktiengesellschaft' with the given address and stocks.
     *
     * @param address address of this group
     * @param stocks  stocks of this group
     * @return new group
     * @throws IllegalArgumentException if the address cannot be found or stocks is less or equal to 0
     */
    @Nonnull
    @Contract("_, _ -> new")
    @ApiStatus.Experimental
    public static Aktiengesellschaft createAktiengesellschaft(int address, int stocks) throws IllegalArgumentException {
        return provider.createAktiengesellschaft(address, stocks);
    }

    /**
     * Gets all state companies.
     *
     * @return list of all state companies
     */
    @Nonnull
    public static List<StateCompany> getStateCompanies() {
        return provider.getStateCompanies();
    }


    /**
     * Gets the telephone with the specific telephone number.
     *
     * @param telephoneNumber telephone number to get telephone from
     * @return telephone with the specific telephone number
     */
    @Nullable
    @Contract("null -> null")
    public static Telephone getTelephone(@Nullable String telephoneNumber) {
        return provider.getTelephone(telephoneNumber);
    }

    /**
     * Gets the registrant object that is represented by the specific string.
     *
     * @param id registrant as string
     * @return represented registrant
     */
    @Nullable
    @Contract("null -> null")
    public static Registrant getRegistrant(@Nullable String id) {
        return provider.getRegistrant(id);
    }

    /**
     * Starts a timer with the specific parameters.
     *
     * @param delay    delay after which this timer terminates (in minutes)
     * @param callback callback that is called when this timer terminates
     * @return timer with the specific parameters
     * @throws IllegalArgumentException if the delay is less than 1 or the callback is null
     */
    @Nonnull
    @Contract("_, _ -> new")
    public static Timer startTimer(int delay, @Nonnull Runnable callback) throws IllegalArgumentException {
        return provider.startTimer(delay, callback);
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
     * @throws IllegalArgumentException if the period is less than 1 or the callback is null
     */
    public static RepeatingTimer startRepeatingTimer(int period, @Nonnull Runnable callback) throws IllegalArgumentException {
        return provider.startRepeatingTimer(period, callback);
    }

    /**
     * Creates a reminder with the specific parameters.
     *
     * @param hours    hours on which this reminder is called
     * @param minutes  minutes on which this reminder is called
     * @param callback callback that is called when the given date/time is reached
     * @param weekdays weekdays on which this reminder is active
     * @return reminder with the specific parameters.
     * @throws IllegalArgumentException if the hours or minutes are invalid
     */
    public static Reminder createReminder(int hours, int minutes, @Nonnull Runnable callback, DayOfWeek... weekdays) throws IllegalArgumentException {
        return provider.createReminder(hours, minutes, callback, weekdays);
    }

    /**
     * Creates a reminder with the specific parameters.
     *
     * @param hours    hours on which this reminder is called
     * @param minutes  minutes on which this reminder is called
     * @param callback callback that is called when the given date/time is reached
     * @return reminder with the specific parameters.
     * @throws IllegalArgumentException if the hours or minutes are invalid or the callback is null
     */
    @Nonnull
    public static Reminder createReminder(@Nonnegative int hours, @Nonnegative int minutes, @Nonnull Runnable callback) throws IllegalArgumentException {
        return provider.createReminder(hours, minutes, callback, DayOfWeek.values());
    }

    /**
     * Creates a new Discord Webhook.
     *
     * @param url URL of Webhook
     * @return Webhook with given URL
     * @throws IllegalArgumentException if the URL is null
     */
    @Nonnull
    public static Webhook createWebhook(@Nonnull URL url) throws IllegalArgumentException {
        return provider.createWebhook(url);
    }

    /**
     * Creates an embedded message to be sent via webhook
     *
     * @return embedded message
     */
    @Nonnull
    public static EmbeddedMessage createEmbeddedMessage() {
        return provider.createEmbeddedMessage();
    }

    /**
     * Creates a NPC with the specific parameters.
     *
     * @param skinUniqueId unique id of the player that this npc adapts the skin from.
     * @param name         name that will be displayed above the head
     * @param location     location to spawn this npc to
     * @return npc with specific parameters
     * @throws IllegalArgumentException if one of the parameters is null
     */
    @Nonnull
    public static NPC createNPC(@Nonnull UUID skinUniqueId, @Nonnull String name, @Nonnull Location location)
            throws IllegalArgumentException {
        return provider.createNPC(skinUniqueId, name, location);
    }

    /**
     * Creates a NPC with the specific parameters.
     *
     * @param skinValue     value of the skin to apply
     * @param skinSignature signature of the skin to apply
     * @param name          name that will be displayed above the head
     * @param location      location to spawn this npc to
     * @return npc with specific parameters
     * @throws IllegalArgumentException if one of the parameters is null
     */
    @Nonnull
    public static NPC createNPC(@Nonnull String skinValue, @Nonnull String skinSignature,
                                @Nonnull String name, @Nonnull Location location) throws IllegalArgumentException {
        return provider.createNPC(skinValue, skinSignature, name, location);
    }

    /**
     * Creates a new car barrier with the specific parameters.
     *
     * @param loc           location of the barrier
     * @param rotation      rotation of the barrier
     * @param barrierBlocks blocks that will be replaced with barrier blocks when the car barrier closes
     * @return car barrier with the specific parameters
     * @throws IllegalArgumentException if the location is null
     */
    @Nonnull
    @Contract("_, _, _ -> new")
    public static CarBarrier createCarBarrier(@Nonnull Location loc, int rotation, @Nonnull List<Block> barrierBlocks) throws IllegalArgumentException {
        while (rotation < 0) rotation += 360;
        rotation %= 360;
        return provider.createCarBarrier(loc, rotation, barrierBlocks);
    }

    /**
     * Creates a hologram with the specific parameters.
     *
     * @param loc               location of the hologram
     * @param visibleToEveryone if true, the hologram is visible to everyone
     * @param lines             lines of the hologram
     * @return hologram with the specific parameters
     * @throws IllegalArgumentException if the location is null or the lines are empty
     */
    public static Hologram createHologram(@Nonnull Location loc, boolean visibleToEveryone, @Nonnull String... lines) throws IllegalArgumentException {
        return provider.createHologram(loc, visibleToEveryone, lines);
    }

    /**
     * Converts an itemstack to a string.
     *
     * @param itemStack itemstack to convert
     * @return string of the itemstack
     * @throws IllegalArgumentException if the itemstack is null
     */
    @Nonnull
    public static String itemStackToString(@Nonnull ItemStack itemStack) throws IllegalArgumentException {
        return provider.itemStackToString(itemStack);
    }

    /**
     * Converts a string to an itemstack.
     *
     * @param itemStack string to convert
     * @return itemstack of the string
     */
    @Nullable
    @Contract("null -> null")
    public static ItemStack itemStackFromString(@Nullable String itemStack) {
        return provider.itemStackFromString(itemStack);
    }

    /**
     * Converts the given hex color code (with or without #) to a decimal color code.
     *
     * @param hex hex color code
     * @return decimal color code
     * @throws IllegalArgumentException if the hex color code is invalid or null
     */
    public static int convertHexToDecimalColor(@Nonnull String hex) throws IllegalArgumentException {
        return provider.convertHexToDecimalColor(hex);
    }

    /**
     * Creates an armorstand with a consumer
     *
     * @param location location to spawn the armorstand at.
     * @return ArmorStand instance
     * @throws IllegalArgumentException if the location is null
     */
    @Nonnull
    @Contract("_ -> new")
    public static FakeArmorStand createFakeArmorStand(@Nonnull Location location) throws IllegalArgumentException {
        return provider.createFakeArmorStand(location);
    }

    /**
     * Gets an armorstand by its id.
     *
     * @param id id of the armorstand
     * @return ArmorStand instance
     */
    @Nullable
    public static FakeArmorStand getFakeArmorStand(int id) {
        return provider.getFakeArmorStand(id);
    }

    /**
     * Converts a string to a transparent string.
     *
     * @param text text to convert
     * @return transparent text
     * @throws IllegalArgumentException if the text contains characters that have no transparent representation
     */
    @Contract("null -> null")
    public static String convertToTransparent(@Nullable String text) throws IllegalArgumentException {
        return provider.convertToTransparent(text);
    }

    /**
     * Creates an interaction trigger with the specific parameters.
     *
     * @param world    world in which this trigger is located
     * @param minX     minimum x value
     * @param minY     minimum y value
     * @param minZ     minimum z value
     * @param maxX     maximum x value
     * @param maxY     maximum y value
     * @param maxZ     maximum z value
     * @param callback callback that is called when a player interacts with this trigger
     * @param range    range in which a player can interact with this trigger
     * @return interaction trigger with the specific parameters
     * @throws IllegalArgumentException if one of the parameters is null, the max values are smaller than the min values or the range is negative
     */
    public static InteractionTrigger createInteractionTrigger(@Nonnull World world,
                                                              double minX, double minY, double minZ,
                                                              double maxX, double maxY, double maxZ,
                                                              @Nonnull Consumer<PlayerInteractEvent> callback,
                                                              @Nonnegative double range)
            throws IllegalArgumentException {
        return provider.createInteractionTrigger(world, minX, minY, minZ, maxX, maxY, maxZ, callback, range);
    }
}