package minevalley.core.api.commerce;

import minevalley.core.api.enums.MemberPermission;

import java.util.List;

public interface Member {

    /**
     * Gets this members unique id.
     * @return unique id of this member
     */
    String getUniqueId();

    /**
     * Gets the department this member is currently in.
     * @return this members department
     */
    Department getDepartment();

    /**
     * Gets this members permissions.
     * @return list of members permissions
     */
    List<MemberPermission> getPermissions();

    /**
     * Gets whether this member is its departments head.
     * @return true, if this member is the head of his department
     */
    boolean isHeadOfDepartment();
}
