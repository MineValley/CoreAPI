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
     * <p>
     * <b>Note:</b> Always check, if the name is already used!
     */
    void setName();

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
     * @return members as list
     */
    List<Member> getMembers();

    /**
     * Removes the specific member from this group.
     * @param member member to remove
     */
    void removeMember(Member member);

    /**
     * Removes the member with the specific unique id from this group.
     * @param uniqueId member to remove
     */
    void removeMember(String uniqueId);

    /**
     * Adds a member with the specific unique id to this group.
     * @param uniqueId member to add
     */
    void addMember(String uniqueId);
}
