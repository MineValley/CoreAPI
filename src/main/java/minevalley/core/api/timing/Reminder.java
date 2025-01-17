package minevalley.core.api.timing;

import lombok.NonNull;

import java.time.DayOfWeek;
import java.util.List;

/**
 * Reminders are used to time specific events that depend on real time.
 * They are called exactly at the time, they are supposed to.
 */
@SuppressWarnings("unused")
public interface Reminder {

    /**
     * Gets this reminder's callback.
     *
     * @return callback
     */
    Runnable getCallback();

    /**
     * Sets the callback that is called, when the reminder is called.
     *
     * @param callback callback to be called, when specific time is reached
     */
    void setCallback(@NonNull Runnable callback);

    /**
     * Gets the selected weekdays.
     *
     * @return list of all selected weekdays
     */
    List<DayOfWeek> getWeekdays();

    /**
     * Sets the weekdays, this reminder is called on.
     *
     * @param weekdays weekdays, to call the callback on
     */
    void setWeekdays(List<DayOfWeek> weekdays);

    /**
     * Adds weekdays, this reminder is called on.
     *
     * @param weekdays weekdays, to call the callback on
     */
    void addWeekdays(DayOfWeek... weekdays);

    /**
     * Removes weekdays, this reminder is called on.
     *
     * @param weekdays weekdays, to call the callback on
     */
    void removeWeekDays(DayOfWeek... weekdays);

    /**
     * Removes all weekdays, this reminder is called on.
     */
    void resetWeekDays();

    /**
     * Gets the hour, this reminder is called on.
     *
     * @return hours as int in [0, 24]
     */
    int getHours();

    /**
     * Sets the hours, this reminder is called on.
     *
     * @param hours hours as int in [0, 23]
     */
    void setHours(int hours);

    /**
     * Gets the minutes, this reminder is called on.
     *
     * @return minutes as int in [0, 59]
     */
    int getMinutes();

    /**
     * Sets the minutes, this reminder is called on.
     *
     * @param minutes minutes as int in [0, 59]
     */
    void setMinutes(int minutes);

    /**
     * Activates this reminder.
     * <p>
     * <b>Note:</b> reminders are activated by default. Only use this method, if this reminder may have been deactivated.
     */
    void activate();

    /**
     * Deactivates this reminder.
     */
    void deactivate();

    /**
     * Checks whether this reminder is activated.
     *
     * @return true, if this reminder is activated
     */
    boolean isActivated();
}
