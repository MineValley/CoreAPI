package minevalley.core.api.registrant.statistics;

import minevalley.core.api.Depends;
import minevalley.core.api.registrant.User;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.time.Instant;

@SuppressWarnings("unused")
@Depends("UserStatistics")
public interface StatisticsHandler {

    @Contract(pure = true)
    int getTotalOnTimeInSeconds(@Nonnull User user) throws IllegalArgumentException;

    @Nonnull
    @Contract(value = "_ -> new", pure = true)
    int[] getThirtyDaysOnTimeInSeconds(@Nonnull User user) throws IllegalArgumentException;

    void addToNextPayDay(@Nonnull User user, @Nonnull String reason, @Nonnegative int amountInCents)
            throws IllegalArgumentException;

    @Nonnull
    @Contract(pure = true)
    Instant getFirstJoin(@Nonnull User user) throws IllegalArgumentException;

    @Nonnull
    @Contract(pure = true)
    Instant getLastJoin(@Nonnull User user) throws IllegalArgumentException;
}
