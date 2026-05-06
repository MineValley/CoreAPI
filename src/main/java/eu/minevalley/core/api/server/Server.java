package eu.minevalley.core.api.server;

import eu.minevalley.core.api.user.OnlineUser;
import eu.minevalley.proxima.api.audio.SoundReceiver;
import eu.minevalley.proxima.api.database.DatabaseHolder;
import eu.minevalley.proxima.api.messaging.MessageReceiver;
import eu.minevalley.proxima.api.server.ServerType;
import eu.minevalley.proxima.api.user.User;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.UUID;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public interface Server extends MessageReceiver, SoundReceiver, DatabaseHolder {

    /**
     * Get the server type.
     *
     * @return the server type
     */
    @Nonnull
    @Contract(pure = true)
    ServerType type();

    /**
     * Gets a stream of all online users.
     *
     * @return a stream of all online users
     */
    @Nonnull
    @Contract(pure = true)
    Stream<OnlineUser> getOnlineUsers();

    /**
     * Gets the online user of this specific player.
     * <br>
     * <strong>Note:</strong> If no user is found, a new one is created based on the player.
     *
     * @param player player to get the online user from
     * @return online user object of the given player
     * @throws IllegalArgumentException if the player is null
     */
    @Nonnull
    @Contract(pure = true)
    OnlineUser getOnlineUser(@Nonnull Player player) throws IllegalArgumentException;

    /**
     * Gets the user of this unique Id.
     *
     * @param uniqueId uuid to get user from
     * @return online user of the user with the given uuid, if online, otherwise null
     */
    @Nullable
    @Contract(pure = true)
    OnlineUser getOnlineUser(@Nonnull UUID uniqueId);

    /**
     * Gets the user of this unique Id.
     *
     * @param user user to get the online user of
     * @return online user of the given user, if online, otherwise null
     */
    @Nullable
    @Contract(pure = true)
    OnlineUser getOnlineUser(@Nonnull User user);

    /**
     * Gets whether the server is in development mode.
     * <p>
     * <b>Note:</b> the development mode is set inside the server properties and cannot be changed during runtime.
     *
     * @return true, if the server is in development mode
     */
    boolean isInDevelopmentMode();

    /**
     * Gets whether the server is in maintenance mode.
     *
     * @return true, if the server is in maintenance mode
     */
    boolean isInMaintenanceMode();

    /**
     * Sets the server to maintenance mode.
     *
     * @param maintenance true, if the server should be in maintenance mode
     */
    void setMaintenanceMode(boolean maintenance);

    /**
     * Gets whether the server is fully started.
     *
     * @return true, if the server is fully started
     */
    boolean isFullyStarted();

    /**
     * Restarts the server.
     */
    void restart();

    /**
     * Restarts the server and marks the cleaning routine to be executed on start up.
     */
    void restartWithCleaningRoutine();
}