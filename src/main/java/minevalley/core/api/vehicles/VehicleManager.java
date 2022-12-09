package minevalley.core.api.vehicles;

import lombok.Setter;
import minevalley.core.api.OnlineUser;

public final class VehicleManager {

    @Setter
    private static Manager manager;

    public static Vehicle getVehicle(OnlineUser user) {
        return manager.getVehicle(user);
    }

    public interface Manager {

        Vehicle getVehicle(OnlineUser user);
    }
}