package minevalley.core.api.timing;

/**
 * Timers are used to measure time periods in a more performant way than schedulers. Don't use them when measuring spans less than 2 minutes (use schedulers)
 * For repeating timers use {@link RepeatingTimer}
 */
public interface Timer {

    /**
     * Gets this timers callback.
     *
     * @return callback that is calles then timer terminates
     */
    Runnable getCallback();

    /**
     * Sets this timers callback.
     *
     * @param runnable callback that will be called when the timer terminates
     */
    void setCallback(Runnable runnable);

    /**
     * Cancels this timer.
     */
    void cancel();

    /**
     * Gets this timers delay in seconds
     *
     * @return delay as int
     */
    int getDelay();

    /**
     * Sets this timers delay
     *
     * @param delay delay in seconds as int
     */
    void setDelay(int delay);

    /**
     * Gets this timers id.
     *
     * @return id as int
     */
    int getId();

    /**
     * Calls this timer.
     * <p>
     * <b>Note:</b> It will be called again after terminating!
     */
    void call();
}
