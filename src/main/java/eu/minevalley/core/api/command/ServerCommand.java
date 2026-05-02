package eu.minevalley.core.api.command;

import eu.minevalley.proxima.api.command.Command;
import eu.minevalley.proxima.api.user.ProxyUser;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

public interface ServerCommand extends Command<ProxyUser> {

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