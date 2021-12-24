package minevalley.core.api.regions;

public interface Region {

    /**
     * Gets a list of the areas that define this region.
     *
     * @return list of areas
     */
    Area[] getAreas();

    /**
     * Gets this regions id.
     *
     * @return id as integer
     */
    int getId();

    /**
     * Gets this regions priority.
     * @return priority as integer
     */
    int getPriority();

    /**
     * Gets a list with the cuboids that this region lies on.
     *
     * @return list of cuboids
     */
    Cuboid[] getCuboids();
}