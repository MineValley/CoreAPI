package minevalley.core.api.users.statistics;

import minevalley.core.api.users.User;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.time.Instant;

@SuppressWarnings("unused")
public record Statistics(@Nonnull User user) {

    /**
     * Returns the total on time of the user in seconds.
     *
     * @return total on time in seconds
     */
    @Contract(pure = true)
    public int getTotalOnTimeInSeconds() {
        return StatisticsProvider.get().getTotalOnTimeInSeconds(user);
    }

    /**
     * Returns an array of the on time in seconds for the last 30 days.
     *
     * @return array of on time in seconds for the last 30 days
     */
    @Nonnull
    @Contract(value = "-> new", pure = true)
    public int[] getThirtyDaysOnTimeInSeconds() {
        return StatisticsProvider.get().getThirtyDaysOnTimeInSeconds(user);
    }

    /**
     * Returns the on time of today in seconds.
     *
     * @return on time of today in seconds
     */
    @Contract(pure = true)
    public int getTodayOnTimeInSeconds() {
        return getThirtyDaysOnTimeInSeconds()[0];
    }

    /**
     * Adds the specified amount in cents to the user's next payday with the given reason.
     *
     * @param reason        the reason for the addition
     * @param amountInCents the amount in cents to add
     * @throws IllegalArgumentException if the reason is null or blank, or if the amount is negative or zero
     */
    public void addToNextPayDay(@Nonnull String reason, @Nonnegative int amountInCents) throws IllegalArgumentException {
        StatisticsProvider.get().addToNextPayDay(user, reason, amountInCents);
    }

    /**
     * Returns the time remaining until the next payday in seconds.
     *
     * @return time to next payday in seconds
     */
    @Contract(pure = true)
    public int getTimeToNextPayDayInSeconds() {
        return getTodayOnTimeInSeconds() % 3600;
    }

    /**
     * Returns the first join date of the user.
     *
     * @return first join date
     */
    @Nonnull
    @Contract(pure = true)
    public Instant getFirstJoin() {
        return StatisticsProvider.get().getFirstJoin(user);
    }

    /**
     * Returns the last join date of the user.
     *
     * @return last join date
     */
    @Nonnull
    @Contract(pure = true)
    public Instant getLastJoin() {
        return StatisticsProvider.get().getLastJoin(user);
    }
}
