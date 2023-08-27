package minevalley.core.api.vehicles;

import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.User;

public interface ParkingTicket {

    String getCarParkName();

    long getStartTime();

    int getPricePerHour();

    int getPricePerDay();

    User getDriver();

    void tow();

    boolean pay(OnlineUser user);
}