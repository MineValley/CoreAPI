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
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

@ApiStatus.Internal
public interface Core {

    @Nonnull
    JavaPlugin getInstance();

    @Nonnull
    Server server();

    @Nonnull
    @Contract(pure = true)
    String getVersion(@Nonnull CoreModule module) throws IllegalArgumentException;

    @Nonnull
    @Contract(pure = true)
    Developer[] getDevelopers(@Nonnull CoreModule module) throws IllegalArgumentException;

    @Nonnull
    BukkitTask runSyncTaskLater(long delay, @Nonnull Runnable runnable) throws IllegalArgumentException;

    @Nonnull
    BukkitTask runAsyncTaskLater(long delay, @Nonnull Runnable runnable) throws IllegalArgumentException;

    @Nonnull
    BukkitTask runSyncTaskPeriodically(long delay, long period, @Nonnull Runnable runnable) throws IllegalArgumentException;

    @Nonnull
    BukkitTask runAsyncTaskPeriodically(long delay, long period, @Nonnull Runnable runnable) throws IllegalArgumentException;

    void registerListener(@Nonnull Listener listener) throws IllegalArgumentException;

    void callEvent(@Nonnull Event event) throws IllegalArgumentException;

    @Nonnull
    OnlineUser getOnlineUser(@Nonnull Player player);

    @Nonnull
    OnlineUser getOnlineUser(@Nonnull UUID uniqueId) throws UserNotOnlineException;

    @Nonnull
    @Contract(pure = true)
    ArgumentType<OnlineUser> getOnlineUserArgumentType();

    @Nonnull
    @Contract(pure = true)
    ArgumentType<Set<OnlineUser>> getOnlineUsersSetArgumentType();

    void setSetting(@Nonnull String key, @Nonnull String value) throws IllegalArgumentException;

    String getSetting(String key);

    void updateStatistic(@Nonnull String key, double value) throws IllegalArgumentException;

    double getStatistic(@Nonnull String key) throws IllegalArgumentException;

    @Nonnull
    World getMainWorld();

    @Nonnull
    World getBuildingWorld() throws IllegalStateException;

    @Nonnull
    World getPresetsWorld() throws IllegalStateException;

    @Nonnull
    FakeBlock createFakeBlock(@Nonnull Block block, @Nonnull Material material, int data) throws IllegalArgumentException;

    @Nonnull
    BlockDisplay createBlockDisplay(@Nonnull Location location, @Nonnull Material material) throws IllegalArgumentException;

    @Nonnull
    ItemDisplay createItemDisplay(@Nonnull Location location, @Nonnull ItemStack itemStack) throws IllegalArgumentException;

    @Nonnull
    TextDisplay createTextDisplay(@Nonnull Location location, @Nonnull ComponentLike text) throws IllegalArgumentException;

    @Nonnull
    NPC createNPC(@Nonnull UUID skinUniqueId, @Nonnull String name, @Nonnull Location location)
            throws IllegalArgumentException;

    @Nonnull
    NPC createNPC(@Nonnull String value, @Nonnull String signature, @Nonnull String name, @Nonnull Location location)
            throws IllegalArgumentException;

    @Nonnull
    CarBarrier createCarBarrier(@Nonnull Location loc, int rotation, @Nonnull List<Block> barrierBlocks) throws IllegalArgumentException;

    @Nonnull
    Hologram createHologram(@Nonnull Location loc, boolean visibleToEveryone, @Nonnull String... lines) throws IllegalArgumentException;

    int convertHexToDecimalColor(@Nonnull String hex) throws IllegalArgumentException;

    @Nonnull
    FakeArmorStand createFakeArmorStand(@Nonnull Location location) throws IllegalArgumentException;

    @Nullable
    FakeArmorStand getFakeArmorStand(int id);

    @Nonnull
    InteractionTrigger createInteractionTrigger(@Nonnull World world,
                                                double minX, double minY, double minZ,
                                                double maxX, double maxY, double maxZ,
                                                @Nonnull Consumer<PlayerInteractEvent> callback,
                                                @Nonnegative double range)
            throws IllegalArgumentException;
}