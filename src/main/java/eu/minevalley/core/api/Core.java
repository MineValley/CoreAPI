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
import eu.minevalley.proxima.api.ProximaProvider;
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
public interface Core extends ProximaProvider {

    /**
     * Get the {@link Server} object, granting access to all server-related features.
     *
     * @return Server object
     */
    @Nonnull
    Server server();

    /**
     * Gets the version of a specific module.
     *
     * @param module the module to get the version from
     * @return the version of the module
     * @throws IllegalArgumentException if module is null
     */
    @Nonnull
    @Contract(pure = true)
    String getVersion(@Nonnull CoreModule module) throws IllegalArgumentException;

    /**
     * Gets the developers of a specific module.
     *
     * @param module the module to get the developers from
     * @return the developers of the module
     * @throws IllegalArgumentException if module is null
     */
    @Nonnull
    @Contract(pure = true)
    Developer[] getDevelopers(@Nonnull CoreModule module) throws IllegalArgumentException;

    /**
     * Returns a task that will run on the next server tick.
     *
     * @param task the task to be run
     * @return a BukkitTask that contains the id number
     * @throws IllegalArgumentException if task is null
     */
    @Nonnull
    default BukkitTask runSyncTaskNow(@Nonnull Runnable task) throws IllegalArgumentException {
        return runSyncTaskLater(0, task);
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
    default BukkitTask runAsyncTaskNow(@Nonnull Runnable task) throws IllegalArgumentException {
        return runAsyncTaskLater(0, task);
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
    BukkitTask runSyncTaskLater(long delay, @Nonnull Runnable task) throws IllegalArgumentException;

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
    BukkitTask runAsyncTaskLater(long delay, @Nonnull Runnable task) throws IllegalArgumentException;

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
    BukkitTask runSyncTaskPeriodically(long delay, long period, @Nonnull Runnable task) throws IllegalArgumentException;

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
    BukkitTask runAsyncTaskPeriodically(long delay, long period, @Nonnull Runnable task) throws IllegalArgumentException;

    /**
     * Registers an event listener.
     *
     * @param listener listener to register
     * @throws IllegalArgumentException if the listener is null
     */
    void registerListener(@Nonnull Listener listener) throws IllegalArgumentException;

    /**
     * Calls an event.
     *
     * @param event event to call
     * @throws IllegalArgumentException if the event is null
     */
    void callEvent(@Nonnull Event event) throws IllegalArgumentException;

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
    OnlineUser getOnlineUser(@Nonnull Player player);

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
    OnlineUser getOnlineUser(@Nonnull UUID uniqueId) throws UserNotOnlineException;

    /**
     * Gets an argument type that resolves a single online user.
     *
     * @return the online user argument type
     */
    @Nonnull
    @Contract(pure = true)
    ArgumentType<OnlineUser> getOnlineUserArgumentType();

    /**
     * Gets an argument type that resolves multiple online users based on a selector.
     *
     * @return the online users selector argument type
     */
    @Nonnull
    @Contract(pure = true)
    ArgumentType<Set<OnlineUser>> getOnlineUsersSetArgumentType();

    /**
     * Sets the setting with the given key.
     * <p>
     * <b>Note:</b> When using the settings-method, do never change the settings manually via database!
     *
     * @param key   string of the key
     * @param value string of the (new) value
     * @throws IllegalArgumentException if the key or value is null
     */
    void setSetting(@Nonnull String key, @Nonnull String value) throws IllegalArgumentException;

    /**
     * Gets the settings with the specific key.
     *
     * @param key string of the key with which the setting is saved
     * @return setting as string from the specific key
     */
    @Nullable
    @Contract("null -> null")
    String getSetting(String key);

    /**
     * Gets the settings with the specific key.
     *
     * @param key          string of the key with which the setting is saved
     * @param defaultValue value that is returned, if the setting is null
     * @return setting as string from the specific key
     */
    @Nonnull
    default String getSetting(String key, @Nonnull String defaultValue) {
        return Optional.ofNullable(getSetting(key)).orElse(defaultValue);
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
    void updateStatistic(@Nonnull String key, double value) throws IllegalArgumentException;

    /**
     * Gets the statistic with the specific key.
     *
     * @param key string of the key with which the statistic is saved
     * @return statistic as double from the specific key
     * @throws IllegalArgumentException if the key is null
     */
    @Contract(pure = true)
    double getStatistic(@Nonnull String key) throws IllegalArgumentException;

    /**
     * Gets the main world.
     *
     * @return main world
     */
    @Nonnull
    @Contract(pure = true)
    World getMainWorld();

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
    World getBuildingWorld() throws IllegalStateException;

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
    World getPresetsWorld() throws IllegalStateException;

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
    FakeBlock createFakeBlock(@Nonnull Block block, @Nonnull Material material, int data) throws IllegalArgumentException;

    /**
     * Creates a block which is only visible to specific players.
     *
     * @param block    block where the fake block is placed
     * @param material fake block's material
     * @return fake block with the specific parameters
     * @throws IllegalArgumentException if one of the parameters is null or data is invalid
     */
    default FakeBlock createFakeBlock(@Nonnull Block block, @Nonnull Material material) throws IllegalArgumentException {
        return createFakeBlock(block, material, 0);
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
    BlockDisplay createBlockDisplay(@Nonnull Location location, @Nonnull Material material) throws IllegalArgumentException;

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
    ItemDisplay createItemDisplay(@Nonnull Location location, @Nonnull ItemStack itemStack) throws IllegalArgumentException;

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
    TextDisplay createTextDisplay(@Nonnull Location location, @Nonnull ComponentLike text) throws IllegalArgumentException;

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
    NPC createNPC(@Nonnull UUID skinUniqueId, @Nonnull String name, @Nonnull Location location)
            throws IllegalArgumentException;

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
    NPC createNPC(@Nonnull String skinValue, @Nonnull String skinSignature, @Nonnull String name, @Nonnull Location location)
            throws IllegalArgumentException;

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
    CarBarrier createCarBarrier(@Nonnull Location loc, int rotation, @Nonnull List<Block> barrierBlocks) throws IllegalArgumentException;

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
    Hologram createHologram(@Nonnull Location loc, boolean visibleToEveryone, @Nonnull String... lines) throws IllegalArgumentException;

    /**
     * Converts the given hex color code (with or without #) to a decimal color code.
     *
     * @param hex hex color code
     * @return decimal color code
     * @throws IllegalArgumentException if the hex color code is invalid or null
     */
    @Contract(pure = true)
    int convertHexToDecimalColor(@Nonnull String hex) throws IllegalArgumentException;

    /**
     * Creates an armorstand with a consumer
     *
     * @param location location to spawn the armorstand at.
     * @return ArmorStand instance
     * @throws IllegalArgumentException if the location is null
     */
    @Nonnull
    @Contract("_ -> new")
    FakeArmorStand createFakeArmorStand(@Nonnull Location location) throws IllegalArgumentException;

    /**
     * Gets an armorstand by its id.
     *
     * @param id id of the armorstand
     * @return ArmorStand instance
     */
    @Nullable
    @Contract(pure = true)
    FakeArmorStand getFakeArmorStand(int id);

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
    InteractionTrigger createInteractionTrigger(@Nonnull World world,
                                                double minX, double minY, double minZ,
                                                double maxX, double maxY, double maxZ,
                                                @Nonnull Consumer<PlayerInteractEvent> callback,
                                                @Nonnegative double range)
            throws IllegalArgumentException;
}