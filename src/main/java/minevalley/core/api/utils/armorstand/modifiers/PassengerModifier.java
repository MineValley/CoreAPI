package minevalley.core.api.utils.armorstand.modifiers;

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
    PassengerModifier addPassenger(Entity entity);

    /**
     * Remove a passenger
     *
     * @param entity the entity to be removed
     */
    PassengerModifier removePassenger(Entity entity);

    /**
     * Update the passengers
     */
    void updatePassengers();
}
