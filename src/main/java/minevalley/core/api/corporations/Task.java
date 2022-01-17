package minevalley.core.api.corporations;

public interface Task {

    /**
     * Gets the number of possible repetitions of this task.
     * @return number of possible repetitions (-1 if there is no restriction)
     */
    int getMaximumAmountOfCompletions();

    /**
     * Defines how often this task can be completed (-1 for no restriction).
     * <b>Note: </b> This must not be less than the number of tasks already completed!
     * @param completions amount of possible completions
     */
    void setMaximumAmountOfCompletions(int completions);

    /**
     * Gets how often this task is completed already.
     * @return amount of completions as integer
     */
    int getCurrentAmountOfCompletions();

    /**
     * Defines how often this task has already been completed.
     * <b>Note: </b> This cannot be higher than the number of possible completions!
     * @param completions amount of completions so far
     */
    void setCurrentAmountOfCompletions(int completions);

    /**
     * Gets the wages paid to the user who completes this task.
     * @return tasks wage
     */
    double getWage();

    /**
     * Sets the wage paid to the user who completes this task.
     */
    void setWage(double wage);

    /**
     * Deletes this task.
     */
    void delete();
}
