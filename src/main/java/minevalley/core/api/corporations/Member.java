package minevalley.core.api.corporations;

import minevalley.core.api.enums.CorporatePermission;

import java.util.List;

public interface Member {

    /**
     * Gets this members unique id.
     *
     * @return unique id of this member
     */
    String getUniqueId();

    /**
     * Gets the department this member is currently in.
     *
     * @return this members department
     */
    Department getDepartment();

    /**
     * Gets this members permissions. This also includes the permissions of the members department.
     *
     * @return list of members permissions
     */
    List<CorporatePermission> getPermissions();

    /**
     * Gets the base wage of this member. If it's not defined, this returns the base wage of the member's department.
     * If the wage isn't defined (e.g. because the group is an organization), this returns -1.
     *
     * @return member's base wage
     */
    double getBaseWage();

    /**
     * Defines this member's base wage. (-1 to set the base wage to 'undefined')
     * @param baseWage member's base wage
     */
    void setBaseWage(double baseWage);

    /**
     * Gets the service wage of this member. If it's not defined, this returns the service wage of the member's department.
     * If the wage isn't defined (e.g. because the group is an organization), this returns -1.
     *
     * @return member's base wage
     */
    double getServiceWage();

    /**
     * Defines this member's service wage. (-1 to set the service wage to 'undefined')
     * @param serviceWage member's service wage
     */
    void setServiceWage(double serviceWage);

    /**
     * Gets whether this member is its departments head.
     *
     * @return true, if this member is the head of his department
     */
    boolean isHeadOfDepartment();
}
