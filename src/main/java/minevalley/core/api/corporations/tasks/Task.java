package minevalley.core.api.corporations.tasks;

import minevalley.core.api.users.User;

import java.util.List;

@SuppressWarnings("unused")
public interface Task {

    /**
     * Gets the wages paid to the user who completes this task.
     *
     * @return tasks wage
     */
    int getWageInCents();

    /**
     * Sets the wage paid to the user who completes this task.
     *
     * @param wageInCents wage in cents
     */
    void setWage(int wageInCents);

    /**
     * Lets a user enter this task.
     *
     * @param user user to enter this task
     * @return true, if participation was successful
     */
    boolean participate(User user);

    /**
     * Lets a user leave this task.
     *
     * @param user user to leave this task
     */
    void leave(User user);

    List<User> getParticipants();

    /**
     * This increases the current amount of completions. Adds the user to the task-log and transfers the wage to the user.
     *
     * @param user user, who completed the task
     */
    void complete(User user);

    /**
     * Deletes this task.
     */
    void delete();
}
