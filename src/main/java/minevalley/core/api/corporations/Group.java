package minevalley.core.api.corporations;

import minevalley.core.api.Registered;
import minevalley.core.api.economy.BankAccount;

import java.util.List;

public interface Group extends Registered {

    /**
     * Gets the id of this group.
     *
     * @return id of group
     */
    int getId();

    /**
     * Gets the name of this group.
     *
     * @return name of group
     */
    String getName();

    /**
     * Sets the name of this group.
     *
     * @return Result of the rename
     */
    RenameFeedback changeName(String name);

    /**
     * Gets this group's description
     *
     * @return description as string
     */
    String getDescription();

    /**
     * Sets the description of this group.
     *
     * @param description description as string
     */
    void setDescription(String description);

    /**
     * Changes the description of this group. Max. length = 150 chars; Min. length = 15 chars
     *
     * @param description description as string
     * @return result of the description change
     */
    RenameFeedback changeDescription(String description);

    /**
     * Gets whether this group is a company (otherwise: organization).
     *
     * @return true, if group is company
     */
    boolean isCompany();

    /**
     * Gets this group's owner.
     *
     * @return unique id of owner as string
     */
    String getOwner();

    /**
     * Gets a list of all operators.
     *
     * @return list of all operators' unique ids
     */
    List<String> getOperators();

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
     * @param uniqueId member to remove
     */
    void removeMember(String uniqueId);

    /**
     * Adds a member with the specific unique id to this group.
     *
     * @param uniqueId member to add
     */
    void addMember(String uniqueId);

    /**
     * Gets the bank account of this group.
     *
     * @return bank account of group
     */
    BankAccount getBankAccount();

    /**
     * Deletes this group.
     */
    void delete();

    enum RenameFeedback {
        FORBIDDEN_CHARACTERS,
        FORBIDDEN_WORDS,
        ALREADY_USED,
        TOO_LONG,
        TOO_SHORT,
        SUCCESS
    }
}
