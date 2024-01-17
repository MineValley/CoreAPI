package minevalley.core.api.utils.armorstand;

public interface MetadataModifier {

    boolean hasBasePlate();

    MetadataModifier setBasePlate(boolean basePlate);

    boolean isSmall();

    MetadataModifier setSmall(boolean small);

    boolean hasArms();

    MetadataModifier setArms(boolean arms);

    boolean isMarker();

    MetadataModifier setMarker(boolean marker);

    boolean isOnFire();

    MetadataModifier setOnFire(boolean onFire);

    boolean isVisible();

    MetadataModifier setVisible(boolean visible);

    boolean isGlowing();

    MetadataModifier setGlowing(boolean glowing);

    boolean hasGravity();

    MetadataModifier setGravity(boolean gravity);

    String getCustomName();

    MetadataModifier setCustomName(String customName);

    boolean isCustomNameVisible();

    MetadataModifier setCustomNameVisible(boolean customNameVisible);

    boolean isSilent();

    MetadataModifier setSilent(boolean silent);

    void updateModifier();
}
