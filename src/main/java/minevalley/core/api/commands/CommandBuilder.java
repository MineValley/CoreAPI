package minevalley.core.api.commands;

import minevalley.core.api.users.OnlineUser;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.function.BiFunction;
import java.util.function.Predicate;

@SuppressWarnings("unused")
public interface CommandBuilder {

    /**
     * Add a new branch to the command tree.
     *
     * @param branch the branch to add. This can either be a {@link CommandLiteral} or a {@link CommandArgument}.
     * @return this
     * @throws IllegalArgumentException if the branch is null.
     */
    @Nonnull
    @Contract("_ -> this")
    CommandBuilder then(@Nonnull CommandBuilder branch) throws IllegalArgumentException;

    /**
     * Sets whether the command can be executed by a given user.
     * <p>
     * <b>Note:</b> For a change in the visibility of a command to take effect in tabbing behavior, the command must be reloaded for the user using {@link OnlineUser#updateCommands()}.
     * </p>
     *
     * @param requirement the requirement to be met for the command to be executable for the user.
     * @return this
     * @throws IllegalArgumentException if the requirement is null.
     * @see OnlineUser#updateCommands()
     */
    @Nonnull
    @Contract("_ -> this")
    CommandBuilder requires(@Nonnull Predicate<OnlineUser> requirement) throws IllegalArgumentException;

    /**
     * Sets whether the command is executable if the user is frozen.
     * <p>
     * <b>Note:</b> By default the command is <b>not</b> executable if the user is frozen.
     * </p>
     *
     * @param executable true if the command should be executable when the user is frozen, false otherwise.
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    CommandBuilder executableIfFrozen(boolean executable);

    /**
     * Defines what happens, whenever the command is caused correctly with someone with the required permissions.
     *
     * @param execution the function to be executed when the command is executed.
     * @throws IllegalArgumentException if the execution is null.
     */
    void executes(@Nonnull BiFunction<OnlineUser, CommandContext, CommandResponse> execution) throws IllegalArgumentException;

    /**
     * Registers the command so it is accessible to the users.
     * <p>
     * <b>Note:</b> When doing this on the run, the users commands have to be updated manually using {@link OnlineUser#updateCommands()} for them to see this command.
     * </p>
     *
     * @see OnlineUser#updateCommands()
     */
    void register();
}
