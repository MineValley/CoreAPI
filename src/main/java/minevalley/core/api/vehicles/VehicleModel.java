package minevalley.core.api.vehicles;

import minevalley.core.api.OnlineUser;
import minevalley.core.api.Registered;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface VehicleModel {

    int getId();

    String getName();

    VehicleBrand getBrand();

    List<VehicleColor> getColors();

    int getFuelTank();

    int getTrunkLines();

    int getDefaultPrice();

    int getMaxSpeed();

    ItemStack getItemStack();

    ItemStack getItemStack(VehicleColor color);

    Vehicle createNew(Registered registered, OnlineUser user, VehicleColor color);
}
