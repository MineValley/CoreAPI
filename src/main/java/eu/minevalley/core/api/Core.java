package eu.minevalley.core.api;

import com.mojang.brigadier.arguments.ArgumentType;
import eu.minevalley.core.api.interaction.InteractionTrigger;
import eu.minevalley.core.api.server.Server;
import eu.minevalley.core.api.user.OnlineUser;
import eu.minevalley.core.api.virtual.CarBarrier;
import eu.minevalley.core.api.virtual.FakeArmorStand;
import eu.minevalley.core.api.virtual.FakeBlock;
import eu.minevalley.core.api.virtual.Hologram;
import eu.minevalley.core.api.virtual.display.BlockDisplay;
import eu.minevalley.core.api.virtual.display.ItemDisplay;
import eu.minevalley.core.api.virtual.display.TextDisplay;
import eu.minevalley.core.api.virtual.npc.NPC;
import eu.minevalley.proxima.api.Developer;
import eu.minevalley.proxima.api.user.exception.UserNotOnlineException;
import net.kyori.adventure.text.ComponentLike;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public final class Core {

    private static CoreProvider provider;

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
     * Gets the version of a specific module.
     *
     * @param module the module to get the version from
     * @return the version of the module
     * @throws IllegalArgumentException if module is null
     */
    @Nonnull
    @Contract(pure = true)
    public static String getVersion(@Nonnull CoreModule module) throws IllegalArgumentException {
        return provider.getVersion(module);
    }

    /**
     * Gets the developers of a specific module.
     *
     * @param module the module to get the developers from
     * @return the developers of the module
     * @throws IllegalArgumentException if module is null
     */
    @Nonnull
    @Contract(pure = true)
    public static Developer[] getDevelopers(@Nonnull CoreModule module) throws IllegalArgumentException {
        return provider.getDevelopers(module);
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
     * Gets the user of this unique Id.
     * <br>
     * <strong>Note:</strong> If the given unique id matches no online player, a {@code UserNotOnlineException} is thrown.
     *
     * @param uniqueId player to get user from
     * @return user object of the given player
     * @throws UserNotOnlineException if no online player matches the given unique id
     */
    @Nonnull
    public static OnlineUser getOnlineUser(@Nonnull UUID uniqueId) throws UserNotOnlineException {
        return provider.getOnlineUser(uniqueId);
    }

    /**
     * Gets an argument type that resolves a single online user.
     *
     * @return the online user argument type
     */
    @Nonnull
    @Contract(pure = true)
    public static ArgumentType<OnlineUser> getOnlineUserArgumentType() {
        return provider.getOnlineUserArgumentType();
    }

    /**
     * Gets an argument type that resolves multiple online users based on a selector.
     *
     * @return the online users selector argument type
     */
    @Nonnull
    @Contract(pure = true)
    public static ArgumentType<Set<OnlineUser>> getOnlineUsersSetArgumentType() {
        return provider.getOnlineUsersSetArgumentType();
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
     * Gets the main world.
     *
     * @return main world
     */
    @Nonnull
    @Contract(pure = true)
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
    @Contract(pure = true)
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
    @Contract(pure = true)
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
     * Creates a NPC with the specific parameters.
     *
     * @param skinUniqueId unique id of the player that this npc adapts the skin from.
     * @param name         name that will be displayed above the head
     * @param location     location to spawn this npc to
     * @return npc with specific parameters
     * @throws IllegalArgumentException if one of the parameters is null
     */
    @Nonnull
    @Contract("_, _, _ -> new")
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
    @Contract("_, _, _, _ -> new")
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
    public static CarBarrier createCarBarrier(@Nonnull Location loc, int rotation, @Nonnull List<Block> barrierBlocks)
            throws IllegalArgumentException {
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
    @Nonnull
    @Contract("_, _, _ -> new")
    public static Hologram createHologram(@Nonnull Location loc, boolean visibleToEveryone, @Nonnull String... lines)
            throws IllegalArgumentException {
        return provider.createHologram(loc, visibleToEveryone, lines);
    }

    /**
     * Converts the given hex color code (with or without #) to a decimal color code.
     *
     * @param hex hex color code
     * @return decimal color code
     * @throws IllegalArgumentException if the hex color code is invalid or null
     */
    @Contract(pure = true)
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
    @Contract(pure = true)
    public static FakeArmorStand getFakeArmorStand(int id) {
        return provider.getFakeArmorStand(id);
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
    @Nonnull
    @Contract("_, _, _, _, _, _, _, _, _ -> new")
    public static InteractionTrigger createInteractionTrigger(@Nonnull World world,
                                                              double minX, double minY, double minZ,
                                                              double maxX, double maxY, double maxZ,
                                                              @Nonnull Consumer<PlayerInteractEvent> callback,
                                                              @Nonnegative double range)
            throws IllegalArgumentException {
        return provider.createInteractionTrigger(world, minX, minY, minZ, maxX, maxY, maxZ, callback, range);
    }
}