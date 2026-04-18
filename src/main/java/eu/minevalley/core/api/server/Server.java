package eu.minevalley.core.api.server;

import eu.minevalley.core.api.audio.SoundReceiver;
import eu.minevalley.core.api.database.DatabaseHolder;
import eu.minevalley.core.api.messaging.MessageReceiver;
import eu.minevalley.core.api.user.OnlineUser;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
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