package minevalley.core.api.vehicles;

import minevalley.core.api.OnlineUser;
import minevalley.core.api.Registrant;
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

    Vehicle createNew(Registrant registrant, OnlineUser user, VehicleColor color);
}
