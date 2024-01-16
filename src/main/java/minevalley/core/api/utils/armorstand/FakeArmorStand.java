package minevalley.core.api.utils.armorstand;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

import java.util.List;

public interface FakeArmorStand extends VisibilityModifier, PoseModifier, EquipmentModifier {

    /**
     * get the custom id from the armorstand
     *
     * @return int
     */
    int getId();

    /**
     * Spawns the armorstand
     */
    void spawn();

    /**
     * Destroys/de-spawn the armor-stand
     */
    void destroy();

    int getVisibilityRange();

    void setVisibilityRange(int visibilityRange);

    /**
     * Get the location of the armorstand
     *
     * @return location
     */
    Location getLocation();

    /**
     * Sets the armorstand's location.
     * <b>Note:</b> This ignores the yaw and pitch values.
     *
     * @param location new location of the armorstand.
     */
    void setLocation(Location location);

    boolean hasBasePlate();

    void setBasePlate(boolean basePlate);

    boolean isSmall();

    void setSmall(boolean small);

    boolean hasArms();

    void setArms(boolean arms);

    boolean isMarker();

    void setMarker(boolean marker);

    /**
     * get the current passenger list
     *
     * @return a list with the passengers as entities
     */
    List<Entity> getPassengers();

    /**
     * Add a passenger to the object
     *
     * @param entity the entity to be added
     */
    void addPassenger(Entity entity);

    /**
     * Remove a passenger
     *
     * @param entity the entity to be removed
     */
    void removePassenger(Entity entity);
}
