package minevalley.core.api.timing;

import lombok.NonNull;

/**
 * Timers are used to measure time periods in a more performant way than schedulers. Don't use them when measuring spans less than 2 minutes (use schedulers).
 * <br>
 * For repeating timers use {@link RepeatingTimer}
 */
@SuppressWarnings("unused")
public interface Timer {

    /**
     * Gets this timer's callback.
     *
     * @return callback that is called then timer terminates
     */
    Runnable getCallback();

    /**
     * Sets this timer's callback.
     *
     * @param runnable callback that will be called when the timer terminates
     */
    void setCallback(@NonNull Runnable runnable);

    /**
     * Gets this timers delay in seconds.
     *
     * @return delay as int
     */
    int getDelay();

    /**
     * Sets this timers delay.
     *
     * @param delay delay in seconds as int
     */
    void setDelay(int delay);

    /**
     * Triggers this timer if it hasn't already done so.
     * <p>
     * <b>Note:</b> Timer will not be triggered again after terminating!
     */
    void expire();

    /**
     * Checks whether this timer has already expired.
     * <p>
     * <b>Note:</b> Timers expire even though they are deactivated. This method only checks whether the planned expiry time is in the past.
     * </p>
     *
     * @return true, if this timer expired
     */
    boolean hasExpired();

    /**
     * Activates this timer.
     * <p>
     * <b>Note:</b> Timers are activated by default. Only use this method, if this reminder may have been deactivated.
     * Reactivating a timer doesn't start it again! If the timer expired while being deactivated, it won't expire again.
     */
    void activate();

    /**
     * Deactivates this timer.
     */
    void deactivate();

    /**
     * Checks whether this timer is activated.
     * <p>
     * <b>Note:</b> This will still be true, when the timer expires and can only be changed by calling
     * {@link #deactivate()}
     * </p>
     *
     * @return true, if this timer is activated
     */
    boolean isActivated();

    /**
     * Restarts this timer.
     */
    void restart();
}
