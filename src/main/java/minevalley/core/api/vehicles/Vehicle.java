package minevalley.core.api.vehicles;

import minevalley.core.api.OnlineUser;
import minevalley.core.api.Registrant;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface Vehicle {

    VehicleModel getModel();

    Registrant getOwner();

    int getKeyId();

    int getKeyNumber();

    int getDurability();

    VehicleColor getColor();

    void changeColor(VehicleColor color);

    void createNewKey(OnlineUser user);

    ItemStack getKeyItem();

    void replaceLock(OnlineUser user);

    void transfer(Registrant registrant, OnlineUser onlineUser);

    String getLicensePlate();

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

    double getFuel();

    void addFuel(double fuelInLiter);

    int getSpeed();

    ParkingTicket getParkingTicket();

    void addParkingTicket(ParkingTicket ticket);

    void removeParkingTicket();

    Repentance getRepentance();

    void addRepentance(Repentance repentance);

    void removeRepentance();
}