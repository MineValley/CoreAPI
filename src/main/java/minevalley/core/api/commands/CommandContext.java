package minevalley.core.api.commands;

import minevalley.core.api.users.OnlineUser;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface CommandContext {

    /**
     * Gets the sender of the command.
     *
     * @return the sender of the command
     */
    @Nonnull
    OnlineUser getSender();

    /**
     * Get the argument with the given name and type.
     *
     * @param name  the name of the argument
     * @param clazz the class of the argument
     * @param <V>   the type of the argument
     * @return the argument
     * @throws IllegalArgumentException if the argument is not of the given type or if the argument is not existing
     */
    @Nonnull
    <V> V getArgument(@Nonnull String name, @Nonnull Class<V> clazz) throws IllegalArgumentException;
}