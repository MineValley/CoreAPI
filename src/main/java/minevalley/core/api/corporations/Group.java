package minevalley.core.api.corporations;

import minevalley.core.api.Registrant;
import minevalley.core.api.banking.BankAccount;
import minevalley.core.api.users.User;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

@SuppressWarnings("unused")
public interface Group extends Registrant {

    /**
     * Gets the name of this group.
     *
     * @return name of group
     */
    @Nonnull
    @Contract(pure = true)
    String getName();

    /**
     * Gets this group's description
     *
     * @return description as string
     */
    @Nonnull
    @Contract(pure = true)
    String getDescription();

    /**
     * Sets the name of this group.
     *
     * @param name new name
     * @return Result of rename
     * @throws IllegalArgumentException if the name is null
     */
    @Nonnull
    RenameFeedback changeName(@Nonnull String name) throws IllegalArgumentException;

    /**
     * Changes the description of this group. Max. length = 150 chars; Min. length = 15 chars
     *
     * @param description description as string
     * @return result of the description change
     */
    @Nonnull
    RenameFeedback changeDescription(@Nonnull String description) throws IllegalArgumentException;

    /**
     * Gets the department, which is markes as default.
     *
     * @return group's default department
     */
    @Nonnull
    @Contract(pure = true)
    Department getDefaultDepartment();

    /**
     * Gets a list of all departments.
     *
     * @return departments as list
     */
    @Nonnull
    @Contract(pure = true)
    List<Department> getDepartments();

    /**
     * Removes the member with the specific unique id from this group.
     *
     * @param user member to remove
     * @throws IllegalArgumentException if the user is null
     */
    void removeMember(@Nonnull User user) throws IllegalArgumentException;

    /**
     * Adds a member to this group.
     * <p>
     * <b>Note:</b> The user will be added to the default department!
     *
     * @param user member to add as user
     * @return member object representing this user
     * @throws IllegalArgumentException if the user is null
     */
    @Nonnull
    Member addMember(@Nonnull User user) throws IllegalArgumentException;

    @Nullable
    @Contract(value = "null -> null", pure = true)
    Member getMember(@Nullable User user);

    /**
     * Gets the bank account of this group.
     *
     * @return bank account of group
     */
    @Nullable
    @Contract(pure = true)
    BankAccount getBankAccount();

    /**
     * Deletes this group.
     *
     * @throws IllegalStateException if the group is already deleted
     */
    void delete() throws IllegalStateException;

    enum RenameFeedback {
        FORBIDDEN_CHARACTERS,
        FORBIDDEN_WORDS,
        ALREADY_USED,
        TOO_LONG,
        TOO_SHORT,
        SUCCESS
    }
}
