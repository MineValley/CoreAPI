package minevalley.core.api.utils.armorstand;

import org.bukkit.entity.Entity;

import java.util.List;

public interface PassengerModifier {

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

    /**
     * Update the passengers
     */
    void updatePassengers();
}
