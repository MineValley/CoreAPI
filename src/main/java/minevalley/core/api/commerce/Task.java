package minevalley.core.api.commerce;

public interface Task {

    /**
     * Gets the number of possible repetitions of this task.
     * @return number of possible repetitions (-1 if there is no restriction)
     */
    int getNumberOfRepetitions();

    /**
     * Sets the number of possible repetitions.
     * -1 if there is no restriction!
     */
    void setNumberOfRepetitions(int repetitions);

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
