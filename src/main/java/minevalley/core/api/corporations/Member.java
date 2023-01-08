package minevalley.core.api.corporations;

import minevalley.core.api.User;

public interface Member {

    /**
     * Gets this member's user object.
     *
     * @return user object
     */
    User getUser();

    /**
     * Gets the department this member is currently in.
     *
     * @return this members department
     */
    Department getDepartment();

    PermissionConfiguration getPermissionConfiguration();

    /**
     * <b>Note:</b> if group is association, this is null!
     */
    WageConfiguration getWageConfiguration();
}
