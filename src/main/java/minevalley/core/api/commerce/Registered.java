package minevalley.core.api.commerce;

import minevalley.core.api.economy.BankAccount;

import java.util.List;

public interface Registered {

    /**
     * Gets the name of this registered.
     *
     * @return name of registered
     */
    String getName();

    /**
     * Sets the name of this registered.
     * <p>
     * <b>Note:</b> Always check, if the name is already used!
     */
    void setName();

    /**
     * Gets the id of this registered.
     *
     * @return id of registered
     */
    String getId();

    /**
     * Gets the bank account of this registered.
     *
     * @return bank account of registered
     */
    BankAccount getBankAccount();

    /**
     * Gets a list with the members of this registered.
     * @return members as list
     */
    List<Member> getMembers();

    /**
     * Removes the specific member from this registered.
     * @param member member to remove
     */
    void removeMember(Member member);

    /**
     * Removes the member with the specific unique id from this registered.
     * @param uniqueId member to remove
     */
    void removeMember(String uniqueId);

    /**
     * Adds a member with the specific unique id to this registered.
     * @param uniqueId member to add
     */
    void addMember(String uniqueId);
}
