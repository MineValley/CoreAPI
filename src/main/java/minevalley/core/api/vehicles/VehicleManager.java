package minevalley.core.api.vehicles;

import lombok.Setter;
import minevalley.core.api.OnlineUser;
import minevalley.core.api.Registered;
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
public final class VehicleManager {

    @Setter
    private static Manager manager;

    /**
     * Gets the vehicle this user is currently driving with. It is not taken into account whether the user is the driver or just a passenger.
     * <p>
     * <b>Note:</b> Returns null if the user is not in a vehicle!
     * </p>
     */
    public static Vehicle getVehicle(OnlineUser user) {
        return manager.getVehicle(user);
    }

    /**
     * Gets the vehicle with the given id.
     * <p>
     * <b>Note:</b> If the car isn't loaded, this returns null!
     * </p>
     * <p>
     * <b>Tip:</b> Using the getVehicle(ArmorStand)-function will try to load the vehicle, if unloaded!
     * </p>
     */
    public static Vehicle getVehicle(int id) {
        return manager.getVehicle(id);
    }

    /**
     * Gets the vehicle that the given armor stand belongs to.
     * <br>
     * If the vehicle isn't loaded yet, this function will try to do so.
     * <p>
     * <b>Note:</b> This might return null, if there is no vehicle associated with the given armor stand!
     * </p>
     */
    public static Vehicle getVehicle(ArmorStand armorStand) {
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
     * @param registered  new owner
     * @param location    location to spawn
     * @param orientation orientation to spawn
     */
    public static Vehicle addVehicle(VehicleModel model, VehicleColor color, OnlineUser user, Registered registered, Location location, BlockFace orientation) {
        return manager.addVehicle(model, color, user, registered, location, orientation);
    }

    /**
     * Adds new vehicle to user. The payment has to be done before calling this method!
     *
     * @param user        owner to give key to
     * @param location    location to spawn
     * @param orientation orientation to spawn
     */
    public static Vehicle addVehicle(VehicleModel model, VehicleColor color, OnlineUser user, Location location, BlockFace orientation) {
        return manager.addVehicle(model, color, user, user, location, orientation);
    }

    /**
     * Moves Vehicle out of depot.
     *
     * @param id          id of car
     * @param location    location to spawn
     * @param orientation orientation to spawn
     */
    public static Vehicle pickUpFromDepot(int id, Location location, BlockFace orientation) {
        return manager.pickUpFromDepot(id, location, orientation);
    }

    public interface Manager {

        Vehicle getVehicle(OnlineUser user);

        Vehicle getVehicle(int id);

        Vehicle getVehicle(ArmorStand armorStand);

        VehicleModel getVehicleModel(int id);

        List<VehicleModel> getAllVehicleModels();

        Vehicle addVehicle(VehicleModel model, VehicleColor color, OnlineUser user, Registered registered, Location location, BlockFace orientation);

        Vehicle pickUpFromDepot(int id, Location location, BlockFace orientation);
    }
}