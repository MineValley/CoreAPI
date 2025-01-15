package minevalley.core.api.server;

import minevalley.core.api.chat.MessageReceiver;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface Server extends MessageReceiver {

    /**
     * Get the server type.
     *
     * @return the server type
     */
    @Nonnull
    ServerType getType();

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