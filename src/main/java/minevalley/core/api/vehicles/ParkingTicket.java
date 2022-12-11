package minevalley.core.api.vehicles;

import minevalley.core.api.OnlineUser;
import minevalley.core.api.User;

public interface ParkingTicket {

    String getCarParkName();

    long getStartTime();

    int getPricePerHour();

    int getPricePerDay();

    User getDriver();

    void tow();

    boolean pay(OnlineUser user);
}