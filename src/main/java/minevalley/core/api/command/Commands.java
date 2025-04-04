package minevalley.core.api.command;

import com.mojang.brigadier.arguments.ArgumentType;
import lombok.Setter;
import org.jetbrains.annotations.ApiStatus;

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
    public static @Nonnull CommandLiteral literal(@Nonnull String name) throws IllegalArgumentException {
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
    public static <T> @Nonnull CommandArgument<T> argument(@Nonnull String name, @Nonnull ArgumentType<T> type) throws IllegalArgumentException {
        return commandManager.argument(name, type);
    }

    @ApiStatus.Internal
    private interface CommandManager {

        @Nonnull
        CommandLiteral literal(@Nonnull String name) throws IllegalArgumentException;

        <T> @Nonnull CommandArgument<T> argument(@Nonnull String name, @Nonnull ArgumentType<T> type) throws IllegalArgumentException;
    }
}
