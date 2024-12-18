package minevalley.core.api.vehicles;

import minevalley.core.api.Registrant;
import minevalley.core.api.users.OnlineUser;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface VehicleModel {

    int getId();

    String getName();

    VehicleBrand getBrand();

    List<Vehicle.Color> getColors();

    int getFuelTank();

    int getTrunkLines();

    int getDefaultPrice();

    int getMaxSpeed();

    ItemStack getItemStack();

    ItemStack getItemStack(Vehicle.Color color);

    Vehicle createNew(Registrant registrant, OnlineUser user, Vehicle.Color color);
}
