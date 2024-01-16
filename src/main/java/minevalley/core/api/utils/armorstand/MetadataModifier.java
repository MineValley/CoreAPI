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

    void updateModifier();
}
