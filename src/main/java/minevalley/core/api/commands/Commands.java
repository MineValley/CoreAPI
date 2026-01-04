package minevalley.core.api.commands;

import com.mojang.brigadier.arguments.ArgumentType;
import lombok.Setter;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

/**
 * A utility class for creating commands.
 */
@SuppressWarnings("unused")
public final class Commands {

    @Setter
    private static CommandManager commandManager;

    /**
     * @param name the name of the (sub-) command
     * @return a {@link CommandLiteral} object representing the (sub-) command
     * @throws IllegalArgumentException if the name is null or empty
     */
    @Nonnull
    @Contract(pure = true)
    public static CommandLiteral literal(@Nonnull String name) throws IllegalArgumentException {
        return commandManager.literal(name);
    }

    /**
     * Creates a new command argument.
     *
     * @param name the name of the argument
     * @param type the type of the argument
     * @param <T>  the class of the argument
     * @return a {@link CommandArgument} object representing the argument
     * @throws IllegalArgumentException if the name is null or empty, or if the type is null
     */
    @Nonnull
    @Contract(pure = true)
    public static <T> CommandArgument<T> argument(@Nonnull String name, @Nonnull ArgumentType<T> type) throws IllegalArgumentException {
        return commandManager.argument(name, type);
    }

    @ApiStatus.Internal
    public interface CommandManager {

        @Nonnull
        @Contract(pure = true)
        CommandLiteral literal(@Nonnull String name) throws IllegalArgumentException;

        @Nonnull
        @Contract(pure = true)
        <T> CommandArgument<T> argument(@Nonnull String name, @Nonnull ArgumentType<T> type) throws IllegalArgumentException;
    }
}
