package minevalley.core.api.corporations;

import minevalley.core.api.corporations.tasks.Task;
import minevalley.core.api.users.User;

import java.util.List;

@SuppressWarnings("unused")
public interface Member {

    String getId();

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

    void switchDepartment(Department department);

    int getBaseWageInCents();

    void setBaseWageInCents(int baseWageInCents);

    List<Task> getAvailableTasks();

    void addTask(Task task);

    void removeTask(Task task);

    List<MemberPermission> getMemberPermissions();

    void addPermission(MemberPermission permission);

    void revokePermission(MemberPermission permission);

    void kick();
}
