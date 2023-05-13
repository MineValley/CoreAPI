package minevalley.core.api.weather;

import lombok.Setter;
import org.bukkit.Chunk;

public class WeatherHandler {

    @Setter
    private static Manager manager;

    public static Season getCurrentSeason() {
        return manager.getCurrentSeason();
    }

    public static Weather getCurrentWeather(Chunk chunk) {
        return manager.getWeather(System.currentTimeMillis(), chunk);
    }

    public static Weather getUpcomingWeather(long timeMillis, Chunk chunk) {
        return manager.getWeather(System.currentTimeMillis(), chunk);
    }

    public interface Manager {
        Season getCurrentSeason();

        Weather getWeather(long timestamp, Chunk chunk);
    }
}