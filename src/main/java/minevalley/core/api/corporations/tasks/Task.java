package minevalley.core.api.corporations.tasks;

import minevalley.core.api.users.User;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.List;

@SuppressWarnings("unused")
public interface Task {

    /**
     * Gets the wages paid to the user who completes this task.
     *
     * @return tasks wage
     */
    @Contract(pure = true)
    int getWageInCents();

    /**
     * Sets the wage paid to the user who completes this task.
     *
     * @param wageInCents wage in cents
     * @throws IllegalArgumentException if the wage is negative
     */
    void setWage(int wageInCents) throws IllegalArgumentException;

    /**
     * Lets a user enter this task.
     *
     * @param user user to enter this task
     * @return true, if participation was successful
     * @throws IllegalArgumentException if the user is null or already participating
     */
    boolean participate(@Nonnull User user) throws IllegalArgumentException;

    /**
     * Lets a user leave this task.
     *
     * @param user user to leave this task
     * @throws IllegalArgumentException if the user is null or not participating
     */
    void leave(@Nonnull User user) throws IllegalArgumentException;

    /**
     * Gets a list of all users currently participating in this task.
     *
     * @return list of participants
     */
    @Nonnull
    @Contract(pure = true)
    List<User> getParticipants();

    /**
     * This increases the current amount of completions. Adds the user to the task-log and transfers the wage to the user.
     *
     * @param user user, who completed the task
     * @throws IllegalArgumentException if the user is null or not participating
     */
    void complete(@Nonnull User user) throws IllegalArgumentException;

    /**
     * Deletes this task.
     */
    void delete();
}
