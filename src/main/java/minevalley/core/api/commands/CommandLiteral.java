package minevalley.core.api.commands;

import minevalley.core.api.users.OnlineUser;
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
     * <b>Note:</b> When doing this on the run, the users commands have to be updated manually using {@link OnlineUser#updateCommands()} for them to see this command.
     * </p>
     *
     * @param executableIfFrozen sets whether the command can be executed when the user is frozen.
     * @see OnlineUser#updateCommands()
     */
    void register(boolean executableIfFrozen);

    /**
     * Registers the command so it is accessible to the users.
     * <p>
     * <b>Note:</b>
     * <ul>
     *     <li>
     *         When doing this on the run, the users commands have to be updated manually using {@link OnlineUser#updateCommands()} for them to see this command.
     *     </li>
     *     <li>
     *         If you want to set the command to be executable when the user is frozen, use {@link #register(boolean)}.
     *     </li>
     * </ul>
     * </p>
     *
     * @see OnlineUser#updateCommands()
     */
    default void register() {
        register(false);
    }
}