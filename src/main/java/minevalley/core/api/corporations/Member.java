package minevalley.core.api.corporations;

import minevalley.core.api.corporations.tasks.Task;
import minevalley.core.api.users.User;

import javax.annotation.Nonnull;
import java.util.List;

@SuppressWarnings("unused")
public interface Member {

    @Nonnull
    String getId();

    /**
     * Gets this member's user object.
     *
     * @return user object
     */
    @Nonnull
    User getUser();

    /**
     * Gets the department this member is currently in.
     *
     * @return this members department
     */
    @Nonnull
    Department getDepartment();

    void switchDepartment(@Nonnull Department department) throws IllegalArgumentException;

    int getBaseWageInCents();

    void setBaseWageInCents(int baseWageInCents) throws IllegalArgumentException;

    @Nonnull
    List<Task> getAvailableTasks();

    void addTask(@Nonnull Task task) throws IllegalArgumentException;

    void removeTask(@Nonnull Task task) throws IllegalArgumentException;

    @Nonnull
    List<MemberPermission> getMemberPermissions();

    void addPermission(@Nonnull MemberPermission permission) throws IllegalArgumentException;

    void revokePermission(@Nonnull MemberPermission permission) throws IllegalArgumentException;

    void kick();
}
