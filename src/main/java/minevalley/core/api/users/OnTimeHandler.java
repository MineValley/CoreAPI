package minevalley.core.api.users;

import lombok.Setter;
import minevalley.core.api.database.Value;

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

    public static void purgeOnTime() {
        // TODO 22.12.2024: purgeOnTime() (OnTimeHandler)
//        USER_BY_UUID.values().forEach(user -> {
//            final int delta = OnTimeHandler.getOnTimeSinceRestartInMinutes(user);
//            if (delta != 0) {
//                user.getEntry().changeValue(new Value("ontime", user.totalOnTimeInMinutes + delta));
//            }
//        });
    }

    public interface Manager {

        int getTodayOnTimeInMinutes(User user);

        Map<LocalDate, Integer> getThirtyDaysOnTimeInMinutes(User user);

        int getOnTimeSinceRestartInMinutes(User user);
    }
}
