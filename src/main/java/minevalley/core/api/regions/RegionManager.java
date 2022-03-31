package minevalley.core.api.regions;


import minevalley.core.api.CoreModule;
import org.bukkit.Location;
import org.bukkit.block.Block;

public final class RegionManager {

    /**
     * Gets the region with the specific id.
     *
     * @param id regions id
     * @return region with specific id
     */
    public static Region getRegion(int id) {
        return CoreModule.getServer().getRegion(id);
    }

    /**
     * Gets the region in which this location lies in.
     *
     * @param location location to get region
     * @return region in which this location lies in
     */
    public static Region getRegion(Location location) {
        return CoreModule.getServer().getRegion(location);
    }

    /**
     * Gets an area object with the given locations.
     *
     * @param loc1 first location as block
     * @param loc2 second location as block
     * @return area with the given locations
     */
    public static Area getArea(Block loc1, Block loc2) {
        return CoreModule.getServer().getArea(loc1, loc2);
    }

    /**
     * Gets the area that is represented by a specific string.
     *
     * @param rawArea area as string
     * @return area that is represented by the specific string
     */
    public static Area getAreaFromString(String rawArea) {
        return CoreModule.getServer().getAreaFromString(rawArea);
    }
}