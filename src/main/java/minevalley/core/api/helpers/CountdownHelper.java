package minevalley.core.api.helpers;

import minevalley.core.api.utils.Countdown;
import org.bukkit.scheduler.BukkitTask;

public interface CountdownHelper {

    void startCountdown(Countdown countdown);

    void stopCountdown(Countdown countdown);

    BukkitTask getTask();
}