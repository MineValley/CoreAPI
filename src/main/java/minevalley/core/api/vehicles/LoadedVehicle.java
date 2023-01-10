package minevalley.core.api.vehicles;

import minevalley.core.api.OnlineUser;
import org.bukkit.Location;

import java.util.List;

public interface LoadedVehicle extends Vehicle {

    void tow(String reason);

    /**
     * Gets the driver.
     * <br>
     * <b>Note:</b> This may be null if there is no driver in the vehicle
     */
    OnlineUser getDriver();

    /**
     * Gets a list of all passengers (including the driver).
     */
    List<OnlineUser> getPassengers();

    boolean hasSirenActivated();

    int getSpeed();

    void respawn(Location location);
}
