package minevalley.core.api.regions;

import minevalley.core.api.OnlineUser;
import org.bukkit.Location;

public interface RadioMast {

    String getName();

    void changeName(String name);

    Location getLocation();

    OnlineUser getConnectedUsers();

    /**
     * Range in percent.
     */
    int getRange();

    void changeRange(int range);

    void remove();
}