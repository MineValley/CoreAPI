package minevalley.core.api.utils;

import lombok.Setter;
import minevalley.core.api.User;

import java.time.LocalDate;
import java.util.Map;

public final class OnTimeHandler {

    @Setter
    private static Manager manager;

    public static int getTotalOnTimeInMinutes(User user) {
        return manager.getTotalOnTimeInMinutes(user);
    }

    public static int getTodayOnTimeInMinutes(User user) {
        return manager.getTodayOnTimeInMinutes(user);
    }

    public static Map<LocalDate, Integer> getThirtyDaysOnTimeInMinutes(User user) {
        return manager.getThirtyDaysOnTimeInMinutes(user);
    }

    public interface Manager {

        int getTotalOnTimeInMinutes(User user);

        int getTodayOnTimeInMinutes(User user);

        Map<LocalDate, Integer> getThirtyDaysOnTimeInMinutes(User user);

    }
}
