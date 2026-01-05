package minevalley.core.api.corporations;

import minevalley.core.api.corporations.tasks.Task;
import minevalley.core.api.users.User;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.List;

@SuppressWarnings("unused")
public interface Member {

    /**
     * Gets this member's id
     *
     * @return member id
     */
    @Nonnull
    @Contract(pure = true)
    String getId();

    /**
     * Gets this member's user object.
     *
     * @return user object
     */
    @Nonnull
    @Contract(pure = true)
    User getUser();

    /**
     * Gets the department this member is currently in.
     *
     * @return this members department
     */
    @Nonnull
    @Contract(pure = true)
    Department getDepartment();

    /**
     * Moves this member to another department
     *
     * @param department department to switch to
     * @throws IllegalArgumentException if the department is null or not in the same group
     * @throws IllegalStateException    if the member is already part of the department, or not part of the group anymore
     */
    void switchDepartment(@Nonnull Department department) throws IllegalArgumentException, IllegalStateException;

    /**
     * Gets the base wage of this member
     *
     * @return base wage in cents
     */
    @Contract(pure = true)
    int getBaseWageInCents();

    /**
     * Sets this member's base wage
     *
     * @param baseWageInCents base wage in cents
     * @throws IllegalArgumentException if the wage is negative
     */
    void setBaseWageInCents(int baseWageInCents) throws IllegalArgumentException;

    /**
     * Gets a list of all available tasks for this member.
     *
     * @return list of all available tasks
     */
    @Nonnull
    List<Task> getAvailableTasks();

    /**
     * Adds a task to this member.
     *
     * @param task task to add
     * @throws IllegalArgumentException if the task is null
     */
    void addTask(@Nonnull Task task) throws IllegalArgumentException;

    /**
     * Removes a task from this member.
     *
     * @param task task to remove
     * @throws IllegalArgumentException if the task is null
     */
    void removeTask(@Nonnull Task task) throws IllegalArgumentException;

    /**
     * Gets a list of all granted member permissions
     *
     * @return list of all granted member permissions
     */
    @Nonnull
    List<MemberPermission> getMemberPermissions();

    /**
     * Grants a permission to this member
     *
     * @param permission permission to grant
     * @throws IllegalArgumentException if the permission is null
     * @throws IllegalStateException    if the permission is already granted
     */
    void addPermission(@Nonnull MemberPermission permission) throws IllegalArgumentException, IllegalStateException;

    /**
     * Revokes a permission from this member
     *
     * @param permission permission to revoke
     * @throws IllegalArgumentException if the permission is null
     * @throws IllegalStateException    if the permission is not granted
     */
    void revokePermission(@Nonnull MemberPermission permission) throws IllegalArgumentException, IllegalStateException;

    /**
     * Removes this member from the group and department.
     */
    void kick();
}
