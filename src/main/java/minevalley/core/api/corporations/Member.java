package minevalley.core.api.corporations;

import minevalley.core.api.User;

import java.util.List;

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

    int getBaseWageInCents();

    void setBaseWageInCents(int baseWageInCents);

    List<Task> getAvailableTasks();

    void addTask(Task task);

    void removeTask(Task task);

    List<MemberPermission> getMemberPermissions();

    void addPermission(MemberPermission permission);

    void revokePermission(MemberPermission permission);
}
