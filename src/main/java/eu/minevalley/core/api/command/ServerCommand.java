package eu.minevalley.core.api.command;

import eu.minevalley.core.api.user.OnlineUser;
import eu.minevalley.proxima.api.command.ArgumentTypes;
import eu.minevalley.proxima.api.command.Command;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

public interface ServerCommand extends Command<OnlineUser> {

    /**
     * Convenience entry point to create arguments using short helper methods, e.g.
     * command.argument().onlineUser("spieler");
     * <p>
     * Implementations should return an {@link ArgumentBuilder} backed
     * by their {@link ArgumentTypes} provider.
     * <p>
     * Note: this method is intentionally abstract to force implementors to provide the
     * ArgumentTypes instance (implementation-specific).
     */
    @Nonnull
    @Contract(pure = true)
    @Override
    ArgumentBuilder argument();
}