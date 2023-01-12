package minevalley.core.api.corporations;

import minevalley.core.api.Registrant;

import java.util.List;
import java.util.Map;

public interface Department extends Registrant {

    /**
     * Gets this department's name.
     *
     * @return name as string
     */
    String getName();

    /**
     * Sets this departments name.
     *
     * @param name name as string
     */
    void setName(String name);

    /**
     * Gets this department's description.
     *
     * @return description as string
     */
    String getDescription();

    /**
     * Sets this departments description.
     *
     * @param description description as string
     */
    void setDescription(String description);

    /**
     * Gets the holder of this department.
     *
     * @return holder of this department (company/organization)
     */
    Group getHolder();

    Department getParentDepartment();

    /**
     * Gets whether this department is the default department of the organization / company. The main department is the department, new members will be put into.
     *
     * @return true, if this department is the main department
     */
    boolean isDefaultDepartment();

    /**
     * Gets the members of this department.
     *
     * @return list with all members of this department
     */
    List<Member> getMembers();

    int getDefaultBaseWageInCents();

    void setDefaultBaseWageInCents(int baseWageInCents);

    List<Task> getAvailableTasks();

    void addTask(Task task);

    void removeTask(Task task);

    List<MemberPermission> getDefaultMemberPermissions();

    void addDefaultPermission(MemberPermission permission);

    void revokeDefaultPermission(MemberPermission permission);

    Map<DepartmentPermission, Integer> getPermissions();

    void addPermission(DepartmentPermission permission, int necessaryApprovalRate);

    void revokePermission(DepartmentPermission permission);

    default void setNecessaryApprovalRate(DepartmentPermission permission, int necessaryApprovalRate) {
        revokePermission(permission);
        addPermission(permission, necessaryApprovalRate);
    }
}
