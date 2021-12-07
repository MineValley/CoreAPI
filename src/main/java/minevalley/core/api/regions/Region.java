package minevalley.core.api.regions;

import java.util.List;

public interface Region {

    /**
     * Gets a list of the areas that define this region.
     * @return list of areas
     */
    List<Area> getAreas();
}