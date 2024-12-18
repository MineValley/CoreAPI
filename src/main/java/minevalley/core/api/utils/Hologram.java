package minevalley.core.api.utils;

import minevalley.core.api.users.OnlineUser;
import org.bukkit.Location;

import java.util.List;
import java.util.function.Function;

public interface Hologram {

    String[] getLines();

    default String getLine(int line) {
        return getLines()[line];
    }

    default void addLine(String text) {
        addLineAfter(getLines().length - 1, text);
    }

    void addLineAfter(int line, String text);

    void changeLine(int line, String text);

    void removeLine(int line);

    void setVisibility(Function<OnlineUser, Boolean> visibilityFunction);

    void updateVisibility();

    void updateVisibility(OnlineUser user);

    List<OnlineUser> getNearbyViewingUsers();

    Location getLocation();

    void move(Location location);

    void delete();
}