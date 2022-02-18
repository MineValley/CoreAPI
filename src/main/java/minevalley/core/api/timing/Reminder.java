package minevalley.core.api.timing;

import lombok.NonNull;

import java.util.List;

/**
 * Reminders are used to time specific events that depend on real time.
 * They are called exactly at the time, they are supposed to.
 */
public interface Reminder {

    /**
     * Gets the selected weekdays.
     *
     * @return list of all selected weekdays
     */
    Weekday[] getWeekdays();

    /**
     * Sets the weekdays, this reminder is called on.
     *
     * @param weekdays weekdays, to call the callback on
     */
    void setWeekdays(List<Weekday> weekdays);

    /**
     * Sets the weekdays, this reminder is called on.
     *
     * @param weekdays weekdays, to call the callback on
     */
    void setWeekdays(Weekday... weekdays);

    /**
     * Sets the weekdays, this reminder is called on.
     *
     * @param weekdays weekdays, to call the callback on
     */
    void addWeekdays(Weekday... weekdays);

    /**
     * Gets the hour, this reminder is called on.
     *
     * @return hours as int in [0,24]
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
     * Gets the callback that is called, when the reminder is called.
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
     * Deletes this callback from the queue.
     */
    void delete();

    enum Weekday {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }
}
