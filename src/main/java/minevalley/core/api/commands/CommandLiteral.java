package minevalley.core.api.commands;

import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

/**
 * A command literal is a string that represents a (sub-) command.
 * It can be used to create the root command or any sub-command.
 */
@SuppressWarnings("unused")
public interface CommandLiteral extends CommandBuilder<CommandLiteral> {

    /**
     * Gets the literal.
     *
     * @return the literal.
     */
    @Nonnull
    @Contract(pure = true)
    String getLiteral();

    /**
     * Registers the command so it is accessible to the users.
     * <p>
     * <b>Note:</b>
     * <ul>
     * <li>
     * Registering a command should always be done directly after the module initialization. Registering a command inside a scheduler or after some other kind of action (other commands, events...) is not possible.
     * Register the command and rule the access via the requirements if needed.
     * </li>
     * <li>
     * If you want to set the command to be executable when the user is frozen, use {@link #register(boolean, String...)}.
     * </li>
     * </ul>
     * </p>
     */
    default void register() {
        register(false);
    }

    /**
     * Registers the command so it is accessible to the users.
     * <p>
     * <b>Note:</b> Registering a command should always be done directly after the module initialization. Registering a command inside a scheduler or after some other kind of action (other commands, events...) is not possible.
     * Register the command and rule the access via the requirements if needed.
     * </p>
     *
     * @param executableIfFrozen sets whether the command can be executed when the user is frozen.
     * @param aliases            the aliases of the command (can be left empty).
     * @throws IllegalArgumentException if the aliases are null.
     */
    void register(boolean executableIfFrozen, @Nonnull String... aliases) throws IllegalArgumentException;
}