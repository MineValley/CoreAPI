package minevalley.core.api.vehicles;

import minevalley.core.api.Registrant;
import minevalley.core.api.users.OnlineUser;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("unused")
public interface Vehicle {

    VehicleModel getModel();

    Registrant getOwner();

    String getId();

    int getKeyNumber();

    int getDurability();

    Color getColor();

    void changeColor(Color color);

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

    record Color(String name, String hex) {
    }
}