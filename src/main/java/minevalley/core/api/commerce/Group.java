package minevalley.core.api.commerce;

import minevalley.core.api.economy.BankAccount;

import java.util.List;

public interface Group {

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
    RenameFeedback setName();

    /**
     * Gets the id of this group.
     *
     * @return id of group
     */
    String getId();

    /**
     * Gets the bank account of this group.
     *
     * @return bank account of group
     */
    BankAccount getBankAccount();

    /**
     * Gets a list with the members of this group.
     *
     * @return members as list
     */
    Member[] getMembers();

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

    enum RenameFeedback {
        FORBIDDEN_CHARACTERS,
        FORBIDDEN_WORDS,
        ALREADY_USED,
        TOO_LONG,
        TOO_SHORT,
        SUCCESS
    }
}
