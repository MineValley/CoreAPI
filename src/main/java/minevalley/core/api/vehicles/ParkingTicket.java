package minevalley.core.api.vehicles;

import minevalley.core.api.OnlineUser;

public interface ParkingTicket {

    String getCarParkName();

    long getStartTime();

    int getPriceAdd();

    int getPriceMultiplier();

    boolean pay(OnlineUser user);
}