package minevalley.core.api.corporations;

import minevalley.core.api.User;
import org.bukkit.Location;

public interface Task {

    /**
     * Gets the number of possible repetitions of this task.
     *
     * @return number of possible repetitions (-1 if there is no restriction)
     */
    int getMaximumAmountOfCompletions();

    /**
     * Defines how often this task can be completed (-1 for no restriction).
     * <b>Note: </b> This must not be less than the number of tasks already completed!
     *
     * @param completions amount of possible completions
     */
    void setMaximumAmountOfCompletions(int completions);

    /**
     * Gets how often this task is completed already.
     *
     * @return amount of completions as integer
     */
    int getCurrentAmountOfCompletions();

    /**
     * Defines how often this task has already been completed.
     * <p>
     * <b>Note: </b> This cannot be higher than the number of possible completions!
     *
     * @param completions amount of completions so far
     */
    void setCurrentAmountOfCompletions(int completions);

    /**
     * This increases the current amount of completions. Adds the user to the task-log and transfers the wage to the user.
     *
     * @param user user, who completed the task
     */
    void complete(User user);

    /**
     * Gets the wages paid to the user who completes this task.
     *
     * @return tasks wage
     */
    double getWage();

    /**
     * Sets the wage paid to the user who completes this task.
     */
    void setWage(double wage);

    /**
     * Lets a user enter this task.
     *
     * @param user user to enter this task
     */
    void enter(User user);

    /**
     * Lets a user leave this task.
     *
     * @param user user to leave this task
     */
    void leave(User user);

    /**
     * Gets the location, this task will take place.
     *
     * @return this task's location
     */
    Location getLocation();

    /**
     * Deletes this task.
     */
    void delete();
}
