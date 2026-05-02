package eu.minevalley.core.api.command;

import eu.minevalley.core.api.user.OnlineUser;
import eu.minevalley.proxima.api.command.Command;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

public interface ServerCommand extends Command<OnlineUser> {

    /**
     * Gets the interface with all useful command arguments
     *
     * @return interface with useful command arguments
     */
    @Nonnull
    @Contract(pure = true)
    @Override
    ServerArgumentTypes argumentTypes();
}