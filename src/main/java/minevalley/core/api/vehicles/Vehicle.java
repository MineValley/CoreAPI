package minevalley.core.api.vehicles;

import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.Registrant;
import org.bukkit.inventory.ItemStack;

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

    double getFuel();

    void addFuel(double fuelInLiter);

    ParkingTicket getParkingTicket();

    void addParkingTicket(ParkingTicket ticket);

    void removeParkingTicket();

    Repentance getRepentance();

    void addRepentance(Repentance repentance);

    void removeRepentance();

    LoadedVehicle getLoadedVehicle();

    default boolean isLoaded() {
        return getLoadedVehicle() != null;
    }
}