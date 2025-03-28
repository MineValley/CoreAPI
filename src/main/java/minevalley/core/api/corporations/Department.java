package minevalley.core.api.corporations;

import minevalley.core.api.Registrant;
import minevalley.core.api.corporations.tasks.Task;
import minevalley.core.api.users.User;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public interface Department extends Registrant {

    /**
     * Gets this department's name.
     *
     * @return name as string
     */
    @Nonnull
    @Contract(pure = true)
    String getName();

    /**
     * Sets this departments name.
     *
     * @param name name as string
     * @throws IllegalArgumentException if the name is null
     */
    void setName(@Nonnull String name) throws IllegalArgumentException;

    /**
     * Gets this department's description.
     *
     * @return description as string
     */
    @Nonnull
    @Contract(pure = true)
    String getDescription();

    /**
     * Sets this departments description.
     *
     * @param description description as string
     */
    void setDescription(@Nonnull String description);

    /**
     * Gets the holder of this department.
     *
     * @return holder of this department (company/organization)
     */
    @Nonnull
    @Contract(pure = true)
    Group getHolder();

    @Nonnull
    Department getParentDepartment();

    @Nonnull
    List<Department> getChildDepartments();

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
    @Nonnull
    List<Member> getMembers();

    @Nullable
    @Contract(value = "null -> null", pure = true)
    Member getMember(@Nullable User user);

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
