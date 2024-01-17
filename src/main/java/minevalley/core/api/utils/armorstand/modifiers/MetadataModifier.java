package minevalley.core.api.utils.armorstand.modifiers;

public interface MetadataModifier {

    /**
     * @return true if the armorstand has a base plate
     */
    boolean hasBasePlate();

    /**
     * @param basePlate true if the armorstand should have a base plate
     * @return the MetadataModifier
     */
    MetadataModifier setBasePlate(boolean basePlate);

    /**
     * @return true if the armorstand is small
     */
    boolean isSmall();

    /**
     * @param small true if the armorstand should be small
     * @return the MetadataModifier
     */
    MetadataModifier setSmall(boolean small);

    /**
     * @return true if the armorstand has arms
     */
    boolean hasArms();

    /**
     * @param arms true if the armorstand should have arms
     * @return the MetadataModifier
     */
    MetadataModifier setArms(boolean arms);

    /**
     * @return true if the armorstand is a marker
     */
    boolean isMarker();

    /**
     * @param marker true if the armorstand should be a marker
     * @return the MetadataModifier
     */
    MetadataModifier setMarker(boolean marker);

    /**
     * @return true if the armorstand is on fire
     */
    boolean isOnFire();

    /**
     * @param onFire true if the armorstand should be on fire
     * @return the MetadataModifier
     */
    MetadataModifier setOnFire(boolean onFire);

    /**
     * @return true if the armorstand is visible
     */
    boolean isVisible();

    /**
     * @param visible true if the armorstand should be visible
     * @return the MetadataModifier
     */
    MetadataModifier setVisible(boolean visible);

    /**
     * @return true if the armorstand is glowing
     */
    boolean isGlowing();

    /**
     * @param glowing true if the armorstand should be glowing
     * @return the MetadataModifier
     */
    MetadataModifier setGlowing(boolean glowing);

    /**
     * @return true if the armorstand is affected by gravity
     */
    boolean hasGravity();

    /**
     * @param gravity true if the armorstand should be affected by gravity
     * @return the MetadataModifier
     */
    MetadataModifier setGravity(boolean gravity);

    /**
     * @return custom name of the armorstand
     */
    String getCustomName();

    /**
     * @param customName custom name of the armorstand
     * @return the MetadataModifier
     */
    MetadataModifier setCustomName(String customName);

    /**
     * @return true if the custom name is visible
     */
    boolean isCustomNameVisible();

    /**
     * @param customNameVisible true if the custom name should be visible
     * @return the MetadataModifier
     */
    MetadataModifier setCustomNameVisible(boolean customNameVisible);

    /**
     * @return true if the armorstand is silent
     */
    boolean isSilent();

    /**
     * @param silent true if the armorstand should be silent
     * @return the MetadataModifier
     */
    MetadataModifier setSilent(boolean silent);

    /**
     * updates the metadata of the armorstand
     */
    void updateMetadata();
}
