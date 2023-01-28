package minevalley.core.api.corporations;

import minevalley.core.api.Registrant;
import minevalley.core.api.User;
import minevalley.core.api.economy.BankAccount;

import java.util.List;

public interface Group extends Registrant {

    /**
     * Gets the name of this group.
     *
     * @return name of group
     */
    String getName();

    /**
     * Gets this group's description
     *
     * @return description as string
     */
    String getDescription();

    /**
     * Sets the name of this group.
     *
     * @return Result of rename
     */
    RenameFeedback changeName(String name);

    /**
     * Changes the description of this group. Max. length = 150 chars; Min. length = 15 chars
     *
     * @param description description as string
     * @return result of the description change
     */
    RenameFeedback changeDescription(String description);

    /**
     * Gets the department, which is markes as default.
     *
     * @return group's default department
     */
    Department getDefaultDepartment();

    /**
     * Gets a list of all departments.
     *
     * @return departments as list
     */
    List<Department> getDepartments();

    /**
     * Removes the member with the specific unique id from this group.
     *
     * @param user member to remove
     */
    void removeMember(User user);

    /**
     * Adds a member to this group.
     * <p>
     * <b>Note:</b> The user will be added to the default department!
     *
     * @param user member to add
     */
    Member addMember(User user);

    Member getMember(User user);

    /**
     * Gets the bank account of this group.
     *
     * @return bank account of group
     */
    BankAccount getBankAccount();

    enum RenameFeedback {
        FORBIDDEN_CHARACTERS,
        FORBIDDEN_WORDS,
        ALREADY_USED,
        TOO_LONG,
        TOO_SHORT,
        SUCCESS
    }
}
