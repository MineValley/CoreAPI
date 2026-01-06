package minevalley.core.api.weather;

import lombok.Setter;
import org.bukkit.Chunk;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class WeatherHandler {

    @Setter
    private static Manager manager;

    /**
     * Gets the current season.
     *
     * @return The current season.
     */
    @Nonnull
    @Contract(pure = true)
    public static Season getCurrentSeason() {
        return manager.getCurrentSeason();
    }

    /**
     * Gets the current weather in the given chunk.
     *
     * @param chunk The chunk to get the weather for.
     * @return The current weather in the given chunk.
     */
    @Nonnull
    @Contract(pure = true)
    public static Weather getCurrentWeather(@Nonnull Chunk chunk) {
        return manager.getWeather(System.currentTimeMillis(), chunk);
    }

    /**
     * Gets the upcoming weather in the given chunk at the specified time.
     *
     * @param timeMillis The time in milliseconds to get the weather for.
     * @param chunk      The chunk to get the weather for.
     * @return The upcoming weather in the given chunk at the specified time.
     * @throws IllegalArgumentException If the chunk is null or the time is invalid.
     */
    @Nonnull
    @Contract(pure = true)
    public static Weather getWeather(long timeMillis, @Nonnull Chunk chunk) throws IllegalArgumentException {
        return manager.getWeather(System.currentTimeMillis(), chunk);
    }

    public interface Manager {

        @Nonnull
        @Contract(pure = true)
        Season getCurrentSeason();

        @Nonnull
        @Contract(pure = true)
        Weather getWeather(long timestamp, @Nonnull Chunk chunk) throws IllegalArgumentException;
    }
}