package minevalley.core.api.utils;

import lombok.Setter;
import minevalley.core.api.users.User;

import java.time.LocalDate;
import java.util.Map;

public final class OnTimeHandler {

    @Setter
    private static Manager manager;

    public static int getTodayOnTimeInMinutes(User user) {
        return manager.getTodayOnTimeInMinutes(user);
    }

    public static Map<LocalDate, Integer> getThirtyDaysOnTimeInMinutes(User user) {
        return manager.getThirtyDaysOnTimeInMinutes(user);
    }

    public static int getOnTimeSinceRestartInMinutes(User user) {
        return manager.getOnTimeSinceRestartInMinutes(user);
    }

    public interface Manager {

        int getTodayOnTimeInMinutes(User user);

        Map<LocalDate, Integer> getThirtyDaysOnTimeInMinutes(User user);

        int getOnTimeSinceRestartInMinutes(User user);
    }
}
