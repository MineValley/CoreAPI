package minevalley.core.api.regions;

public interface Locality {

    /**
     * Gets this localitys id.
     *
     * @return id as integer
     */
    int getId();

    /**
     * Gets the name of this locality.
     *
     * @return name as string
     */
    String getName();

    /**
     * Gets the description of this locality.
     *
     * @return descripton as string
     */
    String getDescription();
}
