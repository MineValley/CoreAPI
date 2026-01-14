package minevalley.core.api.users.statistics;

import minevalley.core.api.Depends;

import javax.annotation.Nonnull;

@Depends("UserStatistics")
public final class StatisticsProvider {

    private static volatile StatisticsHandler handler;

    @Nonnull
    public static StatisticsHandler get() throws IllegalStateException {
        if (handler == null) {
            throw new IllegalStateException("No StatisticsHandler registered");
        }
        return handler;
    }

    public static void register(@Nonnull StatisticsHandler h) throws IllegalArgumentException {
        if (h == null) throw new IllegalArgumentException("handler is null");
        handler = h;
    }

}