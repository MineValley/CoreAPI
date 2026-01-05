package minevalley.core.api.corporations;

import minevalley.core.api.Registrant;
import minevalley.core.api.corporations.tasks.Task;
import minevalley.core.api.users.User;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    @Nullable
    @Contract(pure = true)
    String getDescription();

    /**
     * Sets this departments description.
     *
     * @param description description as string
     */
    void setDescription(@Nullable String description);

    /**
     * Gets the holder of this department.
     *
     * @return holder of this department (company/organization)
     */
    @Nonnull
    @Contract(pure = true)
    Group getHolder();

    /**
     * Gets the parent department of this department.
     *
     * @return parent department
     */
    @Nonnull
    @Contract(pure = true)
    Department getParentDepartment();

    /**
     * Gets the child departments of this department.
     *
     * @return list with all child departments
     */
    @Nonnull
    @Contract(pure = true)
    List<Department> getChildDepartments();

    /**
     * Gets whether this department is the default department of the organization / company. The main department is the department, new members will be put into.
     *
     * @return true, if this department is the main department
     */
    @Contract(pure = true)
    boolean isDefaultDepartment();

    /**
     * Gets the members of this department.
     *
     * @return list with all members of this department
     */
    @Nonnull
    @Contract(pure = true)
    List<Member> getMembers();

    /**
     * Gets the member of this department for the given user.
     *
     * @param user the user
     * @return the member or null, if the user is not a member of this department
     */
    @Nullable
    @Contract(value = "null -> null", pure = true)
    Member getMember(@Nullable User user);

    /**
     * Gets the default base wage of this department in cents.
     *
     * @return base wage in cents
     */
    @Contract(pure = true)
    int getDefaultBaseWageInCents();

    /**
     * Sets the default base wage of this department in cents.
     *
     * @param baseWageInCents base wage in cents
     * @throws IllegalArgumentException if the base wage is negative
     */
    void setDefaultBaseWageInCents(int baseWageInCents) throws IllegalArgumentException;

    /**
     * Gets all available tasks of this department.
     *
     * @return list with all available tasks
     */
    @Contract(pure = true)
    List<Task> getAvailableTasks();

    /**
     * Adds a new available task to this department.
     *
     * @param task the task to add
     * @throws IllegalArgumentException if the task is null or already added
     */
    void addTask(@Nonnull Task task) throws IllegalArgumentException;

    /**
     * Removes an available task from this department.
     *
     * @param task the task to remove
     * @throws IllegalArgumentException if the task is null or not present
     */
    void removeTask(@Nonnull Task task) throws IllegalArgumentException;

    /**
     * Gets the default member permissions of this department.
     *
     * @return set with all default member permissions
     */
    @Nonnull
    @Contract(pure = true)
    Set<MemberPermission> getDefaultMemberPermissions();

    /**
     * Adds a default member permission to this department.
     *
     * @param permission the permission to add
     * @throws IllegalArgumentException if the permission is null
     * @throws IllegalStateException    if the permission is already present
     */
    void addDefaultPermission(@Nonnull MemberPermission permission) throws IllegalArgumentException, IllegalStateException;

    /**
     * Revokes a default member permission from this department.
     *
     * @param permission the permission to revoke
     * @throws IllegalArgumentException if the permission is null
     * @throws IllegalStateException    if the permission is not present
     */
    void revokeDefaultPermission(@Nonnull MemberPermission permission) throws IllegalArgumentException, IllegalStateException;

    /**
     * Gets the department permissions with their necessary approval rates.
     *
     * @return map with all department permissions and their necessary approval rates
     */
    @Nonnull
    @Contract(pure = true)
    Map<DepartmentPermission, Integer> getPermissions();

    /**
     * Adds a department permission with the given necessary approval rate.
     *
     * @param permission            the permission to add
     * @param necessaryApprovalRate the necessary approval rate (0-100)
     * @throws IllegalArgumentException if the permission is null or the necessary approval rate is out of bounds
     * @throws IllegalStateException    if the permission is already present
     */
    void addPermission(@Nonnull DepartmentPermission permission, int necessaryApprovalRate)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * Revokes a department permission.
     *
     * @param permission the permission to revoke
     * @throws IllegalArgumentException if the permission is null
     * @throws IllegalStateException    if the permission is not present
     */
    void revokePermission(@Nonnull DepartmentPermission permission)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * Sets the necessary approval rate for a department permission.
     *
     * @param permission            the permission to set the approval rate for
     * @param necessaryApprovalRate the necessary approval rate (0-100)
     * @throws IllegalArgumentException if the permission is null or the necessary approval rate is out of bounds
     * @throws IllegalStateException    if the permission is not present
     */
    default void setNecessaryApprovalRate(@Nonnull DepartmentPermission permission, int necessaryApprovalRate)
            throws IllegalArgumentException, IllegalStateException {
        revokePermission(permission);
        addPermission(permission, necessaryApprovalRate);
    }
}
