package minevalley.core.api.vehicles;

import lombok.Setter;
import minevalley.core.api.OnlineUser;
import minevalley.core.api.Registered;
import minevalley.core.api.User;
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

    /**
     * Gets the brand with given id.
     */
    public static VehicleBrand getBrand(int id) {
        return manager.getBrand(id);
    }

    /**
     * Creates new repentance to add to vehicle.
     */
    public static Repentance createRepentance(User officer, String message) {
        return manager.createRepentance(officer, message);
    }

    /**
     * Creates new parking ticket to add to vehicle.
     *
     * @param carParkName  name of the car park
     * @param pricePerHour price in cents
     * @param pricePerDay  price in cents
     * @param driver       current driver
     */
    public static ParkingTicket createParkingTicket(String carParkName, int pricePerHour, int pricePerDay, User driver) {
        return manager.createParkingTicket(carParkName, pricePerHour, pricePerDay, driver);
    }

    public interface Manager {

        Vehicle getVehicle(OnlineUser user);

        Vehicle getVehicle(int id);

        Vehicle getVehicle(ArmorStand armorStand);

        VehicleModel getVehicleModel(int id);

        List<VehicleModel> getAllVehicleModels();

        Vehicle addVehicle(VehicleModel model, VehicleColor color, OnlineUser user, Registered registered, Location location, BlockFace orientation);

        Vehicle pickUpFromDepot(int id, Location location, BlockFace orientation);

        VehicleBrand getBrand(int id);

        Repentance createRepentance(User officer, String message);

        ParkingTicket createParkingTicket(String carParkName, int pricePerHour, int pricePerDay, User driver);
    }
}