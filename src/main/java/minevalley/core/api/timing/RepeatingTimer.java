package minevalley.core.api.timing;

import javax.annotation.Nonnull;

/**
 * Repeating timers are used to call continuous actions that are supposed to be called in a period longer than 2 minutes (for shorter spans use schedulers).
 */
@SuppressWarnings("unused")
public interface RepeatingTimer {

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
    void setCallback(@Nonnull Runnable runnable);

    /**
     * Gets this timers period.
     *
     * @return period as int
     */
    int getPeriod();

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
}
