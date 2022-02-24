package minevalley.core.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

public interface Registered {

    /**
     * Gets the registerNumber of this registered.
     * <p>
     * <b>User:</b> user's unique id
     * <p>
     * <b>Company:</b> company's id
     * <p>
     * <b>Organization:</b> organization's id
     * <p>
     * <b>Department (of company/organization):</b> department's id
     */
    String getRegisterNumber();

    /**
     * Gets the name to display on signs etc.
     * <p>
     * <b>User:</b> user's name
     * <p>
     * <b>Company:</b> company's name
     * <p>
     * <b>Organization:</b> organizsation's name
     * <p>
     * <b>Department (of company/organization):</b> name of department - name of company/organisation
     * <p>
     * <p>
     * <b>Note:</b> department names may be longer than 16 characters and can therefore not been put onto signs!
     */
    String getRegisterName();

    /**
     * Checks whether a user is represented by this registered (in case it represents only one user),
     * or whether the user is part of the group / department, that this registered represents.
     *
     * @param user user to check
     * @return true, if the user is represented by this registered or is a part of the group / department that this registered represents
     */
    boolean contains(User user);

    /**
     * Gets the type of this registered.
     *
     * @return registered's type
     */
    Type getType();

    /**
     * Converts this registered to a string.
     *
     * @return registered as string
     */
    String toString();

    @AllArgsConstructor
    @Getter
    enum Type {
        USER("U"),
        GROUP("G"),
        DEPARTMENT("D");

        private final String mark;
    }
}
