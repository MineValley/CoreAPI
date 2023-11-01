package minevalley.core.api.utils.armorstand.adapter;

import minevalley.core.api.utils.armorstand.properties.VisibilityModifier;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

import java.util.List;

/**
 * This class contains all the multiverse methods, which needs to be configured/coded for every version
 */
public interface ArmorStandVersionAdapter extends VisibilityModifier {

    /**
     * Spawns the armorstand
     */
    void spawn(Location location);

    /**
     * Destroys/de-spawn the armor-stand
     */
    void destroy();

    /**
     * Add a passenger to the object
     * @param entity the entity to be added
     */
    void addPassenger(Entity entity);

    /**
     * Remove a passenger
     * @param entity the entity to be removed
     */
    void removePassenger(Entity entity);

    /**
     * get the current passenger list
     * @return a list with the passengers as entities
     */
    List<Entity> getPassengers();

    /**
     * Teleports the entity to a given location
     * IGNORES the yaw and pitch values. (See {@link #setHeadRotation(float, float)} for yaw and pitch alignments)
     * Uses a different packet, when the target destination is below 8 blocks.
     * @param location
     */
    void teleport(Location location);

    /**
     * Set the yaw and pitch values for the current location of the armorstand
     * @param yaw
     * @param pitch
     */
    void setHeadRotation(float yaw, float pitch);

    float[] getHeadRotation();

    /**
     * Updates the metadata of the current armorstand instance
     */
    void updateMetaData();


    /**
     * Refreshed the Armorstand with its configuration
     */
    void refresh();

}
