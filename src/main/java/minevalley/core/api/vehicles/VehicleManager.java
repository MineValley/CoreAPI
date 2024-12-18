package minevalley.core.api.vehicles;

import lombok.Setter;
import minevalley.core.api.Depends;
import minevalley.core.api.Registrant;
import minevalley.core.api.users.OnlineUser;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.ArmorStand;

import java.util.List;

/**
 * This manager is handled by another module! Do not change the manager-attribute.
 * <br>
 * Due to the circumstance that your module might load before this manager's handler, it is necessary not to call any
 * of the functions below on module start without using a scheduler!
 */
@Depends("FastCar")
public final class VehicleManager {

    @Setter
    private static Manager manager;

    public static List<Vehicle> getVehicles(Registrant registrant) {
        return manager.getVehicles(registrant);
    }

    /**
     * Gets the vehicle with the given id.
     */
    public static Vehicle getVehicle(String id) {
        return manager.getVehicle(id);
    }

    /**
     * Gets the vehicle this user is currently driving with. It is not taken into account whether the user is the driver or just a passenger.
     * <p>
     * <b>Note:</b> Returns null if the user is not in a vehicle!
     * </p>
     */
    public static LoadedVehicle getVehicle(OnlineUser user) {
        return manager.getVehicle(user);
    }

    /**
     * Gets the vehicle that the given armor stand belongs to.
     * <br>
     * If the vehicle isn't loaded yet, this function will try to do so.
     * <p>
     * <b>Note:</b> This might return null, if there is no vehicle associated with the given armor stand!
     * </p>
     */
    public static LoadedVehicle getVehicle(ArmorStand armorStand) {
        return manager.getVehicle(armorStand);
    }

    /**
     * Gets the model with the given id.
     */
    public static VehicleModel getVehicleModel(int id) {
        return manager.getVehicleModel(id);
    }

    /**
     * Gets all vehicle models.
     */
    public static List<VehicleModel> getAllVehicleModels() {
        return manager.getAllVehicleModels();
    }

    /**
     * Adds new vehicle to user. The payment has to be done before calling this method!
     *
     * @param user        user to give key to
     * @param registrant  new owner
     * @param location    location to spawn
     * @param orientation orientation to spawn
     */
    public static LoadedVehicle addVehicle(VehicleModel model, Vehicle.Color color, OnlineUser user, Registrant registrant,
                                           Location location, BlockFace orientation) {
        return manager.addVehicle(model, color, user, registrant, location, orientation);
    }

    /**
     * Adds new vehicle to user. The payment has to be done before calling this method!
     *
     * @param user        owner to give key to
     * @param location    location to spawn
     * @param orientation orientation to spawn
     */
    public static LoadedVehicle addVehicle(VehicleModel model, Vehicle.Color color, OnlineUser user, Location location,
                                           BlockFace orientation) {
        return manager.addVehicle(model, color, user, user, location, orientation);
    }


    /**
     * Gets the brand with given id.
     */
    public static VehicleBrand getBrand(int id) {
        return manager.getBrand(id);
    }

    public interface Manager {

        List<Vehicle> getVehicles(Registrant registrant);

        Vehicle getVehicle(String id);

        LoadedVehicle getVehicle(OnlineUser user);

        LoadedVehicle getVehicle(ArmorStand armorStand);

        VehicleModel getVehicleModel(int id);

        List<VehicleModel> getAllVehicleModels();

        LoadedVehicle addVehicle(VehicleModel model, Vehicle.Color color, OnlineUser user, Registrant registrant,
                                 Location location, BlockFace orientation);

        VehicleBrand getBrand(int id);
    }
}