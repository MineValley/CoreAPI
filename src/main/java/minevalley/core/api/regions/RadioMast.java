package minevalley.core.api.regions;

import minevalley.core.api.users.OnlineUser;
import org.bukkit.Location;

import java.util.List;

public interface RadioMast {

    String getName();

    void changeName(String name);

    Location getLocation();

    double distance(Location location);

    void changeLocation(Location location);

    List<OnlineUser> getConnectedUsers();

    /**
     * The range defines how far this radio mast reaches.
     *
     * @return Range in percent as integer.
     */
    int getRange();

    void changeRange(int range);

    void remove();
}