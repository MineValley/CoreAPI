package minevalley.core.api.utils.armorstand;

import minevalley.core.api.utils.armorstand.enums.ArmorStandMetaData;
import minevalley.core.api.utils.armorstand.enums.EquipmentSlot;
import minevalley.core.api.utils.armorstand.properties.VisibilityModifier;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.UUID;

public interface FakeArmorStand extends VisibilityModifier {

    /**
     * Get the random generated uuid of the armorstand
     * @return uuid
     */
    UUID getUniqueId();

    /**
     * get the custom id from the armorstand
     * @return int
     */
    int getId();

    /**
     * set the custom id for the armorstand
     * @param id
     */
    void setId(int id);

    /**
     * Get the yaw from the armorstand facing
     * @return float
     */
    float getYaw();

    /**
     * Get the pitch from the armorstand facing
     * @return float
     */
    float getPitch();

    /**
     * Set the equipment to the given slot see {@link EquipmentSlot} for the available slots
     * @param item itemstack to be setted
     * @param slot the slot to be replaced
     */
    void setEquipment(ItemStack item, EquipmentSlot slot);

    /**
     * Get the Item from the given asked slot
     * @param slot EquipmentSlot Enum
     * @return ItemStack
     */
    ItemStack getEquipment(EquipmentSlot slot);

    /**
     * Set specific attributes for the armorstand in form of metadata
     * @param metaData the metadata enum
     * @param state the new state of this attribute
     */
    void setAttribute(ArmorStandMetaData metaData, boolean state);

    /**
     * Get the state of an attribute
     * @param metaData the metadata enum
     * @return state of the attribute
     */
    boolean getAttribute(ArmorStandMetaData metaData);

    /**
     * Get the location of the armorstand
     * @return location
     */
    Location getLocation();

    /**
     * Set the location of the armorstand
     * @param location
     */
    void setLocation(Location location);

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
     * @param location
     */
    void teleport(Location location);

    /**
     * Set the yaw and pitch values for the current location of the armorstand
     * @param yaw
     * @param pitch
     */
    void setHeadRotation(float yaw, float pitch);

    /**
     * Updates the metadata of the current armorstand instance
     */
    void updateMetaData();

    /**
     * Refreshed the Armorstand with its configuration
     */
    void refresh();

}
