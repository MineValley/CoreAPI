package eu.minevalley.core.api.command;

import eu.minevalley.core.api.user.OnlineUser;
import eu.minevalley.proxima.api.command.CommandArgument;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.Set;

@SuppressWarnings("unused")
public interface ArgumentBuilder extends eu.minevalley.proxima.api.command.ArgumentBuilder<OnlineUser> {

    /**
     * Gets an argument type that resolves a single online user.
     *
     * @param name the name of the argument
     * @return the online user argument type
     */
    @Nonnull
    @Contract(pure = true)
    CommandArgument<OnlineUser, OnlineUser> onlineUser(@Nonnull String name);

    /**
     * Gets an argument type that resolves multiple online users based on a selector.
     *
     * @param name the name of the argument
     * @return the online users selector argument type
     */
    @Nonnull
    @Contract(pure = true)
    CommandArgument<OnlineUser, Set<OnlineUser>> onlineUsersSet(@Nonnull String name);
}
