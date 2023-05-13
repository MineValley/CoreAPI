package minevalley.core.api.weather;

public interface Weather {

    String getCurrentTime();
    String getCurrentSeason();
    String getCurrentDate();
    String getCurrentWeather();
    String[] getUpcomingWeather();

}
